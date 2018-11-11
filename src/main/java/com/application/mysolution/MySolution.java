package com.application.mysolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class MySolution{

    static void usage(){
    	System.out.println("Please provide an input file!");
    	String msg = "E.g.: java -cp mySolution.jar <input file path>";
    	System.out.println(msg);
    }

    public static void main(String[] args) {;
    	ArrayList<MultiDimPoint> points;
    	if (args.length > 0){
    		String filename = args[0];
    		points = readPointsFromFile(filename);
    		// Test case for file reading
    		if (args.length > 1 && args[1] == "test_fileread"){
    			for (MultiDimPoint point : points){
    				point.printCoords();
    			}
    		}
    		calcMinDistance(points);
    	} else{
    		usage();
    		System.exit(1);
    	}

    }


    /**
     * Read points from file using BufferedReader and InputStreamReader
     * The points are stored inside a list as MultiDimPoint class objects
     */
    static ArrayList<MultiDimPoint> readPointsFromFile(String fileName) {
        ArrayList<MultiDimPoint> points = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(fileName));
        } catch (IOException e) {
            InputStreamReader isr = new InputStreamReader(
                MySolution.class.getClassLoader()
                .getResourceAsStream(fileName));
            reader = new BufferedReader(isr);
        }
        AtomicInteger index = new AtomicInteger(0);
        reader.lines().map(line -> Stream.of(line.split("\t")))
                .map(s -> s.mapToDouble(Double::valueOf))
                .map(s -> s.toArray())
                .forEachOrdered(coords -> points.add(
                new MultiDimPoint(index.incrementAndGet(), coords)));
        return points;
    }

    /**
     * Calculate the closest point pairs, using brute force O(n^2) time.
     * @param points - Array of N dimensional points
     * The function prints out the closest pairs.
     */

    private static void calcMinDistance(ArrayList<MultiDimPoint> points){
    	ArrayList<MultiDimPoint> closestPairs = bruteForce(points);
      // For Debug: System.out.println("Size of closestpairs "+closestPairs.size());
    	for (MultiDimPoint point : closestPairs){
    		point.printCoords();
    	}

    }

    public static ArrayList<MultiDimPoint> bruteForce(ArrayList<MultiDimPoint> points)
    {
    	ArrayList<MultiDimPoint> pair = new ArrayList<MultiDimPoint>();
    	int numPoints = points.size();
    	if (numPoints < 2)
    	  return null;
    	if (numPoints > 2)
    	{
      	    for (int i = 0; i < numPoints - 1; i++){
        		MultiDimPoint point1 = points.get(i);
        		for (int j = i + 1; j < numPoints; j++){
          			MultiDimPoint point2 = points.get(j);
          			// Initialize the pair list
          			if (pair.size() < 1){
          				pair.add(point1);
          				pair.add(point2);
          			}
          			double distance = point1.computeDistance(point2.getCoords());
          			double currDist = pair.get(0).computeDistance(pair.get(1).getCoords());
          			//point1.printCoords();
          			//point2.printCoords();
          			//System.out.println("Point dist: "+distance);
          			//System.out.println("Stored dist: "+currDist);
                if (distance < currDist){
                  pair.removeAll(pair);
                  pair.add(point1);
                  pair.add(point2);                  
                }
        		}
      		}
    	}
      //double currDist = pair.get(0).computeDistance(pair.get(1).getCoords());
      //System.out.println(currDist);
    	return pair;
  	}

}
