package HHS_PROJGR6.Entities;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
 * Diner class
 * Inherits from Entity
 */
public class EntityTransport extends Entity {
    public EntityTransport(String entityImage) {
        super(entityImage);
    }

    /**
     *
     */
    public void drawEntity(Graphics g) {
        g.fillRect(getX() * getPixelResolution(), (getY() - (getHeight() - 1)) * getPixelResolution(), getWidth() * getPixelResolution(), getHeight() * getPixelResolution());
        super.drawEntity(g);
    }
}
