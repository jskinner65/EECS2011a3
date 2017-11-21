package eecs2011a3;

public class TEST_CASES {
	public static void runTestsVersion1() {
		Log.clearLog(); // starts with a clean log (for testing)
		A3Version1 a3 = new A3Version1();
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
		System.out.println("Priority: " + priority + "\n" + ev);
		System.out.println();
		System.out.println("Priority: " + priority2 + "\n" + ev2);
		System.out.println();
		System.out.println("Priority: " + priority3 + "\n" + ev3);
		System.out.println();
		System.out.println("Priority: " + priority4 + "\n" + ev4);
		System.out.println();
		System.out.println("Priority: " + priority5 + "\n" + ev5);
		a3.run();
		Log.saveLog();
		Log.saveLog();
	}

	public static void runTestsVersion2() {
		Log.clearLog(); // starts with a clean log (for testing)
		A3Version1 a3 = new A3Version1();
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
		System.out.println("Priority: " + priority + "\n" + ev);
		System.out.println();
		System.out.println("Priority: " + priority2 + "\n" + ev2);
		System.out.println();
		System.out.println("Priority: " + priority3 + "\n" + ev3);
		System.out.println();
		System.out.println("Priority: " + priority4 + "\n" + ev4);
		System.out.println();
		System.out.println("Priority: " + priority5 + "\n" + ev5);
		a3.run();
		Log.saveLog();
		Log.saveLog();
	}

}
