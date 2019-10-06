package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/*
* Entity class
*/

public class Entity implements IEntity, HotelEventListener {
    /**
     * 
     */
    public int x;

    /**
     * 
     */
    public int y;

    /**
     * 
     */
    public int width;

    /**
     * 
     */
    public int height;

    /**
     * 
     */
    public Color entityColor;


    /**
     * 
     */

    private JLabel label;

    private int pixelResolution;

    public Entity(Color entityColor) {
        this.x = 0;
        this.y = 0;
        this.entityColor = entityColor;
        this.pixelResolution = Settings.getPixelResolution();
    }

    /**
     * Action to execute when triggered
     * 
     */
    public void Notify(HotelEvent entities) {

    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        //g.setColor(Color.black);
        g.drawRect(x * pixelResolution, (y - (height - 1)) * pixelResolution, width * pixelResolution, height * pixelResolution);

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
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
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

    /**
     * Util to get entity on position
     * 
     * @param x
     * @param y
     * @param entities
     * @return
     */
    public static List<IEntity> getOnPosition(int x, int y, List<IEntity> entities) {
        // return entities.stream().filter(e -> {
        // return e.getXPosition() == x && e.getXPosition() + e.getWidth() <= x &&
        // e.getYPosition() == y && e.getYPosition() - e.getHeight() <= y;
        // }).toArray(IEntity);
        return null;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
}
