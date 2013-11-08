package main;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

import javax.swing.JOptionPane;

public class Algoritm {
    Graph graph;
    Controller controller;
    boolean[][] vertexLabels;
    boolean isBipartition;

    public Algoritm(Controller controller) {
	this.controller = controller;
    }

    public boolean runAlgoritm(Graph graph) throws InterruptedException {
	this.graph = new Graph(graph);

	vertexLabels = new boolean[graph.countVertex()][2];
	for (int numVert = 0; numVert < graph.countVertex(); numVert++) {
	    vertexLabels[numVert][0] = false;
	    vertexLabels[numVert][1] = false;
	}
	isBipartition = true;

	checkGraphOnBipartition();
	return isBipartition;
    }

    public void checkGraphOnBipartition() throws InterruptedException {
	isBipartition = true;
	if (graph.countVertex() != 0) {
	    for (int numVertex = 0; numVertex < graph.countVertex(); numVertex++) {
		if (vertexLabels[numVertex][0] == false) {
		    searchInDepth(graph.getVertex(numVertex), false);
		}
	    }
	    if (isBipartition) {
		JOptionPane.showMessageDialog(null, "���� ����������");
	    } else {
		JOptionPane.showMessageDialog(null, "���� �� ����������");
	    }
	}
    }

    public boolean[][] getVertexLabels() {
	return vertexLabels;
    }

    private void searchInDepth(Vertex vertex, boolean flag)
	    throws InterruptedException {
	if (!isBipartition)
	    return;

	vertexLabels[graph.findVertex(vertex)][0] = true;
	vertexLabels[graph.findVertex(vertex)][1] = flag;

	controller.repaint();
	// JOptionPane.showMessageDialog(null, "����������...");

	// Thread.sleep(2000);

	for (int numEdge = 0; numEdge < graph.countEdge() && isBipartition; numEdge++) {
	    Edge edge = graph.getEdge(numEdge);
	    Vertex vertex1 = edge.getVertex1(), vertex2 = edge.getVertex2();
	    if (vertex1 == vertex) {
		if (vertexLabels[graph.findVertex(vertex2)][0] == false) {
		    searchInDepth(vertex2, !flag);
		}
		if (vertexLabels[graph.findVertex(vertex2)][1] == flag) {
		    isBipartition = false;
		    return;
		}
	    } else if (vertex2 == vertex) {
		if (vertexLabels[graph.findVertex(vertex1)][0] == false) {
		    searchInDepth(vertex1, !flag);
		}
		if (vertexLabels[graph.findVertex(vertex1)][1] == flag) {
		    isBipartition = false;
		    return;
		}
	    }
	}
    }

    public void run() {
	controller.repaint();
    }
    /*
     * // mainFrame.repaint(); // Thread.sleep(2000); public void reset() {
     * isBipartition = true; for (int numVertex = 0; numVertex <
     * graph.countVertex(); numVertex++) { //
     * graph.getVertex(numVertex).setFlag(-1); } }
     */

}
