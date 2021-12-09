import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import aima.core.agent.impl.SimpleEnvironmentView;
import aima.core.environment.wumpusworld.EfficientHybridWumpusAgent;
import aima.core.environment.wumpusworld.HybridWumpusAgent;
import aima.core.environment.wumpusworld.WumpusCave;
import aima.core.environment.wumpusworld.WumpusEnvironment;
import aima.core.logic.propositional.inference.DPLL;

public class Enviroment extends Agent {
	
	//регистрация в DF
	protected void setup() {

		System.out.println("Hello! Enviroment-agent "+getAID().getName()+" is ready.");

		 DFAgentDescription dfd = new DFAgentDescription();
	        dfd.setName(getAID());
	        ServiceDescription sd = new ServiceDescription();
	        sd.setType( "Enviroment" );
	        sd.setName( getLocalName() );
	        dfd.addServices(sd);
	        
	        try {  
	            DFService.register(this, dfd );  
	        }
	        catch (FIPAException fe) { fe.printStackTrace(); }

	        addBehaviour(new LocationRequestsServer());
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
