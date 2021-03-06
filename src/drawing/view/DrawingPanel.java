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
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 350, SpringLayout.NORTH, this);
		addEllipseButton = new JButton("Add an ellipse!");
		addCircleButton = new JButton("Add a circle!");
		addSquareButton = new JButton("Add a square!");
		addTriangleButton = new JButton("Add a triangle!");
		clearButton = new JButton("Click to clear");
		drawRectangleButton = new JButton("Click to draw a rectangle. For some reason this is different than the other rectangle button.");

		setupPanel();
		setupLayout();
		setupListeners();

	}

	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setColor(Color.PINK);
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(90, 10, 20, 40));

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
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(addRectangleButton);
		this.add(addCircleButton);
		this.add(addSquareButton);
		this.add(addTriangleButton);
		this.add(addEllipseButton);
		this.add(addPolygonButton);
		this.add(clearButton);
		this.add(drawRectangleButton);
		this.setBackground(Color.BLUE);
		this.add(shapePanel);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, addRectangleButton, 107, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, addRectangleButton, -32, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addCircleButton, 37, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, addCircleButton, -24, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addSquareButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, addSquareButton, -36, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addTriangleButton, 0, SpringLayout.NORTH, addSquareButton);
		baseLayout.putConstraint(SpringLayout.EAST, addTriangleButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addPolygonButton, 0, SpringLayout.NORTH, addSquareButton);
		baseLayout.putConstraint(SpringLayout.WEST, addPolygonButton, 77, SpringLayout.EAST, addSquareButton);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -50, SpringLayout.EAST, this);

	}

	private void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int xPosition = (int) (Math.random() * 800);
				int yPosition = (int) (Math.random() * 800);
				int width = (int) (Math.random() * 100);
				int height = (int) (Math.random() * 150);

				rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
				repaint();
			}
		});

		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});

		addCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});

		addSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			}
		});

		addTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});

		addEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});

		addPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});

		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
				repaint();
			}
		});
	}
}
