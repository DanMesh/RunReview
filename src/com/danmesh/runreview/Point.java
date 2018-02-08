// © Daniel Mesham 2018

package com.danmesh.runreview;

/**
 *
 * @author Dan
 */
public class Point {
    protected double lat;
    protected double lon;
    
    public Point(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    
    /**
     * Calculates the 'world coordinates' of the point, as defined by Google here:
     * https://developers.google.com/maps/documentation/javascript/examples/map-coordinates.
     * @return 2D array of world coordinates in the form [x, y].
     */
    public double[] getWorldCoords() {
        double siny = Math.sin(lat * Math.PI/180);
        double y = 256 * (0.5 - (Math.log((1 + siny)/(1 - siny)) / (4 * Math.PI)));
        double x = 256 * (0.5 + lon/360);
        return new double[]{x, y};
    }
    
    /**
     * Calculates the 'pixel coordinates' (at the given zoom) of the point with
     * respect to the whole world, as defined by Google here:
     * https://developers.google.com/maps/documentation/javascript/examples/map-coordinates.
     * @param zoom The zoom level of the map.
     * @return 2D array of pixel coordinates in the form [x, y].
     */
    public int[] getPixelCoords(int zoom) {
        double[] wc = this.getWorldCoords();
        int x = (int) (wc[0]*Math.pow(2, zoom));
        int y = (int) (wc[1]*Math.pow(2, zoom));
        return new int[]{x, y};
    }
    
    @Override
    public String toString() {
        return "[" + lat + "," + lon + "]";
    }
}
