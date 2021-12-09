import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Speleolog extends Agent {
	
	//регистрация в DF
	protected void setup() {

		System.out.println("Hello! Speleolog-agent "+getAID().getName()+" is ready.");

		 DFAgentDescription dfd = new DFAgentDescription();
	        dfd.setName(getAID());
	        ServiceDescription sd = new ServiceDescription();
	        sd.setType( "Speleolog" );
	        sd.setName( getLocalName() );
	        dfd.addServices(sd);
	        
	        try {  
	            DFService.register(this, dfd );  
	        }
	        catch (FIPAException fe) { fe.printStackTrace(); }

	        addBehaviour(new LocationRequestsServer());
	    }
}
