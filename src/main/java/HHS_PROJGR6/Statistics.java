package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Entities.EntityGuest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Bron: https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */
public class Statistics extends JFrame {

    public Statistics(List<Entity> entities) {
        super.setSize(400, 540);
        super.setLocation(935, 0);

        // Define data and columns
        List<String[]> data = new ArrayList<String[]>();
        String column[] = { "Person", "Floor", "Preference",/* "Location" */ };

        // Loop trough entities
        for (int i = 0; i < entities.size(); i++) {
            // Set row data
            if (entities.get(i) instanceof EntityGuest) {
                EntityGuest entity = (EntityGuest) entities.get(i);
                String[] row = new String[3];
                row[0] = "Guest: " + ((EntityGuest) entities.get(i)).getID();
                row[1] = "" + entities.get(i).getY();

                if (entities.get(i).getY() == 7) {
                    row[1] = "Lobby";
                }if (entities.get(i).getY() == 6) {
                    row[1] = "First floor";
                }if (entities.get(i).getY() == 5) {
                    row[1] = "Second floor";
                }if (entities.get(i).getY() == 4) {
                    row[1] = "Third floor";
                }if (entities.get(i).getY() == 3) {
                    row[1] = "Fourth floor";
                }if (entities.get(i).getY() == 2) {
                    row[1] = "Fifth floor";
                }
                row[2] = "Room: " + ((EntityGuest) entities.get(i)).getPreference();
                //row[3] = ""+ ((EntityHousekeeping) entities.get(i))

                // for (IEntity lookupEntity : entities) {
                // if (lookupEntity.getXPosition() == entity.getXPosition() &&
                // lookupEntity.getYPosition() == entity.getYPosition()) {
                //
                // if (lookupEntity instanceof EntityRoom) {
                // row[4] = "Room " + ((EntityRoom) lookupEntity).getClassification();
                // }
                // if (lookupEntity instanceof EntityLobby) {
                //
                // }
                // // Set row in data
                // }
                // }
                data.add(row);
            }
        }

        // Create table
        String[][] arrayOfData = new String[data.size()][];
        arrayOfData = data.toArray(arrayOfData);

        JTable jt = new JTable(arrayOfData, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        add(sp);

        setTitle("Statistieken");
        setResizable(true);
        getContentPane().setBackground(new Color(245, 245, 240));
    }
}
