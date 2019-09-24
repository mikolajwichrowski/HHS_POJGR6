package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Entity class
*/

public class Entity implements IEntity {
    // TODO: dit is belangrijk
    public int XPosition;
    public int YPosition;

    /**
     * 
     */
    public Entity() {
        XPosition = 0;
        YPosition = 0;
    }

    /**
     * 
     */
    public void setPosition(Integer x, Integer y) {
        this.XPosition = x; // drawing offset
        this.YPosition = y; // drawinf offeset
    }

    /**
     * Action to execute when triggered
     * 
     * 
     */
    public void Notify() {
        // Logic for entity.
        // Make sure to implement features by OOSE principles
        // NOT TO DO : hier komen de algoritmes, afblijven HAHA

        // I verander aan de hand van waar ik ben
    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        g.setColor(Color.PINK);
        g.drawRect(XPosition * 30, YPosition * 30, 30, 30);
    }

    /**
     * 
     * @return
     */
    public int getXPosition() {
        return XPosition;
    }

    /**
     * 
     */
    public int getYPosition() {
        return YPosition;
    }

    /**
     * 
     * @param y
     * @param x
     */
    public void setPosition(int y, int x) {
        this.XPosition = x;
        this.YPosition = y;

    }

}
