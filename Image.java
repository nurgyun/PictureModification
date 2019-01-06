import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Image 
{
	private int width, height; 
	private int[][] pixels;
   
	public Image(String filename) throws Exception 
	{ 
		this.read(filename); 
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
   
	public void read(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
        BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();
		
		// Complete the remainder of this method 
      pixels = new int [bufImage.getWidth()][bufImage.getHeight()];
      	for (int row = 0; row < this.width; row++)
      	{
         	for (int col = 0; col < this.height; col++)
         	{
         		this.pixels[row][col] = bufImage.getRGB(row, col);
         	}
         }         
   }
   
   private BufferedImage createBufferedImage() 
   	{ 
   	BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  
      	for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width; col++)
         	{
         		bufImage.setRGB(col, row, this.pixels[col][row]);
         	}
        }
         
      	return bufImage;
	    }
   
   public void write(String filename) throws Exception 
   {
        File fileImage = new File(filename);
        String ext = filename.substring(filename.indexOf('.') + 1);
        BufferedImage bufImage = createBufferedImage();
        ImageIO.write(bufImage, ext, fileImage);
   }
   
   
	public void draw(Graphics gc, int x, int y)
	{
   		BufferedImage bufImage = createBufferedImage();
      	gc.drawImage(bufImage, x, y, null);
   }
   
   public void flipY(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
        BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();      
         pixels = new int [bufImage.getWidth()][bufImage.getHeight()];
      	for (int row = 0; row < this.width; row++)
      	{
         	for (int col = 0; col < this.height; col++)
         	{
         		this.pixels[this.width-row-1][col] = bufImage.getRGB(row, col);
         	}
         } 

   }
   public void flipX(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
        BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();      
         pixels = new int [bufImage.getWidth()][bufImage.getHeight()];
      	for (int row = 0; row < this.width; row++)
      	{
         	for (int col = 0; col < this.height; col++)
         	{
         		this.pixels[row][this.height-col-1] = bufImage.getRGB(row, col);
         	}
         } 

   }

} 