package eecs2011a3;

import java.util.TreeMap;

public class A3 implements TBD{
	public static final TreeMap<String, EntryValue> ITEMS_LOGS = new TreeMap<String, EntryValue>();
	
	
	public A3() {
		; // intentionally blank
	}

	public void run() {
		
	}
	
	public EntryValue getInstances(int priority, Parts part, Errors error) {
		if (ITEMS_LOGS.containsKey("" + priority)) {
			return ITEMS_LOGS.get("" + priority);
		}
		else {
			EntryValue ev =  new EntryValue(part, error);
			ITEMS_LOGS.put("" + priority, ev);
		
			return ITEMS_LOGS.get(""+priority);
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
		int priority = 6;
		EntryValue ev = a3.getInstances(priority, Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);
		int priority2 = 7;
		EntryValue ev2 = a3.getInstances(priority2, Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);
		int priority3 = 8;
		EntryValue ev3 = a3.getInstances(priority3, Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);
		int priority4 = 9;
		EntryValue ev4 = a3.getInstances(priority4, Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);
		int priority5 = 4;
		EntryValue ev5 = a3.getInstances(priority5, Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);
		System.out.println("Priority: " +priority +"\n" + ev);
		System.out.println();
		System.out.println("Priority: " +priority2 +"\n" + ev2);
		System.out.println();
		System.out.println("Priority: " +priority3 +"\n" + ev3);
		System.out.println();
		System.out.println("Priority: " +priority4 +"\n" + ev4);
		System.out.println();
		System.out.println("Priority: " +priority5 +"\n" + ev5);

		
		
		
		Log.saveLog();
		
		
		
		a3.run();
	}
}
