package eecs2011a3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Log {
	private static final TreeMap<String, String> ITEMS_LOGS = new TreeMap<String, String>();
	private final String FILENAME = "log.txt";
	public void  saveLog() {
		try {
			//Writes to a text file.
			PrintWriter out = new PrintWriter(FILENAME);
				out.write( A3.ITEMS_LOGS.get(0));
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Log File ERROR.");
		}
	}
}
