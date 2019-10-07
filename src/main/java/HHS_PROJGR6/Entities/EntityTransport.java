
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Diner class
* Inherits from Entity
*/
public class EntityTransport extends Entity implements IEntity {
    public EntityTransport(String entityImage, String activityType) {
        super(entityImage);
        switch (activityType) {
        case "Stairs":
            this.entityImage = "Images/Stair.png";
            break;
        case "Elevator":
            this.entityImage = "Images/Elevator.png";
            break;
        default:
            break;
        }
    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());

        super.drawEntity(g);
    }
}
