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

    JLabel guest;
    JLabel location;
    JTextField g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15, g16, g17, g18, g19, g20, g21, g22, g23, g24, g25, g26, g27;
    JTextField l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27;

    public Statistics(List<IEntity> entities) {
        super.setSize(300, 200);
        super.setLocation(1050, 0);

        System.out.println("Entities = " + entities.size());

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
        setVisible(true);

        // guest = new JLabel("Guests", JLabel.CENTER);
        // guest.setFont(new Font("Calabri", Font.ITALIC, 12));
        // guest.setBounds(0, 0, 150, 40);
        // guest.setBackground(new Color(214, 214, 194));
        // guest.setBorder(border);
        // guest.setOpaque(true);

        // location = new JLabel("Location", JLabel.CENTER);
        // location.setFont(new Font("Calabri", Font.ITALIC, 12));
        // location.setBounds(150, 0, 150, 40);
        // location.setBackground(new Color(214, 214, 194));
        // location.setBorder(border);
        // location.setOpaque(true);

        // g1 = new JTextField("guest 1");
        // g1.setHorizontalAlignment(SwingConstants.CENTER);
        // g1.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g1.setBounds(0, 40, 150, 20);
        // g1.setBackground(Color.white);
        // g1.setBorder(border);
        // g1.setOpaque(true);

        // g2 = new JTextField("guest 2");
        // g2.setHorizontalAlignment(SwingConstants.CENTER);
        // g2.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g2.setBounds(0, 60, 150, 20);
        // g2.setBackground(Color.white);
        // g2.setBorder(border);
        // g2.setOpaque(true);

        // g3 = new JTextField("guest 3");
        // g3.setHorizontalAlignment(SwingConstants.CENTER);
        // g3.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g3.setBounds(0, 80, 150, 20);
        // g3.setBackground(Color.white);
        // g3.setBorder(border);
        // g3.setOpaque(true);

        // g4 = new JTextField("guest 4");
        // g4.setHorizontalAlignment(SwingConstants.CENTER);
        // g4.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g4.setBounds(0, 100, 150, 20);
        // g4.setBackground(Color.white);
        // g4.setBorder(border);
        // g4.setOpaque(true);

        // g5 = new JTextField("guest 5");
        // g5.setHorizontalAlignment(SwingConstants.CENTER);
        // g5.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g5.setBounds(0, 120, 150, 20);
        // g5.setBackground(Color.white);
        // g5.setBorder(border);
        // g5.setOpaque(true);

        // g6 = new JTextField("guest 6");
        // g6.setHorizontalAlignment(SwingConstants.CENTER);
        // g6.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g6.setBounds(0, 140, 150, 20);
        // g6.setBackground(Color.white);
        // g6.setBorder(border);
        // g6.setOpaque(true);

        // g7 = new JTextField("guest 7");
        // g7.setHorizontalAlignment(SwingConstants.CENTER);
        // g7.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g7.setBounds(0, 160, 150, 20);
        // g7.setBackground(Color.white);
        // g7.setBorder(border);
        // g7.setOpaque(true);

        // g8 = new JTextField("guest 8");
        // g8.setHorizontalAlignment(SwingConstants.CENTER);
        // g8.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g8.setBounds(0, 180, 150, 20);
        // g8.setBackground(Color.white);
        // g8.setBorder(border);
        // g8.setOpaque(true);

        // g9 = new JTextField("guest 9");
        // g9.setHorizontalAlignment(SwingConstants.CENTER);
        // g9.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g9.setBounds(0, 200, 150, 20);
        // g9.setBackground(Color.white);
        // g9.setBorder(border);
        // g9.setOpaque(true);

        // g10 = new JTextField("guest 10");
        // g10.setHorizontalAlignment(SwingConstants.CENTER);
        // g10.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g10.setBounds(0, 220, 150, 20);
        // g10.setBackground(Color.white);
        // g10.setBorder(border);
        // g10.setOpaque(true);

        // g11 = new JTextField("guest 11");
        // g11.setHorizontalAlignment(SwingConstants.CENTER);
        // g11.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g11.setBounds(0, 240, 150, 20);
        // g11.setBackground(Color.white);
        // g11.setBorder(border);
        // g11.setOpaque(true);

        // g12 = new JTextField("guest 12");
        // g12.setHorizontalAlignment(SwingConstants.CENTER);
        // g12.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g12.setBounds(0, 260, 150, 20);
        // g12.setBackground(Color.white);
        // g12.setBorder(border);
        // g12.setOpaque(true);

        // g13 = new JTextField("guest 13");
        // g13.setHorizontalAlignment(SwingConstants.CENTER);
        // g13.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g13.setBounds(0, 280, 150, 20);
        // g13.setBackground(Color.white);
        // g13.setBorder(border);
        // g13.setOpaque(true);

        // g14 = new JTextField("guest 14");
        // g14.setHorizontalAlignment(SwingConstants.CENTER);
        // g14.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g14.setBounds(0, 300, 150, 20);
        // g14.setBackground(Color.white);
        // g14.setBorder(border);
        // g14.setOpaque(true);

        // g15 = new JTextField("guest 15");
        // g15.setHorizontalAlignment(SwingConstants.CENTER);
        // g15.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g15.setBounds(0, 320, 150, 20);
        // g15.setBackground(Color.white);
        // g15.setBorder(border);
        // g15.setOpaque(true);

        // g16 = new JTextField("guest 16");
        // g16.setHorizontalAlignment(SwingConstants.CENTER);
        // g16.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g16.setBounds(0, 340, 150, 20);
        // g16.setBackground(Color.white);
        // g16.setBorder(border);
        // g16.setOpaque(true);

        // g17 = new JTextField("guest 17");
        // g17.setHorizontalAlignment(SwingConstants.CENTER);
        // g17.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g17.setBounds(0, 360, 150, 20);
        // g17.setBackground(Color.white);
        // g17.setBorder(border);
        // g17.setOpaque(true);

        // g18 = new JTextField("guest 18");
        // g18.setHorizontalAlignment(SwingConstants.CENTER);
        // g18.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g18.setBounds(0, 380, 150, 20);
        // g18.setBackground(Color.white);
        // g18.setBorder(border);
        // g18.setOpaque(true);

        // g19 = new JTextField("guest 19");
        // g19.setHorizontalAlignment(SwingConstants.CENTER);
        // g19.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g19.setBounds(0, 400, 150, 20);
        // g19.setBackground(Color.white);
        // g19.setBorder(border);
        // g19.setOpaque(true);

        // g20 = new JTextField("guest 20");
        // g20.setHorizontalAlignment(SwingConstants.CENTER);
        // g20.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g20.setBounds(0, 420, 150, 20);
        // g20.setBackground(Color.white);
        // g20.setBorder(border);
        // g20.setOpaque(true);

        // g21 = new JTextField("guest 21");
        // g21.setHorizontalAlignment(SwingConstants.CENTER);
        // g21.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g21.setBounds(0, 440, 150, 20);
        // g21.setBackground(Color.white);
        // g21.setBorder(border);
        // g21.setOpaque(true);

        // g22 = new JTextField("guest 22");
        // g22.setHorizontalAlignment(SwingConstants.CENTER);
        // g22.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g22.setBounds(0, 460, 150, 20);
        // g22.setBackground(Color.white);
        // g22.setBorder(border);
        // g22.setOpaque(true);

        // g23 = new JTextField("guest 23");
        // g23.setHorizontalAlignment(SwingConstants.CENTER);
        // g23.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g23.setBounds(0, 480, 150, 20);
        // g23.setBackground(Color.white);
        // g23.setBorder(border);
        // g23.setOpaque(true);

        // g24 = new JTextField("guest 24");
        // g24.setHorizontalAlignment(SwingConstants.CENTER);
        // g24.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g24.setBounds(0, 500, 150, 20);
        // g24.setBackground(Color.white);
        // g24.setBorder(border);
        // g24.setOpaque(true);

        // g25 = new JTextField("guest 25");
        // g25.setHorizontalAlignment(SwingConstants.CENTER);
        // g25.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g25.setBounds(0, 520, 150, 20);
        // g25.setBackground(Color.white);
        // g25.setBorder(border);
        // g25.setOpaque(true);

        // g26 = new JTextField("guest 26");
        // g26.setHorizontalAlignment(SwingConstants.CENTER);
        // g26.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g26.setBounds(0, 540, 150, 20);
        // g26.setBackground(Color.white);
        // g26.setBorder(border);
        // g26.setOpaque(true);

        // g27 = new JTextField("guest 27");
        // g27.setHorizontalAlignment(SwingConstants.CENTER);
        // g27.setFont(new Font("Calabri", Font.ITALIC, 12));
        // g27.setBounds(0, 560, 150, 20);
        // g27.setBackground(Color.white);
        // g27.setBorder(border);
        // g27.setOpaque(true);

        // //////////////////////////////////////////////////////////////////////////////////////////////////////

        // l1 = new JTextField();
        // l1.setHorizontalAlignment(SwingConstants.CENTER);
        // l1.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l1.setBounds(150, 40, 150, 20);
        // l1.setBackground(Color.white);
        // l1.setBorder(border);
        // l1.setOpaque(true);

        // l2 = new JTextField("location");
        // l2.setHorizontalAlignment(SwingConstants.CENTER);
        // l2.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l2.setBounds(150, 60, 150, 20);
        // l2.setBackground(Color.white);
        // l2.setBorder(border);
        // l2.setOpaque(true);

        // l3 = new JTextField("location");
        // l3.setHorizontalAlignment(SwingConstants.CENTER);
        // l3.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l3.setBounds(150, 80, 150, 20);
        // l3.setBackground(Color.white);
        // l3.setBorder(border);
        // l3.setOpaque(true);

        // l4 = new JTextField("location");
        // l4.setHorizontalAlignment(SwingConstants.CENTER);
        // l4.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l4.setBounds(150, 100, 150, 20);
        // l4.setBackground(Color.white);
        // l4.setBorder(border);
        // l4.setOpaque(true);

        // l5 = new JTextField("location");
        // l5.setHorizontalAlignment(SwingConstants.CENTER);
        // l5.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l5.setBounds(150, 120, 150, 20);
        // l5.setBackground(Color.white);
        // l5.setBorder(border);
        // l5.setOpaque(true);

        // l6 = new JTextField("location");
        // l6.setHorizontalAlignment(SwingConstants.CENTER);
        // l6.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l6.setBounds(150, 140, 150, 20);
        // l6.setBackground(Color.white);
        // l6.setBorder(border);
        // l6.setOpaque(true);

        // l7 = new JTextField("location");
        // l7.setHorizontalAlignment(SwingConstants.CENTER);
        // l7.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l7.setBounds(150, 160, 150, 20);
        // l7.setBackground(Color.white);
        // l7.setBorder(border);
        // l7.setOpaque(true);

        // l8 = new JTextField("location");
        // l8.setHorizontalAlignment(SwingConstants.CENTER);
        // l8.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l8.setBounds(150, 180, 150, 20);
        // l8.setBackground(Color.white);
        // l8.setBorder(border);
        // l8.setOpaque(true);

        // l9 = new JTextField("location");
        // l9.setHorizontalAlignment(SwingConstants.CENTER);
        // l9.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l9.setBounds(150, 200, 150, 20);
        // l9.setBackground(Color.white);
        // l9.setBorder(border);
        // l9.setOpaque(true);

        // l10 = new JTextField("location");
        // l10.setHorizontalAlignment(SwingConstants.CENTER);
        // l10.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l10.setBounds(150, 220, 150, 20);
        // l10.setBackground(Color.white);
        // l10.setBorder(border);
        // l10.setOpaque(true);

        // l11 = new JTextField("location");
        // l11.setHorizontalAlignment(SwingConstants.CENTER);
        // l11.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l11.setBounds(150, 240, 150, 20);
        // l11.setBackground(Color.white);
        // l11.setBorder(border);
        // l11.setOpaque(true);

        // l12 = new JTextField("location");
        // l12.setHorizontalAlignment(SwingConstants.CENTER);
        // l12.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l12.setBounds(150, 260, 150, 20);
        // l12.setBackground(Color.white);
        // l12.setBorder(border);
        // l12.setOpaque(true);

        // l13 = new JTextField("location");
        // l13.setHorizontalAlignment(SwingConstants.CENTER);
        // l13.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l13.setBounds(150, 280, 150, 20);
        // l13.setBackground(Color.white);
        // l13.setBorder(border);
        // l13.setOpaque(true);

        // l14 = new JTextField("location");
        // l14.setHorizontalAlignment(SwingConstants.CENTER);
        // l14.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l14.setBounds(150, 300, 150, 20);
        // l14.setBackground(Color.white);
        // l14.setBorder(border);
        // l14.setOpaque(true);

        // l15 = new JTextField("location");
        // l15.setHorizontalAlignment(SwingConstants.CENTER);
        // l15.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l15.setBounds(150, 320, 150, 20);
        // l15.setBackground(Color.white);
        // l15.setBorder(border);
        // l15.setOpaque(true);

        // l16 = new JTextField("location");
        // l16.setHorizontalAlignment(SwingConstants.CENTER);
        // l16.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l16.setBounds(150, 340, 150, 20);
        // l16.setBackground(Color.white);
        // l16.setBorder(border);
        // l16.setOpaque(true);

        // l17 = new JTextField("location");
        // l17.setHorizontalAlignment(SwingConstants.CENTER);
        // l17.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l17.setBounds(150, 360, 150, 20);
        // l17.setBackground(Color.white);
        // l17.setBorder(border);
        // l17.setOpaque(true);

        // l18 = new JTextField("location");
        // l18.setHorizontalAlignment(SwingConstants.CENTER);
        // l18.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l18.setBounds(150, 380, 150, 20);
        // l18.setBackground(Color.white);
        // l18.setBorder(border);
        // l18.setOpaque(true);

        // l19 = new JTextField("location");
        // l19.setHorizontalAlignment(SwingConstants.CENTER);
        // l19.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l19.setBounds(150, 400, 150, 20);
        // l19.setBackground(Color.white);
        // l19.setBorder(border);
        // l19.setOpaque(true);

        // l20 = new JTextField("location");
        // l20.setHorizontalAlignment(SwingConstants.CENTER);
        // l20.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l20.setBounds(150, 420, 150, 20);
        // l20.setBackground(Color.white);
        // l20.setBorder(border);
        // l20.setOpaque(true);

        // l21 = new JTextField("location");
        // l21.setHorizontalAlignment(SwingConstants.CENTER);
        // l21.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l21.setBounds(150, 440, 150, 20);
        // l21.setBackground(Color.white);
        // l21.setBorder(border);
        // l21.setOpaque(true);

        // l22 = new JTextField("location");
        // l22.setHorizontalAlignment(SwingConstants.CENTER);
        // l22.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l22.setBounds(150, 460, 150, 20);
        // l22.setBackground(Color.white);
        // l22.setBorder(border);
        // l22.setOpaque(true);

        // l23 = new JTextField("location");
        // l23.setHorizontalAlignment(SwingConstants.CENTER);
        // l23.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l23.setBounds(150, 480, 150, 20);
        // l23.setBackground(Color.white);
        // l23.setBorder(border);
        // l23.setOpaque(true);

        // l24 = new JTextField("location");
        // l24.setHorizontalAlignment(SwingConstants.CENTER);
        // l24.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l24.setBounds(150, 500, 150, 20);
        // l24.setBackground(Color.white);
        // l24.setBorder(border);
        // l24.setOpaque(true);

        // l25 = new JTextField("location");
        // l25.setHorizontalAlignment(SwingConstants.CENTER);
        // l25.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l25.setBounds(150, 520, 150, 20);
        // l25.setBackground(Color.white);
        // l25.setBorder(border);
        // l25.setOpaque(true);

        // l26 = new JTextField("location");
        // l26.setHorizontalAlignment(SwingConstants.CENTER);
        // l26.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l26.setBounds(150, 540, 150, 20);
        // l26.setBackground(Color.white);
        // l26.setBorder(border);
        // l26.setOpaque(true);

        // l27 = new JTextField("location");
        // l27.setHorizontalAlignment(SwingConstants.CENTER);
        // l27.setFont(new Font("Calabri", Font.ITALIC, 12));
        // l27.setBounds(150, 560, 150, 20);
        // l27.setBackground(Color.white);
        // l27.setBorder(border);
        // l27.setOpaque(true);

        // super.add(guest);
        // super.add(location);
        // super.add(g1);
        // super.add(g2);
        // super.add(g3);
        // super.add(g4);
        // super.add(g5);
        // super.add(g6);
        // super.add(g7);
        // super.add(g8);
        // super.add(g9);
        // super.add(g10);
        // super.add(g11);
        // super.add(g12);
        // super.add(g13);
        // super.add(g14);
        // super.add(g15);
        // super.add(g16);
        // super.add(g17);
        // super.add(g18);
        // super.add(g19);
        // super.add(g20);
        // super.add(g21);
        // super.add(g22);
        // super.add(g23);
        // super.add(g24);
        // super.add(g25);
        // super.add(g26);
        // super.add(g27);

        // super.add(l1);
        // super.add(l2);
        // super.add(l3);
        // super.add(l4);
        // super.add(l5);
        // super.add(l6);
        // super.add(l7);
        // super.add(l8);
        // super.add(l9);
        // super.add(l10);
        // super.add(l11);
        // super.add(l12);
        // super.add(l13);
        // super.add(l14);
        // super.add(l15);
        // super.add(l16);
        // super.add(l17);
        // super.add(l18);
        // super.add(l19);
        // super.add(l20);
        // super.add(l21);
        // super.add(l22);
        // super.add(l23);
        // super.add(l24);
        // super.add(l25);
        // super.add(l26);
        // super.add(l27);

        // Zet deze aan als je ze allemaal in 1 keer wil sluiten
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
