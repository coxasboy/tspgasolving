package org.acabativa.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.acabativa.controller.TSController;
import org.acabativa.model.TSModel;
import org.acabativa.view.drawer.BestSolutionDrawer;

@SuppressWarnings("serial")
public class BestSolutionView extends AbstractBasicView {

	BestSolutionDrawer bestSolutionDrawer = new BestSolutionDrawer();
	
	public BestSolutionView(TSController controller, TSModel model) {
		super(controller, model);
		frame.setLocation(0,0);
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		try {
			bestSolutionDrawer.draw(g2d, model.getBestOne());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected int getHeightFrame() {
		return 500;
	}

	@Override
	protected int getWidthFrame() {
		return 500;
	}


}
