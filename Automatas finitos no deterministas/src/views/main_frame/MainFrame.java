package views.main_frame;

import javax.swing.JFrame;
import  java.awt.*;    

import java.awt.event.ActionListener; 

public class MainFrame extends JFrame{

    private CanvasFA canvas;
    private NorthPanel menuBarr;
	
    public MainFrame(ActionListener actionListener){
        this.canvas = new CanvasFA(300, 300);
        this.menuBarr = new NorthPanel(actionListener);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); 
        this.setSize(800,800);
        this.initComponents();
        this.setVisible(true);  
    }

    private void initComponents(){
        this.add(canvas, BorderLayout.CENTER);  
        this.add(menuBarr, BorderLayout.NORTH);
    }

    public void restartAutomaton(){
        canvas.restartAutomaton();
    }
}
