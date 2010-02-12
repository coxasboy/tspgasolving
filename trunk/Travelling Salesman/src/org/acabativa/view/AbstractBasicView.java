package org.acabativa.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.acabativa.controller.TSController;
import org.acabativa.model.TSModel;
import org.acabativa.util.Observer;

public abstract class AbstractBasicView extends JPanel implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;
	public static final int MAX_WIDHT = 500;
	public static final int MAX_HEIGHT = 500;
	TSController controller;
	TSModel model;
	JFrame frame;
		
	public AbstractBasicView(TSController controller, TSModel model) {
		this.controller = controller;
		this.model = model;
		model.addObserver(this);
		frame = new JFrame("TS Experiment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(MAX_WIDHT + 17 , MAX_HEIGHT + 37);
		frame.setLocationRelativeTo(null);
		frame.add(this);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	@Override
	public void notifyEvent(String event) {
		repaint();
	}

}
