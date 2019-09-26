package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Room class
* Inherits from Entity
*/

public class EntityRoom extends Entity implements IEntity {
    public Color roomColor;

    public EntityRoom(Color roomColor) {
        this.roomColor = roomColor;
    }

    @Override
    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(roomColor);
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);

        g.setColor(Color.BLACK);
        g.drawString("R", (x * 60) + (width * 60 / 2), (y * 60) + (height * 60 / 2));


    }

    // Action to execute when triggered
    public void Notify() {
        // Logic for Room entity.
        // Make sure to implement features by OOSE principles
    }

}
