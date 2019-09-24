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
    public int x;
    public int y;
    public int width;
    public int height;

    /**
     * 
     */
    public Entity() {
        this.x = 0;
        this.y = 0;
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
        g.drawRect(x * 30, (y - (height - 1)) * 30, width * 30, height * 30);
    }

    /**
     * 
     * @return
     */
    public int getXPosition() {
        return x;
    }

    /**
     * 
     */
    public int getYPosition() {
        return y;
    }

    /**
     * 
     * @param y
     * @param x
     */
    public void setPosition(Integer y, Integer x) {
        this.x = x;
        this.y = y;

    }

    /**
     * 
     * @param y
     * @param x
     */
    public void setDimensions(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

}
