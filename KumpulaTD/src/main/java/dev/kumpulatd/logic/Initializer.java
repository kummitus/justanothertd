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

    public static GoalLocation initGoal(String row, GoalLocation goal) {
        try {
            String[] list = row.split(",");
            goal = new GoalLocation(Integer.parseInt(list[0]), Integer.parseInt(list[1]));
        } catch (Exception e) {
            new WarningMessage().invokeWarning("Map file corrupt");
        }
        return goal;
    }

    public static void initLists(String row, List<SpawnLocation> spawns, List<TowerLocation> towerlocations) {
        try {
            String[] list = row.split(",");
            for (int i = 0; i < list.length; i += 2) {
                spawns.add(new SpawnLocation(Integer.parseInt(list[i]), Integer.parseInt(list[i + 1])));
            }
            towerlocations = new ArrayList<>();
        } catch (Exception e) {
            new WarningMessage().invokeWarning("Map file corrupt");
        }
    }

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

    public static void initTowers(String row, List<TowerLocation> towerlocations) {
        try {
            String[] list = row.split(",");
            int j = 1;
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

    public static void initImages(List<BufferedImage> imagelist) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/freshman0.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/freshman1.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/tutor.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/professor.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/tutorammo.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
        try {
            img = ImageIO.read(new File("src/main/resources/professorammo.png"));
        } catch (IOException e) {

            img = new BufferedImage(1, 1, 1);

        }
        imagelist.add(img);
    }

}
