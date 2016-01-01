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

    public PathFinding() {
        list = new ArrayList<>();
    }

    public void addPoint(int x, int y) {
        list.add(new PathPoint(x, y));
    }

    public PathPoint getPoint(int x) {
        if (x < list.size()) {
            return list.get(x);
        }
        return list.get(list.size()-1);

    }

    public int getSize() {
        return list.size();
    }

    public List<PathPoint> getPoints() {
        return list;
    }
}
