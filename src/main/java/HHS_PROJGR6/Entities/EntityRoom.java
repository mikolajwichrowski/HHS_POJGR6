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

String AreaType;


    public EntityRoom() {

    }

    @Override
    public void drawEntity(Graphics g) {
        super.drawEntity(g);
        g.setColor(Color.BLUE);
        g.drawRect(XPosition*30, YPosition*30, 30, 30);

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
