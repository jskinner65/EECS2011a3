package eecs2011a3;

import java.util.TreeMap;

public class A3Version1 implements TBD {
	public static final TreeMap<String, EntryValue> ITEMS_LOGS = new TreeMap<String, EntryValue>();

	public A3Version1() {
		; // intentionally blank
	}

	public void run() {

	}

	public EntryValue getInstances(Parts part, Errors error) {
		String priority = error.toString().substring(1,3);
		if (ITEMS_LOGS.containsKey("" + priority + ";"+ part.ordinal())) {
			return ITEMS_LOGS.get("" + priority + ";"+ part.ordinal());
		} else {
			EntryValue ev = new EntryValue(part, error);
			ITEMS_LOGS.put("" + priority+ ";"+ part.ordinal(), ev);
			Log.add("" + priority+ ";"+ part.ordinal(), ev);
			return ITEMS_LOGS.get("" + priority+ ";"+ part.ordinal());
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

	// ***************************************************************************************************
	// ***************************************************************************************************

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TEST_CASES.runTestsVersion1();
		Log.retrieveLog();
		TEST_CASES.runTestsVersion1();
		A3Version1 a3 = new A3Version1();
		
		a3.getInstances(Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);

	}
}
