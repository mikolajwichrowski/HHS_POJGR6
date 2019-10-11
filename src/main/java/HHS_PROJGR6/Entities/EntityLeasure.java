package HHS_PROJGR6.Entities;

import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

public class EntityLeasure extends Entity {
    /**
     *
     */
    private String activityType;

    /**
     * @param entityImage
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
        g.fillRect(getX() * getPixelResolution(), (getY() - (getHeight() - 1)) * getPixelResolution(), getWidth() * getPixelResolution(), getHeight() * getPixelResolution());
        super.drawEntity(g);
    }

    /**
     * @return the activityType
     */
    public String getActivityType() {
        return activityType;
    }
}
