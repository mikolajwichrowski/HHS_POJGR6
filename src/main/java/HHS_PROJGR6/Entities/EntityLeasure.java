package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;
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
     * @param event
     */
    public void Notify(HotelEvent event) {
        // if (event == HotelEventType.START_CINEMA) {
        // set op locked
        // }

        // als lock op 1 dan tellen
        if (false) {
            // wacht tijd ophogen zolang wacht tijd tussen 1 en eind(10?)
        }
    }

    /**
     * 
     */
    public void drawEntity(Graphics g) {
        g.setColor(new Color(84, 84, 84));
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
     * 
     */
    public void frame() {
        // TODO: ?
    }
}
