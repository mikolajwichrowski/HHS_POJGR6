package HHS_PROJGR6.Factories;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.Enums.EntityType;

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
            return new EntityRoom(Color.BLUE);
        case "Fitness":
            return new EntityRoom(Color.RED);
        case "Cinema":
            return new EntityRoom(Color.ORANGE);
        case "Room":
            return new EntityRoom(Color.GREEN);

        case "Guest":
            return new EntityGuest();

        case "Housekeeping":
            return new EntityHousekeeping();

        case "Transport":
            return new EntityTransport();

        default:
            return new Entity();
        }
    }
}
