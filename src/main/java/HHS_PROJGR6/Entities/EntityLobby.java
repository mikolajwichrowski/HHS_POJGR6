package HHS_PROJGR6.Entities;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

public class EntityLobby extends Entity {
    public EntityLobby(String entityImage) {
        super(entityImage);
    }

    public void drawEntity(Graphics g) {
        g.fillRect(getX() * getPixelResolution(), (getY() - (getHeight() - 1)) * getPixelResolution(), getWidth() * getPixelResolution(), getHeight() * getPixelResolution());
        super.drawEntity(g);
    }
}
