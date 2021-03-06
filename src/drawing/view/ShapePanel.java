package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	public void clear()
	{
		rectangleList.clear();
		ellipseList.clear();
		circleList.clear();
		triangleList.clear();
		polygonList.clear();
		squareList.clear();
	}
	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 800);
		int yPosition = (int)(Math.random() * 800);
		int width = (int)(Math.random() * 100);
		int height = (int)(Math.random() * 150);
		
		rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
		
	}
	
	public void addSquare()
	{
		int xPosition = (int)(Math.random() * 800);
		int yPosition = (int)(Math.random() * 800);
		int width = (int)(Math.random() * 100);
		
		rectangleList.add(new Rectangle(xPosition, yPosition, width, width));
		
	}
	
	public void addEllipse()
	{
		int xPosition = (int)(Math.random() * 1500);
		int yPosition = (int)(Math.random() * 1000);
		int width = (int)(Math.random() * 2000);
		int height =(int)(Math.random() * 1000);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
		ellipseList.add(currentEllipse);
		
	}
	
	public void addCircle()
	{
		int xPosition = (int)(Math.random() * 1500);
		int yPosition = (int)(Math.random() * 1000);
		int width = (int)(Math.random() * 2000);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, width);
		ellipseList.add(currentEllipse);
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
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		for (Rectangle current : rectangleList)
		{
			int randomStroke = (int) (Math.random() * 7);
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));

			mainGraphics.fill(current);
		}
		
		for (Ellipse2D current : circleList)
		{
			int randomStroke = (int) (Math.random() * 7);
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));

			mainGraphics.fill(current);
		}
		
		for (Ellipse2D current : ellipseList)
		{
			int randomStroke = (int) (Math.random() * 7);
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));

			mainGraphics.fill(current);
		}
		
		for (Rectangle current : squareList)
		{
			int randomStroke = (int) (Math.random() * 7);
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));

			mainGraphics.fill(current);
		}
		
		for (Polygon current : triangleList)
		{
			int randomStroke = (int) (Math.random() * 7);
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));

			mainGraphics.fill(current);
		}
		
		for (Polygon current: polygonList)
		{
			int randomStroke = (int) (Math.random() * 7);
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));

			mainGraphics.fill(current);
		}
	}
	
	
}
