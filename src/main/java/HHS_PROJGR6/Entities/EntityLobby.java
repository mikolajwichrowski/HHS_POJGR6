package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import static HHS_PROJGR6.Settings.getPixelResolution;

import java.awt.*;

public class EntityLobby extends Entity implements IEntity {
    public EntityLobby(String entityImage) {
        super(entityImage);
    }

    public void drawEntity(Graphics g) {
        g.setColor(new Color(84, 84, 84));
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
        super.drawEntity(g);
    }

    /**
     * 
     */
    public void frame() {
        // TODO: nothing
    }
}
