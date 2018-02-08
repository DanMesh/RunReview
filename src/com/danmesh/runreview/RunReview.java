// © Daniel Mesham 2018

package com.danmesh.runreview;

import java.util.Arrays;
import java.util.Scanner;
import net.studioblueplanet.fitreader.FitReader;
import net.studioblueplanet.fitreader.FitRecord;
import net.studioblueplanet.fitreader.FitRecordRepository;
import net.studioblueplanet.logger.DebugLogger;


/**
 * This is the main class for the program. Run this to analyse a run.
 * @author Dan
 */
public class RunReview {
    
    Scanner scan;
    Track track;
    
    public RunReview() {
        DebugLogger.setDebugLevel(DebugLogger.DEBUGLEVEL_INFO);
        track = new Track("resources/testfile.FIT");
        
        /*
        scan = new Scanner(System.in);
        int response = -1;
        
        while (response != 0) {
            response = showMenu();
            
            switch(response) {
                case 1:
                    showLapInfo();
                    break;
                case 2:
                    showActivityInfo();
                    break;
                default:
            }
        }
        */
        new TrackView(track);
    }
    
    private void showLapInfo() {
        System.out.println("LAP INFO:");
        track.printLapInfoTable();
    }
    
    private void showActivityInfo() {
        System.out.println("ACTIVITY INFO:\n"
                + "--------------------------\n"
                + "Distance:    " + track.getDistance() + "m\n"
                + "Time:        " + track.getTimerTime() + "s\n"
                + "Laps:        " + track.getNumLaps() + "\n"
        );
    }
    
    private int showMenu() {
        System.out.print("\n********** RUN REVIEW **********\n"
                + " 1. Lap info\n"
                + " 2. Activity info\n"
                + " 0. Quit\n\n"
                + ">> ");
        return scan.nextInt();
    }

    public static void main(String[] args) {        
        /*
        DebugLogger.setDebugLevel(DebugLogger.DEBUGLEVEL_ERROR);
        Track track = new Track("resources/testfile.FIT");
        System.out.println("DISTANCE: " + track.getDistance() + "m");
        System.out.println("TIMER:    " + track.getTimerTime() + "s");
        System.out.println("ELAPSED:  " + track.getElapsedTime() + "s");

        FitReader reader = FitReader.getInstance();
        FitRecordRepository repo = reader.readFile("resources/testfile.FIT");
        
        FitRecord lapRecord = repo.getFitRecord("lap");
        FitRecord pointsRecord = repo.getFitRecord("record");
        FitRecord actRecord = repo.getFitRecord("activity");
        FitRecord sesRecord = repo.getFitRecord("session");
        
        System.out.println(actRecord.getTimeValue(0, "local_timestamp"));
        System.out.println(actRecord.getTimeValue(0, "timestamp"));
        System.out.println(sesRecord.getIntValue(0, "total_calories"));
        System.out.println(pointsRecord.getIntValue(1000, "calories"));
        */
        new RunReview();
    }

}
