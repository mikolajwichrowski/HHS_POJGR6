package HHS_PROJGR6.Entities;

import java.awt.Color;
import java.awt.Graphics;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Entity class
*/

public class Entity implements HotelEventListener, IEntity {
    // TODO: dit is belangrijk
    private int XPosition;
    private int YPosition;

    /**
     * 
     */
    public Entity() {
        // Start positie entiteit
        XPosition = 30;
        YPosition = 600;
    }

    public void setPosition(Integer x, Integer y) {
        this.XPosition = x;
        this.YPosition = y;
    }

    /**
     * Action to execute when triggered
     * 
     * 
     */
    public void doAction() {
        if (XPosition == 30) {
            XPosition += 100;
        }

        // Logic for entity.
        // Make sure to implement features by OOSE principles
        // NOT TO DO : hier komen de algoritmes, afblijven HAHA

        // I verander aan de hand van waar ik ben
    }

    public void drawEntity(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(XPosition * 30, YPosition * 30, 30, 30);
    }

    public int getXPosition() {
        return XPosition;
    }

    public int getYPosition() {
        return YPosition;
    }

    @Override
    public void Notify(HotelEvent event) {
        // TODO Auto-generated method stub

    }
}
