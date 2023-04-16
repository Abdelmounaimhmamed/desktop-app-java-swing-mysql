import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ProfesseurManagment extends JFrame {
    
    JPanel updatePanel ;
    JPanel updatePanelM;
    JPanel panel7 ;
    JLabel labeltitleupdate ;
    JLabel labelidP1 ;
    JLabel labelnomP ;
    JLabel labelprenomP ;
    JLabel labelageP ;
    JLabel labelidA ;
    JLabel labellogin ;
    JLabel labelpwd ;
    JTextField idP1 ;
    JTextField nomP ;
    JTextField prenomP ;
    JTextField ageP ;
    JTextField idA ;
    JTextField login ;
    JTextField password ;
    JPanel panelButtonupdate ;
    JButton buttonupdate ;


    JPanel deletePanel ;
    JPanel panel1 ;
    JLabel labeltitle ;
    JPanel panel2 ;
    JLabel labelidP ;
    JTextField idP ;
    JButton deleteProf ;
    JPanel deletedDataD ;
    JLabel message ;
    

    JPanel searchPanel ;
    JPanel panel3 ;
    JLabel labeltitle2 ;
    JPanel panel4 ;
    JLabel labelidPS ;
    JTextField idPS ;
    JButton searchProf ;
    JPanel panel5 ;
    JTextArea textSearchedProf ;




    public ProfesseurManagment(){
        deletePanel = new JPanel(new BorderLayout());
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(Color.ORANGE);
        labeltitle = new JLabel("supprimer un Professeur : ");
        panel1.add(labeltitle);

        panel2 = new JPanel();
        labelidP = new JLabel("l'id du prof : ");
        idP = new JTextField(20);
        deleteProf = new JButton("delete professeur ");
        deleteProf.addActionListener(new eventsListener());
        panel2.add(labelidP);
        panel2.add(idP);
        panel2.add(deleteProf);
        deletedDataD = new JPanel();
        message = new JLabel();
        deletedDataD.add(message);
        

        deletePanel.add(panel1 , BorderLayout.NORTH);
        deletePanel.add(panel2 , BorderLayout.CENTER);
        deletePanel.add(deletedDataD , BorderLayout.SOUTH);



        updatePanel = new JPanel(new BorderLayout());
        updatePanelM = new JPanel(new GridLayout(7,7));
        panelButtonupdate = new JPanel(new FlowLayout());
        panel7 = new JPanel(new FlowLayout());
        panel7.setBackground(Color.ORANGE);
        labeltitleupdate = new JLabel("modifier un prof :");
        panel7.add(labeltitleupdate);
        labelidP1  = new JLabel("id Professeur :");
        labelnomP  = new JLabel("nom Professeur :") ;
        labelprenomP = new JLabel("prenom Professeur :");
        labelageP  = new JLabel("age Professeur :");
        labelidA  = new JLabel("ida Professeur :");
        labellogin  = new JLabel("login Professeur :");
        labelpwd  = new JLabel("password Professeur :");
        idP1  = new JTextField(20);
        nomP  = new JTextField(20);
        prenomP  = new JTextField(20);
        ageP  = new JTextField(20);
        idA  = new JTextField(20);
        login  = new JTextField(20);
        password  = new JTextField(20);
        buttonupdate = new JButton("update Professeur");
        buttonupdate.addActionListener(new eventsListener());
        updatePanelM.add(labelidP1);
        updatePanelM.add(idP1);
        updatePanelM.add(labelnomP);
        updatePanelM.add(nomP);
        updatePanelM.add(labelprenomP);
        updatePanelM.add(prenomP);
        updatePanelM.add(labelageP);
        updatePanelM.add(ageP);
        updatePanelM.add(labelidA);
        updatePanelM.add(idA);
        updatePanelM.add(labellogin);
        updatePanelM.add(login);
        updatePanelM.add(labelpwd);
        updatePanelM.add(password);
        panelButtonupdate.add(buttonupdate);
        updatePanel.add(panel7,BorderLayout.NORTH);
        updatePanel.add(updatePanelM,BorderLayout.CENTER);
        updatePanel.add(panelButtonupdate,BorderLayout.SOUTH);

        
        searchPanel = new JPanel(new BorderLayout());
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(Color.ORANGE);
        labeltitle2 = new JLabel("chercher un Professeur : ");
        panel3.add(labeltitle2);
        panel4 = new JPanel();
        labelidPS = new JLabel("l'id de l'Professeur : ");
        idPS = new JTextField(20);
        searchProf = new JButton("cherhcer Professeur ");
        searchProf.addActionListener(new eventsListener());
        panel4.add(labelidPS);
        panel4.add(idPS);
        panel4.add(searchProf);
        panel5 = new JPanel(new FlowLayout());
        textSearchedProf = new JTextArea("waiting data from database ...");
        panel5.add(textSearchedProf);
        searchPanel.add(panel3 , BorderLayout.NORTH);
        searchPanel.add(panel4 , BorderLayout.CENTER);
        searchPanel.add(textSearchedProf , BorderLayout.SOUTH);
    
        
        
        
        
        JTabbedPane tabedPane = new JTabbedPane();
        tabedPane.add("search Professeur" ,searchPanel);
        tabedPane.add("update Professeur" ,updatePanel);
        tabedPane.add("delete Professeur" ,deletePanel);


        this.setSize(700, 600);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.add(tabedPane);
    }

   
    class eventsListener implements ActionListener {

        @Override 
        public void actionPerformed(ActionEvent e){

            Statement sqlSt ;
            ResultSet result ;
            String url = "jdbc:mysql://localhost:3306/java";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try {
                    Connection connexion = DriverManager.getConnection(url , "root","Mounaim_user2001");
                   
                    if (e.getSource() == deleteProf){
                        String query1 = "SET FOREIGN_KEY_CHECKS=0" ;              
                        String query2 = "SET FOREIGN_KEY_CHECKS=1;";         
                        String querySql = "delete from Professeur where idP = \""+(String)idP.getText()+"\"";
                        sqlSt =  connexion.createStatement();
                        sqlSt.execute(query1);
                        sqlSt.execute(querySql);
                        sqlSt.execute(query2);
                        message.setText("Professeur deleted !");
                    }
                    if (e.getSource() == buttonupdate){
                        String idp = idP1.getText();
                        String nomp = nomP.getText();
                        String prenomp = prenomP.getText();
                        String agepString = ageP.getText();
                        String ida = idA.getText();
                        String loginP = login.getText();
                        String passwordP = password.getText();

                        String query = "update  Professeur set idP="+idp+",nomP=\""+nomp+"\",prenomP=\""+prenomp+"\",age=\""+agepString+"\",idA=\""+ida+"\",login=\""+loginP+"\",pwd=\""+passwordP+"\" where idP=\""+idp+"\"";
                        System.out.println(query.toString());
                        sqlSt =  connexion.createStatement();
                        boolean state = sqlSt.execute(query);
                        if(state){
                            System.out.println("updated !");
                        }else{
                            System.out.println("not updated !");
                        }
                    }
                    if (e.getSource() == searchProf){
                        String querySQl = "select * from Professeur where idP= \""+idP.getText()+"\"";
                        sqlSt = connexion.createStatement();
                        ResultSet result1 = sqlSt.executeQuery(querySQl);
                        System.out.println(result1.getString(1));
                        while(result1.next()){
                            System.out.println(
                            "Nom :" +result1.getString(1)+
                            "Prenom : "+result1.getString("prenom")+
                            "age :"+result1.getString("age")+
                            "idA :"+result1.getString("idA")
                            );
                            textSearchedProf.setText( "data");
                        }
                        System.out.println("no provided data");
                    }
                } catch (SQLException e1) {
                    
                    e1.printStackTrace();

                }
            } catch (ClassNotFoundException e1) {
                
                e1.printStackTrace();
            }
            
        }
    }
}
