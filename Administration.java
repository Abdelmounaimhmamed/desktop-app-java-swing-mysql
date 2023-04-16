import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Administration extends JFrame {
    JPanel panel1 ;
    JPanel panel2;
    JPanel panel3 ;
    JPanel mainPanel ;
    JLabel labelNom ;
    JLabel labelPrenom ;
    JLabel labelLogin ;
    JLabel labelPassword ;
    JLabel text ;
    JTextField Nom ;
    JTextField Prenom ;
    JTextField Login ;
    JTextField Password ;
    JButton AuthenticateUser ;

    public Administration(){

        mainPanel = new JPanel(new BorderLayout());
        panel1 = new JPanel();
        this.text = new JLabel("Administration Login ");
        this.panel1.add(this.text);
        this.panel1.setBackground(Color.ORANGE);
        
        panel2 = new JPanel(new GridLayout(4,4));
        
        // implement labels : 
        labelNom = new JLabel("Nom : ");
        labelPrenom = new JLabel("Prenom : ");
        labelLogin = new JLabel("login : ");
        labelPassword = new JLabel("Password : ");
    
        // implement text fields : 
        Nom = new JTextField(20);
        Prenom = new JTextField(20);
        Login = new JTextField(20);
        Password = new JTextField(20);

        this.panel2.add(labelNom);
        this.panel2.add(Nom) ;
        this.panel2.add(labelPrenom) ;
        this.panel2.add(Prenom) ;
        this.panel2.add(labelLogin) ;
        this.panel2.add(Login) ;
        this.panel2.add(labelPassword) ;
        this.panel2.add(Password) ;

        panel3 = new JPanel();
        AuthenticateUser = new JButton("Auhenticate ");
        AuthenticateUser.addActionListener(new eventHandler());
        panel3.add(AuthenticateUser);

        this.mainPanel.add(panel1, BorderLayout.NORTH);
        this.mainPanel.add(panel2, BorderLayout.CENTER);
        this.mainPanel.add(panel3   , BorderLayout.SOUTH);

        this.setSize(900, 800);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.add(mainPanel);
    }


    class eventHandler implements ActionListener {

        // get user data from inputs : 
        String nom = Nom.getText();
        String prenom = Prenom.getText();
        String login = Login.getText();
        String password = Password.getText();


        @Override 
        public void actionPerformed(ActionEvent event){
            if (event.getSource() == AuthenticateUser){
                Statement sqlSt ;
                boolean result ;
                String query = "select * from Administration where nom=\""+nom+"\"and prenom=\""+prenom+"\"and login=\""+login+"\"and password=\""+password+"\"";
                String url = "jdbc:mysql://localhost:3306/java";
                try {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Connection conn = DriverManager.getConnection(url, "root", "Mounaim_user2001");
                    System.out.println("Connected !");
                    sqlSt =  conn.createStatement();
                    result =  sqlSt.execute(query);
                    if (result){
                        new AdministrationHome();
                    }



                } catch (SQLException e) {
                    
                    e.printStackTrace();
                    System.out.println("not connected");
                }
            }
        }
    }

}

