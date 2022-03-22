package views.main_frame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import views.elements.StateElement;
import views.elements.Transition; 

/*
 * Clase CanvasFA: Es el canvas del Finite Automata, donde se van a dibujar los distintos elementos graficos
 * */
public class CanvasFA extends JPanel{
	public int width, height;
    public static int CIRCLE_RADIUS = 30;
    private StateElement se = new StateElement();
    private ArrayList<StateElement> states = new ArrayList<StateElement>();
    private ArrayList<Transition> transitions = new ArrayList<Transition>();
    private boolean creatingTransition = false;
    
	public CanvasFA(int width, int height) {
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			
			boolean isOverlapping = false;
			StateElement selected = null;
			
			int counter = 0;
			
			while(!isOverlapping && counter < states.size()) {
				if(dist(states.get(counter).x + CIRCLE_RADIUS/2, states.get(counter).y + CIRCLE_RADIUS/2, e.getX(), e.getY()) < CIRCLE_RADIUS) {
					selected = states.get(counter);
					isOverlapping = true;
				}
				counter++;
			}
			if(!isOverlapping) {
				states.add(new StateElement(e.getX()-CIRCLE_RADIUS/2, e.getY()-CIRCLE_RADIUS/2, "q" + states.size()));
				for(StateElement state : states) {
					drawState(state.x, state.y);
				}
			}else if(!creatingTransition) {
				System.out.println("Creating Transition");
				Transition t = new Transition();
				t.start = selected;
				creatingTransition = true;
				transitions.add(t);
			}else if(creatingTransition) {
				transitions.get(transitions.size()-1).end = selected;
				creatingTransition = false;
				for(Transition t : transitions) {
					System.out.println(t.start.tag + "->" + t.end.tag);
				}
			}
			drawState();
		}
		});
	}
	private void drawState(int x, int y) {
		final int CURR_X = se.getX();
        final int CURR_Y = se.getY();
        final int OFFSET = 1;

        if ((CURR_X!=x) || (CURR_Y!=y)) {

            // The square is moving, repaint background 
            // over the old square location. 
            repaint(CURR_X,CURR_Y,CIRCLE_RADIUS,CIRCLE_RADIUS);

            // Update coordinates.
            se.setX(x);
            se.setY(y);

            // Repaint the square at the new location.
            repaint(se.getX(), se.getY(), CIRCLE_RADIUS+OFFSET, CIRCLE_RADIUS+OFFSET);
        }
    }
	private void drawState(){
		repaint();
	}
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        Graphics2D g2 = (Graphics2D)g;
        // Draw Text
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING,
        		 RenderingHints.VALUE_RENDER_QUALITY);
        		hints.put(RenderingHints.KEY_ANTIALIASING,
        		RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(hints);
        for(Transition t : transitions) {
        	t.drawTransition(g2);
        }
        for(StateElement state : states) {
        	state.paintState(g2);
        }
    }
	
	private double dist(float x1, float y1, float x2, float y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	public void restartAutomaton(){
		new StateElement();
	}
}
