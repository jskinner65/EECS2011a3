package eecs2011a3;

import java.util.TreeMap;

public class A3 implements TBD{
	public static final TreeMap<String, String> ITEMS_LOGS = new TreeMap<String, String>();
	
	
	public A3() {
		; // intentionally blank
	}

	public void run() {
		
	}
	
	public String getInstances(Parts part) {
		String item = part.toString();
		if (ITEMS_LOGS.containsKey(item)) {
			return ITEMS_LOGS.get(item);
		}
		else {
			ITEMS_LOGS.put(item, "00, error");
		
			return ITEMS_LOGS.get(item);
		}
	}

	@Override
	public void viewLog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveLog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retreiveLog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToLog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reorganize() {
		// TODO Auto-generated method stub
		
	}

	
	
	//***************************************************************************************************
	//***************************************************************************************************
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A3 a3 = new A3();
		a3.run();
	}
}
