// © Daniel Mesham 2018

package com.danmesh.runreview;

import hirondelle.date4j.DateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import net.studioblueplanet.fitreader.FitReader;
import net.studioblueplanet.fitreader.FitRecord;
import net.studioblueplanet.fitreader.FitRecordRepository;
import net.studioblueplanet.logger.DebugLogger;

/**
 * This class contains the details of the GPS route for a given activity.
 * It includes all laps (and hence route points) recorded by the GPS device.
 * @author Dan
 */
public class Track {
    private ArrayList<Segment> laps;

    /**
     * A list of all the GPS track points recorded in the track.
     */
    protected ArrayList<TrackPoint> points;
    
    private double distance;
    private double timerTime;
    private double elapsedTime;
    private DateTime localTimestamp;
    private int calories;
    
    private Point[] limit;
    private static final int N = 0;
    private static final int S = 1;
    private static final int E = 2;
    private static final int W = 3;
    
    /**
     * Constructor. Creates a Track sing the data stored in a .FIT file.
     * @param filename The filename of the .FIT file for the Track.
     */
    public Track(String filename) {
        FitReader reader = FitReader.getInstance();
        FitRecordRepository repo = reader.readFile("resources/testfile.FIT");
        
        FitRecord record = repo.getFitRecord("lap");
        parseLaps(record);
        
        record = repo.getFitRecord("record");
        parseTrackPoints(record);
        
        record = repo.getFitRecord("session");
        this.distance = record.getDistanceValue(0, "total_distance");
        this.timerTime = record.getIntValue(0, "total_timer_time")/1000.0;
        this.elapsedTime = record.getIntValue(0, "total_elapsed_time")/1000.0;
        this.calories = record.getIntValue(0, "total_calories");
        
        record = repo.getFitRecord("activity");
        this.localTimestamp = record.getTimeValue(0, "local_timestamp");
    }
    
    //<editor-fold defaultstate="collapsed" desc="Info Getter Methods">
    
    /**
     * Returns the total distance of the track.
     * @return Double equal to the total track distance in meters.
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Returns the time recorded on the timer for the track.
     * @return The timer time in seconds as a double.
     */
    public double getTimerTime() {
        return timerTime;
    }

    public String getTimerTimeString() {
        return "";
    }
    
    /**
     * Returns the total time elapsed during the track (including pauses).
     * @return The elapsed time in seconds as a double.
     */
    public double getElapsedTime() {
        return elapsedTime;
    }
    
    /**
     * Returns the time of the activity in the time zone where it was run.
     * @return DateTime representation of the local timestamp of the activity.
     */
    public DateTime getLocalTimestamp() {
        return localTimestamp;
    }
    
    public String getDateString() {
        return localTimestamp.format("D MMMM YYYY, hh:mm", Locale.ENGLISH);
    }

    public String getDayOfWeek() {
        return localTimestamp.format("WWWW", Locale.ENGLISH);
    }
    
    public int getCalories() {
        return calories;
    }
    
    /**
     * Calculates the average pace for the run, in min/km.
     * @return Pace as a string in the form "mm:ss".
     */
    public String getPaceString() {
        return timeToString(1000*timerTime/distance, false, false);
    }
    
    /**
     * Returns the number of laps in the track.
     * @return Integer number of laps in the track.
     */
    public int getNumLaps() {
        return laps.size();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GPS & Map Info Methods">
      
    public Point getCentrePoint() {
        double lat = 0.5*(limit[N].lat + limit[S].lat);
        double lon = 0.5*(limit[E].lon + limit[W].lon);
        return new Point(lat, lon);
    }
   
    
    /**
     * Returns the range of latitudes and longitudes on the track in world coordinates.
     * @return Array of world coordinate ranges in the form [latitude_range, longitude_range].
     */
    public double[] worldCoordRange() {
        double wcLatRange = Math.abs(limit[N].getWorldCoords()[0] - limit[S].getWorldCoords()[0]);
        double wcLonRange = Math.abs(limit[E].getWorldCoords()[1] - limit[W].getWorldCoords()[1]);
        return new double[]{wcLatRange, wcLonRange};
    }
    
    //</editor-fold>
    
    public void printLapInfoTable() {
        System.out.printf("%3s%12s%12s\n", "Lap", "Dist (km)", "Time (s)");
        System.out.println("---------------------------");
        for (int i = 0; i < laps.size(); i++) {
            System.out.printf("%3d%12.2f%12.2f\n", i, laps.get(i).getDistance()/1000, laps.get(i).getTimerTime());
        }
    }
    
    
    /**
     * Parses laps from a FitRecord into Segment objects.
     * @param record The FitRecord of "laps".
     */
    private void parseLaps(FitRecord record) {
        int numLaps = record.getNumberOfRecordValues();
        laps = new ArrayList<>();
        
        for (int i = 0; i < numLaps; i++) {
            DateTime startTime  = record.getTimeValue(i, "start_time");
            DateTime endTime    = record.getTimeValue(i, "timestamp");
            double timerTime    = record.getIntValue(i, "total_timer_time")/1000.0;
            double elapsedTime  = record.getIntValue(i, "total_elapsed_time")/1000.0;
            double distance     = record.getDistanceValue(i, "total_distance");
            
            laps.add(new Segment(startTime, endTime, timerTime, elapsedTime, distance));
        }
    }
    
    /**
     * Parses track points from a FitRecord.
     * @param record The FitRecord containing "records".
     */
    private void parseTrackPoints(FitRecord record) {
        int numPoints = record.getNumberOfRecordValues();
        points = new ArrayList<>();
        limit = new Point[]{new Point(-90,0), new Point(90,0), new Point(0,-180), new Point(0,180)};
        
        for (int i = 0; i < numPoints; i++) {
            DateTime timestamp = record.getTimeValue(i, "timestamp");
            
            double lat = record.getLatLonValue(i, "position_lat");
            double lon = record.getLatLonValue(i, "position_long");
            
            double alt = record.getAltitudeValue(i, "altitude");
            
            double speed = record.getSpeedValue(i, "speed");
            double distance = record.getDistanceValue(i, "distance");
            
            TrackPoint tp = new TrackPoint(timestamp, lat, lon, alt, speed, distance);
            points.add(tp);
            
            /* Find the coordinate bounds now to avoid going through all points later */
            if (lat > limit[N].lat) limit[N] = tp;
            if (lat < limit[S].lat) limit[S] = tp;
            if (lon > limit[E].lon) limit[E] = tp;
            if (lon < limit[W].lon) limit[W] = tp;
        }
        DebugLogger.debug("Parsed all track points.");
    }
    
    public static String timeToString(double timeInSeconds, boolean withDecimal, boolean showHours) {
        String ret;
        
        double seconds = timeInSeconds % 60;
        if (withDecimal) ret = String.format("%.1f", seconds);
        else ret = String.format("%.0f", seconds);
        if (seconds < 10.0) ret = "0" + ret;
        
        int minutes = (int) Math.floor(timeInSeconds/60.0);
        int hours = 0;
        if (showHours) {
            hours = (int) Math.floor(minutes/60);
            minutes -= 60*hours;
        }
        ret = minutes + ":" + ret;
        if (hours > 0) {
            if (minutes < 10) ret = "0" + ret;
            ret = hours + ":" + ret;
        }
        return ret;
    }
}
