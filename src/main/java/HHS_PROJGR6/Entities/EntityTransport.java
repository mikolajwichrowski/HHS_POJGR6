
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;
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
            this.entityImage = "Images/Stair2.png";
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
        g.setColor(new Color(84, 84, 84));
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());

        super.drawEntity(g);
    }
}
