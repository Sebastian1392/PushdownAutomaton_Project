import java.util.ArrayList;
import model.NDFA;
import model.State;
import model.StateType;
import model.Transition;

public class testValidateWord {
    
    public static void main(String[] args) {
       
        //NDFA Prueba 1
        NDFA ndfa = new NDFA();

        ndfa.addState("q0", StateType.INITIAL);
        ndfa.addState("q1", StateType.DEFAULT);
        ndfa.addState("q2", StateType.FINAL);

        ArrayList<State> states = ndfa.getStates();

        ndfa.addTransition('0', states.get(ndfa.getStateIndex("q0")), states.get(ndfa.getStateIndex("q1")));
        ndfa.addTransition('1', states.get(ndfa.getStateIndex("q1")), states.get(ndfa.getStateIndex("q1")));
        ndfa.addTransition('0', states.get(ndfa.getStateIndex("q1")), states.get(ndfa.getStateIndex("q2")));
        ndfa.addTransition('1', states.get(ndfa.getStateIndex("q2")), states.get(ndfa.getStateIndex("q1"))); 
        
        ArrayList<Transition> transitions = ndfa.gTransitions();

        for(int i = 0; i < transitions.size(); i++){
           //System.out.println(transitions.get(i).getInfo() + "\n");
        }

        //System.out.println(ndfa.validateWord("01011101"));

        //NDFA Prueba 2
        NDFA ndfa2 = new NDFA();

        ndfa2.addState("q0", StateType.INITIAL);
        ndfa2.addState("q1", StateType.FINAL);
        ndfa2.addState("q2", StateType.FINAL);
        ndfa2.addState("q3", StateType.DEFAULT);

        ArrayList<State> states2 = ndfa2.getStates();

        ndfa2.addTransition('0', states2.get(ndfa2.getStateIndex("q0")), states2.get(ndfa2.getStateIndex("q1")));
        ndfa2.addTransition('0', states2.get(ndfa2.getStateIndex("q1")), states2.get(ndfa2.getStateIndex("q3")));
        ndfa2.addTransition('1', states2.get(ndfa2.getStateIndex("q1")), states2.get(ndfa2.getStateIndex("q2")));
        ndfa2.addTransition('0', states2.get(ndfa2.getStateIndex("q2")), states2.get(ndfa2.getStateIndex("q3")));
        ndfa2.addTransition('1', states2.get(ndfa2.getStateIndex("q2")), states2.get(ndfa2.getStateIndex("q0")));
        ndfa2.addTransition('1', states2.get(ndfa2.getStateIndex("q3")), states2.get(ndfa2.getStateIndex("q2")));

        System.out.println(ndfa2.validateWordDeterministic("00110101"));

    }
}
