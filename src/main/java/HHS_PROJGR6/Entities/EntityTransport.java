
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Diner class
* Inherits from Entity
*/
public class EntityTransport extends Entity implements IEntity {
    private String activityType;

    public EntityTransport(String entityImage, String activityType) {
        super(entityImage);
        this.activityType = activityType;
    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        g.setColor(new Color(84, 84, 84));
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());

        switch (this.activityType) {
        case "Stairs":
            this.entityImage = Toolkit.getDefaultToolkit().getImage("Images/Stair2.png");
            break;
        case "Elevator":
            this.entityImage = Toolkit.getDefaultToolkit().getImage("Images/Elevator.png");
            break;
        default:
            break;
        }
        super.drawEntity(g);
    }
}
