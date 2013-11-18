package editorGraph.shell;

import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import static java.awt.event.InputEvent.SHIFT_DOWN_MASK;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuPanel extends JMenuBar {
	public MenuPanel(Map<String, ActionListener> listeners) {
		JMenu fileMenu = new JMenu("����");

		JMenuItem newFile = new JMenuItem("�����");
		newFile.addActionListener(listeners.get("CREATE"));
		newFile.setAccelerator(KeyStroke.getKeyStroke('N', CTRL_DOWN_MASK));
		JMenuItem loadFile = new JMenuItem("�������");
		loadFile.addActionListener(listeners.get("OPEN"));
		loadFile.setAccelerator(KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));
		JMenuItem saveFile = new JMenuItem("���������");
		saveFile.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
		saveFile.addActionListener(listeners.get("SAVE"));
		JMenuItem closeFile = new JMenuItem("�������");
		closeFile.setAccelerator(KeyStroke.getKeyStroke('W', CTRL_DOWN_MASK));
		closeFile.addActionListener(listeners.get("CLOSE"));
		JMenuItem exitItem = new JMenuItem("�����");
		exitItem.addActionListener(listeners.get("EXIT"));

		fileMenu.add(newFile);
		fileMenu.add(loadFile);
		fileMenu.add(saveFile);
		fileMenu.add(closeFile);
		fileMenu.add(exitItem);

		add(fileMenu);
		// -----------------------------------
		JMenu toolsMenu = new JMenu("�����������");

		JMenuItem toolVertex = new JMenuItem("����");
		toolVertex.addActionListener(listeners.get("VERTEX_MODE"));
		toolVertex.setAccelerator(KeyStroke.getKeyStroke('V', SHIFT_DOWN_MASK));
		JMenuItem toolEdge = new JMenuItem("����");
		toolEdge.addActionListener(listeners.get("EDGE_MODE"));
		toolEdge.setAccelerator(KeyStroke.getKeyStroke('A', SHIFT_DOWN_MASK));
		JMenuItem editNameOrLenght = new JMenuItem("��� - �����");
		editNameOrLenght.addActionListener(listeners.get("EDIT_MODE"));
		editNameOrLenght.setAccelerator(KeyStroke.getKeyStroke('E',
				SHIFT_DOWN_MASK));

		toolsMenu.add(toolVertex);
		toolsMenu.add(toolEdge);
		toolsMenu.add(editNameOrLenght);

		add(toolsMenu);
		// -----------------------------------
		JMenu editMenu = new JMenu("��������������");

		JMenuItem removeItem = new JMenuItem("�������");
		removeItem.addActionListener(listeners.get("REMOVE"));
		removeItem
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));

		JMenuItem selectAllItem = new JMenuItem("�������� ���");
		selectAllItem.addActionListener(listeners.get("SELECT_ALL"));
		selectAllItem.setAccelerator(KeyStroke
				.getKeyStroke('A', CTRL_DOWN_MASK));

		editMenu.add(removeItem);
		editMenu.add(selectAllItem);
		add(editMenu);
		// -----------------------------------
		JMenu algoMenu = new JMenu("��������");
		JMenuItem runAlgo = new JMenuItem("���������");
		runAlgo.addActionListener(listeners.get("RUN_ALGO"));
		runAlgo.setAccelerator(KeyStroke.getKeyStroke('R', CTRL_DOWN_MASK));
		JMenuItem stepAlgo = new JMenuItem("����������..");
		stepAlgo.setEnabled(false);
		stepAlgo.addActionListener(listeners.get("STEP_ALGO"));
		stepAlgo.setAccelerator(KeyStroke.getKeyStroke('W', CTRL_DOWN_MASK));
		JMenuItem breakAlgo = new JMenuItem("��������");
		breakAlgo.addActionListener(listeners.get("BREAK_ALGO"));
		breakAlgo.setAccelerator(KeyStroke.getKeyStroke('T', CTRL_DOWN_MASK));
		breakAlgo.setEnabled(false);

		algoMenu.add(runAlgo);
		algoMenu.add(stepAlgo);
		algoMenu.add(breakAlgo);
		add(algoMenu);
	}
}