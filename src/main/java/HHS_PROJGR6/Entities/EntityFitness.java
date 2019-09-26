package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

public class EntityFitness extends Entity implements IEntity {

    public EntityFitness() {

    }


    public void Notify() {
        // Logic for Diner entity.
        // Make sure to implement features by OOSE principles
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(Color.RED);
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);

        g.setColor(Color.BLACK);
        g.drawString("F", (x * 60) + (width * 60 / 2), (y * 60) + (height * 60 / 2));

    }
}

