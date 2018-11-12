package com.application.mysolution;

import java.util.*;
import java.util.stream.IntStream;
import org.apache.commons.math3.util.MathArrays;


public class MultiDimPoint{
    private int rowNum;
    private double[] coords;
    //double... coords will automatically convert all supplied coordinates to the array,
    // we can store it in double[] coords.
    public MultiDimPoint(int rowNum, double[] coords){
        this.coords = coords;
        this.rowNum = rowNum;
    }

    /**
     * @return the Euclidean distance of the two points
     */
    public double computeDistance(double[] other) {
        return MathArrays.distance(coords, other);
    }

    /**
     * @return the row number
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * @return the coords array
     */
    public double[] getCoords() {
        return coords;
    }

    /**
     * Print the point coords to the stdout
     */
    public void printCoords(){
        System.out.print(rowNum+":");
        for(int i=0; i<coords.length; i++){
            System.out.print(coords[i]+" ");
        }
        System.out.println("\n");
    }
}