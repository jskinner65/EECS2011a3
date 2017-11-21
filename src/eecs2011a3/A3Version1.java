package eecs2011a3;

import java.util.TreeMap;

public class A3Version1 implements TBD {
	public static final TreeMap<String, EntryValue> ITEMS_LOGS = new TreeMap<String, EntryValue>();

	public A3Version1() {
		; // intentionally blank
	}

	public void run() {

	}

	public EntryValue getInstances(int priority, Parts part, Errors error) {
		if (ITEMS_LOGS.containsKey("" + priority)) {
			return ITEMS_LOGS.get("" + priority);
		} else {
			EntryValue ev = new EntryValue(part, error);
			ITEMS_LOGS.put("" + priority, ev);
			Log.add("" + priority, ev);
			return ITEMS_LOGS.get("" + priority);
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
		TEST_CASES.runTestsVersion1();
	}
}
