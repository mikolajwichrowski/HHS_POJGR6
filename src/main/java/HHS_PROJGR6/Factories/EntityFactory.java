package HHS_PROJGR6.Factories;

import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.Interfaces.IEntity;

import java.awt.*;

/**
 * The sources below have been used to design the factory. Bron:
 * https://blackboard.hhs.nl/bbcswebdav/pid-2782283-dt-content-rid-23462854_2/courses/H-SE-OOSE-1-17-2019/Advanced%20Programming%201.pdf
 * Bron: https://refactoring.guru/design-patterns/factory-method
 */

public class EntityFactory {

    /**
     * Below switch method creates a String Entity type and returns the new object.
     * Each Entity is a place on the screen. The interface will tell them what to do
     * because the classes inherits the interface IEntity.
     * 
     * @param type
     *                 is from Enum EntityType
     * @return IEntity
     */
    public static IEntity createEntity(String type) {
        // Creating entity based on requested type
        switch (type) {
        case "Restaurant":
            return new EntityDiner(new Color(255, 128, 0));

        case "Room":
            return new EntityRoom(new Color(255, 255, 255));

        case "Fitness":
            return new EntityLeasure(new Color(255, 0, 0), type);

        case "Cinema":
            return new EntityLeasure(new Color(255, 0, 255), type);

        case "Guest":
            return new EntityGuest(new Color(0, 0, 0));

        case "Housekeeping":
            return new EntityHousekeeping(new Color(0, 255, 255));

        case "Elevator":
            return new EntityTransport(new Color(138, 138, 92));

        case "Stairs":
            return new EntityTransport(new Color(214, 214, 194));

        case "Default":
            return new EntityTransport(Color.white);

        default:
            return new Entity(Color.white);
        }
    }
}
