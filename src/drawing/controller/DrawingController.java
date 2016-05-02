package drawing.controller;

import drawing.view.DrawingFrame;
public class DrawingController
{
	private DrawingFrame baseFrame;
	public void start()
	{
	
	}
	
	public DrawingController()
	{
		baseFrame = new DrawingFrame(this);
		
	}
}
