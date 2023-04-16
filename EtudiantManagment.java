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

public class EtudiantManagment extends JFrame {
    
    JPanel updatePanel ;
    JPanel updatePanelM;
    JPanel panel7 ;
    JLabel labeltitleupdate ;
    JLabel labelidE1 ;
    JLabel labelnomE ;
    JLabel labelprenomE ;
    JLabel labelageE ;
    JLabel labelidA ;
    JLabel labelnomFiliere ;
    JTextField idE1 ;
    JTextField nomE ;
    JTextField prenomE ;
    JTextField ageE ;
    JTextField idA ;
    JTextField nomFiliere ;
    JPanel panelButtonupdate ;
    JButton buttonupdate ;


    JPanel deletePanel ;
    JPanel panel1 ;
    JLabel labeltitle ;
    JPanel panel2 ;
    JLabel labelidE ;
    JTextField idE ;
    JButton deleteEtudiant ;
    JPanel deletedDataD ;
    JLabel message ;
    

    JPanel searchPanel ;
    JPanel panel3 ;
    JLabel labeltitle2 ;
    JPanel panel4 ;
    JLabel labelidES ;
    JTextField idES ;
    JButton searchEtudiant ;
    JPanel panel5 ;
    JTextArea textSearchedStudent ;


    public EtudiantManagment(){
        deletePanel = new JPanel(new BorderLayout());
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(Color.ORANGE);
        labeltitle = new JLabel("supprimer un etudiant : ");
        panel1.add(labeltitle);

        panel2 = new JPanel();
        labelidE = new JLabel("l'id de l'etudiant : ");
        idE = new JTextField(20);
        deleteEtudiant = new JButton("delete Etudiant ");
        deleteEtudiant.addActionListener(new eventsListener());
        panel2.add(labelidE);
        panel2.add(idE);
        panel2.add(deleteEtudiant);
        deletedDataD = new JPanel();
        message = new JLabel();
        deletedDataD.add(message);
        

        deletePanel.add(panel1 , BorderLayout.NORTH);
        deletePanel.add(panel2 , BorderLayout.CENTER);
        deletePanel.add(deletedDataD , BorderLayout.SOUTH);



        updatePanel = new JPanel(new BorderLayout());
        updatePanelM = new JPanel(new GridLayout(6,6));
        panelButtonupdate = new JPanel(new FlowLayout());
        panel7 = new JPanel(new FlowLayout());
        panel7.setBackground(Color.ORANGE);
        labeltitleupdate = new JLabel("modifier un etudiant :");
        panel7.add(labeltitleupdate);
        labelidE1  = new JLabel("id Etudiant :");
        labelnomE  = new JLabel("nom Etudiant :") ;
        labelprenomE = new JLabel("prenom Etudiant :");
        labelageE  = new JLabel("age Etudiant :");
        labelidA  = new JLabel("ida Etudiant :");
        labelnomFiliere  = new JLabel("nom filiere  :");
        idE1  = new JTextField(20);
        nomE  = new JTextField(20);
        prenomE  = new JTextField(20);
        ageE  = new JTextField(20);
        idA  = new JTextField(20);
        nomFiliere  = new JTextField(20);
        buttonupdate = new JButton("update Etudiant");
        buttonupdate.addActionListener(new eventsListener());
        updatePanelM.add(labelidE1);
        updatePanelM.add(idE1);
        updatePanelM.add(labelnomE);
        updatePanelM.add(nomE);
        updatePanelM.add(labelprenomE);
        updatePanelM.add(prenomE);
        updatePanelM.add(labelageE);
        updatePanelM.add(ageE);
        updatePanelM.add(labelidA);
        updatePanelM.add(idA);
        updatePanelM.add(labelnomFiliere);
        updatePanelM.add(nomFiliere);
        panelButtonupdate.add(buttonupdate);
        updatePanel.add(panel7,BorderLayout.NORTH);
        updatePanel.add(updatePanelM,BorderLayout.CENTER);
        updatePanel.add(panelButtonupdate,BorderLayout.SOUTH);

        
        searchPanel = new JPanel(new BorderLayout());
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(Color.ORANGE);
        labeltitle2 = new JLabel("chercher un etudiant : ");
        panel3.add(labeltitle2);
        panel4 = new JPanel();
        labelidES = new JLabel("l'id de l'etudiant : ");
        idES = new JTextField(20);
        searchEtudiant = new JButton("cherhcer Etudiant ");
        searchEtudiant.addActionListener(new eventsListener());
        panel4.add(labelidES);
        panel4.add(idES);
        panel4.add(searchEtudiant);
        panel5 = new JPanel(new FlowLayout());
        textSearchedStudent = new JTextArea("waiting data from database ...");
        panel5.add(textSearchedStudent);
        searchPanel.add(panel3 , BorderLayout.NORTH);
        searchPanel.add(panel4 , BorderLayout.CENTER);
        searchPanel.add(textSearchedStudent , BorderLayout.SOUTH);
    
        
        
        
        
        JTabbedPane tabedPane = new JTabbedPane();
        tabedPane.add("search Etudiant" ,searchPanel);
        tabedPane.add("update Etudiant" ,updatePanel);
        tabedPane.add("delete Etudiant" ,deletePanel);


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
                   
                    if (e.getSource() == deleteEtudiant){
                        String query1 = "SET FOREIGN_KEY_CHECKS=0" ;              
                        String query2 = "SET FOREIGN_KEY_CHECKS=1;";         
                        String querySql = "delete from Etudiant where idE = \""+(String)idE.getText()+"\"";
                        sqlSt =  connexion.createStatement();
                        sqlSt.execute(query1);
                        sqlSt.execute(querySql);
                        sqlSt.execute(query2);
                        message.setText("Etudiant deleted !");
                    }
                    if (e.getSource() == buttonupdate){
                        String ide = idE1.getText();
                        String nome = nomE.getText();
                        String prenome = prenomE.getText();
                        String ageEString = ageE.getText();
                        String ida = idA.getText();
                        String nomfiliere = nomFiliere.getText();
                        String query = "update  Etudiant set idE=\""+ide+"\",nom=\""+nome+"\",prenom=\""+prenome+"\",age=\""+ageEString+"\",idA=\""+ida+"\",nomFiliere=\""+nomfiliere+"\" where idE=\""+ide+"\"";
                        System.out.println(query.toString());
                        sqlSt =  connexion.createStatement();
                        boolean state = sqlSt.execute(query);
                        if(state){
                            System.out.println("updated !");
                        }else{
                            System.out.println("not updated !");
                        }
                    }
                    if (e.getSource() == searchEtudiant){
                        String querySQl = "select * from Etudiant where idE= \""+idE.getText()+"\"";
                        sqlSt = connexion.createStatement();
                        ResultSet result1 = sqlSt.executeQuery(querySQl);
                        System.out.println(result1.getString(1));
                        while(result1.next()){
                            System.out.println(
                            "Nom :" +result1.getString(1)+
                            "Prenom : "+result1.getString("prenom")+
                            "age :"+result1.getString("age")+
                            "idA :"+result1.getString("idA")+
                            "Nomfiliere :"+result1.getString("nomFiliere")
                            );
                            textSearchedStudent.setText( "dikchi khawi");
                        }
                        System.out.println("makayen walo");
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



// export CLASSPATH=/usr/share/java/mysql-connector-j-8.0.32.jar:$CLASSPATH 
