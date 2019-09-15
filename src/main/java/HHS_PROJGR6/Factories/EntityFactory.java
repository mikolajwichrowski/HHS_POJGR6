package HHS_PROJGR6.Factories;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Entities.*;


public class EntityFactory {


    // Constructor
    public EntityFactory() {

    }

    // Action to execute when triggered
    public static Entity createEntity(Entity type) {

Entity entity = null;

switch (type) {

    case Entity:
        entity = new Entity();
        break;

    case EntityDiner:
        entity = new EntityDiner();
        break;

    case EntityGuest:
        entity = new EntityGuest();
        break;

    case EntityHousekeeping:
        entity = new EntityHousekeeping();
        break;

    case EntityRoom:
        entity = new EntityRoom();
        break;

        }
        // Logic for Factory entity.
        // Make sure to implement features by OOSE principles
        return new EntityRoom();
    }
}

