
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

    public EntityTransport(Color entityColor, String activityType) {
        super(entityColor);
        this.activityType = activityType;
    }

    /**
     * Action to execute when triggered
     * 
     * @param event
     */
    public void Notify(HotelEvent event) {
        // Logic for transport entity.
        // Make sure to implement features by OOSE principles
    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        g.setColor(entityColor);
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());

        switch (this.activityType) {

        case "Stairs":

            Image img1 = Toolkit.getDefaultToolkit().getImage("Images/Stair2.png");
            g.drawImage(img1, x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution(), null);
            super.drawEntity(g);
            break;

        case "Elevator":
            Image img2 = Toolkit.getDefaultToolkit().getImage("Images/Elevator.png");
            g.drawImage(img2, x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution(), null);
            super.drawEntity(g);
            break;

        case "Default":

            break;

        default:
        }

    }
}
