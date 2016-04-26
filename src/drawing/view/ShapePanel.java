package drawing.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;


public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	private ArrayList<Rectangle> squareList;
	
	
	public ShapePanel()
	{
		
		rectangleList = new ArrayList<Rectangle>();
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		squareList = new ArrayList<Rectangle>();
		circleList = new ArrayList<Ellipse2D>();
		ellipseList = new ArrayList<Ellipse2D>();
	}
	
	public void addRectangle()
	{
		
	}
	
	public void addSquare()
	{
		
	}
	
	public void addEllipse()
	{
		
	}
	
	public void addCircle()
	{
		
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int [3];
		int [] yPoints = new int [3];
		xPoints[0] = (int)(Math.random() * 250);
		
		xPoints = new int []{(int)(Math.random() * 250), (int)(Math.random() *250), (int)(Math.random() * 250)};
		yPoints = new int []{(int)(Math.random() * 250), (int)(Math.random() *250), (int)(Math.random() * 250)};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		
		triangleList.add(triangle);
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 9) + 3;
		int [] xPoints = new int [numberOfSides];
		int [] yPoints = new int [numberOfSides];
		
		for (int sides = 0; sides < numberOfSides; sides++)
		{
			xPoints[sides] = (int)(Math.random() * 300);
			yPoints[sides] = (int)(Math.random() * 300);
		}
		
		Polygon myPolygon = new Polygon(xPoints,yPoints, numberOfSides);
		polygonList.add(myPolygon);
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
	}
}
