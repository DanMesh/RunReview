// © Daniel Mesham 2018

package com.danmesh.runreview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import net.studioblueplanet.logger.DebugLogger;

/**
 * 
 * @author Dan
 */
public class MapPanel extends JPanel {
    private static int width = 600;
    private static int height = 500;
    
    private static final double MAP_PADDING = 0.05;
    private static final int    MARKER_RADIUS = 5;
    
    private int         zoom = 15;
    private double[]    coordRanges = {0.0176145 * (width/600.0), 0.0311515 * (height/600.0)};
    private Point centrePoint;
    
    private Track track;
    
    private static String IMAGE_FILE = "resources/mapImage.png";
    
    public MapPanel() {
        this(null);
    }
    
    /**
     * Constructor. Draws a map of the given track.
     * @param trackToMap The track to be drawn.
     */
    public MapPanel(Track trackToMap) {
        super();
        this.setPreferredSize(new Dimension(width, height));
        
        if (trackToMap == null) return;
        this.track = trackToMap;
        centrePoint = track.getCentrePoint();
        setZoomLevel();
        saveImage(getMapURL(centrePoint, zoom, width, height), IMAGE_FILE);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Map Image Methods"> 
    
    private void setZoomLevel() {
        double latRange = track.worldCoordRange()[0] * (1 + MAP_PADDING);
        double lonRange = track.worldCoordRange()[1] * (1 + MAP_PADDING);
        int latZoom = (int) Math.floor(Math.log(height/latRange)/Math.log(2));
        int lonZoom = (int) Math.floor(Math.log(width/lonRange)/Math.log(2));
        zoom = Math.min(latZoom, lonZoom);
    }
    
    /**
     * Forms the URL of a Google Static Map centred on a certain point with a
     * specified zoom level and dimensions.
     * Note: The dimensions of the resulting file are doubled as there is a 2x scale factor.
     * @param centre The location of the centre of the map.
     * @param zoom The zoom level.
     * @param width Width of the resulting image.
     * @param height Height of the resulting image.
     * @return A string representation of the map's URL.
     */
    private String getMapURL(Point centre, int zoom, int width, int height) {
        return "https://maps.googleapis.com/maps/api/staticmap?"
                + "center=" + centre.lat + "," + centre.lon +  "&"
                + "zoom=" + zoom + "&"
                + "size=" + width + "x" + height + "&"
                + "scale=2&"
                + "maptype=roadmap";
    }
    
    /**
     * Downloads an image at the given URL and stores it as a certain file.
     * Written by Chad Darby at: http://www.luv2code.com/2015/05/15/how-to-add-google-maps-to-java-swing-gui/
     * @param imageURL URL of the image to be downloaded.
     * @param file Filename of the downloaded image.
     * @return True if successfully downloaded, false if an error occurred.
     */
    private boolean saveImage(String imageURL, String file) {
        try {
            URL url = new URL(imageURL);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(file);
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            DebugLogger.error("Could not download image at URL=" + imageURL);
            return false;
        }
        
        return true;
    }
    
    private boolean drawBackgroundImage(Graphics g, String imageFile) {
        try {
            BufferedImage image = ImageIO.read(new File(imageFile));
            g.drawImage(image, 0, 0, width, height, this);
        } catch (IOException e) {
            DebugLogger.error("Could not draw the background image from imageFile=" + imageFile);
            return false;
        }
        return true;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Track Graphics & Drawing Methods"> 
    
    private int[] getPointXY(Point p) {
        int x = (width/2)  + (p.getPixelCoords(zoom)[0] - centrePoint.getPixelCoords(zoom)[0]);
        int y = (height/2) + (p.getPixelCoords(zoom)[1] - centrePoint.getPixelCoords(zoom)[1]);
        return new int[]{x, y};
    }
    
    private void drawMarker(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        x -= MARKER_RADIUS;
        y-= MARKER_RADIUS;
        g.fillOval(x, y, MARKER_RADIUS, MARKER_RADIUS);
    }
    
    private void drawMarker(Graphics g, Point point, Color color) {
        int[] xy = getPointXY(point);
        drawMarker(g, xy[0], xy[1], color);
    }
    
    private void drawLine(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
    
    private void drawLine(Graphics g, TrackPoint point1, TrackPoint point2, Color color) {
        int[] xy1 = getPointXY(point1);
        int[] xy2 = getPointXY(point2);
        drawLine(g, xy1[0], xy1[1], xy2[0], xy2[1], color);
    }
    
    private void drawTrack(Graphics g, Color color) {
        for (int i = 0; i < track.points.size()-1; i++) {
            drawLine(g, track.points.get(i), track.points.get(i+1), color);//TRACE
        }
        drawMarker(g, track.points.get(0), Color.GREEN);
        drawMarker(g, track.points.get(track.points.size() - 1), Color.RED);
    }
    
    // </editor-fold> 
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (track == null) return;
        drawBackgroundImage(g, IMAGE_FILE);
        drawTrack(g, Color.RED);
    }
    
    
}
