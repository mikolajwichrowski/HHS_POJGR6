package HHS_PROJGR6;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import HHS_PROJGR6.Entities.EntityGuest;
import HHS_PROJGR6.Interfaces.IEntity;

/**
 * Bron: https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */
public class Statistics extends JFrame {
    public Statistics(List<IEntity> entities) {
        super.setSize(300, 200);
        super.setLocation(1050, 0);

        // Define data and columns
        List<String[]> data = new ArrayList<String[]>();
        String column[] = { "ID", "X", "Y" };

        // Loop trough entities
        for (int i = 0; i < entities.size(); i++) {
            // Set row data
            if (entities.get(i) instanceof EntityGuest) {
                String[] row = new String[3];
                row[0] = "Entity " + ((EntityGuest) entities.get(i)).getID();
                row[1] = "" + entities.get(i).getXPosition();
                row[2] = "" + entities.get(i).getYPosition();

                // Set row in data
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
