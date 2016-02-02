package Files;

import java.io.FileWriter;
import java.util.List;

public class Y_Filewriter {
	private String path;

	public Y_Filewriter(String filepath) {
		path = filepath;
	}

	public void write(String[] content) {
		try {
			FileWriter fw = new FileWriter(path);

			for(String line : content) {
				fw.write(line);
			}
			
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}

	public void write(List<String> content) {
		try {
			FileWriter fw = new FileWriter(path);

			for(String line : content) {
				fw.write(line);
			}
			
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
