// © Daniel Mesham 2018

package com.danmesh.runreview;

import hirondelle.date4j.DateTime;
import java.util.ArrayList;

/**
 * This class represents an arbitrary segment of a route.
 * It is defined by the start and end times of the segment.
 * @author Dan
 */
public class Segment {
    private DateTime startTime;
    private DateTime endTime;
    
    private double timerTime;
    private double elapsedTime;
    
    private double distance;
    
    TrackPoint startPoint;
    TrackPoint endPoint;

    /**
     * Constructor. Creates a new lap based on a start and end time, and distance.
     * @param startTime Timestamp when the segment started.
     * @param endTime Timestamp when the segment ended.
     * @param timerTime Time in seconds recorded by the timer for the segment.
     * @param elapsedTime Time in seconds from the start to the end of the segment.
     * @param distance The distance covered in the segment.
     */
    public Segment(DateTime startTime, DateTime endTime, double timerTime, double elapsedTime, double distance) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.timerTime = timerTime;
        this.elapsedTime = elapsedTime;
        this.distance = distance;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters"> 
    public void setStartPoint(TrackPoint startPoint) {
        this.startPoint = startPoint;
    }
    
    public void setEndPoint(TrackPoint endPoint) {
        this.endPoint = endPoint;
    }
    
    public TrackPoint getStartPoint() {
        return startPoint;
    }

    public TrackPoint getEndPoint() {
        return endPoint;
    }

    public DateTime getStartTime() {
        return startTime;
    }
    
    public DateTime getEndTime() {
        return endTime;
    }

    public double getTimerTime() {
        return timerTime;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }
    
    public double getDistance() {
        return distance;
    }
    
    //</editor-fold>
    
    
}
