package editorGraph.listeners.eventListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import editorGraph.controller.Controller;

public class MouseMotionTemporaryEdge implements MouseMotionListener {
	Controller controller;

	public MouseMotionTemporaryEdge(Controller controller) {
		this.controller = controller;
	}

	public void mouseDragged(MouseEvent event) {
		if (controller.getCurrentGraph().checkExistsTempEdge()) {
			controller.getCurrentGraph().setEndTempEdge(event.getPoint());
			controller.repaint();
		}
	}

	public void mouseMoved(MouseEvent event) {
		if (controller.getCurrentGraph().checkExistsTempEdge()) {
			controller.getCurrentGraph().setEndTempEdge(event.getPoint());
			controller.repaint();
		}
	}
}
