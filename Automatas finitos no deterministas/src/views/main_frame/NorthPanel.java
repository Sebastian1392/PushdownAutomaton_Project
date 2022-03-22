package views.main_frame;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;


import controller.Commands;  

public class NorthPanel extends JPanel{
    
    private JButton restartAutomaton, validateWord;

    public NorthPanel(ActionListener actionListener){
        restartAutomaton = new JButton();
        validateWord = new JButton();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.LIGHT_GRAY);
        this.initComponents(actionListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener){
        restartAutomaton.setText("Reiniciar");
        restartAutomaton.addActionListener(actionListener);
        restartAutomaton.setActionCommand(Commands.C_RESTART.toString());
        this.add(restartAutomaton);
        validateWord.addActionListener(actionListener);
        validateWord.setActionCommand(Commands.C_VALIDATE_WORD.toString());
        validateWord.setText("Ingresar palabra");
        this.add(validateWord);
    }

}
