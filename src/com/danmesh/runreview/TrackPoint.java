// © Daniel Mesham 2018

package com.danmesh.runreview;

import hirondelle.date4j.DateTime;

/**
 * This class contains the details of a single point recorded on a route.
 * @author Dan
 */
public class TrackPoint extends Point {
    private DateTime    timestamp;
    
    private double      alt;
    
    private double      speed;
    private double      distance;

    
    /**
     * Constructor. Creates a TrackPoint from given data.
     * @param timestamp
     * @param lat
     * @param lon
     * @param alt
     * @param speed
     * @param distance 
     */
    public TrackPoint(DateTime timestamp, double lat, double lon, double alt, double speed, double distance) {
        super(lat, lon);
        this.timestamp = timestamp;
        this.alt = alt;
        this.speed = speed;
        this.distance = distance;
    }
    
    /**
     * Determines whether this TrackPoint lies within a Segment.
     * @param seg The Segment of interest.
     * @return True if the point lies within the segment, false if not.
     */
    public boolean isInSegment(Segment seg) {
        DateTime startTime = seg.getStartTime();
        DateTime endTime = seg.getEndTime();
        return timestamp.gteq(startTime) && timestamp.lteq(endTime);
    }
    
    public DateTime getTimestamp() {
        return timestamp;
    }

    public double getAlt() {
        return alt;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }
    
    /**
     * Returns a string description of the TrackPoint for debugging.
     * @return String containing the TrackPoint's timestamp and distance.
     */
    /*@Override
    public String toString() {
        return "[Time: " + timestamp + ", Dist: " + distance + "]";
    }*/

}
