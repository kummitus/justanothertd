/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kummi
 */
public class PathFinding {

    private List<PathPoint> list;

    /**
     *Constructor for the PathFinding class
     */
    public PathFinding() {
        list = new ArrayList<>();
    }

    /**
     * Add a point to the pathfinding class
     * @param x
     * @param y
     */
    public void addPoint(int x, int y) {
        list.add(new PathPoint(x, y));
    }

    /**
     * Get a point from pathfinding class
     * @param x
     * @return
     */
    public PathPoint getPoint(int x) {
        if (x < list.size()) {
            return list.get(x);
        }
        return list.get(list.size()-1);

    }

    /**
     * Get the length of the path
     * @return
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Get all the waypoints
     * @return
     */
    public List<PathPoint> getPoints() {
        return list;
    }
}
