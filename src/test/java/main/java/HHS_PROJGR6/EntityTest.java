package HHS_PROJGR6;

import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

import HHS_PROJGR6.Factories.EntityFactory;
import HHS_PROJGR6.Utils.DijkstraAlgorithm;
import HHS_PROJGR6.Utils.Node;
import HHS_PROJGR6.Entities.EntityGuest;

public class EntityTest {
    @Test
    public void movementPerFrame() throws Exception {
        EntityGuest guest = (EntityGuest) EntityFactory.createEntity("Guest", null);

        // Make instructions publicly accesible
        Field field = EntityGuest.class.getDeclaredField("instructions");
        field.setAccessible(true);

        // Create and add instructions
        ArrayList<Node> instructions = new ArrayList<Node>();
        instructions.add(DijkstraAlgorithm.createLocationNode(1, 1));
        instructions.add(DijkstraAlgorithm.createLocationNode(1, 2));
        instructions.add(DijkstraAlgorithm.createLocationNode(1, 3));
        instructions.add(DijkstraAlgorithm.createLocationNode(1, 4));
        guest.setInstructions(instructions);

        // Check amount of instrutions
        int lengthOfInstructions = ((ArrayList<Node>) field.get(guest)).size();
        assertEquals(lengthOfInstructions, 4);

        // Execute frame and check for new value
        guest.Notify();
        lengthOfInstructions = ((ArrayList<Node>) field.get(guest)).size();

        // Assert value after frame
        assertEquals(lengthOfInstructions, 3);
    }
}
