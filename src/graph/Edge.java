package graph;

import java.awt.Point;
import java.awt.geom.Line2D;

public class Edge extends Line2D.Double {
	private static final int SIDELENGTH = 25;
	private Vertex vertex1;
	private Vertex vertex2;
	private int lenght;
	private boolean active;
	private boolean actual;

	public Edge(Vertex beginVertex, Vertex endVertex) {
		vertex1 = beginVertex;
		vertex2 = endVertex;
		lenght = 1;
		activeOn();
		refresh();
	}

	public Edge(Edge edge) {
		vertex1 = edge.getVertex1();
		vertex2 = edge.getVertex2();
		lenght = 1;
		activeOn();
		refresh();
	}

	public void actualOn() {
		actual = true;
	}

	public void actualOff() {
		actual = false;
	}

	public boolean isActual() {
		return actual;
	}

	public void activeOn() {
		active = true;
	}

	public void activeOff() {
		active = false;
	}

	public boolean isActive() {
		return active;
	}

	public Point getPointBeginEdge() {
		Point pointBegin = new Point((int) (vertex1.getCenterX() - SIDELENGTH
				* Math.sin(getAngle())), (int) (vertex1.getCenterY() - SIDELENGTH
				* Math.cos(getAngle())));

		return pointBegin;
	}

	public Point getPointEndEdge() {
		Point pointEnd = new Point((int) (vertex2.getCenterX() + SIDELENGTH
				* Math.sin(getAngle())), (int) (vertex2.getCenterY() + SIDELENGTH
				* Math.cos(getAngle())));

		return pointEnd;
	}

	public double getAngle() {
		return Math.atan2(vertex1.getX() - vertex2.getX(), vertex1.getY() - vertex2.getY());
	}

	public int getLenght() {
		return lenght;
	}

	public double getCenterX() {
		return (vertex1.getCenterX() + vertex2.getCenterX()) / 2;
	}

	public double getCenterY() {
		return (vertex1.getCenterY() + vertex2.getCenterY()) / 2;
	}

	public Vertex getVertex1() {
		return vertex1;
	}

	public Vertex getVertex2() {
		return vertex2;
	}

	public boolean isContentVertexInEdge(Vertex vertex) {
		return (vertex1 == vertex || vertex2 == vertex);
	}

	public void revers() {
		Vertex vertexTemp = vertex1;
		vertex1 = vertex2;
		vertex2 = vertexTemp;
		setLine(getPointEndEdge(), getPointBeginEdge());
	}

	public void refresh() {
		setLine(getPointBeginEdge(), getPointEndEdge());
	}

	public boolean isEdgeInArea(Point p1, Point p2) {
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();

		if (x1 > x2) {
			double temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if (y1 > y2) {
			double temp = y1;
			y1 = y2;
			y2 = temp;
		}

		if (getCenterX() >= x1 && getCenterX() <= x2 && getCenterY() >= y1
				&& getCenterY() <= y2) {
			return true;
		}
		return false;
	}

	public void resize(int value) {
		lenght = value;
	}

}
