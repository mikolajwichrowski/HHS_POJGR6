package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import static HHS_PROJGR6.Settings.getPixelResolution;

/**
 * 
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
    public String entityImage;

    /**
     * 
     */

    private JLabel label;

    public Entity(String entityImage) {
        this.x = 0;
        this.y = 0;
        this.entityImage = entityImage;
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
        Image img1 = Toolkit.getDefaultToolkit().getImage(entityImage);
        g.drawImage(img1, x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution(), null);
        g.setColor(Color.black);
        g.drawRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
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
        // TODO: fix for graph generator
        return entities.stream().filter(e -> {
            boolean position = e.getXPosition() == x && e.getYPosition() == y;
            boolean positionWithOffset = e.getXPosition() + e.getWidth() <= x && e.getYPosition() - e.getHeight() <= y;
            return true;// position && positionWithOffset;
        }).collect(Collectors.toList());
    }

    public void frame() {
        // TODO: Niks wss
    }

    public JLabel getLabel() {
        return this.label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
}
