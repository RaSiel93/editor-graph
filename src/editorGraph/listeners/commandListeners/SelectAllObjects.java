package editorGraph.listeners.commandListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editorGraph.controller.Controller;

public class SelectAllObjects implements ActionListener {
	Controller controller;
	
	public SelectAllObjects(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.selectAll();
		controller.repaint();
	}
}
