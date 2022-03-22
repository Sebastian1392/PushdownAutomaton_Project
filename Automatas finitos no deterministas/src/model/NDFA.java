package model;

import java.util.ArrayList;

public class NDFA {
	
	private ArrayList<State> states;
	private ArrayList<Transition> transitions;
	
	public NDFA() {
		states=new ArrayList<State>();
		transitions=new ArrayList<Transition>();
	}
	
	public void addState(String name, StateType type) {
		states.add(new State(name,type));
	}
	
	public void deleteState(State state) {
		states.remove(state);
	}
	
	public void addTransition(char transitionValue, State initialState, State finalState) {
		transitions.add(new Transition(transitionValue,initialState,finalState));
	}
	
	public void deleteTransition(Transition transition) {
		transitions.remove(transition);
	}

	
	//Para determinista
	public boolean validateWordDeterministic(String word) {
		boolean validation = false;
		String[] splitWord = word.split(""); 
		ArrayList<Transition> stateTransitions = searchTransitions(this.states.get(0));
		State currentState = stateTransitions.get(0).getFinalState();

		for(int i = 0; i<splitWord.length; i++){
			for(int j = 0; j < stateTransitions.size(); j++){
				if(splitWord[i].compareTo( String.valueOf(stateTransitions.get(j).getTransitionValue()) ) == 0 ){
					System.out.println(splitWord[i] + ": " +stateTransitions.get(j).getInfo());
					currentState = stateTransitions.get(j).getFinalState();
					stateTransitions = searchTransitions(currentState);
					validation = true;
					break;
				}
				else{
					validation = false;
				}
			}

			if(validation == false){
				return validation;
			}
		}

		if(currentState.getType().equals(StateType.FINAL)){
			validation = true;
		}else{
			validation = false;
		}

		return validation;
	}

	//Para no determinista 
	public boolean validateWordNonDeterministic(String word){
		return false;
	}

	public ArrayList<Transition> searchTransitions(State state){
		ArrayList<Transition> stateTransitions = new ArrayList<Transition>();
		for(int i = 0; i < this.transitions.size(); i++){
			if(transitions.get(i).getInitialState().equals(state) == true){
				stateTransitions.add(transitions.get(i));
			}
		}
		return stateTransitions;
	}

	public int getStateIndex(String stateName){
		int index = 0;
		for(int i = 0; i < states.size() ;i++){
			if(states.get(i).getName().compareTo(stateName) == 0){
				index = i;
			}
		}
		return index;
	}
	
	public ArrayList<State> getStates(){
		return this.states;
	}

	public ArrayList<Transition> gTransitions(){
		return this.transitions;
	}
}
