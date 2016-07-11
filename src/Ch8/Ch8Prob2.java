package Ch8;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Valued Customer on 2016/7/7.
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can
 * only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on
 * them. Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class Ch8Prob2 {
    class Point {
        int r;
        int c;
        Point(int row, int col) {r = row; c = col;}
    }

    ArrayList<Point> findPath(boolean[][] map) {
        if (map == null || map.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<Point>();
        if (getPath(map, map.length-1, map[0].length-1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);

        // if we've already visited this cell, return.
        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        // if there's a path from start to my current location, add my location
        if (isAtOrigin || getPath(maze, row, col-1, path, failedPoints) || getPath(maze, row-1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }
}
