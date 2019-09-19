package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;


/*
* Room class
* Inherits from Entity
*/

public class EntityRoom extends Entity implements IEntity {

private int StarRoom;
public boolean Clean;

    public EntityRoom(int starRoom, boolean clean){
    this.StarRoom = starRoom;
    this.Clean = clean;

    // clean = true;
    // wij dachten zelf bovenstaande regel toe te passen.
    /*
    @ miek: zullen we de kamer bij default op true zetten en wanneer een klant is geweest dat deze veranderd naar false?
     */
    }

    @Override
    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(Color.BLUE);
        g.fillRect(XPosition*30, YPosition*30, 60, 60);
    }

    // Action to execute when triggered
    public void doAction() {
        // Logic for Room entity.
        // Make sure to implement features by OOSE principles
    }

    public boolean getClean() {
        return Clean;
    }

        public void setClean(boolean clean){
            this.Clean = true;
    }

}
