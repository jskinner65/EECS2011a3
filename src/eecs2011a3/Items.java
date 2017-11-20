package eecs2011a3;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/*  Each item has its own log so a mechanic can easily find a log based on an item
 * 
 * 
 */



public class Items {
	int priority;
	Parts item;
	AVLTreeMap<Date, String> Log = new AVLTreeMap<Date, String>();
	
	public Items(Parts item, String error) {
		this.item = item;
		addLog(error);
	}
	
	private void addLog(String Error) {
		Log.put(new Date(), Error);  //Error has priority built into it  ("pp, Error")
	}
	
	private void adjustPriority() {
		for (int i = 0; i<Log.size(); i++) {
			if (priority < Integer.parseInt(Log.get(i).substring(0,2))) {
				priority =  Integer.parseInt(Log.get(i).substring(0,2));  //sets highest priority found to this.priority
			}
		}
	}
	
	
	
	
}
