import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame {
    JPanel mainPanel;
    JPanel panel1 ;
    JPanel panel2 ;

    JMenuBar menuBar  ;
    JMenu menu ;
    JMenuItem menuItem ;


    JLabel title ;

    // button  :
    JButton AdministraionArea ;
    JButton ProfesseurArea ;
    JButton EtudiantArea ;
    JButton Quit ;


    public Fenetre (){
        // setup title panel  : 
        this.title = new JLabel("Gestion des Absences des Etudiants de l'ensa Khouribga");
        this.panel1 = new JPanel();
        this.panel1.add( this.title); 
        this.panel1.setBackground(Color.ORANGE);


        // implement buttons : 
        this.AdministraionArea = new JButton("Administration Area");
        this.AdministraionArea.addActionListener(new eventHandler());
        this.ProfesseurArea = new JButton("Professeur Area");
        this.ProfesseurArea.addActionListener(new eventHandler());
        this.EtudiantArea = new JButton("Etudianr Area");
        this.EtudiantArea.addActionListener(new eventHandler());
        this.Quit = new JButton("Quit ");
        this.Quit.addActionListener(new eventHandler());

        this.panel2 = new JPanel(new GridLayout(4,0));
        this.panel2.setSize(400, 400);
        this.panel2.add(AdministraionArea);
        this.panel2.add(ProfesseurArea);
        this.panel2.add(EtudiantArea);
        this.panel2.add(Quit);
        

        this.mainPanel = new JPanel(new BorderLayout());
        this.mainPanel.add(panel1 , BorderLayout.NORTH);
        this.mainPanel.add(panel2 , BorderLayout.CENTER);
        this.mainPanel.setBackground(Color.ORANGE);
        this.mainPanel.setBackground(Color.ORANGE);

        // the main frame setup :
        this.setSize(900, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(this.mainPanel);
    }


    class eventHandler implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == AdministraionArea){
                new Administration();
            }
            if(e.getSource() == ProfesseurArea){
                new Professeur();
            }
            if (e.getSource() == EtudiantArea){
                new Etudiant();
            }
            if(e.getSource() == Quit){
                System.out.println("system.shut.Down");
            }
        }

    }
}
