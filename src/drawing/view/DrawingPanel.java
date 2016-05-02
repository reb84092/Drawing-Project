package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import drawing.controller.DrawingController;
import java.awt.event.ActionEvent;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private SpringLayout baseLayout;
	private ShapePanel shapePanel;
	private ArrayList<Rectangle> rectangleList;
	private JButton addRectangleButton;
	private JButton addCircleButton;
	private JButton addSquareButton;
	private JButton addTriangleButton;
	private JButton addEllipseButton;
	private JButton addPolygonButton;
	private JButton clearButton;
	private JButton drawRectangleButton;
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		addRectangleButton = new JButton("Add a rectangle!");
		addPolygonButton = new JButton("Add a polygon!");
		rectangleList = new ArrayList<Rectangle>();
		shapePanel = new ShapePanel();
		addEllipseButton = new JButton ("Add an ellipse!");
		addCircleButton = new JButton ("Add a circle!");
		addSquareButton = new JButton ("Add a square!");
		addTriangleButton = new JButton ("Add a triangle!");
		
	}

	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setColor(Color.PINK);
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(90, 10, 20, 40));
		
		for(Rectangle current : rectangleList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
	}
	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int)(Math.random() * 800);
				int yPosition = (int)(Math.random() * 800);
				int width = (int)(Math.random() * 100);
				int height = (int)(Math.random() * 150);
				
				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				repaint();
			}
		});
	}
}
