package Utils;

public class Y_NumberTool {

	public static String num_toString(int tostring, int min_length) {
		return String.format("%0" + min_length + "d",  tostring);
	}
	
	public static boolean is_nummber(String test) {
		try {
			Integer.parseInt(test);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}