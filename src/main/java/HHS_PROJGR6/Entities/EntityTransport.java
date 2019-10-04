
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.External.HotelEvent;
import HHS_PROJGR6.External.HotelEventListener;
import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;
import java.awt.*;

import static HHS_PROJGR6.Settings.getPixelResolution;

/*
* Diner class
* Inherits from Entity
*/

public class EntityTransport extends Entity implements IEntity, HotelEventListener {
    /**
     * 
     * @param entityColor
     */
    private ImageIcon image;

    public EntityTransport(Color entityColor) {
        super(entityColor);
        //this.image=image;

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
        //ImageIcon T = new ImageIcon("C:\\Icons\\Sleutelbarricade\\SleutelRood100.png");
        g.fillRect(x * getPixelResolution(), (y - (height - 1)) * getPixelResolution(), width * getPixelResolution(), height * getPixelResolution());
        super.drawEntity(g);
    }
}
