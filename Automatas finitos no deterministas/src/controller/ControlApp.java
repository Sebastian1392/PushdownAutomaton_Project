package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.main_frame.MainFrame;

public class ControlApp implements ActionListener{

    private MainFrame frame; //instancia de la vista, frame principal

    public ControlApp(){
        frame = new MainFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(Commands.valueOf(e.getActionCommand())){
            case C_RESTART:
                // reiniciar el automata 
                frame.restartAutomaton();

                break;
            case C_VALIDATE_WORD:
                // jOption para ingresar la palabra
                this.validateWord();
                break;
            default:
                break;

        }
        
    }

    public void validateWord() {
		String name = JOptionPane.showInputDialog("Ingresa la palabra a validar"); 

		if (JOptionPane.showConfirmDialog(frame, "¿Seguro que desea validar esta palabra: " + name + "?",
				"Pregunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			// llamar al metodo de validacion del modelo y enviar la palabra guardada en name
            System.out.println(name);
		}
	}


    
}
