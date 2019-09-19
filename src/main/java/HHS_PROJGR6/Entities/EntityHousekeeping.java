package HHS_PROJGR6.Entities;

import HHS_PROJGR6.Interfaces.IEntity;

/*
* Housekeeping class
* Inherits from Entity
*/

public class EntityHousekeeping extends Entity implements IEntity {

    EntityRoom entityroom;


    // Constructor
    public EntityHousekeeping() {

    }

    // Action to execute when triggered
    public void doAction() {
        // Logic for Housekeeping entity.
        // Make sure to implement features by OOSE principles
    }

    public void checkRoom(boolean clean) {
        if (entityroom.getClean() == false) {
            // code schrijven voor maak kamer schoon. 
        }

    }
}