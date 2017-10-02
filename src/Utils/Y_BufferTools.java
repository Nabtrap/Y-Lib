package Utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

public class Y_BufferTools {
	// Good for PhySIX engine, helps buffering.
	public static void clear(Graphics g){
	g.setColor(Color.black); 
	g.fillRect(-5000, -5000, 10000, 10000); // Dont have Width, Height^
}
public static void DrawImage(int x, int y, Image img, Graphics g){
	g.drawImage(img, x, y, null);
}
public static void show(Graphics g, BufferStrategy strat){
	strat.show();
	g.dispose();
}
}
