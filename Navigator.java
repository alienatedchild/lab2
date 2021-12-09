import BookBuyerAgent.RequestPerformer;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Navigator extends Agent {
	
	//регистрация в DF
	protected void setup() {

		System.out.println("Hello! Navigator-agent "+getAID().getName()+" is ready.");

		 DFAgentDescription dfd = new DFAgentDescription();
	        dfd.setName(getAID());
	        ServiceDescription sd = new ServiceDescription();
	        sd.setType(Speleolog.NAVIGATOR);
	        sd.setName( getLocalName() );
	        dfd.addServices(sd);
	        
	        try {  
	            DFService.register(this, dfd );  
	        }
	        catch (FIPAException fe) { fe.printStackTrace(); }

	        addBehaviour(new ListenSpeleolog());
	    }
	private class ListenSpeleolog extends CyclicBehaviour {
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            }
            else {
                block();
            }
        }
    }

}
