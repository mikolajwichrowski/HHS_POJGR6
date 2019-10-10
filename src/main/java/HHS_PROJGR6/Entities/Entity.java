package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.ISquare;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static HHS_PROJGR6.Settings.getPixelResolution;

/**
 * 
 */
public class Entity implements ISquare {
    /**
     * 
     */
    private int x;

    /**
     * 
     */
    private int y;

    /**
     * 
     */
    private int width;

    /**
     * 
     */
    private int height;

    /**
     * 
     */
    private String entityImage;

    /**
     * 
     * @param entityImage
     */
    public Entity(String entityImage) {
        this.x = 0;
        this.y = 0;
        this.entityImage = entityImage;
    }

    /**
     * 
     * @param g
     */
    public void drawEntity(Graphics g) {
        Image img1 = Toolkit.getDefaultToolkit().getImage(entityImage);
        g.drawImage(img1, x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution(), null);
        g.setColor(Color.black);
        g.drawRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
    }

    /**
     * 
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * 
     */
    public int getY() {
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
    public static ArrayList<ISquare> getOnPosition(int x, int y, ArrayList<Entity> entities) {
        return ((ArrayList<ISquare>) entities.clone()).stream().filter(entity -> {
            ISquare e = (ISquare) entity;
            boolean belowPosition = e.getX() + (e.getWidth() - 1) >= x && e.getY() - (e.getHeight() - 1) <= y;
            boolean abovePostion = (e.getX() <= x && e.getY() >= y) ? belowPosition : false;
            return true; // abovePostion;
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Parse string to int and remove all other characters while doing this.
     * 
     * @param someText
     * @return
     */
    public static Integer parseInt(String someText) {
        return Integer.parseInt(0 + someText.replaceAll("[^0-9]+", ""));
    }

    /**
     * 
     */
    public void Notify() {
        // TODO: Niks wss
    }
}
