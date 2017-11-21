package eecs2011a3;

public class TEST_CASES {
	public static void runTestsVersion1() {
		Log.clearLog(); // starts with a clean log (for testing)
		A3Version1 a3 = new A3Version1();
		EntryValue ev = a3.getInstances(Parts.FRONT_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);
		EntryValue ev2 = a3.getInstances(Parts.BRAKES, Errors.B01_NO_BRAKES);
		EntryValue ev3 = a3.getInstances(Parts.OIL, Errors.P99_LOW_PRESSURE);
		EntryValue ev4 = a3.getInstances(Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);

		EntryValue ev5 = a3.getInstances(Parts.BACK_RIGHT_TIRE, Errors.P88_HIGH_PRESSURE);
		System.out.println(ev);
		System.out.println();
		System.out.println(ev2);
		System.out.println();
		System.out.println(ev3);
		System.out.println();
		System.out.println(ev4);
		System.out.println();
		System.out.println( ev5);
		a3.run();
		Log.saveLog();
		Log.saveLog();
	}

	public static void runTestsVersion2() {
	
	}

}
