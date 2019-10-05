
package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.External.*;

import java.awt.*;

/*
* Diner class
* Inherits from Entity
*/

public class EntityTransport extends Entity implements IEntity {

    /**
     * 
     * @param entityColor
     */
    public EntityTransport(Color entityColor) {
        super(entityColor);
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
        g.fillRect(x * 60, (y - (height - 1)) * 60, width * 60, height * 60);
        super.drawEntity(g);
    }
}
