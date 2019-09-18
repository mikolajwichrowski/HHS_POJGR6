package HHS_PROJGR6.Entities;

import java.awt.Color;
import java.awt.Graphics;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Entity class
*/

public class Entity implements IEntity {
    private int XPosition;
    private int YPosition;

    // Constructor
    public Entity() {
        // Start positie entiteit
        XPosition = 50;
        YPosition = 600;
    }

    // Action to execute when triggered
    public void doAction() {
        if (XPosition == 50) {
            XPosition += 100;
        }

        // Logic for entity.
        // Make sure to implement features by OOSE principles
        // NOT TO DO : hier komen de algoritmes, afblijven HAHA

        // I verander aan de hand van waar ik ben
    }

    public void drawEntity(Graphics g) {
        // TODO: Teken mij :)
        g.setColor(Color.RED);
        g.drawRect(XPosition, YPosition, 50, 50);
    }


    public int getXPosition() {
        return XPosition;
    }

    public int getYPosition() {
        return YPosition;
    }
}


