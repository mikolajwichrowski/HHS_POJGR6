package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

public class EntityLeasure extends Entity implements IEntity {
    /**
     * 
     */
    private String activityType;

    /**
     * 
     * @param entityColor
     * @param activityType
     */
    public EntityLeasure(String entityImage, String activityType) {
        super(entityImage);
        this.activityType = activityType;
    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());

        switch (this.activityType) {
        case "Cinema":
            this.entityImage = "Images/cinema.png";
            break;

        case "Fitness":
            this.entityImage = "Images/fitness.png";
            break;
        default:
            break;
        }
        super.drawEntity(g);
    }

    /**
     * @return the activityType
     */
    public String getActivityType() {
        return activityType;
    }

    /**
     * 
     */
    public void Notify() {
        // TODO: ?
    }
}
