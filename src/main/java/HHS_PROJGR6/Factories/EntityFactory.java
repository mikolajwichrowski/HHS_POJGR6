package HHS_PROJGR6.Factories;

import HHS_PROJGR6.Entities.*;
import HHS_PROJGR6.Interfaces.IEntity;

import javax.swing.*;

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
            return new EntityDiner(new JLabel("Restaurant"));

        case "Room":
            return new EntityRoom(new JLabel());

        case "Fitness":
            return new EntityLeasure(new JLabel(), type);

        case "Cinema":
            return new EntityLeasure(new JLabel(), type);

        case "Guest":
            return new EntityGuest(new JLabel());

        case "Housekeeping":
            return new EntityHousekeeping(new JLabel());

        case "Elevator":
            return new EntityTransport(new JLabel("Images/Elevator.png"), type);

        case "Stairs":
            return new EntityTransport(new JLabel(), type);

        case "Lobby":
            return new EntityLobby(new JLabel());

        default:
            return new Entity(new JLabel());
        }
    }
}
