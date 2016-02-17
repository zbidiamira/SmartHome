package projet_tt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import projet_tt.Logger;
import projet_tt.LoginDialog;
import projet_tt.fenetre;

public class LoginDialog extends JDialog {

    public JTextField login;
    public JTextField password;
    public Logger logger;
    static ResultSet test;
    static JDialog dialog;

    public LoginDialog() {
        ahmed();
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    private void ahmed() {
        setTitle("Identification");
        JPanel pan_principal = new JPanel(new BorderLayout());
        JPanel pan_label = new JPanel(new GridLayout(2, 1));
        JPanel pan_textField = new JPanel(new GridLayout(2, 1));
        JPanel pan_button = new JPanel(new GridLayout(1, 2));
        pan_principal.add(pan_label, BorderLayout.WEST);
        pan_principal.add(pan_textField, BorderLayout.CENTER);
        pan_principal.add(pan_button, BorderLayout.SOUTH);
        dialog = new JDialog();
        dialog.add(pan_principal);

        pan_label.add(new JLabel(" Login  "));
        pan_label.add(new JLabel(" Password  "));
        final JButton ok = new JButton("OK");
        JButton annuler = new JButton("Annuler");

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logger.login(login.getText(), password.getText());
            }
        });
        annuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                logger.cancelled();
            }
        });

        pan_button.add(annuler);
        pan_button.add(ok);
        login = new JTextField(20);
        password = new JPasswordField(20);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                password.requestFocus();
            }
        });
        password.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok.doClick(300);
            }
        });

        pan_textField.add(login);
        pan_textField.add(password);

        this.setContentPane(pan_principal);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 3 - this.getWidth() / 2, dim.height / 3 - this.getHeight() / 2);
        this.pack();

    }

    public static void main(String[] args) {

        LoginDialog log = new LoginDialog();
        log.setLogger(new Logger() {
                public void login(String login, String password) {
                    System.out.println("login=" + login);
                    System.out.println("password=" + password);
                    BDconn con = new BDconn();
                    con = new BDconn();
                    con.connexionDB("application_tt");
                    con.open("application_tt");
                    try {
                        test = con.selectQuery("SELECT count(u.login) FROM utilisateur u WHERE u.login= '" + login + "' AND u.pwd= '" + password + "'");

                        while (test.next()) {

                            int s;
                            s = Integer.parseInt(test.getString(1));

                            if (s != 0) {
                                try {
                                    test = con.selectQuery("SELECT u.fonction FROM utilisateur u WHERE u.login= '" + login + "'");

                                    while (test.next()) {

                                        if (test.getString(1).equals("Admin")) {
                                            this.cancelled();
                                            new acceuil();

                                        } else {
                                            JFrame f = new JFrame();
                                            JOptionPane.showMessageDialog(f, "vous n'êtes pas un administrateur", "", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "vous n'êtes pas connus par la socitée !!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(LoginDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                public void cancelled() {
                    System.out.println("annulé !");
                    dialog.getParent().setVisible(false);
                }
            });        
        log.setVisible(true);

    }
}
