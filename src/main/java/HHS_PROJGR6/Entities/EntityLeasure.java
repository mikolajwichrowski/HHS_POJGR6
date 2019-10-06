package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

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

        switch (this.activityType) {

            case "Cinema":
                Image img1 = Toolkit.getDefaultToolkit().getImage("Images/cinema.png");
                g.drawImage(img1, x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution(), null);
                //g.setColor(entityColor);
                //g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
                super.drawEntity(g);
                break;

            case "Fitness":
                Image img2 = Toolkit.getDefaultToolkit().getImage("Images/fitness.png");
                g.drawImage(img2, x * getPixelResolution(), y * getPixelResolution(), getPixelResolution(), getPixelResolution(), null);
                super.drawEntity(g);
                break;

            default:



        }

    }
}
