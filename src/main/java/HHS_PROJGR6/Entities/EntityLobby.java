package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

public class EntityLobby extends Entity implements IEntity {
    public EntityLobby(Color entityColor) {
        super(entityColor);
    }

    public void drawEntity(Graphics g) {
        g.setColor(entityColor);
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
        super.drawEntity(g);
    }

    /**
     * 
     */
    public void frame() {
        // TODO: nothing
    }
}
