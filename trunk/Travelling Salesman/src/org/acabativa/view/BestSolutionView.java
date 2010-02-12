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


}
