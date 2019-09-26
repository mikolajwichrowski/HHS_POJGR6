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
            return new EntityDiner();

//            case"Room":
//                return new EntityRoom(Color.green);

        case "Fitness":
            return new EntityFitness();

        case "Cinema":
            return new EntityCinema();

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

    public static IEntity createEntityRoom (String classification) {
        // Creating entity based on requested type
        switch (classification) {
            case "1 Star":
            return new EntityRoom(Color.green);

            case "2 Star":
                return new EntityRoom(Color.blue);

            default:
                return new Entity();
        }
    }

}
