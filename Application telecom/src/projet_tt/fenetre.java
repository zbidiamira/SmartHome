package projet_tt;

import com.objectplanet.chart.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;
import com.mysql.jdbc.Statement;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.applet.Applet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.*;
import com.objectplanet.chart.*;

public class fenetre extends JFrame implements ActionListener, ItemListener, MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;

    protected JPanel northPanel;
    protected JPanel westPanel;
    protected JPanel centralPanel;
    protected JPanel centralNorthPanel;
    protected JPanel centralDrawPanel;
    protected String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    protected String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    protected String[] years = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"};
    protected String date;
    protected JComboBox cdays;
    protected JComboBox cmonths;
    protected JComboBox cyears;
    protected ResultSet rs;
    protected ResultSet rstype;
    protected JTable totaltable;
    protected JButton day;
    protected JButton month;
    protected JButton year;
    protected JButton stat;

    private JTextField login;
    private JTextField password;
    public projet_tt.Logger logger;
    public ResultSet testlog;
    public JDialog dialog;

    JMenuBar menuBar;

    JMenu refresh;

    JMenu liaison;
    JMenuItem ajoutl;
    JMenuItem modifl;

    JMenu edition;
    JMenu entreprise;
    JMenuItem ajoute;
    JMenuItem modife;
    JMenu centre_rattach;
    JMenuItem ajoutc;
    JMenuItem modifc;
    JMenu marche;
    JMenuItem ajoutma;
    JMenuItem modifma;
    JMenu metro;
    JMenuItem ajoutme;
    JMenuItem modifme;
    JMenu type;
    JMenuItem ajoutt;
    JMenuItem modift;

    JMenu statistique;

    JMenu info;
    JMenuItem tt;
    JMenuItem fttx;
    JMenuItem application;

    JMenu users;
    JMenuItem ajoutu;
    JMenuItem modifu;

    Container c;

    ResultSet resvit2;
    ResultSet resvit3;
    ResultSet resvit4;
    ResultSet resvit6;
    ResultSet resvit7;
    ResultSet resvit10;
    ResultSet test;
    JFrame fen;
    JFrame fengeneral;
    JPanel panelcentral;

    JTable table;
    JTable tablev;

    MyTableModell modell;
    TableRowSorter<MyTableModell> sorterl;

    MyTableModelc modelc;
    TableRowSorter<MyTableModelc> sorterc;

    MyTableModele modele;
    TableRowSorter<MyTableModele> sortere;

    MyTableModelma modelma;
    TableRowSorter<MyTableModelma> sorterma;

    MyTableModelme modelme;
    TableRowSorter<MyTableModelme> sorterme;

    MyTableModelt modelt;
    TableRowSorter<MyTableModelt> sortert;

    MyTableModelu modelu;
    TableRowSorter<MyTableModelu> sorteru;

    MyTableModelv modelv;
    TableRowSorter<MyTableModelv> sorterv;

    JScrollPane scroller;
    JScrollPane scrollerv;
    Object[][] data;
    String[] values;
    Connection con;
    JFileChooser chooser;
    FileNameExtensionFilter filter;
    int returnVal;
    JLabel lab;
    JButton ajol;
    JButton annl;
    JButton impl;

    JButton ajoc;
    JButton annc;
    JButton impc;

    JButton ajoe;
    JButton anne;
    JButton impe;

    JButton ajoma;
    JButton annma;
    JButton impma;

    JButton ajome;
    JButton annme;
    JButton impme;

    JButton ajot;
    JButton annt;
    JButton impt;

    JButton ajou;
    JButton annu;
    JButton impu;

    JTextField noml;
    JComboBox centrel;
    JComboBox entrel;
    JComboBox longl;
    JComboBox recepl;
    JComboBox planl;
    JTextField datel;
    JTextArea observl;
    JComboBox typel;
    JComboBox marchel;

    JTextField nomt;
    JTextArea desct;

    JTextField nome;
    JTextField adre;
    JTextField logoe;

    JTextField nomc;
    JComboBox metroc;

    JTextField nomme;

    JTextField nomma;
    JTextField datedma;
    JTextField datefma;

    JTextField logu;
    JTextField pwdu;
    JComboBox fctu;

    JButton modiflrefresh;
    JButton modifcrefresh;
    JButton modiferefresh;
    JButton modifmerefresh;
    JButton modifmarefresh;
    JButton modiftrefresh;
    JButton modifurefresh;

    public void init() {
        setBackground(Color.white);
    }

    public fenetre() {
        super("Liaison FTTx");
        fengeneral = new JFrame();
        this.setSize(new Dimension(855, 565));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	this.addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent e){
                
                   int reponse = JOptionPane.showConfirmDialog(fengeneral,
                                        "Voulez-vous quitter l'application",
                                        "Confirmation",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE);
                   if (reponse==JOptionPane.YES_OPTION){
                           System.exit(0);
                   }
             }
        }); 
        northPanel = new JPanel();
        westPanel = new JPanel();
        centralPanel = new JPanel();
        centralNorthPanel = new JPanel();
        centralDrawPanel = new JPanel();
        BDconn con = new BDconn();
        con.connexionDB("application_tt");

        TableColumn col;

        modelv = new MyTableModelv(true);
        sorterv = new TableRowSorter<MyTableModelv>(modelv);
        tablev = new JTable(modelv);

        tablev.setRowHeight(18);
        col = tablev.getColumnModel().getColumn(2);
        col.setPreferredWidth(10);
        //tablev.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        scrollerv = new JScrollPane(tablev);

        /*try {
         rs = con.selectQuery("select * from lview ;");
         totaltable = new JTable(buildTableModel(rs));
         northPanel.add(totaltable);
         northPanel.add(new JScrollBar(JScrollBar.VERTICAL));
         } catch (SQLException ex) {
         // Logger.getLogger(AppTT.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("erreur de creation de 1er table");
         }*/
        cdays = new JComboBox(days);
        cmonths = new JComboBox(months);
        cyears = new JComboBox(years);
        /**
         * *****************************************************************************************************
         */
        c = this.getContentPane();

        data = new Object[100][100];
        values = new String[11];

        menuBar = new JMenuBar();

        refresh = new JMenu("Acceuil");
        refresh.setIcon(new ImageIcon(".\\src\\images\\refr.png"));
        menuBar.add(refresh);
        //////////////////////////////
        liaison = new JMenu("Liaison");
        liaison.setIcon(new ImageIcon(".\\src\\images\\fttx.jpg"));
        ajoutl = new JMenuItem("Ajouter");
        modifl = new JMenuItem("Modifier");
        liaison.add(ajoutl);
        liaison.addSeparator();
        liaison.add(modifl);
        ajoutl.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modifl.setIcon(new ImageIcon(".\\src\\images\\modif.png"));
        menuBar.add(liaison);
        ////////////////////////////////
        edition = new JMenu("Edition");
        edition.setIcon(new ImageIcon(".\\src\\images\\centre.png"));
        entreprise = new JMenu("Entreprise");
        ajoute = new JMenuItem("Ajouter");
        modife = new JMenuItem("Modifier");
        ajoute.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modife.setIcon(new ImageIcon(".\\src\\images\\modif.png"));
        entreprise.add(ajoute);
        entreprise.addSeparator();
        entreprise.add(modife);
        centre_rattach = new JMenu("Centre de Rattach");
        ajoutc = new JMenuItem("Ajouter");
        modifc = new JMenuItem("Modifier");
        ajoutc.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modifc.setIcon(new ImageIcon(".\\src\\images\\modif.png"));
        centre_rattach.add(ajoutc);
        centre_rattach.addSeparator();
        centre_rattach.add(modifc);
        marche = new JMenu("Marche");
        ajoutma = new JMenuItem("Ajouter");
        modifma = new JMenuItem("Modifier");
        ajoutma.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modifma.setIcon(new ImageIcon(".\\src\\images\\modif.png"));
        marche.add(ajoutma);
        marche.addSeparator();
        marche.add(modifma);
        metro = new JMenu("Metro");
        ajoutme = new JMenuItem("Ajouter");
        modifme = new JMenuItem("Modifier");
        ajoutme.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modifme.setIcon(new ImageIcon(".\\src\\images\\modif.png"));
        metro.add(ajoutme);
        metro.addSeparator();
        metro.add(modifme);
        type = new JMenu("Type");
        ajoutt = new JMenuItem("Ajouter");
        modift = new JMenuItem("Modifier");
        ajoutt.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modift.setIcon(new ImageIcon(".\\src\\images\\modif.png"));
        type.add(ajoutt);
        type.addSeparator();
        type.add(modift);
        edition.add(entreprise);
        edition.addSeparator();
        edition.add(centre_rattach);
        edition.addSeparator();
        edition.add(marche);
        edition.addSeparator();
        edition.add(metro);
        edition.addSeparator();
        edition.add(type);
        menuBar.add(edition);
        ///////////////////////////////
        users = new JMenu("Utilisateur");
        users.setIcon(new ImageIcon(".\\src\\images\\user.png"));
        ajoutu = new JMenuItem("Ajouter");
        modifu = new JMenuItem("Modifier");
        ajoutu.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modifu.setIcon(new ImageIcon(".\\src\\images\\modif.png"));
        users.add(ajoutu);
        users.addSeparator();
        users.add(modifu);
        ajoutl.setIcon(new ImageIcon(".\\src\\images\\inser.png"));
        modifl.setIcon(new ImageIcon(".\\src\\images\\modif.png"));

        menuBar.add(users);
        ///////////////////////////////
        statistique = new JMenu("Statistique");
        statistique.setIcon(new ImageIcon(".\\src\\images\\stat.png"));
        menuBar.add(statistique);
        //////////////////////////////
        info = new JMenu("Info");
        info.setIcon(new ImageIcon(".\\src\\images\\info.png"));
        tt = new JMenuItem("Tunisie Telecom");
        fttx = new JMenuItem("Liaison FTTX");
        application = new JMenuItem("Notre application");
        info.add(tt);
        info.addSeparator();
        info.add(fttx);
        info.addSeparator();
        info.add(application);
        menuBar.add(info);
        //////////////////////////////

        this.setJMenuBar(menuBar);
        statistique.addMouseListener(this);
        refresh.addMouseListener(this);
        ////////////////////////////////////
        ajoutl.addActionListener(this);
        modifl.addActionListener(this);
        ajoute.addActionListener(this);
        modife.addActionListener(this);
        ajoutc.addActionListener(this);
        modifc.addActionListener(this);
        ajoutma.addActionListener(this);
        modifma.addActionListener(this);
        ajoutme.addActionListener(this);
        modifme.addActionListener(this);
        ajoutt.addActionListener(this);
        modift.addActionListener(this);
        tt.addActionListener(this);
        fttx.addActionListener(this);
        application.addActionListener(this);
        ajoutu.addActionListener(this);
        modifu.addActionListener(this);
        ////////////////////////////////////
        panelcentral = new JPanel();

        //acceuil
        JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
        JLabel labac2 = new JLabel(new ImageIcon(".\\src\\images\\acceuil2.png"));
        JPanel panac = new JPanel();

        panelcentral.add(labac2);
        panac.add(labac);
        c.add(panelcentral, BorderLayout.CENTER);
        c.add(panac, "South");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

        /**
         * **********************************************************************************************************************
         */
        ImageIcon iconaj = new ImageIcon(".\\src\\images\\add.png");
        ImageIcon iconan = new ImageIcon(".\\src\\images\\cancel.png");

        ajol = new JButton(iconaj);
        ajol.setPreferredSize(new Dimension(119, 35));
        ajol.addActionListener(this);
        impl = new JButton("Importer");
        impl.setPreferredSize(new Dimension(119, 35));
        impl.setIcon(new ImageIcon(".\\src\\images\\import.png"));
        impl.addActionListener(this);
        annl = new JButton(iconan);
        annl.setPreferredSize(new Dimension(119, 35));
        annl.addActionListener(this);

        ajoc = new JButton(iconaj);
        ajoc.setPreferredSize(new Dimension(119, 35));
        ajoc.addActionListener(this);
        impc = new JButton("Importer");
        impc.setPreferredSize(new Dimension(119, 35));
        impc.setIcon(new ImageIcon(".\\src\\images\\import.png"));
        impc.addActionListener(this);

        annc = new JButton(iconan);
        annc.setPreferredSize(new Dimension(119, 35));
        annc.addActionListener(this);

        ajoe = new JButton(iconaj);
        ajoe.setPreferredSize(new Dimension(119, 35));
        ajoe.addActionListener(this);
        impe = new JButton("Importer");
        impe.setPreferredSize(new Dimension(119, 35));
        impe.setIcon(new ImageIcon(".\\src\\images\\import.png"));
        impe.addActionListener(this);

        anne = new JButton(iconan);
        anne.setPreferredSize(new Dimension(119, 35));
        anne.addActionListener(this);

        ajoma = new JButton(iconaj);
        ajoma.setPreferredSize(new Dimension(119, 35));
        ajoma.addActionListener(this);
        impma = new JButton("Importer");
        impma.setPreferredSize(new Dimension(119, 35));
        impma.setIcon(new ImageIcon(".\\src\\images\\import.png"));
        impma.addActionListener(this);

        annma = new JButton(iconan);
        annma.setPreferredSize(new Dimension(119, 35));
        annma.addActionListener(this);

        ajome = new JButton(iconaj);
        ajome.setPreferredSize(new Dimension(119, 35));
        ajome.addActionListener(this);
        impme = new JButton("Importer");
        impme.setPreferredSize(new Dimension(119, 35));
        impme.setIcon(new ImageIcon(".\\src\\images\\import.png"));
        impme.addActionListener(this);

        annme = new JButton(iconan);
        annme.setPreferredSize(new Dimension(119, 35));
        annme.addActionListener(this);

        ajot = new JButton(iconaj);
        ajot.setPreferredSize(new Dimension(119, 35));
        ajot.addActionListener(this);
        impt = new JButton("Importer");
        impt.setPreferredSize(new Dimension(119, 35));
        impt.setIcon(new ImageIcon(".\\src\\images\\import.png"));
        impt.addActionListener(this);

        annt = new JButton(iconan);
        annt.setPreferredSize(new Dimension(119, 35));
        annt.addActionListener(this);

        ajou = new JButton(iconaj);
        ajou.setPreferredSize(new Dimension(119, 35));
        ajou.addActionListener(this);
        impu = new JButton("Importer");
        impu.setPreferredSize(new Dimension(119, 35));
        impu.setIcon(new ImageIcon(".\\src\\images\\import.png"));
        impu.addActionListener(this);

        annu = new JButton(iconan);
        annu.setPreferredSize(new Dimension(119, 35));
        annu.addActionListener(this);

        this.setVisible(true);
    }

    public static void main(String args[]) {
        new fenetre();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        if (e.getSource().equals(ajol)) {
            BDconn con = new BDconn();
            con.connexionDB("application_tt");

            String info1 = noml.getText();
            String info2 = longl.getSelectedItem().toString();
            String info3 = datel.getText();
            String info4 = typel.getSelectedItem().toString();
            String info5 = centrel.getSelectedItem().toString();
            String info6 = entrel.getSelectedItem().toString();
            String info7 = planl.getSelectedItem().toString();
            String info8 = recepl.getSelectedItem().toString();
            String info9 = observl.getText();
            String info10 = marchel.getSelectedItem().toString();

            if (info1.length() == 0 || info2.length() == 0 || info3.length() == 0 || info4.length() == 0 || info5.length() == 0 || info6.length() == 0 || info7.length() == 0 || info8.length() == 0 || info9.length() == 0 || info10.length() == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Veillez remplir tous les champs !!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    test = con.selectQuery("SELECT count(l.nom) FROM liaison l WHERE l.nom= '" + info1 + "'");

                    while (test.next()) {
                        int s;
                        s = Integer.parseInt(test.getString(1));
                        if (s == 0) {
                            String val4;
                            test = con.selectQuery("SELECT count(t.nom) FROM type t WHERE t.nom= '" + info4 + "'");
                            while (test.next()) {
                                s = Integer.parseInt(test.getString(1));
                                if (s != 0) {
                                    resvit2 = con.selectQuery("SELECT t.idType, t.nom FROM type t WHERE t.nom='" + info4 + "'");
                                    while (resvit2.next()) {
                                        val4 = resvit2.getString(1);

                                        String val5;
                                        test = con.selectQuery("SELECT count(c.nom) FROM centre_rattach c WHERE c.nom= '" + info5 + "'");
                                        while (test.next()) {
                                            s = Integer.parseInt(test.getString(1));
                                            if (s != 0) {
                                                resvit3 = con.selectQuery("SELECT c.idCenRat, c.nom FROM centre_rattach c WHERE c.nom='" + info5 + "'");
                                                while (resvit3.next()) {
                                                    val5 = resvit3.getString(1);

                                                    String val6;
                                                    test = con.selectQuery("SELECT count(e.nom) FROM entreprise e WHERE e.nom= '" + info6 + "'");
                                                    while (test.next()) {
                                                        s = Integer.parseInt(test.getString(1));
                                                        if (s != 0) {
                                                            resvit4 = con.selectQuery("SELECT e.idEntreprise, e.adresse FROM entreprise e WHERE e.nom='" + info6 + "'");
                                                            while (resvit4.next()) {
                                                                val6 = resvit4.getString(1);

                                                                String val8;
                                                                test = con.selectQuery("SELECT count(r.nom) FROM reception r WHERE r.nom= '" + info8 + "'");
                                                                while (test.next()) {
                                                                    s = Integer.parseInt(test.getString(1));
                                                                    if (s != 0) {
                                                                        resvit6 = con.selectQuery("SELECT r.idReception, r.description FROM reception r WHERE r.nom='" + info8 + "'");
                                                                        while (resvit6.next()) {
                                                                            val8 = resvit6.getString(1);

                                                                            String val7;
                                                                            test = con.selectQuery("SELECT count(p.nom) FROM plan p WHERE p.nom= '" + info7 + "'");
                                                                            while (test.next()) {
                                                                                s = Integer.parseInt(test.getString(1));
                                                                                if (s != 0) {
                                                                                    resvit7 = con.selectQuery("SELECT p.idPlan, p.description FROM plan p WHERE p.nom='" + info7 + "'");
                                                                                    while (resvit7.next()) {
                                                                                        val7 = resvit7.getString(1);

                                                                                        String val10;
                                                                                        test = con.selectQuery("SELECT count(m.nom) FROM marche m WHERE m.nom= '" + info10 + "'");
                                                                                        while (test.next()) {

                                                                                            s = Integer.parseInt(test.getString(1)) + 1;
                                                                                            if (s != 0) {
                                                                                                resvit10 = con.selectQuery("SELECT m.idMarche, m.datedeb FROM marche m WHERE m.nom='" + info10 + "'");
                                                                                                while (resvit10.next()) {
                                                                                                    val10 = resvit10.getString(1);

                                                                                                    String sqlinsert = String.format("INSERT INTO `application_tt`.`liaison` (nom,idType,idCentRat,idEntreprise,longueur,idReception,idPlan,dateMES,observation,idMarche) VALUES ('%s',%s,%s,%s,%s,%s,%s,'%s','%s',%s)", info1, val4, val5, val6, info2, val8, val7, info3, info9, val10);
                                                                                                    con.updateQuery(sqlinsert);
                                                                                                }

                                                                                            } else {
                                                                                                JFrame f = new JFrame();
                                                                                                JOptionPane.showMessageDialog(f, "le marche " + info10 + "n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    JFrame f = new JFrame();
                                                                                    JOptionPane.showMessageDialog(f, "le plan " + info7 + "n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        JFrame f = new JFrame();
                                                                        JOptionPane.showMessageDialog(f, "la reception " + info8 + " n'est pas connue par l'application !", "", JOptionPane.WARNING_MESSAGE);
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            JFrame f = new JFrame();
                                                            JOptionPane.showMessageDialog(f, "l'entreprise " + info6 + " n'est pas trouvée dans la base", "", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    }
                                                }
                                            } else {
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(f, "le centre " + info5 + " n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                            }
                                        }
                                    }
                                } else {
                                    JFrame f = new JFrame();
                                    JOptionPane.showMessageDialog(f, "le type " + info4 + " n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        } else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "la liaison " + info1 + " est déja existante dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        if (e.getSource().equals(impl)) {
            try {
                chooser = new JFileChooser();
                filter = new FileNameExtensionFilter(
                        "Fichier Excel (.xls)", "xls");
                chooser.setFileFilter(filter);

                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                String fich = chooser.getSelectedFile().getName();
                InputStream input = new FileInputStream(fich);
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator rows = sheet.rowIterator();

                while (rows.hasNext()) {
                    values[0] = null;
                    values[1] = null;
                    values[2] = null;
                    values[3] = null;
                    values[4] = null;
                    values[5] = null;
                    values[6] = null;
                    values[7] = null;
                    values[8] = null;
                    values[9] = null;
                    values[10] = null;
                    int t = 0;

                    HSSFRow row = (HSSFRow) rows.next();

                    Iterator cells = row.cellIterator();
                    System.out.println("lecture ligne excel est effectuée");

                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();
                        if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            System.out.println("type cellule = int");
                            values[t] = Integer.toString((int) cell.getNumericCellValue());
                            t++;
                        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                            System.out.println("type cellule = String");
                            values[t] = cell.getStringCellValue();
                            t++;
                        } else {
                            values[t] = null;
                            t++;
                        }
                    }

                    System.out.println("lecture cellules excel est effectuée, id= " + values[0] + ",nom= " + values[1] + ",type= " + values[2] + ",centre= " + values[3] + ",entreprise= " + values[4] + ",longueur= " + values[5] + ",reception= " + values[6] + ",plan= " + values[7] + ",date= " + values[8] + ",observation= " + values[9]);

                    try {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String val0 = null;
                        System.out.println("t3adda w 3mal el val0");
                        String val1 = values[1];
                        System.out.println("t3adda w 3mal el val1");
                        test = con.selectQuery("SELECT count(l.nom) FROM liaison l WHERE l.nom= '" + val1 + "'");
                        while (test.next()) {
                            int s;
                            s = Integer.parseInt(test.getString(1));
                            if (s == 0) {
                                String val2;
                                test = con.selectQuery("SELECT count(t.nom) FROM type t WHERE t.nom= '" + values[2] + "'");
                                while (test.next()) {
                                    s = Integer.parseInt(test.getString(1));
                                    if (s != 0) {
                                        resvit2 = con.selectQuery("SELECT t.idType, t.nom FROM type t WHERE t.nom='" + values[2] + "'");
                                        while (resvit2.next()) {
                                            val2 = resvit2.getString(1);

                                            String val3;
                                            test = con.selectQuery("SELECT count(c.nom) FROM centre_rattach c WHERE c.nom= '" + values[3] + "'");
                                            while (test.next()) {
                                                s = Integer.parseInt(test.getString(1));
                                                if (s != 0) {
                                                    resvit3 = con.selectQuery("SELECT c.idCenRat, c.nom FROM centre_rattach c WHERE c.nom='" + values[3] + "'");
                                                    while (resvit3.next()) {
                                                        val3 = resvit3.getString(1);
                                                        String val4;
                                                        test = con.selectQuery("SELECT count(e.nom) FROM entreprise e WHERE e.nom= '" + values[4] + "'");
                                                        while (test.next()) {
                                                            s = Integer.parseInt(test.getString(1));
                                                            if (s != 0) {
                                                                resvit4 = con.selectQuery("SELECT e.idEntreprise, e.adresse FROM entreprise e WHERE e.nom='" + values[4] + "'");
                                                                while (resvit4.next()) {
                                                                    val4 = resvit4.getString(1);
                                                                    String val5 = values[5];
                                                                    String val6;
                                                                    test = con.selectQuery("SELECT count(r.nom) FROM reception r WHERE r.nom= '" + values[6] + "'");
                                                                    while (test.next()) {
                                                                        s = Integer.parseInt(test.getString(1));
                                                                        if (s != 0) {
                                                                            resvit6 = con.selectQuery("SELECT r.idReception, r.description FROM reception r WHERE r.nom='" + values[6] + "'");
                                                                            while (resvit6.next()) {
                                                                                val6 = resvit6.getString(1);
                                                                                String val7;
                                                                                test = con.selectQuery("SELECT count(p.nom) FROM plan p WHERE p.nom= '" + values[7] + "'");
                                                                                while (test.next()) {
                                                                                    s = Integer.parseInt(test.getString(1));
                                                                                    if (s != 0) {
                                                                                        resvit7 = con.selectQuery("SELECT p.idPlan, p.description FROM plan p WHERE p.nom='" + values[7] + "'");
                                                                                        while (resvit7.next()) {
                                                                                            val7 = resvit7.getString(1);
                                                                                            String val10;
                                                                                            test = con.selectQuery("SELECT count(p.nom) FROM plan p WHERE p.nom= '" + values[7] + "'");
                                                                                            while (test.next()) {
                                                                                                s = Integer.parseInt(test.getString(1));
                                                                                                if (s != 0) {
                                                                                                    resvit10 = con.selectQuery("SELECT m.idMarche, m.datedeb FROM marche m WHERE m.nom='" + values[10] + "'");
                                                                                                    while (resvit10.next()) {
                                                                                                        val10 = resvit10.getString(1);
                                                                                                        String val8 = values[8];
                                                                                                        System.out.println("t3adda w 3mal el val8");
                                                                                                        String val9 = values[9];
                                                                                                        System.out.println("t3adda w 3mal el val8");
                                                                                                        String sqlinsert = String.format("INSERT INTO `application_tt`.`liaison` (nom,idType,idCentRat,idEntreprise,longueur,idReception,idPlan,dateMES,observation,idMarche) VALUES ('%s',%s,%s,%s,%s,%s,%s,'%s','%s',%s)", val1, val2, val3, val4, val5, val6, val7, val8, val9, val10);
                                                                                                        con.updateQuery(sqlinsert);
                                                                                                    }
                                                                                                } else {
                                                                                                    JFrame f = new JFrame();
                                                                                                    JOptionPane.showMessageDialog(f, "le marche " + values[10] + "n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        JFrame f = new JFrame();
                                                                                        JOptionPane.showMessageDialog(f, "le plan " + values[7] + "n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            JFrame f = new JFrame();
                                                                            JOptionPane.showMessageDialog(f, "la reception " + values[6] + " n'est pas connue par l'application !", "", JOptionPane.WARNING_MESSAGE);
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                JFrame f = new JFrame();
                                                                JOptionPane.showMessageDialog(f, "l'entreprise " + values[4] + " n'est pas trouvée dans la base", "", JOptionPane.WARNING_MESSAGE);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    JFrame f = new JFrame();
                                                    JOptionPane.showMessageDialog(f, "le centre " + values[3] + " n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                                }
                                            }
                                        }
                                    } else {
                                        JFrame f = new JFrame();
                                        JOptionPane.showMessageDialog(f, "le type " + values[2] + " n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "la liaison " + values[1] + " est déja existante dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (Exception el) {
                        el.printStackTrace();
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Erreur au niveau de la récuperation des données !!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception es) {
                es.printStackTrace();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Erreur au niveau du fichier Excel Liaison !!", null, JOptionPane.WARNING_MESSAGE);
            }

        }
        if (e.getSource().equals(ajoc)) {
            BDconn con = new BDconn();
            con.connexionDB("application_tt");
            String info1 = nomc.getText();
            String info2 = metroc.getSelectedItem().toString();

            if (info1.length() == 0 || info2.length() == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Veillez remplir tous les champs !!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                String val2;
                try {
                    test = con.selectQuery("SELECT count(m.type) FROM metro m WHERE m.type= '" + info2 + "'");

                    while (test.next()) {

                        int s = Integer.parseInt(test.getString(1));
                        if (s != 0) {
                            try {
                                resvit2 = con.selectQuery("SELECT m.idMetro, m.type FROM metro m WHERE m.type='" + info2 + "'");
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                while (resvit2.next()) {
                                    val2 = resvit2.getString(1);
                                    String sqlinsert = String.format("INSERT INTO `application_tt`.`centre_rattach` (nom,idMetro) VALUES ('%s',%s)", info1, val2);
                                    con.updateQuery(sqlinsert);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "le metro " + info2 + " n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (e.getSource().equals(impc)) {
            try {
                chooser = new JFileChooser();
                filter = new FileNameExtensionFilter(
                        "Fichier Excel (.xls)", "xls");
                chooser.setFileFilter(filter);

                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                String fich = chooser.getSelectedFile().getName();
                InputStream input = new FileInputStream(fich);
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator rows = sheet.rowIterator();

                while (rows.hasNext()) {
                    values[0] = null;
                    values[1] = null;
                    values[2] = null;
                    values[3] = null;
                    values[4] = null;
                    values[5] = null;
                    values[6] = null;
                    values[7] = null;
                    values[8] = null;
                    values[9] = null;
                    int t = 0;

                    HSSFRow row = (HSSFRow) rows.next();

                    Iterator cells = row.cellIterator();
                    System.out.println("lecture ligne excel est effectuée");

                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();
                        if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            System.out.println("type cellule = int");
                            values[t] = Integer.toString((int) cell.getNumericCellValue());
                            t++;
                        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                            System.out.println("type cellule = String");
                            values[t] = cell.getStringCellValue();
                            t++;
                        } else {
                            values[t] = null;
                            t++;
                        }
                    }

                    System.out.println("lecture cellules excel est effectuée, id= " + values[0] + ",nom= " + values[1] + ",metro= " + values[2]);
                    try {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String val0 = null;
                        String val1 = values[1];
                        test = con.selectQuery("SELECT count(c.nom) FROM centre_rattach c WHERE c.nom= '" + val1 + "'");
                        while (test.next()) {
                            int s;
                            s = Integer.parseInt(test.getString(1));
                            if (s == 0) {
                                String val2;
                                test = con.selectQuery("SELECT count(m.type) FROM metro m WHERE m.type= '" + values[2] + "'");
                                while (test.next()) {
                                    s = Integer.parseInt(test.getString(1));
                                    if (s != 0) {
                                        resvit2 = con.selectQuery("SELECT m.idMetro, m.type FROM metro m WHERE m.type='" + values[2] + "'");
                                        while (resvit2.next()) {
                                            val2 = resvit2.getString(1);
                                            String sqlinsert = String.format("INSERT INTO `application_tt`.`centre_rattach` (nom,idMetro) VALUES ('%s',%s)", val1, val2);
                                            con.updateQuery(sqlinsert);
                                        }
                                    } else {
                                        JFrame f = new JFrame();
                                        JOptionPane.showMessageDialog(f, "le metro " + values[2] + "n'est pas trouvé dans la base", "", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "le centre " + values[1] + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (Exception el) {
                        el.printStackTrace();
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Erreur au niveau de la récuperation des données !!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception es) {
                es.printStackTrace();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Erreur au niveau du fichier Excel Centre !!", null, JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource().equals(ajoe)) {
            BDconn con = new BDconn();
            con.connexionDB("application_tt");
            String info1 = nome.getText();
            String info2 = adre.getText();
            String info3 = logoe.getText();

            if (info1.length() == 0 || info2.length() == 0 || info3.length() == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Veillez remplir tous les champs !!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                String val2;
                try {
                    String sqlinsert = String.format("INSERT INTO `application_tt`.`entreprise` (nom,logo,adresse) VALUES ('%s','%s','%s')", info1, info3, info2);
                    con.updateQuery(sqlinsert);
                } catch (SQLException ex) {
                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource().equals(impe)) {
            try {
                chooser = new JFileChooser();
                filter = new FileNameExtensionFilter(
                        "Fichier Excel (.xls)", "xls");
                chooser.setFileFilter(filter);

                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                String fich = chooser.getSelectedFile().getName();
                InputStream input = new FileInputStream(fich);
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator rows = sheet.rowIterator();

                while (rows.hasNext()) {
                    values[0] = null;
                    values[1] = null;
                    values[2] = null;
                    values[3] = null;
                    values[4] = null;
                    values[5] = null;
                    values[6] = null;
                    values[7] = null;
                    values[8] = null;
                    values[9] = null;
                    values[10] = null;
                    int t = 0;

                    HSSFRow row = (HSSFRow) rows.next();
                    Iterator cells = row.cellIterator();

                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();
                        if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            System.out.println("type cellule = int");
                            values[t] = Integer.toString((int) cell.getNumericCellValue());
                            t++;
                        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                            System.out.println("type cellule = String");
                            values[t] = cell.getStringCellValue();
                            t++;
                        } else {
                            values[t] = null;
                            t++;
                        }
                    }

                    System.out.println("lecture cellules excel est effectuée, id= " + values[0] + ",nom= " + values[1] + ",logo= " + values[2] + ",adresse= " + values[3] + ",Marche= " + values[4]);
                    try {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String val0 = null;
                        String val1 = values[1];
                        test = con.selectQuery("SELECT count(e.nom) FROM entreprise e WHERE e.nom= '" + val1 + "'");

                        while (test.next()) {
                            int s;
                            s = Integer.parseInt(test.getString(1));
                            if (s == 0) {
                                String val2 = values[2];
                                String val3 = values[3];
                                String sqlinsert = String.format("INSERT INTO `application_tt`.`entreprise` (nom,logo,adresse) VALUES ('%s','%s','%s',%s)", val1, val2, val3);
                                con.updateQuery(sqlinsert);
                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "l'entreprise " + values[1] + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (Exception el) {
                        el.printStackTrace();
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Erreur au niveau de la récuperation des données !!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception es) {
                es.printStackTrace();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Erreur au niveau du fichier Excel Entreprise !!", null, JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource().equals(ajoma)) {
            BDconn con = new BDconn();
            String info1 = nomma.getText();
            String info2 = datedma.getText();
            String info3 = datefma.getText();
            if (info1.length() == 0 || info2.length() == 0 || info3.length() == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Veillez remplir tous les champs !!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                con.connexionDB("application_tt");
                try {
                    test = con.selectQuery("SELECT count(m.nom) FROM marche m WHERE m.nom= '" + info1 + "'");
                    while (test.next()) {
                        int s;
                        s = Integer.parseInt(test.getString(1));
                        if (s == 0) {
                            String sqlinsert = String.format("INSERT INTO `application_tt`.`marche` (datedeb,datefin,nom) VALUES ('%s','%s','%s')", info3, info2, info1);
                            con.updateQuery(sqlinsert);
                        } else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Le marche " + info1 + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (e.getSource().equals(impma)) {
            try {
                chooser = new JFileChooser();
                filter = new FileNameExtensionFilter(
                        "Fichier Excel (.xls)", "xls");
                chooser.setFileFilter(filter);

                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                String fich = chooser.getSelectedFile().getName();
                InputStream input = new FileInputStream(fich);
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator rows = sheet.rowIterator();

                while (rows.hasNext()) {
                    values[0] = null;
                    values[1] = null;
                    values[2] = null;
                    values[3] = null;
                    values[4] = null;
                    values[5] = null;
                    values[6] = null;
                    values[7] = null;
                    values[8] = null;
                    values[9] = null;
                    int t = 0;

                    HSSFRow row = (HSSFRow) rows.next();

                    Iterator cells = row.cellIterator();
                    System.out.println("lecture ligne excel est effectuée");

                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();
                        if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            System.out.println("type cellule = int");
                            values[t] = Integer.toString((int) cell.getNumericCellValue());
                            t++;
                        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                            System.out.println("type cellule = String");
                            values[t] = cell.getStringCellValue();
                            t++;
                        } else {
                            values[t] = null;
                            t++;
                        }
                    }

                    System.out.println("lecture cellules excel est effectuée, id= " + values[0] + ",datedeb= " + values[1] + ",datefin= " + values[2] + ",nom " + values[3]);
                    try {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String val0 = null;
                        String val1 = values[1];
                        String val2 = values[2];
                        String val3 = values[3];
                        test = con.selectQuery("SELECT count(m.nom) FROM marche m WHERE m.nom= '" + val3 + "'");
                        while (test.next()) {
                            int s;
                            s = Integer.parseInt(test.getString(1));
                            if (s == 0) {
                                String sqlinsert = String.format("INSERT INTO `application_tt`.`marche` (datedeb,datefin,nom) VALUES ('%s','%s','%s')", val1, val2, val3);
                                con.updateQuery(sqlinsert);
                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "le centre " + values[3] + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (Exception el) {
                        el.printStackTrace();
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Erreur au niveau de la récuperation des données !!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception es) {
                es.printStackTrace();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Erreur au niveau du fichier Excel Marche !!", null, JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource().equals(ajome)) {
            BDconn con = new BDconn();
            String info = nomme.getText();
            if (info.length() == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Veillez remplir le champs nom !!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                con.connexionDB("application_tt");
                con.open("application_tt");
                try {
                    test = con.selectQuery("SELECT count(m.type) FROM metro m WHERE m.type= '" + info + "'");
                    while (test.next()) {
                        int s;
                        s = Integer.parseInt(test.getString(1));
                        if (s == 0) {
                            String sqlinsert = String.format("INSERT INTO `application_tt`.`metro` (type) VALUES ('%s')", info);
                            con.updateQuery(sqlinsert);
                        } else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "le centre " + info + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (e.getSource().equals(impme)) {
            try {
                chooser = new JFileChooser();
                filter = new FileNameExtensionFilter(
                        "Fichier Excel (.xls)", "xls");
                chooser.setFileFilter(filter);

                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                String fich = chooser.getSelectedFile().getName();
                InputStream input = new FileInputStream(fich);
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator rows = sheet.rowIterator();
                while (rows.hasNext()) {
                    values[0] = null;
                    values[1] = null;
                    values[2] = null;
                    values[3] = null;
                    values[4] = null;
                    values[5] = null;
                    values[6] = null;
                    values[7] = null;
                    values[8] = null;
                    values[9] = null;
                    int t = 0;

                    HSSFRow row = (HSSFRow) rows.next();

                    Iterator cells = row.cellIterator();
                    System.out.println("lecture ligne excel est effectuée");

                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();
                        if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            System.out.println("type cellule = int");
                            values[t] = Integer.toString((int) cell.getNumericCellValue());
                            t++;
                        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                            System.out.println("type cellule = String");
                            values[t] = cell.getStringCellValue();
                            t++;
                        } else {
                            values[t] = null;
                            t++;
                        }
                    }

                    System.out.println("lecture cellules excel est effectuée, id= " + values[0] + ",type= " + values[1]);

                    try {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String val0 = null;
                        String val1 = values[1];
                        test = con.selectQuery("SELECT count(m.type) FROM metro m WHERE m.type= '" + val1 + "'");
                        while (test.next()) {
                            int s;
                            s = Integer.parseInt(test.getString(1));
                            if (s == 0) {
                                String sqlinsert = String.format("INSERT INTO `application_tt`.`metro` (type) VALUES ('%s')", val1);
                                con.updateQuery(sqlinsert);
                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "le centre " + values[1] + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    } catch (Exception el) {
                        el.printStackTrace();
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Erreur au niveau de la récuperation des données !!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception es) {
                es.printStackTrace();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Erreur au niveau du fichier Excel Metro !!", null, JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource().equals(ajot)) {
            BDconn con = new BDconn();
            String info1 = nomt.getText();
            String info2 = desct.getText();
            if (info1.length() == 0 || info2.length() == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Veillez remplir tous les champs !!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                con = new BDconn();
                con.connexionDB("application_tt");
                try {
                    test = con.selectQuery("SELECT count(t.nom) FROM type t WHERE t.nom= '" + info1 + "'");
                    while (test.next()) {
                        int s;
                        s = Integer.parseInt(test.getString(1));
                        if (s == 0) {
                            String sqlinsert = String.format("INSERT INTO `application_tt`.`type` (nom,description) VALUES ('%s','%s')", info1, info2);
                            con.updateQuery(sqlinsert);
                        } else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Le type " + info1 + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (e.getSource().equals(ajou)) {
            BDconn con = new BDconn();
            String info1 = logu.getText();
            String info2 = pwdu.getText();
            String info3 = fctu.getSelectedItem().toString();

            if (info1.length() == 0 || info2.length() == 0 || info3.length() == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Veillez remplir tous les champs !!", "", JOptionPane.WARNING_MESSAGE);
            } else {
                con = new BDconn();
                con.connexionDB("application_tt");
                try {
                    test = con.selectQuery("SELECT count(u.id) FROM utilisateur u WHERE u.login= '" + info1 + "' AND u.pwd= '" + info2 + "'");
                    while (test.next()) {
                        int s;
                        s = Integer.parseInt(test.getString(1));
                        if (s == 0) {
                            String sqlinsert = String.format("INSERT INTO `utilisateur`(`login`, `pwd`, `fonction`) VALUES ('" + info1 + "','" + info2 + "','" + info3 + "')");
                            con.updateQuery(sqlinsert);
                        } else {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Le type " + info1 + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource().equals(impu)) {
            try {
                chooser = new JFileChooser();
                filter = new FileNameExtensionFilter(
                        "Fichier Excel (.xls)", "xls");
                chooser.setFileFilter(filter);

                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                String fich = chooser.getSelectedFile().getName();
                InputStream input = new FileInputStream(fich);
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator rows = sheet.rowIterator();
                while (rows.hasNext()) {
                    values[0] = null;
                    values[1] = null;
                    values[2] = null;
                    values[3] = null;
                    values[4] = null;
                    values[5] = null;
                    values[6] = null;
                    values[7] = null;
                    values[8] = null;
                    values[9] = null;
                    int t = 0;

                    HSSFRow row = (HSSFRow) rows.next();

                    Iterator cells = row.cellIterator();
                    System.out.println("lecture ligne excel est effectuée");

                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();
                        if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            System.out.println("type cellule = int");
                            values[t] = Integer.toString((int) cell.getNumericCellValue());
                            t++;
                        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                            System.out.println("type cellule = String");
                            values[t] = cell.getStringCellValue();
                            t++;
                        } else {
                            values[t] = null;
                            t++;
                        }
                    }

                    System.out.println("lecture cellules excel est effectuée, id= " + values[0] + ",login= " + values[1] + ",pwd= " + values[2] + ",role= " + values[3]);

                    try {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String val0 = null;
                        String val1 = values[1];
                        String val2 = values[2];
                        test = con.selectQuery("SELECT count(u.id) FROM utilisateur u WHERE u.login= '" + val1 + "' AND u.pwd= '" + val2 + "'");
                        while (test.next()) {
                            int s;
                            s = Integer.parseInt(test.getString(1));
                            if (s == 0) {
                                String sqlinsert = String.format("INSERT INTO `application_tt`.`utilisateur` (login,pwd,fonction) VALUES ('%s','%s','%s')", val1, val2, values[3]);
                                con.updateQuery(sqlinsert);
                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "l'utilisateur " + values[1] + " est déja existant!!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    } catch (Exception el) {
                        el.printStackTrace();
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Erreur au niveau de la récuperation des données !!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception es) {
                es.printStackTrace();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Erreur au niveau du fichier Excel Utilisateur !!", null, JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource().equals(tt)) {
            String etude = "Tunisie Télécom est un opérateur de télécommunication en Tunisie, crée le 17 avril 1995 par\n"
                    + "la loi N°36 et mis en place le 1er janvier 1996 sus le couvert du ministère des technologies de\n"
                    + "la communication, la société nationale des télécommunications «Tunisie Télécom» est une\n"
                    + "entreprise semi étatique implantée dans tout le territoire tunisien, dont le district de Mahdia où\n"
                    + "nous avons effectué notre stage. ";
            JOptionPane.showMessageDialog(null, etude, "Informations Utiles",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(fttx)) {
            String etude = "Les déploiements de réseaux de nouvelle génération basés sur des accès Fibre Optique (FTTx)\n"
                    + "sont largement amorcés dans plusieurs régions du monde.\nLe FTTx (fiber to the...) consiste à amener la fibre optique au plus près de l'utilisateur.\n"
                    + "Souvent, quand on parle de raccordement des utilisateurs à la fibre optique, il s'agit dans les\n"
                    + "faits d'un rapprochement du réseau de fibres optiques au client via une paire de cuivre\n"
                    + "(opérateurs télécom) ou d'un câble coaxial (câblo-opérateur).\n"
                    + "Le débit fourni via une fibre optique est indépendant de la distance, alors que le débit fourni\n"
                    + "via les derniers mètres (ou hectomètres) de cuivre dépend de la longueur de la paire de cuivre\n"
                    + "(affaiblissement du signal).\n"
                    + "En pratique, si la longueur de cuivre résiduelle est inférieure à 1km, le client peut bénéficier\n"
                    + "du très haut-débit";
            JOptionPane.showMessageDialog(null, etude, "Informations Utiles",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(application)) {
            String Explication = "Une application codée en JAVA par les étudiants \"Ahmed Ben Hsouna\", \"Hammouda Bouzidi\", et \"Amira Zbidi\"\n"
                    + "concernant une gestion des liaisons FTTx, et tous qui en est en relation,\n"
                    + "tel est le cas des entreprises, des centres de rattach et meme les marchées et les types des liaisons\n"
                    + "\n"
                    + "De plus, vous pouvez importer les données ou les exporter en un fichier Excel (.xls)\n";
            JOptionPane.showMessageDialog(null, Explication, "Informations Utiles",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource().equals(ajoutl) || e.getSource().equals(annl)) {
            this.setTitle("Ajouter une liaison");
            c.removeAll();
            c.setLayout(new BorderLayout());
            JPanel pan1 = new JPanel();
            JLabel abh = new JLabel();
            abh.setSize(300, 250);
            abh.setText("Ajouter une liaison .. Remplire les champs suivants");
            abh.setFont(new Font("Verdana", 1, 18));
            abh.setForeground(new Color(0, 0, 153));
            pan1.add(abh);
            JLabel nom = new JLabel();
            nom.setFont(new Font("Serif", 1, 16));
            nom.setForeground(new Color(111, 0, 0));
            nom.setBounds(220, 55, 50, 30);
            nom.setText("Nom: ");
            noml = new JTextField("", 20);
            noml.setBounds(265, 55, 170, 30);

            JLabel longueur = new JLabel();
            longueur.setFont(new Font("Serif", 1, 16));
            longueur.setForeground(new Color(111, 0, 0));
            longueur.setBounds(520, 55, 160, 30);
            longueur.setText("Longueur en m: ");
            String[] listl = new String[10000];
            for (int j = 0; j < 10000; j++) {
                String js = Integer.toString(j + 1);
                listl[j] = js;
                longl = new JComboBox(listl);
            }
            longl.setBounds(635, 55, 60, 30);
            longl.setEditable(true);

            JLabel date = new JLabel();
            date.setFont(new Font("Serif", 1, 16));
            date.setForeground(new Color(111, 0, 0));
            date.setBounds(220, 110, 90, 30);
            date.setText("Date: ");
            datel = new JTextField("", 20);
            datel.setBounds(265, 110, 170, 30);

            JLabel observation = new JLabel();
            observation.setFont(new Font("Serif", 1, 16));
            observation.setForeground(new Color(111, 0, 0));
            observation.setBounds(555, 220, 110, 30);
            observation.setText("Observation");
            observl = new JTextArea();
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            observl.setBorder(border);
            observl.setBounds(520, 255, 170, 100);

            JLabel type = new JLabel();
            type.setFont(new Font("Serif", 1, 16));
            type.setForeground(new Color(111, 0, 0));
            type.setBounds(520, 165, 90, 30);
            type.setText("Type: ");
            BDconn con = new BDconn();
            con.connexionDB("application_tt");
            int k = 0;
            String[] comb = new String[20];
            try {
                resvit2 = con.selectQuery("SELECT t.idType,t.nom FROM type t ");
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (resvit2.next()) {
                    comb[k] = resvit2.getString(2);
                    k++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] list = new String[k];
            int h = 0;
            while (h < k) {
                list[h] = comb[h];
                h++;
            }
            typel = new JComboBox(list);
            typel.setBounds(580, 165, 113, 30);
            typel.setEditable(true);

            JLabel centre = new JLabel();
            centre.setFont(new Font("Serif", 1, 16));
            centre.setForeground(new Color(111, 0, 0));
            centre.setBounds(520, 110, 90, 30);
            centre.setText("Centre: ");
            con = new BDconn();
            con.connexionDB("application_tt");
            int a = 0;
            String[] combc = new String[20];
            try {
                resvit2 = con.selectQuery("SELECT c.idCenRat,c.nom FROM centre_rattach c ");
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (resvit2.next()) {
                    combc[a] = resvit2.getString(2);
                    a++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            ;
            String[] listc = new String[a];
            int b = 0;
            while (b < a) {
                listc[b] = combc[b];
                b++;
            }
            centrel = new JComboBox(listc);
            centrel.setBounds(580, 110, 113, 30);
            centrel.setEditable(true);

            JLabel entreprise = new JLabel();
            entreprise.setFont(new Font("Serif", 1, 16));
            entreprise.setForeground(new Color(111, 0, 0));
            entreprise.setBounds(220, 275, 90, 30);
            entreprise.setText("Entreprise: ");
            con = new BDconn();
            con.connexionDB("application_tt");
            int u = 0;
            String[] combe = new String[20];
            try {
                resvit2 = con.selectQuery("SELECT e.idEntreprise,e.nom FROM entreprise e ");
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (resvit2.next()) {
                    combe[u] = resvit2.getString(2);
                    u++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] liste = new String[u];
            int v = 0;
            while (v < u) {
                liste[v] = combe[v];
                v++;
            }
            entrel = new JComboBox(liste);
            entrel.setBounds(305, 275, 130, 30);
            entrel.setEditable(true);

            JLabel plan = new JLabel();
            plan.setFont(new Font("Serif", 1, 16));
            plan.setForeground(new Color(111, 0, 0));
            plan.setBounds(220, 165, 90, 30);
            plan.setText("Plan: ");
            con = new BDconn();
            con.connexionDB("application_tt");
            int x = 0;
            String[] combp = new String[20];
            try {
                resvit2 = con.selectQuery("SELECT p.idPlan,p.nom FROM plan p ");
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (resvit2.next()) {
                    combp[x] = resvit2.getString(2);
                    x++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] listp = new String[x];
            int z = 0;
            while (z < x) {
                listp[z] = combp[z];
                z++;
            }
            planl = new JComboBox(listp);
            planl.setBounds(265, 165, 170, 30);
            planl.setEditable(true);

            JLabel reception = new JLabel();
            reception.setFont(new Font("Serif", 1, 16));
            reception.setForeground(new Color(111, 0, 0));
            reception.setBounds(220, 330, 90, 30);
            reception.setText("Reception: ");
            con = new BDconn();
            con.connexionDB("application_tt");
            int w = 0;
            String[] combr = new String[20];
            try {
                resvit2 = con.selectQuery("SELECT r.idReception,r.nom FROM reception r ");
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (resvit2.next()) {
                    combr[w] = resvit2.getString(2);
                    w++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] listr = new String[w];
            int qq = 0;
            while (qq < w) {
                listr[qq] = combr[qq];
                qq++;
            }
            recepl = new JComboBox(listr);
            recepl.setBounds(300, 330, 135, 30);
            recepl.setEditable(true);

            JLabel mar = new JLabel();
            mar.setFont(new Font("Serif", 1, 16));
            mar.setForeground(new Color(111, 0, 0));
            mar.setBounds(220, 220, 90, 30);
            mar.setText("Marche: ");
            con = new BDconn();
            con.connexionDB("application_tt");
            int p = 0;
            String[] combm = new String[20];
            try {
                resvit2 = con.selectQuery("SELECT m.idMarche,m.nom FROM marche m");
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (resvit2.next()) {
                    combm[p] = resvit2.getString(2);
                    p++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] listm = new String[p];
            int o = 0;
            while (o < p) {
                listm[o] = combm[o];
                o++;
            }
            marchel = new JComboBox(listm);
            marchel.setBounds(285, 220, 150, 30);
            marchel.setEditable(true);

            c.add(nom);
            c.add(noml);
            c.add(centre);
            c.add(centrel);
            c.add(entreprise);
            c.add(entrel);
            c.add(longueur);
            c.add(longl);
            c.add(reception);
            c.add(recepl);
            c.add(plan);
            c.add(planl);
            c.add(observation);
            c.add(observl);
            c.add(date);
            c.add(datel);
            c.add(type);
            c.add(typel);
            c.add(mar);
            c.add(marchel);

            JPanel pan3 = new JPanel();
            pan3.setLayout(new GridLayout(2, 1, 0, 0));

            JPanel pan31 = new JPanel();
            pan31.add(impl);

            JPanel pan32 = new JPanel();
            pan32.setLayout(new GridLayout(5, 1, 0, 0));
            JLabel tel = new JLabel();
            tel.setFont(new Font("Serif", 1, 16));
            tel.setForeground(new Color(111, 0, 0));
            tel.setText("Telephone: 73 643 235");
            JLabel fax = new JLabel();
            fax.setFont(new Font("Serif", 1, 16));
            fax.setForeground(new Color(111, 0, 0));
            fax.setText("Fax:            73 643 240");

            JLabel vide = new JLabel();
            vide.setText("");

            pan32.add(ajol);
            pan32.add(annl);
            pan32.add(vide);
            pan32.add(tel);
            pan32.add(fax);

            pan3.add(pan31);
            pan3.add(pan32);

            JPanel pan2 = new JPanel();
            lab = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            pan2.add(lab);

            c.add(pan1, "Center");
            c.add(pan3, "West");
            c.add(pan2, "South");
            this.setVisible(true);
        }

        if (e.getSource().equals(ajoutt) || e.getSource().equals(annt)) {
            this.setTitle("Ajouter un type de liaison");
            c.removeAll();
            c.setLayout(new BorderLayout());

            JPanel pan1 = new JPanel();
            JLabel abh = new JLabel();
            abh.setSize(300, 250);
            abh.setText("Ajouter un type .. Remplire les champs suivants");
            abh.setFont(new Font("Verdana", 1, 18));
            abh.setForeground(new Color(0, 0, 153));
            pan1.add(abh);

            JLabel nom = new JLabel();
            nom.setFont(new Font("Serif", 1, 16));
            nom.setForeground(new Color(111, 0, 0));
            nom.setBounds(335, 80, 90, 30);
            nom.setText("Nom: ");
            nomt = new JTextField("", 20);
            nomt.setBounds(383, 80, 190, 30);

            JLabel desc = new JLabel();
            desc.setFont(new Font("Serif", 1, 16));
            desc.setForeground(new Color(111, 0, 0));
            desc.setBounds(415, 135, 90, 30);
            desc.setText("Description");
            desct = new JTextArea();
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            desct.setBorder(border);
            desct.setBounds(335, 170, 240, 100);

            c.add(nom);
            c.add(nomt);
            c.add(desc);
            c.add(desct);

            JPanel pan3 = new JPanel();
            pan3.setLayout(new GridLayout(2, 1, 0, 0));

            JPanel pan31 = new JPanel();
            pan31.add(impt);

            JPanel pan32 = new JPanel();
            pan32.setLayout(new GridLayout(5, 1, 0, 0));
            JLabel tel = new JLabel();
            tel.setFont(new Font("Serif", 1, 16));
            tel.setForeground(new Color(111, 0, 0));
            tel.setText("Telephone: 73 643 235");
            JLabel fax = new JLabel();
            fax.setFont(new Font("Serif", 1, 16));
            fax.setForeground(new Color(111, 0, 0));
            fax.setText("Fax:            73 643 240");

            JLabel vide = new JLabel();
            vide.setText("");

            pan32.add(ajot);
            pan32.add(annt);
            pan32.add(vide);
            pan32.add(tel);
            pan32.add(fax);

            pan3.add(pan31);
            pan3.add(pan32);

            JPanel pan2 = new JPanel();
            lab = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            pan2.add(lab);

            c.add(pan1, "Center");
            c.add(pan2, "South");
            c.add(pan3, "West");
            this.setVisible(true);
        }

        if (e.getSource().equals(ajoute) || e.getSource().equals(anne)) {
            this.setTitle("Ajouter une entreprise");
            c.removeAll();
            c.setLayout(new BorderLayout());

            JPanel pan1 = new JPanel();
            JLabel abh = new JLabel();
            abh.setSize(300, 250);
            abh.setText("Ajouter une entreprise .. Remplire les champs suivants");
            abh.setFont(new Font("Verdana", 1, 18));
            abh.setForeground(new Color(0, 0, 153));
            pan1.add(abh);

            JLabel nom = new JLabel();
            nom.setFont(new Font("Serif", 1, 16));
            nom.setForeground(new Color(111, 0, 0));
            nom.setBounds(335, 110, 90, 30);
            nom.setText("Nom: ");
            nome = new JTextField("", 20);
            nome.setBounds(383, 110, 190, 30);

            JLabel logo = new JLabel();
            logo.setFont(new Font("Serif", 1, 16));
            logo.setForeground(new Color(111, 0, 0));
            logo.setBounds(335, 165, 90, 30);
            logo.setText("Logo: ");
            logoe = new JTextField("", 20);
            logoe.setBounds(383, 165, 190, 30);

            JLabel adresse = new JLabel();
            adresse.setFont(new Font("Serif", 1, 16));
            adresse.setForeground(new Color(111, 0, 0));
            adresse.setBounds(335, 220, 90, 30);
            adresse.setText("Adresse: ");
            adre = new JTextField("", 20);
            adre.setBounds(400, 220, 173, 30);

            c.add(nom);
            c.add(nome);
            c.add(adresse);
            c.add(adre);
            c.add(logo);
            c.add(logoe);

            JPanel pan3 = new JPanel();
            pan3.setLayout(new GridLayout(2, 1, 0, 0));

            JPanel pan31 = new JPanel();
            pan31.add(impe);

            JPanel pan32 = new JPanel();
            pan32.setLayout(new GridLayout(5, 1, 0, 0));
            JLabel tel = new JLabel();
            tel.setFont(new Font("Serif", 1, 16));
            tel.setForeground(new Color(111, 0, 0));
            tel.setText("Telephone: 73 643 235");
            JLabel fax = new JLabel();
            fax.setFont(new Font("Serif", 1, 16));
            fax.setForeground(new Color(111, 0, 0));
            fax.setText("Fax:            73 643 240");

            JLabel vide = new JLabel();
            vide.setText("");

            pan32.add(ajoe);
            pan32.add(anne);
            pan32.add(vide);
            pan32.add(tel);
            pan32.add(fax);

            pan3.add(pan31);
            pan3.add(pan32);

            JPanel pan2 = new JPanel();
            lab = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            pan2.add(lab);

            c.add(pan1, "Center");
            c.add(pan3, "West");
            c.add(pan2, "South");
            this.setVisible(true);
        }

        if (e.getSource().equals(ajoutc) || e.getSource().equals(annc)) {

            this.setTitle("Ajouter un centre de rattach");
            c.removeAll();
            c.setLayout(new BorderLayout());

            JPanel pan1 = new JPanel();
            JLabel abh = new JLabel();
            abh.setSize(300, 250);
            abh.setText("Ajouter un centre de rattach .. Remplire les champs suivants");
            abh.setFont(new Font("Verdana", 1, 18));
            abh.setForeground(new Color(0, 0, 153));
            pan1.add(abh);

            JLabel nom = new JLabel();
            nom.setFont(new Font("Serif", 1, 16));
            nom.setForeground(new Color(111, 0, 0));
            nom.setBounds(335, 110, 90, 30);
            nom.setText("Nom: ");
            nomc = new JTextField("", 20);
            nomc.setBounds(383, 110, 190, 30);

            JLabel met = new JLabel();
            met.setFont(new Font("Serif", 1, 16));
            met.setForeground(new Color(111, 0, 0));
            met.setBounds(335, 165, 90, 30);
            met.setText("Metro: ");

            BDconn con = new BDconn();
            con.connexionDB("application_tt");
            int k = 0;
            String[] comb = new String[20];
            try {
                resvit2 = con.selectQuery("SELECT m.idMetro,m.type FROM metro m");
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("requet resvit2 9rahaaa");
            try {
                while (resvit2.next()) {
                    comb[k] = resvit2.getString(2);
                    System.out.println("t3adda w 3abba hethi," + comb[k]);
                    k++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("k= " + k);
            String[] list = new String[k];
            int h = 0;
            while (h < k) {
                list[h] = comb[h];
                h++;
            }
            metroc = new JComboBox(list);
            metroc.setBounds(388, 165, 185, 30);
            metroc.setEditable(true);

            c.add(nom);
            c.add(nomc);
            c.add(met);
            c.add(metroc);

            JPanel pan3 = new JPanel();
            pan3.setLayout(new GridLayout(2, 1, 0, 0));

            JPanel pan31 = new JPanel();
            pan31.add(impc);

            JPanel pan32 = new JPanel();
            pan32.setLayout(new GridLayout(5, 1, 0, 0));
            JLabel tel = new JLabel();
            tel.setFont(new Font("Serif", 1, 16));
            tel.setForeground(new Color(111, 0, 0));
            tel.setText("Telephone: 73 643 235");
            JLabel fax = new JLabel();
            fax.setFont(new Font("Serif", 1, 16));
            fax.setForeground(new Color(111, 0, 0));
            fax.setText("Fax:            73 643 240");

            JLabel vide = new JLabel();
            vide.setText("");

            pan32.add(ajoc);
            pan32.add(annc);
            pan32.add(vide);
            pan32.add(tel);
            pan32.add(fax);

            pan3.add(pan31);
            pan3.add(pan32);

            JPanel pan2 = new JPanel();
            lab = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            pan2.add(lab);

            c.add(pan1, "Center");
            c.add(pan3, "West");
            c.add(pan2, "South");
            this.setVisible(true);
        }

        if (e.getSource().equals(ajoutme) || e.getSource().equals(annme)) {
            this.setTitle("Ajouter un metro");
            c.removeAll();
            c.setLayout(new BorderLayout());

            JPanel pan1 = new JPanel();
            JLabel abh = new JLabel();
            abh.setSize(300, 250);
            abh.setText("Ajouter un metro .. Remplire le champ suivant");
            abh.setFont(new Font("Verdana", 1, 18));
            abh.setForeground(new Color(0, 0, 153));
            pan1.add(abh);

            JLabel nom = new JLabel();
            nom.setFont(new Font("Serif", 1, 16));
            nom.setForeground(new Color(111, 0, 0));
            nom.setBounds(335, 120, 90, 30);
            nom.setText("Nom: ");
            nomme = new JTextField("", 20);
            nomme.setBounds(383, 120, 190, 30);

            c.add(nom);
            c.add(nomme);

            JPanel pan3 = new JPanel();
            pan3.setLayout(new GridLayout(2, 1, 0, 0));

            JPanel pan31 = new JPanel();
            pan31.add(impme);

            JPanel pan32 = new JPanel();
            pan32.setLayout(new GridLayout(5, 1, 0, 0));
            JLabel tel = new JLabel();
            tel.setFont(new Font("Serif", 1, 16));
            tel.setForeground(new Color(111, 0, 0));
            tel.setText("Telephone: 73 643 235");
            JLabel fax = new JLabel();
            fax.setFont(new Font("Serif", 1, 16));
            fax.setForeground(new Color(111, 0, 0));
            fax.setText("Fax:            73 643 240");

            JLabel vide = new JLabel();
            vide.setText("");

            pan32.add(ajome);
            pan32.add(annme);
            pan32.add(vide);
            pan32.add(tel);
            pan32.add(fax);

            pan3.add(pan31);
            pan3.add(pan32);

            JPanel pan2 = new JPanel();
            lab = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            pan2.add(lab);

            c.add(pan1, "Center");
            c.add(pan3, "West");
            c.add(pan2, "South");
            this.setVisible(true);
        }

        if (e.getSource().equals(impt)) {
            try {
                chooser = new JFileChooser();
                filter = new FileNameExtensionFilter(
                        "Fichier Excel (.xls)", "xls");
                chooser.setFileFilter(filter);

                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                }
                String fich = chooser.getSelectedFile().getName();
                InputStream input = new FileInputStream(fich);
                POIFSFileSystem fs = new POIFSFileSystem(input);
                HSSFWorkbook wb = new HSSFWorkbook(fs);
                HSSFSheet sheet = wb.getSheetAt(0);
                Iterator rows = sheet.rowIterator();

                while (rows.hasNext()) {
                    values[0] = null;
                    values[1] = null;
                    values[2] = null;
                    values[3] = null;
                    values[4] = null;
                    values[5] = null;
                    values[6] = null;
                    values[7] = null;
                    values[8] = null;
                    values[9] = null;
                    values[10] = null;
                    int t = 0;

                    HSSFRow row = (HSSFRow) rows.next();
                    Iterator cells = row.cellIterator();
                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();
                        if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            System.out.println("type cellule = int");
                            values[t] = Integer.toString((int) cell.getNumericCellValue());
                            t++;
                        } else if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
                            System.out.println("type cellule = String");
                            values[t] = cell.getStringCellValue();
                            t++;
                        } else {
                            values[t] = null;
                            t++;
                        }
                    }
                    System.out.println("lecture cellules excel est effectuée, id= " + values[0] + ",nom= " + values[1] + ",desc= " + values[2]);
                    try {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String val0 = null;
                        String val1 = values[1];
                        String val2 = values[2];
                        test = con.selectQuery("SELECT count(t.nom) FROM type t WHERE t.nom= '" + val1 + "'");

                        while (test.next()) {
                            int s;
                            s = Integer.parseInt(test.getString(1));
                            if (s == 0) {
                                String sqlinsert = String.format("INSERT INTO `application_tt`.`type` (nom,description) VALUES ('%s','%s')", val1, val2);
                                con.updateQuery(sqlinsert);
                            } else {
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f, "le type " + values[1] + " est déja existant dans la base !!", "", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } catch (Exception el) {
                        el.printStackTrace();
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "Erreur au niveau de la récuperation des données !!", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception es) {
                es.printStackTrace();
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Erreur au niveau du fichier Excel Type !!", null, JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource().equals(ajoutma) || e.getSource().equals(annma)) {
            this.setTitle("Ajouter un marche");
            c.removeAll();
            c.setLayout(new BorderLayout());

            JPanel pan1 = new JPanel();
            JLabel abh = new JLabel();
            abh.setSize(300, 250);
            abh.setText("Ajouter un marche .. Remplire les champs suivants");
            abh.setFont(new Font("Verdana", 1, 18));
            abh.setForeground(new Color(0, 0, 153));
            pan1.add(abh);

            JLabel nom = new JLabel();
            nom.setFont(new Font("Serif", 1, 16));
            nom.setForeground(new Color(111, 0, 0));
            nom.setBounds(335, 110, 90, 30);
            nom.setText("Nom: ");
            nomma = new JTextField("", 20);
            nomma.setBounds(383, 110, 190, 30);

            JLabel dated = new JLabel();
            dated.setFont(new Font("Serif", 1, 16));
            dated.setForeground(new Color(111, 0, 0));
            dated.setBounds(335, 165, 90, 30);
            dated.setText("Date Debut: ");
            datedma = new JTextField("", 20);
            datedma.setBounds(425, 165, 147, 30);

            JLabel datef = new JLabel();
            datef.setFont(new Font("Serif", 1, 16));
            datef.setForeground(new Color(111, 0, 0));
            datef.setBounds(335, 220, 90, 30);
            datef.setText("Date Fin: ");
            datefma = new JTextField("", 20);
            datefma.setBounds(405, 220, 166, 30);

            c.add(nom);
            c.add(nomma);
            c.add(dated);
            c.add(datedma);
            c.add(datef);
            c.add(datefma);

            JPanel pan3 = new JPanel();
            pan3.setLayout(new GridLayout(2, 1, 0, 0));

            JPanel pan31 = new JPanel();
            pan31.add(impma);

            JPanel pan32 = new JPanel();
            pan32.setLayout(new GridLayout(5, 1, 0, 0));
            JLabel tel = new JLabel();
            tel.setFont(new Font("Serif", 1, 16));
            tel.setForeground(new Color(111, 0, 0));
            tel.setText("Telephone: 73 643 235");
            JLabel fax = new JLabel();
            fax.setFont(new Font("Serif", 1, 16));
            fax.setForeground(new Color(111, 0, 0));
            fax.setText("Fax:            73 643 240");

            JLabel vide = new JLabel();
            vide.setText("");

            pan32.add(ajoma);
            pan32.add(annma);
            pan32.add(vide);
            pan32.add(tel);
            pan32.add(fax);

            pan3.add(pan31);
            pan3.add(pan32);

            JPanel pan2 = new JPanel();
            lab = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            pan2.add(lab);

            c.add(pan1, "Center");
            c.add(pan3, "West");
            c.add(pan2, "South");
            this.setVisible(true);
        }

        if (e.getSource().equals(modifl) || e.getSource().equals(modiflrefresh)) {
            // TODO Auto-generated catch block
            this.setTitle("Modifier et supprimer une liaison");
            panelcentral.removeAll();
            c.removeAll();
            JLabel titre = new JLabel();
            titre.setSize(300, 250);
            titre.setBounds(10, 20, 1010, 20);
            titre.setText("       LIAISON     ");
            titre.setFont(new Font("Verdana", 1, 18));
            titre.setForeground(new Color(0, 0, 153));

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2m.jpg"));
            JPanel panac = new JPanel();
            panac.add(labac);
            c.add(panac, "South");

            TableColumn col;
            modell = new MyTableModell(true);
            sorterl = new TableRowSorter<MyTableModell>(modell);
            table = new JTable(modell);
            table.setRowHeight(23);
            col = table.getColumnModel().getColumn(9);
            col.setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            scroller = new JScrollPane(table);

            JPanel tit = new JPanel();
            ImageIcon icon = new ImageIcon((".\\src\\images\\Excel-2-icon.png"));
            JButton expor = new JButton("export to Excel");
            expor.setToolTipText("export to Excel");
            expor.setIcon(icon);
            expor.setRolloverEnabled(true);
            expor.setRolloverIcon(new RolloverIcon(icon));
            expor.setBackground(null);
            tit.add(expor);
            expor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser fille = new JFileChooser();
                    fille.showOpenDialog(null);
                    File file = fille.getSelectedFile();
                    exporter(table, file);
                }
            });

            modiflrefresh = new JButton("Actualiser");
            modiflrefresh.setIcon(new ImageIcon(".\\src\\images\\refresh.png"));
            modiflrefresh.addActionListener(this);
            tit.add(modiflrefresh);

            tit.add(titre);

            final JTextField fil = new JTextField(15);
            JButton filtre = new JButton("Recherche");
            filtre.setSize(20, 10);
            filtre.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));

            filtre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                            0);
                    filters.add(RowFilter.regexFilter(fil.getText(), 1));
                    RowFilter<Object, Object> serviceFilter = RowFilter
                            .andFilter(filters);
                    sorterl.setRowFilter(serviceFilter);

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });

            JPanel rech = new JPanel();
            rech.add(filtre);
            rech.add(fil);
            JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bar.add(tit);
            bar.add(rech);
            c.add(bar, BorderLayout.NORTH);

            table.setRowSorter(sorterl);
            c.add(scroller, BorderLayout.CENTER);

            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();

                    if (col == 0) {
                        int jo = JOptionPane.showConfirmDialog(fen, "Voulez-vous supprimer cette ligne ?", "Message de confirmation", JOptionPane.YES_NO_OPTION);
                        if (jo == JOptionPane.YES_OPTION) {
                            BDconn con = new BDconn();
                            con.connexionDB("application_tt");
                            String requp = "DELETE FROM `application_tt`.`liaison` WHERE `liaison`.`idLaison` = " + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 1) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau nom !", "Modification du nom", JOptionPane.QUESTION_MESSAGE);
                        
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`liaison` SET `nom` = '-.-' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`liaison` SET `nom` = '" + mod + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 2) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comb = new String[20];
                        try {
                            resvit2 = con.selectQuery("SELECT t.idType,t.nom FROM type t");
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            while (resvit2.next()) {
                                comb[k] = resvit2.getString(2);
                                k++;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] list = new String[k];
                        int h = 0;
                        while (h < k) {
                            list[h] = comb[h];
                            h++;
                        }
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication de Type", dialogButton);
                        if (dialogButton == 0) {
                            if (jcb.getSelectedIndex() >= 0) {
                                try {
                                    resvit2 = con.selectQuery("SELECT t.idType FROM type t WHERE t.nom= '" + jcb.getSelectedItem().toString() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    int id;
                                    while (resvit2.next()) {
                                        id = resvit2.getInt(1);
                                        String idch = Integer.toString((int) id);
                                        String requp = "UPDATE `application_tt`.`liaison` SET `idType` = '" + idch + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                                        try {
                                            con.updateQuery(requp);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    } else if (col == 3) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comb = new String[20];
                        try {
                            resvit2 = con.selectQuery("SELECT c.idCenRat,c.nom FROM centre_rattach c");
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            while (resvit2.next()) {
                                comb[k] = resvit2.getString(2);
                                k++;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] list = new String[k];
                        int h = 0;
                        while (h < k) {
                            list[h] = comb[h];
                            h++;
                        }
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication de Centre", dialogButton);
                        if (dialogButton == 0) {
                            if (jcb.getSelectedIndex() >= 0) {
                                try {
                                    resvit2 = con.selectQuery("SELECT c.idCenRat FROM centre_rattach c WHERE c.nom= '" + jcb.getSelectedItem().toString() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    int id;
                                    while (resvit2.next()) {
                                        id = resvit2.getInt(1);
                                        String idch = Integer.toString((int) id);
                                        String requp = "UPDATE `application_tt`.`liaison` SET `idCentRat` = '" + idch + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                                        try {
                                            con.updateQuery(requp);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    } else if (col == 4) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comb = new String[20];
                        try {
                            resvit2 = con.selectQuery("SELECT e.idEntreprise,e.nom FROM entreprise e");
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            while (resvit2.next()) {
                                comb[k] = resvit2.getString(2);
                                k++;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] list = new String[k];
                        int h = 0;
                        while (h < k) {
                            list[h] = comb[h];
                            h++;
                        }
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication d'entreprise", dialogButton);
                        if (dialogButton == 0) {
                            if (jcb.getSelectedIndex() >= 0) {
                                try {
                                    resvit2 = con.selectQuery("SELECT e.idEntreprise FROM entreprise e WHERE e.nom= '" + jcb.getSelectedItem().toString() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    int id;
                                    while (resvit2.next()) {
                                        id = resvit2.getInt(1);
                                        String idch = Integer.toString((int) id);
                                        String requp = "UPDATE `application_tt`.`liaison` SET `idEntreprise` = '" + idch + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                                        try {
                                            con.updateQuery(requp);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    } else if (col == 9) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comboo = new String[10000];
                        for (int j = 0; j < 10000; j++) {
                            String js = Integer.toString(j + 1);
                            comboo[j] = js;
                        }

                        JComboBox jcb = new JComboBox(comboo);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication de longueur", dialogButton);

                        if (dialogButton == 0) {
                            int i = jcb.getSelectedIndex() + 1;
                            String lo = Integer.toString(i);
                            String requp = "UPDATE `application_tt`.`liaison` SET `longueur` = '" + lo + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    } else if (col == 600) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comb = new String[20];
                        try {
                            resvit2 = con.selectQuery("SELECT r.idReception,r.nom FROM reception r");
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            while (resvit2.next()) {
                                comb[k] = resvit2.getString(2);
                                k++;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] list = new String[k];
                        int h = 0;
                        while (h < k) {
                            list[h] = comb[h];
                            h++;
                        }
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication de Reception", dialogButton);
                        if (dialogButton == 0) {
                            if (jcb.getSelectedIndex() >= 0) {
                                try {
                                    resvit2 = con.selectQuery("SELECT r.idReception FROM reception r WHERE r.nom= '" + jcb.getSelectedItem().toString() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    int id;
                                    while (resvit2.next()) {
                                        id = resvit2.getInt(1);
                                        String idch = Integer.toString((int) id);
                                        String requp = "UPDATE `application_tt`.`liaison` SET `idReception` = '" + idch + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                                        try {
                                            con.updateQuery(requp);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    } else if (col == 700) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comb = new String[20];
                        try {
                            resvit2 = con.selectQuery("SELECT p.idPlan,p.nom FROM plan p");
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            while (resvit2.next()) {
                                comb[k] = resvit2.getString(2);
                                k++;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] list = new String[k];
                        int h = 0;
                        while (h < k) {
                            list[h] = comb[h];
                            h++;
                        }
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication de Plan", dialogButton);
                        if (dialogButton == 0) {
                            if (jcb.getSelectedIndex() >= 0) {
                                try {
                                    resvit2 = con.selectQuery("SELECT p.idPlan FROM plan p WHERE p.nom= '" + jcb.getSelectedItem().toString() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    int id;
                                    while (resvit2.next()) {
                                        id = resvit2.getInt(1);
                                        String idch = Integer.toString((int) id);
                                        String requp = "UPDATE `application_tt`.`liaison` SET `idPlan` = '" + idch + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                                        try {
                                            con.updateQuery(requp);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    } else if (col == 5) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");

                        //DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                        //JCalender jc = new JCalender();
                        //String mod = jc.tex.getText();
                        //Calendar calendar = jc.getCalendar();
                        //System.out.println(calendar.get(calendar.DAY_OF_MONTH));
                        //String mod = df.format(calendar.getTime());
                        /*final JButton ok= new JButton("Modifier");
                         ok.addActionListener(new ActionListener() { 
                         @Override
                         public void actionPerformed(ActionEvent e) {
                                            
                         d = new JTextField();
                         JButton ok2=ok;
                         Test t=new Test(ok2,d);
                         String m = d.getText();
                         }
                         });*/
                        //String mod = df.format(t.calendar.getDate());
                        //System.out.println("mod  = "+mod);
                        String mod = JOptionPane.showInputDialog(fen, "Entrer la nouvelle date !", "Modification de date-MES", JOptionPane.QUESTION_MESSAGE);
                        System.out.println("nouv date= " + mod + ", ancien date= " + table.getModel().getValueAt(row, col));
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`liaison` SET `dateMES` = '-.-' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`liaison` SET `dateMES` = '" + mod + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    } else if (col == 900) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer la nouvelle observation !", "Modification d'observation", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`liaison` SET `observation` = '-.-' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`liaison` SET `observation` = '" + mod + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    } else if (col == 6) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comb = new String[20];
                        try {
                            resvit2 = con.selectQuery("SELECT m.idMarche,m.nom FROM marche m");
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            while (resvit2.next()) {
                                comb[k] = resvit2.getString(2);
                                k++;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] list = new String[k];
                        int h = 0;
                        while (h < k) {
                            list[h] = comb[h];
                            h++;
                        }
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modification de Marche", dialogButton);
                        if (dialogButton == 0) {
                            if (jcb.getSelectedIndex() >= 0) {
                                try {
                                    resvit2 = con.selectQuery("SELECT m.idMarche FROM marche m WHERE m.nom= '" + jcb.getSelectedItem().toString() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    int id;
                                    while (resvit2.next()) {
                                        id = resvit2.getInt(1);
                                        String idch = Integer.toString((int) id);
                                        String requp = "UPDATE `application_tt`.`liaison` SET `idMarche` = '" + idch + "' WHERE `liaison`.`idLaison` =" + table.getModel().getValueAt(row, 0);
                                        try {
                                            con.updateQuery(requp);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    } else if ((col == 7) || (col == 8)) {
                        JOptionPane.showMessageDialog(fen, "Champs immodifiable !", "Message d'avertissement", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            c = this.getContentPane();
            this.setVisible(true);
        }

        if (e.getSource().equals(modifc) || e.getSource().equals(modifcrefresh)) {
            // TODO Auto-generated catch block

            this.setTitle("Modifier et supprimer un centre de rattach");
            c.removeAll();
            panelcentral.removeAll();
            JLabel titre = new JLabel();
            titre.setSize(300, 250);
            titre.setBounds(10, 20, 1010, 20);
            titre.setText("       CENTRE      ");
            titre.setFont(new Font("Verdana", 1, 18));
            titre.setForeground(new Color(0, 0, 153));

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2m.jpg"));
            JPanel panac = new JPanel();
            panac.add(labac);
            c.add(panac, "South");
            panelcentral.add(titre);
            panelcentral.setBounds(100, 100, 680, 500);
            TableColumn col;
            modelc = new MyTableModelc(true);
            sorterc = new TableRowSorter<MyTableModelc>(modelc);
            table = new JTable(modelc);
            table.setRowHeight(23);
            col = table.getColumnModel().getColumn(2);
            col.setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            scroller = new JScrollPane(table);
            panelcentral.add(scroller);

            JPanel tit = new JPanel();
            ImageIcon icon = new ImageIcon((".\\src\\images\\Excel-2-icon.png"));
            JButton expor = new JButton("export to Excel");
            expor.setToolTipText("export to Excel");
            expor.setIcon(icon);
            expor.setRolloverEnabled(true);
            expor.setRolloverIcon(new RolloverIcon(icon));
            expor.setBackground(null);
            tit.add(expor);
            expor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser fille = new JFileChooser();
                    fille.showOpenDialog(null);
                    File file = fille.getSelectedFile();
                    exporter(table, file);
                }
            });

            modifcrefresh = new JButton("Actualiser");
            modifcrefresh.setIcon(new ImageIcon(".\\src\\images\\refresh.png"));
            modifcrefresh.addActionListener(this);
            tit.add(modifcrefresh);
            tit.add(titre);
            final JTextField fil = new JTextField(15);
            JButton filtre = new JButton("Recherche");
            filtre.setSize(20, 10);
            filtre.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            filtre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                            0);
                    filters.add(RowFilter.regexFilter(fil.getText(), 1));
                    RowFilter<Object, Object> serviceFilter = RowFilter
                            .andFilter(filters);
                    sorterc.setRowFilter(serviceFilter);

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            JPanel rech = new JPanel();
            rech.add(filtre);
            rech.add(fil);
            JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bar.add(tit);
            bar.add(rech);
            c.add(bar, BorderLayout.NORTH);

            table.setRowSorter(sorterc);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    if (col == 0) {
                        int jo = JOptionPane.showConfirmDialog(fen, "Voulez-vous supprimer cette ligne ?", "Message de confirmation", JOptionPane.YES_NO_OPTION);
                        if (jo == JOptionPane.YES_OPTION) {
                            BDconn con = new BDconn();
                            con.connexionDB("application_tt");
                            String requp = "DELETE FROM `application_tt`.`centre_rattach` WHERE `centre_rattach`.`idCenRat` = " + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 1) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau nom !", "Modification du nom", JOptionPane.QUESTION_MESSAGE);
                        System.out.println("nouv nom= " + mod + ", ancien nom= " + table.getModel().getValueAt(row, col));
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`centre_rattach` SET `nom` = '-.-' WHERE `centre_rattach`.`idCenRat` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);

                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`centre_rattach` SET `nom` = '" + mod + "' WHERE `centre_rattach`.`idCenRat` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 2) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        int k = 0;
                        String[] comb = new String[20];
                        try {
                            resvit2 = con.selectQuery("SELECT m.idMetro,m.type FROM metro m");
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            while (resvit2.next()) {
                                comb[k] = resvit2.getString(2);
                                k++;
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] list = new String[k];
                        int h = 0;
                        while (h < k) {
                            list[h] = comb[h];
                            h++;
                        }
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication de Metro", dialogButton);
                        if (dialogButton == 0) {
                            if (jcb.getSelectedIndex() >= 0) {
                                try {
                                    resvit2 = con.selectQuery("SELECT m.idMetro FROM metro m WHERE m.type= '" + jcb.getSelectedItem().toString() + "'");
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    int id;
                                    while (resvit2.next()) {
                                        id = resvit2.getInt(1);
                                        String idch = Integer.toString((int) id);
                                        String requp = "UPDATE `application_tt`.`centre_rattach` SET `idMetro` = '" + idch + "' WHERE `centre_rattach`.`idCenRat` =" + table.getModel().getValueAt(row, 0);
                                        try {
                                            con.updateQuery(requp);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("noooooooooooon !!!");
                        }
                    }
                }
            });
            c = this.getContentPane();
            c.add(panelcentral, BorderLayout.CENTER);
            this.setVisible(true);
        }

        if (e.getSource().equals(modife) || e.getSource().equals(modiferefresh)) {
            // TODO Auto-generated catch block

            this.setTitle("Modifier et supprimer une entreprise");
            c.removeAll();
            panelcentral.removeAll();
            JLabel titre = new JLabel();
            titre.setSize(300, 250);
            titre.setBounds(10, 20, 1010, 20);
            titre.setText("    ENTREPRISE ");
            titre.setFont(new Font("Verdana", 1, 18));
            titre.setForeground(new Color(0, 0, 153));

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2m.jpg"));
            JPanel panac = new JPanel();
            panac.add(labac);
            c.add(panac, "South");
            panelcentral.add(titre);
            panelcentral.setBounds(100, 100, 680, 500);
            TableColumn col;
            modele = new MyTableModele(true);
            sortere = new TableRowSorter<MyTableModele>(modele);
            table = new JTable(modele);
            table.setRowHeight(23);
            col = table.getColumnModel().getColumn(3);
            col.setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            scroller = new JScrollPane(table);
            c.add(scroller);
            JPanel tit = new JPanel();
            ImageIcon icon = new ImageIcon((".\\src\\images\\Excel-2-icon.png"));
            JButton expor = new JButton("export to Excel");
            expor.setToolTipText("export to Excel");
            expor.setIcon(icon);
            expor.setRolloverEnabled(true);
            expor.setRolloverIcon(new RolloverIcon(icon));
            expor.setBackground(null);
            tit.add(expor);
            expor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser fille = new JFileChooser();
                    fille.showOpenDialog(null);
                    File file = fille.getSelectedFile();
                    exporter(table, file);
                }
            });

            modiferefresh = new JButton("Actualiser");
            modiferefresh.setIcon(new ImageIcon(".\\src\\images\\refresh.png"));
            modiferefresh.addActionListener(this);
            tit.add(modiferefresh);
            tit.add(titre);
            final JTextField fil = new JTextField(15);
            JButton filtre = new JButton("Recherche");
            filtre.setSize(20, 10);
            filtre.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            filtre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                            0);
                    filters.add(RowFilter.regexFilter(fil.getText(), 1));
                    RowFilter<Object, Object> serviceFilter = RowFilter
                            .andFilter(filters);
                    sortere.setRowFilter(serviceFilter);

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            JPanel rech = new JPanel();
            rech.add(filtre);
            rech.add(fil);
            JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bar.add(tit);
            bar.add(rech);
            c.add(bar, BorderLayout.NORTH);
            table.setRowSorter(sortere);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    if (col == 0) {
                        int jo = JOptionPane.showConfirmDialog(fen, "Voulez-vous supprimer cette ligne ?", "Message de confirmation", JOptionPane.YES_NO_OPTION);
                        if (jo == JOptionPane.YES_OPTION) {
                            BDconn con = new BDconn();
                            con.connexionDB("application_tt");
                            String requp = "DELETE FROM `application_tt`.`entreprise` WHERE `entreprise`.`idEntreprise` = " + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 1) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau Nom !", "Modification du Nom", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`entreprise` SET `nom` = '-.-' WHERE `entreprise`.`idEntreprise` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);

                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`entreprise` SET `nom` = '" + mod + "' WHERE `entreprise`.`idEntreprise` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 2) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau Logo !", "Modification du Logo", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`entreprise` SET `logo` = '-.-' WHERE `entreprise`.`idEntreprise` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`entreprise` SET `logo` = '" + mod + "' WHERE `entreprise`.`idEntreprise` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 3) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau Adresse !", "Modification d'adresse", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`entreprise` SET `adresse` = '-.-' WHERE `entreprise`.`idEntreprise` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`entreprise` SET `adresse` = '" + mod + "' WHERE `entreprise`.`idEntreprise` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
            c = this.getContentPane();
            this.setVisible(true);
        }

        if (e.getSource().equals(modifma) || e.getSource().equals(modifmarefresh)) {
            // TODO Auto-generated catch block
            this.setTitle("Modifier et supprimer un marche");
            c.removeAll();
            JLabel titre = new JLabel();
            titre.setSize(300, 250);
            titre.setBounds(10, 20, 1010, 20);
            titre.setText("       MARCHE     ");
            titre.setFont(new Font("Verdana", 1, 18));
            titre.setForeground(new Color(0, 0, 153));

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2m.jpg"));
            JPanel panac = new JPanel();
            panac.add(labac);
            c.add(panac, "South");
            c.add(titre, "North");
            TableColumn col;
            modelma = new MyTableModelma(true);
            sorterma = new TableRowSorter<MyTableModelma>(modelma);
            table = new JTable(modelma);
            table.setRowHeight(23);
            col = table.getColumnModel().getColumn(3);
            col.setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            scroller = new JScrollPane(table);
            c.add(scroller);
            JPanel tit = new JPanel();
            ImageIcon icon = new ImageIcon((".\\src\\images\\Excel-2-icon.png"));
            JButton expor = new JButton("export to Excel");
            expor.setToolTipText("export to Excel");
            expor.setIcon(icon);
            expor.setRolloverEnabled(true);
            expor.setRolloverIcon(new RolloverIcon(icon));
            expor.setBackground(null);
            tit.add(expor);
            expor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser fille = new JFileChooser();
                    fille.showOpenDialog(null);
                    File file = fille.getSelectedFile();
                    exporter(table, file);
                }
            });

            modifmarefresh = new JButton("Actualiser");
            modifmarefresh.setIcon(new ImageIcon(".\\src\\images\\refresh.png"));
            modifmarefresh.addActionListener(this);
            tit.add(modifmarefresh);
            tit.add(titre);
            final JTextField fil = new JTextField(15);
            JButton filtre = new JButton("Recherche");
            filtre.setSize(20, 10);
            filtre.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            filtre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                            0);
                    filters.add(RowFilter.regexFilter(fil.getText(), 1));
                    RowFilter<Object, Object> serviceFilter = RowFilter
                            .andFilter(filters);
                    sorterma.setRowFilter(serviceFilter);

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            JPanel rech = new JPanel();
            rech.add(filtre);
            rech.add(fil);
            JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bar.add(tit);
            bar.add(rech);
            c.add(bar, BorderLayout.NORTH);
            table.setRowSorter(sorterma);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();

                    if (col == 0) {
                        int jo = JOptionPane.showConfirmDialog(fen, "Voulez-vous supprimer cette ligne ?", "Message de confirmation", JOptionPane.YES_NO_OPTION);
                        if (jo == JOptionPane.YES_OPTION) {
                            BDconn con = new BDconn();
                            con.connexionDB("application_tt");
                            String requp = "DELETE FROM `application_tt`.`marche` WHERE `marche`.`idMarche` = " + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 2) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer la nouvelle Date-Debut !", "Modification de Date-Debut", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`marche` SET `datedeb` = '-.-' WHERE `marche`.`idMarche` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`marche` SET `datedeb` = '" + mod + "' WHERE `marche`.`idMarche` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 3) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer la nouvelle Date-Fin !", "Modification de Date-Fin", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`marche` SET `datefin` = '-.-' WHERE `marche`.`idMarche` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`marche` SET `datefin` = '" + mod + "' WHERE `marche`.`idMarche` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 1) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau nom !", "Modification du Nom", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`marche` SET `nom` = '-.-' WHERE `marche`.`idMarche` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);

                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`marche` SET `nom` = '" + mod + "' WHERE `marche`.`idMarche` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
            c = this.getContentPane();
            this.setVisible(true);
        }

        if (e.getSource().equals(modifme) || e.getSource().equals(modifmerefresh)) {
            // TODO Auto-generated catch block
            this.setTitle("Modifier et supprimer un metro");
            c.removeAll();
            panelcentral.removeAll();
            JLabel titre = new JLabel();
            titre.setSize(300, 250);
            titre.setBounds(10, 20, 1010, 20);
            titre.setText("         METRO      ");
            titre.setFont(new Font("Verdana", 1, 18));
            titre.setForeground(new Color(0, 0, 153));

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2m.jpg"));
            JPanel panac = new JPanel();
            panac.add(labac);
            c.add(panac, "South");
            panelcentral.add(titre);
            TableColumn col;
            modelme = new MyTableModelme(true);
            sorterme = new TableRowSorter<MyTableModelme>(modelme);
            table = new JTable(modelme);
            table.setRowHeight(23);
            col = table.getColumnModel().getColumn(1);
            col.setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            scroller = new JScrollPane(table);
            panelcentral.add(scroller);
            JPanel tit = new JPanel();
            ImageIcon icon = new ImageIcon((".\\src\\images\\Excel-2-icon.png"));
            JButton expor = new JButton("export to Excel");
            expor.setToolTipText("export to Excel");
            expor.setIcon(icon);
            expor.setRolloverEnabled(true);
            expor.setRolloverIcon(new RolloverIcon(icon));
            expor.setBackground(null);
            tit.add(expor);
            expor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser fille = new JFileChooser();
                    fille.showOpenDialog(null);
                    File file = fille.getSelectedFile();
                    exporter(table, file);
                }
            });

            modifmerefresh = new JButton("Actualiser");
            modifmerefresh.setIcon(new ImageIcon(".\\src\\images\\refresh.png"));
            modifmerefresh.addActionListener(this);
            tit.add(modifmerefresh);
            tit.add(titre);
            final JTextField fil = new JTextField(15);
            JButton filtre = new JButton("Recherche");
            filtre.setSize(20, 10);
            filtre.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            filtre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                            0);
                    filters.add(RowFilter.regexFilter(fil.getText(), 1));
                    RowFilter<Object, Object> serviceFilter = RowFilter
                            .andFilter(filters);
                    sorterme.setRowFilter(serviceFilter);

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            JPanel rech = new JPanel();
            rech.add(filtre);
            rech.add(fil);
            JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bar.add(tit);
            bar.add(rech);
            c.add(bar, BorderLayout.NORTH);
            table.setRowSorter(sorterme);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    if (col == 0) {
                        int jo = JOptionPane.showConfirmDialog(fen, "Voulez-vous supprimer cette ligne ?", "Message de confirmation", JOptionPane.YES_NO_OPTION);
                        if (jo == JOptionPane.YES_OPTION) {
                            BDconn con = new BDconn();
                            con.connexionDB("application_tt");
                            String requp = "DELETE FROM `application_tt`.`metro` WHERE `metro`.`idMetro` = " + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 1) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau Type !", "Modification du Type", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`metro` SET `type` = '-.-' WHERE `metro`.`idMetro` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`metro` SET `type` = '" + mod + "' WHERE `metro`.`idMetro` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
            c = this.getContentPane();
            c.add(panelcentral);
            c.add(panelcentral, BorderLayout.CENTER);
            this.setVisible(true);
        }

        if (e.getSource().equals(modift) || e.getSource().equals(modiftrefresh)) {
            // TODO Auto-generated catch block
            this.setTitle("Modifier et supprimer un type");
            panelcentral.removeAll();
            c.removeAll();
            panelcentral.setBounds(200, 50, 680, 500);
            JLabel titre = new JLabel();
            titre.setSize(300, 250);
            titre.setBounds(10, 20, 1010, 20);
            titre.setText("          TYPE        ");
            titre.setFont(new Font("Verdana", 1, 18));
            titre.setForeground(new Color(0, 0, 153));

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2m.jpg"));
            JPanel panac = new JPanel();
            panac.add(labac);
            c.add(panac, "South");

            panelcentral.add(titre);
            TableColumn col;
            modelt = new MyTableModelt(true);
            sortert = new TableRowSorter<MyTableModelt>(modelt);
            table = new JTable(modelt);
            table.setRowHeight(23);
            //table.setBorder(BorderFactory.createLineBorder(Color.BLUE,0));
            col = table.getColumnModel().getColumn(2);
            col.setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            scroller = new JScrollPane(table);
            panelcentral.add(scroller);
            JPanel tit = new JPanel();
            ImageIcon icon = new ImageIcon((".\\src\\images\\Excel-2-icon.png"));
            JButton expor = new JButton("export to Excel");
            expor.setToolTipText("export to Excel");
            expor.setIcon(icon);
            expor.setRolloverEnabled(true);
            expor.setRolloverIcon(new RolloverIcon(icon));
            expor.setBackground(null);
            tit.add(expor);
            expor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser fille = new JFileChooser();
                    fille.showOpenDialog(null);
                    File file = fille.getSelectedFile();
                    exporter(table, file);
                }
            });

            modiftrefresh = new JButton("Actualiser");
            modiftrefresh.setIcon(new ImageIcon(".\\src\\images\\refresh.png"));
            modiftrefresh.addActionListener(this);
            tit.add(modiftrefresh);
            tit.add(titre);
            final JTextField fil = new JTextField(15);
            JButton filtre = new JButton("Recherche");
            filtre.setSize(20, 10);
            filtre.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            filtre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                            0);
                    filters.add(RowFilter.regexFilter(fil.getText(), 1));
                    RowFilter<Object, Object> serviceFilter = RowFilter
                            .andFilter(filters);
                    sortert.setRowFilter(serviceFilter);

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            JPanel rech = new JPanel();
            rech.add(filtre);
            rech.add(fil);
            JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bar.add(tit);
            bar.add(rech);
            c.add(bar, BorderLayout.NORTH);
            table.setRowSorter(sortert);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    if (col == 0) {

                        int jo = JOptionPane.showConfirmDialog(fen, "Voulez-vous supprimer cette ligne ?", "Message de confirmation", JOptionPane.YES_NO_OPTION);
                        if (jo == JOptionPane.YES_OPTION) {
                            BDconn con = new BDconn();
                            con.connexionDB("application_tt");
                            String requp = "DELETE FROM `application_tt`.`type` WHERE `type`.`idType` = " + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 1) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau Nom !", "Modification du Nom", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`type` SET `nom` = '-.-' WHERE `type`.`idType` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`type` SET `nom` = '" + mod + "' WHERE `type`.`idType` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 2) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau Description !", "Modification de le description", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`type` SET `description` = '-.-' WHERE `type`.`idType` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`type` SET `description` = '" + mod + "' WHERE `type`.`idType` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
            c = this.getContentPane();
            c.add(panelcentral);
            c.add(panelcentral, BorderLayout.CENTER);
            this.setVisible(true);
        }
        if (e.getSource().equals(ajoutu) || e.getSource().equals(annu)) {
            this.setTitle("Ajouter un metro");
            c.removeAll();
            c.setLayout(new BorderLayout());

            JPanel pan1 = new JPanel();
            JLabel abh = new JLabel();
            abh.setSize(300, 250);
            abh.setText("Ajouter un utilisateur .. Remplire les champs suivants");
            abh.setFont(new Font("Verdana", 1, 18));
            abh.setForeground(new Color(0, 0, 153));
            pan1.add(abh);

            JLabel log = new JLabel();
            log.setFont(new Font("Serif", 1, 16));
            log.setForeground(new Color(111, 0, 0));
            log.setBounds(335, 90, 90, 30);
            log.setText("Nom: ");
            logu = new JTextField("", 20);
            logu.setBounds(383, 90, 190, 30);

            JLabel pwd = new JLabel();
            pwd.setFont(new Font("Serif", 1, 16));
            pwd.setForeground(new Color(111, 0, 0));
            pwd.setBounds(335, 140, 130, 30);
            pwd.setText("Mot de passe: ");
            pwdu = new JTextField("", 20);
            pwdu.setBounds(440, 140, 132, 30);

            JLabel fct = new JLabel();
            fct.setFont(new Font("Serif", 1, 16));
            fct.setForeground(new Color(111, 0, 0));
            fct.setBounds(335, 190, 90, 30);
            fct.setText("Role: ");
            String[] listu = {"Simple User", "Admin"};
            fctu = new JComboBox(listu);
            fctu.setBounds(383, 190, 190, 30);

            c.add(log);
            c.add(logu);

            c.add(pwd);
            c.add(pwdu);

            c.add(fct);
            c.add(fctu);

            JPanel pan3 = new JPanel();
            pan3.setLayout(new GridLayout(2, 1, 0, 0));

            JPanel pan31 = new JPanel();
            pan31.add(impu);

            JPanel pan32 = new JPanel();
            pan32.setLayout(new GridLayout(5, 1, 0, 0));
            JLabel tel = new JLabel();
            tel.setFont(new Font("Serif", 1, 16));
            tel.setForeground(new Color(111, 0, 0));
            tel.setText("Telephone: 73 643 235");
            JLabel fax = new JLabel();
            fax.setFont(new Font("Serif", 1, 16));
            fax.setForeground(new Color(111, 0, 0));
            fax.setText("Fax:            73 643 240");

            JLabel vide = new JLabel();
            vide.setText("");

            pan32.add(ajou);
            pan32.add(annu);
            pan32.add(vide);
            pan32.add(tel);
            pan32.add(fax);

            pan3.add(pan31);
            pan3.add(pan32);

            JPanel pan2 = new JPanel();
            lab = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            pan2.add(lab);

            c.add(pan1, "Center");
            c.add(pan3, "West");
            c.add(pan2, "South");
            this.setVisible(true);
        }
        if (e.getSource().equals(modifu) || e.getSource().equals(modifurefresh)) {
            // TODO Auto-generated catch block
            this.setTitle("Modifier et supprimer un utilisateur");
            panelcentral.removeAll();
            c.removeAll();
            panelcentral.setBounds(200, 50, 680, 500);
            JLabel titre = new JLabel();
            titre.setSize(300, 250);
            titre.setBounds(10, 20, 1010, 20);
            titre.setText("  UTILISATEUR ");
            titre.setFont(new Font("Verdana", 1, 18));
            titre.setForeground(new Color(0, 0, 153));
            JLabel abh = new JLabel();
            abh.setSize(300, 250);

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2m.jpg"));
            JPanel panac = new JPanel();
            panac.add(labac);
            c.add(panac, "South");

            panelcentral.add(titre);
            TableColumn col;
            modelu = new MyTableModelu(true);
            sorteru = new TableRowSorter<MyTableModelu>(modelu);
            table = new JTable(modelu);
            table.setRowHeight(23);
            col = table.getColumnModel().getColumn(3);
            col.setPreferredWidth(25);
            table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            scroller = new JScrollPane(table);
            panelcentral.add(scroller);
            JPanel tit = new JPanel();
            ImageIcon icon = new ImageIcon((".\\src\\images\\Excel-2-icon.png"));
            JButton expor = new JButton("export to Excel");
            expor.setToolTipText("export to Excel");
            expor.setIcon(icon);
            expor.setRolloverEnabled(true);
            expor.setRolloverIcon(new RolloverIcon(icon));
            expor.setBackground(null);
            tit.add(expor);
            expor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JFileChooser fille = new JFileChooser();
                    fille.showOpenDialog(null);
                    File file = fille.getSelectedFile();
                    exporter(table, file);
                }
            });

            modifurefresh = new JButton("Actualiser");
            modifurefresh.setIcon(new ImageIcon(".\\src\\images\\refresh.png"));
            modifurefresh.addActionListener(this);
            tit.add(modifurefresh);
            tit.add(titre);
            final JTextField fil = new JTextField(15);
            JButton filtre = new JButton("Recherche");
            filtre.setSize(20, 10);
            filtre.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            filtre.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(
                            0);
                    filters.add(RowFilter.regexFilter(fil.getText(), 1));
                    RowFilter<Object, Object> serviceFilter = RowFilter
                            .andFilter(filters);
                    sorteru.setRowFilter(serviceFilter);

                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            JPanel rech = new JPanel();
            rech.add(filtre);
            rech.add(fil);
            JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bar.add(tit);
            bar.add(rech);
            c.add(bar, BorderLayout.NORTH);
            table.setRowSorter(sorteru);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    if (col == 0) {
                        int jo = JOptionPane.showConfirmDialog(fen, "Voulez-vous supprimer cet utilisateur ?", "Message de confirmation", JOptionPane.YES_NO_OPTION);
                        if (jo == JOptionPane.YES_OPTION) {
                            BDconn con = new BDconn();
                            con.connexionDB("application_tt");
                            String requp = "DELETE FROM `application_tt`.`utilisateur` WHERE `utilisateur`.`id` = " + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);

                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 1) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau login !", "Modification du login", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`utilisateur` SET `login` = '-.-' WHERE `utilisateur`.`id` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`utilisateur` SET `login` = '" + mod + "' WHERE `utilisateur`.`id` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 2) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");
                        String mod;
                        mod = JOptionPane.showInputDialog(fen, "Entrer le nouveau pwd !", "Modification du password", JOptionPane.QUESTION_MESSAGE);
                        if (mod.length() == 0) {
                            String requp = "UPDATE `application_tt`.`utilisateur` SET `pwd` = '-.-' WHERE `utilisateur`.`id` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            String requp = "UPDATE `application_tt`.`utilisateur` SET `pwd` = '" + mod + "' WHERE `utilisateur`.`id` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else if (col == 3) {
                        BDconn con = new BDconn();
                        con.connexionDB("application_tt");

                        String[] comboo = {"Simple User", "Admin"};
                        JComboBox jcb = new JComboBox(comboo);
                        jcb.setEditable(true);
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        dialogButton = JOptionPane.showConfirmDialog(null, jcb, "Modofication de longueur", dialogButton);

                        if (dialogButton == 0) {

                            String requp = "UPDATE `application_tt`.`utilisateur` SET `fonction` = '" + jcb.getSelectedItem() + "' WHERE `utilisateur`.`id` =" + table.getModel().getValueAt(row, 0);
                            try {
                                con.updateQuery(requp);
                            } catch (SQLException ex) {
                                Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
            c = this.getContentPane();
            c.add(panelcentral);
            c.add(panelcentral, BorderLayout.CENTER);
            this.setVisible(true);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(statistique)) {
            this.setTitle("Statistiques");
            westPanel.removeAll();
            centralDrawPanel.removeAll();
            JLabel a = new JLabel(new ImageIcon(".\\src\\images\\st.png"));
            centralDrawPanel.add(a);
            panelcentral.removeAll();
            c.removeAll();
            c.setLayout(new GridLayout(2, 1));
            day = new JButton("Rech. par jour ");
            day.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            month = new JButton("Rech. par mois ");
            month.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            year = new JButton("Rech. par année");
            year.setIcon(new ImageIcon(".\\src\\images\\recherche.png"));
            stat = new JButton("Statistique");
            stat.setIcon(new ImageIcon(".\\src\\images\\stat.png"));

            cdays.enable(false);
            cmonths.enable(false);
            cyears.enable(false);
            centralNorthPanel.add(cdays);
            centralNorthPanel.add(cmonths);
            centralNorthPanel.add(cyears);
            westPanel.setLayout(new GridLayout(6, 1));
            westPanel.add(day);
            westPanel.add(month);
            westPanel.add(year);
            westPanel.add(stat);
            westPanel.add(centralNorthPanel);

            JPanel undertable = new JPanel();
            undertable.add("West", westPanel);
            undertable.add("North", centralDrawPanel);

            c.add(scrollerv);
            c.add(undertable);
            day.addActionListener(new EcouteurBouton());
            month.addActionListener(new EcouteurBouton());
            year.addActionListener(new EcouteurBouton());
            stat.addActionListener(new EcouteurBouton());

            c.setVisible(true);
        }
        if (e.getSource().equals(refresh)) {

            this.setTitle("Acceuil");
            panelcentral.removeAll();
            c.removeAll();
            panelcentral.setBounds(200, 50, 680, 500);

            JLabel labac = new JLabel(new ImageIcon(".\\src\\images\\TT2.jpg"));
            JLabel labac2 = new JLabel(new ImageIcon(".\\src\\images\\acceuil2.png"));
            JPanel panac = new JPanel();

            panelcentral.add(labac2);
            panac.add(labac);
            c.add(panelcentral, BorderLayout.CENTER);
            c.add(panac, "South");
            this.setVisible(true);
        }
    }

    class MyTableModell extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModell(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");
                    b++;
                }

                String requete = "SELECT l.idLaison, l.nom, t.nom, c.nom, e.nom, l.dateMES, m.nom, m.datedeb,m.datefin,l.longueur\n"
                        + "FROM liaison l,entreprise e,centre_rattach c, plan p, reception r, type t, marche m \n"
                        + "WHERE l.idType = t.idType\n"
                        + "AND l.idcentRat = c.idCenRat\n"
                        + "AND l.idEntreprise = e.idEntreprise\n"
                        + "AND l.idReception = r.idReception\n"
                        + "AND l.idPlan = p.idPlan\n"
                        + "AND l.idMarche = m.idMarche\n"
                        + "ORDER BY (l.idLaison)\n";
                rs = database.selectQuery(requete);

                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;
                        case 4:
                            data[rowIndex][5] = (String) aValue;
                            break;
                        case 5:
                            data[rowIndex][6] = (String) aValue;
                            break;
                        case 6:
                            data[rowIndex][7] = (String) aValue;
                            break;
                        case 7:
                            data[rowIndex][8] = (String) aValue;
                            break;
                        case 8:
                            data[rowIndex][9] = (String) aValue;
                            break;
                        case 9:
                            data[rowIndex][10] = (String) aValue;
                            break;
                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;
                        case 4:
                            data[rowIndex][5] = (String) aValue;
                            break;
                        case 5:
                            data[rowIndex][6] = (String) aValue;
                            break;
                        case 6:
                            data[rowIndex][7] = (String) aValue;
                            break;
                        case 7:
                            data[rowIndex][8] = (String) aValue;
                            break;
                        case 8:
                            data[rowIndex][9] = (String) aValue;
                            break;
                        case 9:
                            data[rowIndex][10] = (String) aValue;
                            break;
                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Code";
            }
            if (c == 1) {
                return "Nom";
            }
            if (c == 2) {
                return "Type";
            }
            if (c == 3) {
                return "Centre";
            }
            if (c == 4) {
                return "Entreprise";
            }
            if (c == 5) {
                return "DateMES";
            }
            /*if (c == 6) {
             return "Reception";
             }
             if (c == 7) {
             return "Plan";
             }*/
            if (c == 6) {
                return "Marche";
            }
            /*if (c == 9) {
             return "Observation";
             }*/
            if (c == 7) {
                return "Début";
            }
            if (c == 8) {
                return "Fin";
            }
            if (c == 9) {
                return "Longueur";
            }
            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {
            return true;
        }
    }

    class MyTableModelc extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModelc(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");

                    b++;
                }

                String requete = "SELECT c.idCenRat,c.nom , m.type\n"
                        + "FROM centre_rattach c, metro m\n"
                        + "WHERE c.idMetro = m.idMetro ORDER BY (c.idCenRat)\n";

                rs = database.selectQuery(requete);

                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;

                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;

                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Code";
            }
            if (c == 1) {
                return "Nom";
            }
            if (c == 2) {
                return "Metro";
            }

            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {

            return true;
        }

    }

    class MyTableModele extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModele(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");

                    b++;
                }

                String requete = "SELECT e.idEntreprise, e.nom ,e.logo, e.adresse FROM entreprise e ORDER BY (e.idEntreprise)";

                rs = database.selectQuery(requete);
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;

                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;

                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Code";
            }
            if (c == 1) {
                return "Nom";
            }
            if (c == 2) {
                return "Logo";
            }
            if (c == 3) {
                return "Adresse";
            }

            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {

            return true;
        }

    }

    class MyTableModelma extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModelma(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");

                    b++;
                }

                String requete = "SELECT m.idMarche, m.nom , m.datedeb, m.datefin\n"
                        + "FROM marche m ORDER BY (m.idMarche)\n";

                rs = database.selectQuery(requete);

                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;

                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;

                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Code";
            }
            if (c == 1) {
                return "Nom";
            }
            if (c == 2) {
                return "Date Debut";
            }
            if (c == 3) {
                return "Date Fin";
            }

            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {

            return true;
        }

    }

    class MyTableModelme extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModelme(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");

                    b++;
                }

                String requete = "SELECT m.idMetro, m.type\n"
                        + "FROM metro m ORDER BY (m.idMetro)\n";

                rs = database.selectQuery(requete);

                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;

                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Code";
            }
            if (c == 1) {
                return "Nom";
            }

            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {

            return true;
        }

    }

    class MyTableModelt extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModelt(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");

                    b++;
                }

                String requete = "SELECT t.idType, t.nom, t.description\n"
                        + "FROM type t ORDER BY (t.idType)\n";

                rs = database.selectQuery(requete);

                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;

                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;

                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Code";
            }
            if (c == 1) {
                return "Nom";
            }
            if (c == 2) {
                return "Description";
            }

            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {

            return true;
        }

    }

    class MyTableModelu extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModelu(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");

                    b++;
                }

                String requete = "SELECT u.id, u.login, u.pwd, u.fonction\n"
                        + "FROM utilisateur u ORDER BY (u.id)\n";

                rs = database.selectQuery(requete);

                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;

                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;
                        case 3:
                            data[rowIndex][4] = (String) aValue;
                            break;
                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Code";
            }
            if (c == 1) {
                return "Login";
            }
            if (c == 2) {
                return "Mot de passe";
            }
            if (c == 3) {
                return "Role";
            }

            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {

            return true;
        }

    }

    class MyTableModelv extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        String[][] data;
        String[] colonne;
        Boolean filter = true;
        int nbc;
        int nbl;
        int b = 0;
        Boolean a;
        BDconn database;

        public MyTableModelv(Boolean f) {
            filter = f;

            try {
                if (b == 0) {
                    database = new BDconn();
                    database.connexionDB("application_tt");

                    b++;
                }

                String requete = "select * from lview ;";

                rs = database.selectQuery(requete);

                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                nbc = rsmd.getColumnCount();
                nbl = 0;

                while (rs.next()) {
                    nbl++;
                }
                rs.first();
                colonne = new String[nbc];
                for (int i = 0; i < nbc; i++) {
                    colonne[i] = rsmd.getColumnName(i + 1);
                }

                data = new String[nbl][nbc];

                for (int k = 0; k < nbl; k++) {
                    for (int l = 0; l < nbc; l++) {

                        data[k][l] = rs.getString(l + 1);

                    }

                    if (!rs.next()) {
                        break;
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (filter = true) {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;

                    }
                }
            } else {
                if (aValue != null) {
                    switch (columnIndex) {
                        case 0:
                            data[rowIndex][1] = (String) aValue;
                            break;
                        case 1:
                            data[rowIndex][2] = (String) aValue;
                            break;
                        case 2:
                            data[rowIndex][3] = (String) aValue;
                            break;

                    }

                }
            }
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        public Object getValueAt(int row, int column) {

            if (column == data[0].length) {
                return "    ";
            }

            return data[row][column];

        }

        public int getColumnCount() {
            return data[0].length;
        }

        public int getRowCount() {
            if (filter == true) {
                return data.length;
            } else {
                return data.length;
            }
        }

        @Override
        public String getColumnName(int c) {
            if (c == 0) {
                return "Nombre";
            }
            if (c == 1) {
                return "Date";
            }
            if (c == 2) {
                return "Type";
            }

            return "";
        }

        @Override
        public boolean isCellEditable(int arg0, int arg1) {

            return true;
        }

    }

    void exporter(JTable tab, File file) {
        // TODO Auto-generated method stub
        try {

            TableModel model = tab.getModel();
            FileWriter out = new FileWriter(file);
            for (int i = 0; i < model.getColumnCount(); i++) {
                out.write(model.getColumnName(i) + "\t");
            }
            out.write("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    out.write(model.getValueAt(i, j).toString() + "\t");
                }
                out.write("\n");
            }

            out.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    class RolloverIcon implements Icon {

        protected Icon icon;

        public RolloverIcon(Icon icon) {
            this.icon = icon;
        }

        public int getIconHeight() {
            return icon.getIconHeight();
        }

        public int getIconWidth() {
            return icon.getIconWidth();
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D graphics2d = (Graphics2D) g;
            Composite oldComposite = graphics2d.getComposite();
            icon.paintIcon(c, g, x, y);
            graphics2d.setComposite(oldComposite);
        }
    }

    public void drawstat() {
        try {

            BDconn con = new BDconn();
            con.connexionDB("application_tt");
            String requete = "select sum(cn),nom from lview where dt LIKE '%" + date + "' group by nom;";
            rs = con.selectQuery(requete);
            double[] sampleValues = new double[5];
            Color[] sampleColors = new Color[]{new Color(0x63639c), new Color(0x6363ff), new Color(0xc6c6c6), new Color(0x31319c)};

            String reqtype = "SELECT count(nom) FROM type;";
            rstype = con.selectQuery(reqtype);
            while (rstype.next()) {
                int y = Integer.parseInt(rstype.getString(1));
                String[] legendLabels = new String[y];

                int i = 0;

                while (rs.next()) {

                    sampleValues[i] = rs.getBigDecimal(1).doubleValue(); // The double you want
                    legendLabels[i] = (String) rs.getObject(2);
                    System.out.println(sampleValues[i]);
                    System.out.println(legendLabels[i]);
                    i++;
                }

                PieChart chart = new PieChart();

                chart.setFont("titleFont", new Font("Serif", Font.BOLD, 20));
                chart.setSampleCount(sampleValues.length);
                chart.setSampleColors(sampleColors);
                chart.setSampleValues(0, sampleValues);
                chart.setValueLabelsOn(true);

                chart.setValueLabelStyle(Chart.INSIDE);
                chart.setFont("insideLabelFont", new Font("Serif", Font.BOLD, 14));
                chart.setLegendOn(true);
                chart.setLegendLabels(legendLabels);
                chart.setFont("legendFont", new Font("Serif", Font.PLAIN, 13));
                chart.setSliceSeperatorColor(Color.white);
                chart.setBackground(Color.white);

                BarChart chart1 = new BarChart();
                chart1.setSampleCount(6);

                chart1.setSampleValues(0, sampleValues);
                chart1.setSampleColor(0, new Color(0xFFA000));
                chart1.setRange(0, 88);
                chart1.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 13));

                chart1.setSampleLabelsOn(true);
                chart1.setSampleLabelStyle(Chart.OUTSIDE);
                chart1.setSampleLabelSelectionColor(Color.red);
                chart1.setFont("sampleLabelFont", new Font("Arial", Font.BOLD, 12));
                chart1.setBarLabels(legendLabels);
                chart1.setBarLabelsOn(true);
                chart1.setLabelAngle("barLabelAngle", 270);
                for (i = 0; i < sampleValues.length; i++) {
                    chart1.setBarLabelColor(i, new Color(0x961504));
                }
                chart1.setValueLabelsOn(true);
                chart1.setValueLabelStyle(Chart.INSIDE);
                chart1.setFont("valueLabelFont", new Font("Arial", Font.PLAIN, 14));
                chart1.setValueLinesOn(true);
                chart1.setMaxValueLineCount(10);
                chart1.setFont("floatingLabelFont", new Font("Arial", Font.BOLD, 11));
                chart1.setBarWidth(0.5);
                chart1.setBackground(Color.white);

                centralDrawPanel.removeAll();
                centralDrawPanel.add(chart);
                centralDrawPanel.add(chart1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        java.sql.ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        return dtm;

    }

    private class EcouteurBouton implements ActionListener {

        protected ResultSet rs, rs1 = null;

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == day) {

                centralDrawPanel.removeAll();
                JLabel a = new JLabel(new ImageIcon(".\\src\\images\\st.png"));
                centralDrawPanel.add(a);
                cdays.enable(true);
                cmonths.enable(true);
                cyears.enable(true);

            } else if (ae.getSource() == month) {

                centralDrawPanel.removeAll();
                JLabel a = new JLabel(new ImageIcon(".\\src\\images\\st.png"));
                centralDrawPanel.add(a);
                cdays.enable(false);
                cmonths.enable(true);
                cyears.enable(true);

            } else if (ae.getSource() == year) {

                centralDrawPanel.removeAll();
                JLabel a = new JLabel(new ImageIcon(".\\src\\images\\st.png"));
                centralDrawPanel.add(a);
                cdays.enable(false);
                cmonths.enable(false);
                cyears.enable(true);
            } else {
                if (cdays.isEnabled()) {
                    date = cdays.getSelectedItem() + "-" + cmonths.getSelectedItem() + "-" + cyears.getSelectedItem();
                } else if (cmonths.isEnabled()) {
                    date = cmonths.getSelectedItem() + "-" + cyears.getSelectedItem();
                } else if (cyears.isEnabled()) {
                    date = (String) cyears.getSelectedItem();
                } else {
                    System.out.println("date not chosen");
                }
                //System.out.println(date);
                cdays.enable(false);
                cmonths.enable(false);
                cyears.enable(false);
                if (date != null) {

                    drawstat();
                }
            }

            c.revalidate();
            c.repaint();
        }
    };

}
