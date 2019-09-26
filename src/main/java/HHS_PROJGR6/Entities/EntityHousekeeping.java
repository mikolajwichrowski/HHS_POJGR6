package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/*
* Housekeeping class
* Inherits from Entity
*/

public class EntityHousekeeping extends Entity implements IEntity {

    // Constructor
    public EntityHousekeeping() {
    }

    // Action to execute when triggered
    public void Notify() {
        // Logic for Housekeeping entity.
        // Make sure to implement features by OOSE principles
    }

    public void checkRoom(boolean clean) {
        // v ---- > room niet als property nemen :D dat is onnzinige agregatie (Probeer
        // hier de algoritme het werk te laten doen ;) tip: if(Hotel.whatsHere(x, y) ==
        // kamer && !Hotel.whatsHere(x, y).isClean())
        // if (entityroom.getClean() == false) {
        // code schrijven voor maak kamer schoon.
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(Color.PINK);
        g.fillRect(x * 60, y * 60, width * 60, height * 60);
    }

}
