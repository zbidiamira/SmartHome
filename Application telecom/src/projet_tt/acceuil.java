package projet_tt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import static projet_tt.LoginDialog.dialog;
import static projet_tt.LoginDialog.test;

import projet_tt.fenetre;

public class acceuil implements ActionListener {
    JFrame f;
    JButton b1, b2;
    JPanel p1, p2, p3;
    Container c;
    JProgressBar progressbar1;
    JLabel lhaut, lbas;
    Connection con;
    Statement stat;

    public acceuil() {
        f = new JFrame("Espace Liaison FTTx");
        f.setSize(700, 700);
        c = f.getContentPane();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getWidth() / 2, dim.height / 2 - f.getHeight() / 2);
        progressbar1 = new JProgressBar();
        progressbar1.setMinimum(1);
        progressbar1.setMaximum(100);

        ImageIcon icon = new ImageIcon(".\\src\\images\\icon.png");
        ImageIcon iconc = new ImageIcon(".\\src\\images\\iconc.png");

        b1 = new JButton(icon);
        b2 = new JButton(iconc);
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel(new BorderLayout());
        p3 = new JPanel();
        lhaut = new JLabel(new ImageIcon(".\\src\\images\\telecom.jpg"));

        p1.add(lhaut, BorderLayout.NORTH);
        p2.add(progressbar1, BorderLayout.NORTH);
        p3.add(b2);
        p3.add(b1);
        p2.add(p3, BorderLayout.CENTER);
        p1.add(p2, BorderLayout.CENTER);
        c.add(p1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setEnabled(false);
        b2.setEnabled(false);
        f.setResizable(false);
        f.setVisible(true);
        f.pack();
        progress();
        b1.setEnabled(true);
        b2.setEnabled(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void progress() {
        int i = 1;
        int j = 0;
        for (i = 1; i <= 100; i++) {
            progressbar1.setValue(i);
            try {
                Thread.sleep(25);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new acceuil();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource().equals(b2)) {
            f.dispose();
        } else if (e.getSource().equals(b1)) {
            f.dispose();
            new fenetre();
        }

    }
}
