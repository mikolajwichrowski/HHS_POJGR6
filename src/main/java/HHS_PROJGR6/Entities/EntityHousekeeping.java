package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.IStressable;

import javax.swing.*;
import java.awt.*;

/*
* Housekeeping class
* Inherits from Entity
*/

public class EntityHousekeeping extends Entity implements IEntity, IStressable {

    // Constructor
    public EntityHousekeeping(String entityImage) {
        super(entityImage);
    }

    public void cleanRoom() {
        // v ---- > room niet als property nemen :D dat is onnzinige agregatie (Probeer
        // hier de algoritme het werk te laten doen ;) tip: if(Hotel.whatsHere(x, y) ==
        // kamer && !Hotel.whatsHere(x, y).isClean())
        // code schrijven voor maak kamer schoon.
        // TODO: Iterate door alle rooms, als room vies is, ga erheen.
    }

    public void panic() {
        cleanRoom();
    }

    public void drawEntity(Graphics g) {
        super.drawEntity(g);
    }

    /**
     * 
     */
    public void Notify() {
        // TODO: If has instructions
        // // Node instruction = instructions.get(0);
        // // setPosition(instruction.getY(), instruction.getX());
        // // instructions.remove(0);
        // TODO: else clean room

        // TODO: if clean room and no instructions
        // Look for filthy room and set instructions
    }
}
