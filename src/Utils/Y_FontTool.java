package Utils;

import java.awt.Font;
import java.awt.Graphics;

public class Y_FontTool {
public static Font generateFont(String name, int size){
	return new Font(name, Font.BOLD, size);
}
public static void setGenerateFont(String name, int size, Graphics g){
	g.setFont(new Font(name,Font.BOLD,size));
}
public static int getFontWidth(Graphics g, String x){ // No other way i think
	return g.getFontMetrics().stringWidth(x);
}
public static int getFontHeight(Graphics g){
	return g.getFontMetrics().getHeight();
}

}
