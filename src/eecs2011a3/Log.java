package eecs2011a3;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class Log {
	private static final TreeMap<String, EntryValue> ITEMS_LOGS_BACKUP = new TreeMap<String, EntryValue>();
	private static final String FILENAME = "log.txt";

	public static void saveLog() {
		try {
			// Writes to a text file.
			PrintWriter out = new PrintWriter(FILENAME);
			int size = A3Version1.ITEMS_LOGS.size();
			for (int i = 0; i < size; i++) {
				out.println(A3Version1.ITEMS_LOGS.firstEntry());
				ITEMS_LOGS_BACKUP.put("" + A3Version1.ITEMS_LOGS.firstKey(),
						A3Version1.ITEMS_LOGS.get(A3Version1.ITEMS_LOGS.firstKey()));
				A3Version1.ITEMS_LOGS.remove("" + A3Version1.ITEMS_LOGS.firstKey());
			}
			out.close();
			for (int i = 0; i < size; i++) {
				A3Version1.ITEMS_LOGS.put("" + ITEMS_LOGS_BACKUP.firstKey(),
						ITEMS_LOGS_BACKUP.get(ITEMS_LOGS_BACKUP.firstKey()));
				ITEMS_LOGS_BACKUP.remove("" + ITEMS_LOGS_BACKUP.firstKey());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Log File ERROR.");
		}
	}

	public static void add(String priority, EntryValue ev) {

		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(FILENAME, true));
			bw.write(priority + "=" + ev);

			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void clearLog() {

		PrintWriter out;
		try {
			out = new PrintWriter(FILENAME);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
