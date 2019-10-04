package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;
import java.util.ArrayList;
import HHS_PROJGR6.External.*;

public class EntityLeasure extends Entity implements IEntity, HotelEventListener {
    /**
     * 
     */
    private String activityType;

    /**
     * 
     * @param entityColor
     * @param activityType
     */
    public EntityLeasure(Color entityColor, String activityType) {
        super(entityColor);
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
        g.setColor(entityColor);
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
        super.drawEntity(g);
    }
}
