package HHS_PROJGR6.Factories;

import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Entities.*;

/*
* Factory class
* Creates a Entity object
*/ 
public class EntityFactory {
    // Constructor
    public EntityFactory() {

    }

    // Action to execute when triggered
    public IEntity createEntity() {
        // Logic for Factory entity.
        // Make sure to implement features by OOSE principles
        return new EntityRoom();
    }
}


