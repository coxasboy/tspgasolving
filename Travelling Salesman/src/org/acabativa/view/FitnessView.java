package org.acabativa.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.acabativa.controller.TSController;
import org.acabativa.model.TSModel;
import org.acabativa.view.drawer.FitnessDrawer;

@SuppressWarnings("serial")
public class FitnessView extends AbstractBasicView{

	FitnessDrawer fitnessDrawer = new FitnessDrawer();
	
	public FitnessView(TSController controller, TSModel model) {
		super(controller, model);
		frame.setLocation(534,0);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		try {
			fitnessDrawer.draw(g2d, model.getBestFitness());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected int getHeightFrame() {
		return 200;
	}

	@Override
	protected int getWidthFrame() {
		return 300;
	}


}
