package projet_tt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BDconn {

    private Connection connexion;
    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String nameui = "root";
    private String pwd = "oracle";

    public boolean open(String nom) {
        boolean s = false;
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nom + "", nameui, pwd);
            s = true;
        } catch (SQLException e) {
            e.printStackTrace();
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Base-Donnée non trouvée !!", null, JOptionPane.WARNING_MESSAGE);
        }
        return s;
    }

    public boolean connexionDB(String nom) {
        boolean t = false;
        try {
            Class.forName(jdbcDriver).newInstance();
        } catch (InstantiationException e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        t = open(nom);
        return t;
    }

    public void arretDB() throws SQLException {
        Statement st = connexion.createStatement();
        st.execute("SHUTDOWN");
        connexion.close();

    }

    public void updateQuery(String requete) throws SQLException {
        try {
            Statement statement;
            statement = connexion.createStatement();
            statement.executeUpdate(requete);
            JFrame fe = new JFrame();
            JOptionPane.showMessageDialog(fe, "Requète executée avec succèes !");
        } catch (SQLException ex) {
            JFrame fe = new JFrame();
            JOptionPane.showMessageDialog(fe, "Erreur d'exceution !");
        }
    }

    public ResultSet selectQuery(String requete) throws SQLException {
        Statement statement;
        statement = connexion.createStatement();
        ResultSet resultat = statement.executeQuery(requete);
        return resultat;
    }
}