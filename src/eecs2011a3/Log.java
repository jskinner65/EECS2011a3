package eecs2011a3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Log {
	private static final TreeMap<String, EntryValue> ITEMS_LOGS_BACKUP = new TreeMap<String, EntryValue>();
	private static final String FILENAME = "log.txt";
	public static void  saveLog() {
		try {
			//Writes to a text file.
			PrintWriter out = new PrintWriter(FILENAME);
			for (int i =0; i<A3.ITEMS_LOGS.size(); i++) {
				System.out.println(A3.ITEMS_LOGS.get("" + A3.ITEMS_LOGS.firstEntry()));
				out.println(A3.ITEMS_LOGS.firstKey() + " " + A3.ITEMS_LOGS.get("" + A3.ITEMS_LOGS.firstEntry()));
				ITEMS_LOGS_BACKUP.put("" +A3.ITEMS_LOGS.firstEntry(), A3.ITEMS_LOGS.get("" +A3.ITEMS_LOGS.firstEntry()));
				A3.ITEMS_LOGS.remove("" + 0);
			}
			out.close();
			for (int i =0; i<ITEMS_LOGS_BACKUP.size(); i++) {
				out.println(ITEMS_LOGS_BACKUP.firstKey() + " " + ITEMS_LOGS_BACKUP.get("" + ITEMS_LOGS_BACKUP.firstEntry()));
				A3.ITEMS_LOGS.put("" +ITEMS_LOGS_BACKUP.firstEntry(), ITEMS_LOGS_BACKUP.get("" +ITEMS_LOGS_BACKUP.firstEntry()));
				ITEMS_LOGS_BACKUP.remove("" + ITEMS_LOGS_BACKUP.firstEntry());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Log File ERROR.");
		}
	}
}
