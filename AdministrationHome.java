import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AdministrationHome extends JFrame {

    JMenu menuE ;
    JMenu menuP ;
    JMenuBar menubar ;
    JMenuItem item1 ;
    JMenuItem item2;
    JMenuItem item21;
    JMenuItem item3 ;
    JMenuItem item4;
    JMenuItem item5;

    JPanel panelEtudiant ;
    JPanel panel1 ;
    JLabel labeltitle ;
    JPanel panel2 ;
    JLabel labelidE ;
    JLabel labelnomE ;
    JLabel labelprenomE;
    JLabel labelageE ;
    JLabel labelidA ;
    JLabel labelnomFiliere ;
    JTextField idE ;
    JTextField nomE ;
    JTextField prenomE ;
    JTextField ageE ;
    JTextField idA ;
    JTextField nomFiliere ;
    JPanel panel3 ;
    JButton addEtudiant ;
    JPanel panelProfesseur ;
    JPanel panel4 ;
    JLabel title2 ;
    JLabel labelidP ;
    JLabel labelNomP ;
    JLabel labelprenomP ;
    JLabel labelageP ;
    JLabel labellogin ;
    JLabel labelpwd ;
    JLabel labelidA2 ;
    JTextField idP ;
    JTextField nomP;
    JTextField prenomP ;
    JTextField ageP;
    JTextField loginP ;
    JTextField passwordP ;
    JTextField idA2 ;
    JPanel panel5 ;
    JPanel panel6 ;
    JButton addProfesseur ;




    public AdministrationHome(){

        menubar = new JMenuBar();
        menuE = new JMenu("Etudiant");
        item1 = new JMenuItem("Delete");
        item1.addActionListener(new eventHandlers());
        item2 = new JMenuItem("update");
        item2.addActionListener(new eventHandlers());
        item21 = new JMenuItem("search etudiant");
        item21.addActionListener(new eventHandlers());
        menuP = new JMenu("Professeur");
        item3 = new JMenuItem("Delete");
        item3.addActionListener(new eventHandlers());
        item4 = new JMenuItem("update");
        item4.addActionListener(new eventHandlers());
        item5 = new JMenuItem("search professeur");
        item5.addActionListener(new eventHandlers());

        menuE.add(item1);
        menuE.add(item2);
        menuE.add(item21);
        menuP.add(item3);
        menuP.add(item4);
        menuP.add(item5);
        menubar.add(menuE);
        menubar.add(menuP);
        this.setJMenuBar(menubar);

        panelEtudiant = new JPanel(new BorderLayout());
        panel1 = new JPanel(new FlowLayout());
        labeltitle = new JLabel("Ajouter un etudiant :");
        panel1.add(labeltitle);
        panel1.setBackground(Color.ORANGE);

        panel2 = new JPanel(new GridLayout(6,6));
        labelidE = new JLabel("id etudiant : ");
        labelnomE = new JLabel("nom etudiant");
        labelprenomE = new JLabel("prenom etudiant : ");
        labelageE = new JLabel("age etudiant : ");
        labelidA = new JLabel("id administration : ");
        labelnomFiliere = new JLabel("filiere : ");
        idE = new JTextField(20);
        nomE = new JTextField(20);
        prenomE = new JTextField(20);
        ageE = new JTextField(20);
        idA = new JTextField(20);
        nomFiliere = new JTextField(20);
        panel2.add(labelidE);
        panel2.add(idE);
        panel2.add(labelnomE);
        panel2.add(nomE);
        panel2.add(labelprenomE);
        panel2.add(prenomE);
        panel2.add(labelageE);
        panel2.add(ageE);
        panel2.add(labelidA);
        panel2.add(idA);
        panel2.add(labelnomFiliere);
        panel2.add(nomFiliere);

        panel3 = new JPanel(new FlowLayout());
        addEtudiant = new JButton("Add etudiant : ");
        addEtudiant.addActionListener(new eventHandlers());
        panel3.add(addEtudiant);
        
        panelEtudiant.add(panel1, BorderLayout.NORTH);
        panelEtudiant.add(panel2, BorderLayout.CENTER);
        panelEtudiant.add(panel3, BorderLayout.SOUTH);

        panelProfesseur  = new JPanel( new BorderLayout());
        panel4 = new JPanel(new FlowLayout());
        title2 = new JLabel("Ajouter un Professeur :");
        panel4.add(title2);
        panel4.setBackground(Color.ORANGE);


        panel5 = new JPanel(new GridLayout(7,7));
        labelidP = new JLabel("id professeur : ");
        labelNomP = new JLabel("nom professeur");
        labelprenomP = new JLabel("prenom professeur : ");
        labelageP = new JLabel("age profeseur : ");
        labellogin = new JLabel("login : ");
        labelpwd = new JLabel("password : ");
        labelidA2 = new JLabel("id administration : ");
        idP = new JTextField(20);
        nomP = new JTextField(20);
        prenomP = new JTextField(20);
        ageP = new JTextField(20);
        idA2 = new JTextField(20);
        loginP = new JTextField(20);
        passwordP = new JTextField(20);
        panel5.add(labelidP);
        panel5.add(idP);
        panel5.add(labelNomP);
        panel5.add(nomP);
        panel5.add(labelprenomP);
        panel5.add(prenomP);
        panel5.add(labelageP);
        panel5.add(ageP);
        panel5.add(labelidA2);
        panel5.add(idA2);
        panel5.add(labellogin);
        panel5.add(loginP);
        panel5.add(labelpwd);
        panel5.add(passwordP);


        panel6 = new JPanel(new FlowLayout());
        addProfesseur = new JButton("Add Professeur : ");
        addProfesseur.addActionListener(new eventHandlers());
        panel6.add(addProfesseur);


        panelProfesseur.add(panel4, BorderLayout.NORTH);
        panelProfesseur.add(panel5, BorderLayout.CENTER);
        panelProfesseur.add(panel6, BorderLayout.SOUTH);
        

        JTabbedPane tabedPane = new JTabbedPane();
        tabedPane.add("Etudiant", panelEtudiant);
        tabedPane.add("Professeur", panelProfesseur);

        this.setSize(900, 800);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.add(tabedPane);
    }

    class eventHandlers implements ActionListener{

        @Override 
        public void actionPerformed(ActionEvent e ){
            // establich connection to the database : 
            Statement sqlSt ;
            boolean result ;
            String url = "jdbc:mysql://localhost:3306/java";
            

            if(e.getSource() == item1){
                new EtudiantManagment();
            }
            if(e.getSource() == item2){
                new EtudiantManagment();            
            }
            if(e.getSource() == item21){
                new EtudiantManagment();
            }
            if(e.getSource() == item3){
                new ProfesseurManagment();
            }
            if(e.getSource() == item4){
                new ProfesseurManagment();   
            }
            if(e.getSource() == item5){
                new ProfesseurManagment();
            }
            if(e.getSource() == addEtudiant){
                String ide = idE.getText();
                String nome = nomE.getText();
                String prenome = prenomE.getText();
                String ageEString = ageE.getText();
                String ida = idA.getText();
                String nomfiliere = nomFiliere.getText();
                String query = "insert into Etudiant values (\""+ide+"\",\""+nome+"\",\""+prenome+"\",\""+ageEString+"\",\""+ida+"\",\""+nomfiliere+"\")";
                System.out.println(query.toString());
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    try {
                        Connection conn = DriverManager.getConnection(url, "root", "Mounaim_user2001");
                        System.out.println("connected !");
                        sqlSt = conn.createStatement();
                        result =  sqlSt.execute(query);
                        if (result){
                            System.out.println("inserted !");
                        }
                        sqlSt.close();
                    } catch (SQLException e1){
                        e1.printStackTrace();
                    }
                } catch (ClassNotFoundException e1) {
                    System.out.println(e1.getMessage());
                }
            }
            if(e.getSource() == addProfesseur){
                String idp = idP.getText();
                String nompString = nomP.getText();
                String prenompString = prenomP.getText();
                String agePString = ageP.getText();
                String ida = idA2.getText();
                String loginpString = loginP.getText();
                String pwdString = passwordP.getText();
                String query = "insert into Professeur values ("+idp+",\""+nompString+"\",\""+prenompString+"\",\""+agePString+"\",\""+loginpString+"\",\""+pwdString+"\" ,\" "+ida+"\")";
                System.out.println(query.toString());
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    try {
                        Connection conn = DriverManager.getConnection(url, "root", "Mounaim_user2001");
                        System.out.println("connected !");
                        sqlSt = conn.createStatement();
                        result =  sqlSt.execute(query);
                        if (result){
                            System.out.println("inserted !");
                        }
                        sqlSt.close();
                    } catch (SQLException e1){
                        e1.printStackTrace();
                    }
                } catch (ClassNotFoundException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        }


    }
}
