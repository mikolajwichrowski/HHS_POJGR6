package HHS_PROJGR6.Entities;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
 * Diner class
 * Inherits from Entity
 */

public class EntityDiner extends Entity {

    /**
     * Constructor
     * 
     * @param entityImage
     */
    public EntityDiner(String entityImage) {
        super(entityImage);
    }

    /**
     * 
     * @param g
     */
    public void drawEntity(Graphics g) {
        g.fillRect(getX() * getPixelResolution(), (getY() - (getHeight() - 1)) * getPixelResolution(), getWidth() * getPixelResolution(), getHeight() * getPixelResolution());
        super.drawEntity(g);
    }
}
