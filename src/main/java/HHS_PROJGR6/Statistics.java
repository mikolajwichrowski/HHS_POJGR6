package HHS_PROJGR6;

import HHS_PROJGR6.Entities.Entity;
import HHS_PROJGR6.Entities.EntityGuest;
import HHS_PROJGR6.Entities.EntityRoom;
import HHS_PROJGR6.Interfaces.ISquare;

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

        setStatistics(entities);

        setTitle("Statistieken");
        setResizable(true);
        getContentPane().setBackground(new Color(245, 245, 240));
        setVisible(true);

    }

    public void setStatistics(List<Entity> entities) {
        getContentPane().removeAll();
        repaint();

        JTable jt = new JTable();

        // Define data and columns
        List<String[]> data = new ArrayList<String[]>();

        String column[] = { "Person", "Floor", "Preference", "Room" };

        // Loop trough entities
        // Set row data
        for (int i = 0; i < entities.size(); i++)
            if (entities.get(i) instanceof EntityGuest) {
                String[] row = new String[4];
                row[0] = "Guest: " + ((EntityGuest) entities.get(i)).getID();
                row[1] = "" + entities.get(i).getY();

                if (entities.get(i).getY() == 7) {
                    row[1] = "Lobby";
                }
                if (entities.get(i).getY() == 6) {
                    row[1] = "First floor";
                }
                if (entities.get(i).getY() == 5) {
                    row[1] = "Second floor";
                }
                if (entities.get(i).getY() == 4) {
                    row[1] = "Third floor";
                }
                if (entities.get(i).getY() == 3) {
                    row[1] = "Fourth floor";
                }
                if (entities.get(i).getY() == 2) {
                    row[1] = "Fifth floor";
                }
                row[2] = "Room: " + ((EntityGuest) entities.get(i)).getPreference();

                for (ISquare lookupEntity : entities)
                    if (lookupEntity instanceof EntityRoom && ((EntityRoom) lookupEntity).getInhabitantID() == ((EntityGuest) entities.get(i)).getID()) {
                        row[3] = ((EntityRoom) lookupEntity).isDirty() ? "Dirty" : "Clean";
                    }
                data.add(row);
            }

        // Create table
        String[][] arrayOfData = new String[data.size()][];
        arrayOfData = data.toArray(arrayOfData);

        jt = new JTable(arrayOfData, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        try {
            add(sp);
        } catch (Exception e) {

        }

        validate();

    }
}
