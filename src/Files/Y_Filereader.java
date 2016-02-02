package Files;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Y_Filereader {
	private String path;
	
	public Y_Filereader(String filepath) {
		path = filepath;
	}
	
	public String[] read() {
		ArrayList<String> file = read_();
		String[] out = new String[file.size()];
		out = file.toArray(out);
		
		return out;
	}
	
	public ArrayList<String> read_() {
		try {
			FileReader fr = new FileReader(path);
			Scanner s = new Scanner(fr);
			
			ArrayList<String> out = new ArrayList<String>();
			
			while (s.hasNextLine()) {
				out.add(s.nextLine());
			}
			
			s.close();
			fr.close();
			
			return out;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
}
