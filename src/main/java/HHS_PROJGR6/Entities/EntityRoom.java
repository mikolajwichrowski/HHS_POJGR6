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
        g.fillRect(x * 30, (y - (height - 1)) * 30, width * 30, height * 30);

        g.setColor(Color.PINK);
        g.drawString("R", (x * 30) + (width * 30 / 2), (y * 30) + (width * 30 / 2));
    }

    // Action to execute when triggered
    public void Notify() {
        // Logic for Room entity.
        // Make sure to implement features by OOSE principles
    }

}
