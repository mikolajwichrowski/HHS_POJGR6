package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Entities.EntityGuest;
import HHS_PROJGR6.Entities.EntityLobby;
import HHS_PROJGR6.Entities.EntityRoom;
import HHS_PROJGR6.Interfaces.IEntity;
import HHS_PROJGR6.Interfaces.ISquare;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Bron: https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */
public class Statistics extends JFrame {

    /**
     * 
     * @param entities
     */
    public Statistics(ArrayList<Entity> entities) {
        super.setSize(800, 300);
        super.setLocation(1050, 0);

        // Define data and columns
        List<String[]> data = new ArrayList<String[]>();
        String column[] = { "Guest", "position", "Location", "Preference", "Location" };

        // Loop trough entities
        for (int i = 0; i < entities.size(); i++) {
            // Set row data
            if (entities.get(i) instanceof EntityGuest) {
                EntityGuest entity = (EntityGuest) entities.get(i);
                String[] row = new String[5];
                row[0] = "Guest: " + ((EntityGuest) entities.get(i)).getID();
                row[1] = "" + entities.get(i).getX();
                row[2] = "" + entities.get(i).getY();

                if (entities.get(i).getY() == 7) {
                    row[2] = "Lobby";
                }
                if (entities.get(i).getY() == 6) {
                    row[2] = "First floor";
                }
                if (entities.get(i).getY() == 5) {
                    row[2] = "Second floor";
                }
                if (entities.get(i).getY() == 4) {
                    row[2] = "Third floor";
                }
                if (entities.get(i).getY() == 3) {
                    row[2] = "Fourth floor";
                }
                if (entities.get(i).getY() == 2) {
                    row[2] = "Fifth floor";
                }

                row[3] = "Room " + ((EntityGuest) entities.get(i)).getPreference();

                for (ISquare lookupEntity : entities) {
                    if (lookupEntity.getX() == entity.getX() && lookupEntity.getY() == entity.getY()) {

                        if (lookupEntity instanceof EntityRoom) {
                            row[4] = "Room " + ((EntityRoom) lookupEntity).getClassification();
                        }
                        if (lookupEntity instanceof EntityLobby) {
                            row[4] = "Lobby";
                        }
                        // Set row in data
                    }
                }
                data.add(row);

            }

        }

        // Create table
        String[][] arrayOfData = new String[data.size()][];
        arrayOfData = data.toArray(arrayOfData);

        JTable jt = new JTable(arrayOfData, column);

        // Add table
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);

        add(sp);

        setTitle("Statistieken");
        setResizable(true);
        getContentPane().setBackground(new Color(245, 245, 240));
    }
}
