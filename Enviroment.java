import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import aima.core.agent.impl.SimpleEnvironmentView;
import aima.core.environment.wumpusworld.AgentPosition;
import aima.core.environment.wumpusworld.EfficientHybridWumpusAgent;
import aima.core.environment.wumpusworld.HybridWumpusAgent;
import aima.core.environment.wumpusworld.WumpusCave;
import aima.core.environment.wumpusworld.WumpusEnvironment;
import aima.core.environment.wumpusworld.action.Forward;
import aima.core.environment.wumpusworld.action.Shoot;
import aima.core.environment.wumpusworld.action.TurnLeft;
import aima.core.environment.wumpusworld.action.TurnRight;
import aima.core.logic.propositional.inference.DPLL;

public class Enviroment extends Agent {
	
	public static final String GOLD       		 = "G";
	public static final String START             = "S";
	public static final String PIT               = "P";
	public static final String WUMPUS            = "W";
	public static final String FACING_NORTH      = AgentPosition.Orientation.FACING_NORTH.toString();
	public static final String FACING_SOUTH      = AgentPosition.Orientation.FACING_SOUTH.toString();
	public static final String FACING_EAST       = AgentPosition.Orientation.FACING_EAST.toString();
	public static final String FACING_WEST       = AgentPosition.Orientation.FACING_WEST.toString();
	public static final String OK_MESSAGE = "OK";
	public static final String FAIL_MESSAGE = "FAIL";
	public static final String WIN_MESSAGE = "WIN";
	public static final String SPELEOLOGIST_TURN_LEFT = "SPELEOLOGIST_LOOK_LEFT";
	public static final String SPELEOLOGIST_TURN_RIGHT = "SPELEOLOGIST_TURN_RIGHT";
	public static final String SPELEOLOGIST_MOVE_FORWARD = "SPELEOLOGIST_MOVE_FORWARD";
	public static final String SPELEOLOGIST_GRAB = "SPELEOLOGIST_GRAB";
	public static final String SPELEOLOGIST_SHOOT = "SPELEOLOGIST_SHOOT";
	public static final String SPELEOLOGIST_CLIMB = "SPELEOLOGIST_CLIMB";

	public static final String MESSAGE_LEFT = "turn left";
	public static final String MESSAGE_RIGHT = "turn right";
	public static final String MESSAGE_FORWARD = "move forward";
	public static final String MESSAGE_GRAB = "grab the gold";
	public static final String MESSAGE_SHOOT = "shoot";
	public static final String MESSAGE_CLIMB = "climb";
	//регистрация в DF
	protected void setup() {

		System.out.println("Hello! Enviroment-agent "+getAID().getName()+" is ready.");

		 DFAgentDescription dfd = new DFAgentDescription();
	        dfd.setName(getAID());
	        ServiceDescription sd = new ServiceDescription();
	        sd.setType(Speleolog.ENVIROMENT);
	        sd.setName( getLocalName());
	        dfd.addServices(sd);
	        
	        try {  
	            DFService.register(this, dfd );  
	        }
	        catch (FIPAException fe) { fe.printStackTrace(); }
	    }
	
	public static void main(String[] args) {
        WumpusCave cave;
        cave = create4x4Cave();

        WumpusEnvironment env = new WumpusEnvironment(cave);
        SimpleEnvironmentView view = new SimpleEnvironmentView();
        env.addEnvironmentListener(view);

        HybridWumpusAgent agent;
        agent = new HybridWumpusAgent
        // agent = new EfficientHybridWumpusAgent
                (cave.getCaveXDimension(), cave.getCaveYDimension(), cave.getStart(), new DPLL(), env);


    /**
     * A typical wumpus world. The agent is in the bottom left corner, facing right.
     */
    private static WumpusCave create4x4Cave() {
        return new WumpusCave(4, 4, ""
                + ". . . P "
                + "W G P . "
                + ". . . . "
                + "S . P . ");
    }
    
    

}
}
