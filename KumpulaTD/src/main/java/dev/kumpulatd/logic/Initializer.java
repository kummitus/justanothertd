/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.logic;

import dev.kumpulatd.objects.GoalLocation;
import dev.kumpulatd.objects.SpawnLocation;
import dev.kumpulatd.objects.TowerLocation;
import dev.kumpulatd.ui.WarningMessage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author kummi
 */
public class Initializer {

    private static void testForNegativeNumber(String[] list) throws NumberFormatException {
        for (String number : list) {
            try {
                if (Integer.parseInt(number) < 0) {
                    new WarningMessage().invokeWarning("Negative number in files");
                }
            } catch (Exception e){
                new WarningMessage().invokeWarning("Some coordinate is not a number");
            }
        }
    }

    /**
     *
     * @param row
     * @param goal
     * @return
     */
    public static GoalLocation initGoal(String row, GoalLocation goal) {
        try {
            String[] list = row.split(",");
            testForNegativeNumber(list);
            goal = new GoalLocation(Integer.parseInt(list[0]), Integer.parseInt(list[1]));
        } catch (Exception e) {
            new WarningMessage().invokeWarning("Map file corrupt");
        }
        return goal;
    }

    /**
     *
     * @param row
     * @param spawns
     * @param towerlocations
     */
    public static void initLists(String row, List<SpawnLocation> spawns, List<TowerLocation> towerlocations) {
        try {
            String[] list = row.split(",");
            testForNegativeNumber(list);
            for (int i = 0; i < list.length; i += 2) {
                spawns.add(new SpawnLocation(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1])));
            }
            towerlocations = new ArrayList<>();
        } catch (Exception e) {
            new WarningMessage().invokeWarning("Map file corrupt");
        }
    }

    /**
     *
     * @param row
     * @param path
     */
    public static void initPath(String row, PathFinding path) {
        try {
            String[] list = row.split(",");
            for (int i = 0; i < list.length; i += 2) {
                path.addPoint(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1]));
            }
        } catch (Exception e) {
            new WarningMessage().invokeWarning("Map file corrupt");
        }
    }

    /**
     *
     * @param row
     * @param towerlocations
     */
    public static void initTowers(String row, List<TowerLocation> towerlocations) {
        try {
            String[] list = row.split(",");
            int j = 1;
            testForNegativeNumber(list);
            for (int i = 0; i < list.length; i += 2) {
                towerlocations.add(new TowerLocation(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1]), j));
                j++;
                if (j > 9) {
                    break;
                }
            }
        } catch (Exception e) {
            new WarningMessage().invokeWarning("Map file corrupt");
        }
    }

    /**
     *
     * @param imagelist
     */
    public static void initImages(List<BufferedImage> imagelist) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("assets/freshman0.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("assets/freshman1.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("assets/tutor.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("assets/professor.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("assets/tutorammo.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("assets/professorammo.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
    }

}
