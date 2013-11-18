package editorGraph.listeners.commandListeners.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editorGraph.controller.Controller;

public class Save implements ActionListener {
	Controller controller;
	
	public Save(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.save();
	}
}
