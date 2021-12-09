import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Speleolog extends Agent {
	
	public static String ENVIROMENT = "enviroment";
    public static String NAVIGATOR = "navigator";
	
    
    private class WalkWampusWorld extends Behaviour {
		protected void setup() {
			DFAgentDescription dfd = new DFAgentDescription();
		        dfd.setName(getAID());
		        ServiceDescription sd = new ServiceDescription();
		        sd.setType(ENVIROMENT);
		        sd.setName( getLocalName() );
		        dfd.addServices(sd);
		        
		        try {  
		            DFService.register(this, dfd );  
		        }
		        catch (FIPAException fe) { fe.printStackTrace(); }
		    }
}
¯