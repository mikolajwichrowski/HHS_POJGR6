package HHS_PROJGR6.Entities;

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

    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
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
