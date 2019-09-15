package HHS_PROJGR6.Factories;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Entities.*;

/**
 * The class EntityFactory creates new Entities en return the correct type.
 */

public class EntityFactory {


    public static IEntity createEntity(String type) {
        switch (type) {

            case "EntityDiner":
                return new EntityDiner();

            case "EntityGuest":
                return new EntityGuest();

            case "EntityHouseKeeping":
                return new EntityHousekeeping();

            case "EntityRoom":
                return new EntityRoom();

            default:
                return new Entity();
        }
    }
}

