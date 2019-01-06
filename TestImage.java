import java.awt.*;
import javax.imageio.*; 

class TestImage 
{
	public static void main(String args[]) throws Exception 
	{
    	   Frame frame = new Frame("My Images");
      	frame.setSize(1024,768);
      	frame.setVisible(true);
         Graphics gc = frame.getGraphics();
      
      	try 
      	{
            Image myImage = new Image("animals.jpg");
            myImage.draw(gc, 10 ,40);
            myImage.flipY("animals.jpg");
            myImage.draw(gc, 296 ,40);
            myImage.flipX("animals.jpg");
            myImage.draw(gc, 582 ,40);
           ;
            
            Image myImage_flipY = new Image("animals.jpg");
            myImage_flipY.flipY("animals.jpg");
            myImage_flipY.draw(gc, 296 ,40);
             myImage_flipY.write("animals_flipY.jpg");
             
             
            Image myImage_flipX = new Image("animals.jpg");
             myImage_flipX.flipX("animals.jpg");
            myImage_flipX.draw(gc, 582 ,40);
             myImage_flipX.write("animals_flipX.jpg");

		} 
		catch (Exception e)
		{
         	e.printStackTrace();
      	}
	}
}