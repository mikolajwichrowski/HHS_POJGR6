package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.External.*;
import HHS_PROJGR6.Utils.Node;

import java.awt.*;
import java.util.ArrayList;

/*
* Housekeeping class
* Inherits from Entity
*/

public class EntityHousekeeping extends Entity implements IEntity, HotelEventListener {

    // Constructor
    public EntityHousekeeping(Color entityColor) {
        super(entityColor);
    }

    public void cleanRoom() {
        // v ---- > room niet als property nemen :D dat is onnzinige agregatie (Probeer
        // hier de algoritme het werk te laten doen ;) tip: if(Hotel.whatsHere(x, y) ==
        // kamer && !Hotel.whatsHere(x, y).isClean())
        // code schrijven voor maak kamer schoon.
        // TODO: Iterate door alle rooms, als room vies is, ga erheen.
    }

    public void Panic() {
        cleanRoom();
    }

    public void drawEntity(Graphics g) {
        g.setColor(entityColor);
        g.fillRect(x * 60, y * 60, width * 60, height * 60);
        super.drawEntity(g);
    }

    /**
     * 
     */
    public void frame() {
        // TODO: If has instructions
        Node instruction = instructions.get(0);
        setPosition(instruction.getY(), instruction.getX());
        instructions.remove(0);
        // TODO: else clean room

        // TODO: if clean room and no instructions
        // Look for filthy room and set instructions
    }
}
