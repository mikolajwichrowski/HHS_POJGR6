package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;
import java.util.ArrayList;

public class EntityLeasure extends Entity implements IEntity {
    private String activityType;

    public EntityLeasure(Color entityColor, String activityType) {
        super(entityColor);
        this.activityType = activityType;

    }


    public void Notify(ArrayList<IEntity> entities) {
        // Logic for Diner entity.
        // Make sure to implement features by OOSE principles
    }

    public void drawEntity(Graphics g) {
        g.setColor(entityColor);
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
        super.drawEntity(g);
    }
}



