package runner.servers;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

/**
 * Run Payara Micro application server and deploy Java EE Microservice
 * @author Ali Bassam
 *
 */
public class Payara {

	/**
	 * The path to WAR file must be provided as argument
	 * @param args
	 * @throws BootstrapException
	 */
	public static void main(String[] args) throws BootstrapException {
		
			PayaraMicro.getInstance().addDeployment(args[0]).bootStrap();
		
	}
}