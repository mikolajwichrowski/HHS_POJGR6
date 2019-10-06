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
        // TODO: replace color with image path
        switch (type) {
        case "Restaurant":
            return new EntityDiner("Images/Diner.png");

        case "Room":
            return new EntityRoom("Images/0star.png");

        case "Fitness":
            return new EntityLeasure("Images/cinema.png", type);

        case "Cinema":
            return new EntityLeasure("Images/fitness.png", type);

        case "Guest":
            return new EntityGuest("Images/Guest.png");

        case "Housekeeping":
            return new EntityHousekeeping("Images/housekeeping.png");

        case "Elevator":
            return new EntityTransport("Images/Elevator.png", type);

        case "Stairs":
            return new EntityTransport("Images/Stair2.png", type);

        case "Lobby":
            return new EntityLobby("Images/0star.png");

        default:
            return new Entity("Images/0star.png");
        }
    }
}
