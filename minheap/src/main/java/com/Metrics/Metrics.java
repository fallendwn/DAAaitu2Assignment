package com.Metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class Metrics {
    
    private static final Logger logger = Logger.getLogger(Metrics.class.getName());
    public static int comparisons = 0;
    public static int swaps = 0;
    public static int insertions = 0;

    private static final String FILE_NAME = "target/heap_metrics.csv";
    private static boolean headerWritten = false;
    
    private static long startTime;
    private static long endTime;

    public static void reset(){

        comparisons = 0;
        swaps = 0;
        insertions = 0;
        startTime = 0;
        endTime = 0;

    }

    public static void startTimer(){

        startTime = System.nanoTime();

    }

    public static void stopTimer(){

        endTime = System.nanoTime();

    }

    public static long getElapsedTimeNs(){

        return endTime - startTime;

    }

    public static long getElapsedTimeMs(){

        return (endTime - startTime) / 1_000_000;

    }

    public static void logReport(String operation){

        logger.info(()-> "Metrics operation: " +operation + 
        "| comparisons" + comparisons + "| swaps: " +
        swaps + "insertions: "  + insertions + "|time(ms): "
        + getElapsedTimeMs());

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            if (!headerWritten) {
                pw.println("Operation,Comparisons,Swaps,Insertions,Time(ns),Time(ms)");
                headerWritten = true;
            }
            pw.printf("%s,%d,%d,%d,%d,%d%n",
                    operation,
                    comparisons,
                    swaps,
                    insertions,
                    getElapsedTimeNs(),
                    getElapsedTimeMs());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write metrics to CSV", e);
        }

        

    }


}
