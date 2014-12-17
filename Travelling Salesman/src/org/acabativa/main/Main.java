package org.acabativa.main;

import org.acabativa.controller.TSController;
import org.acabativa.controller.TSControllerImpl;
import org.acabativa.model.TSModel;
import org.apache.log4j.BasicConfigurator;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		TSModel model = new TSModel();
		TSController controller = new TSControllerImpl(model);
				
	}
	
	
}
