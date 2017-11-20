package eecs2011a3;

import java.util.Date;

public class EntryValue {
	Parts sensor;
	Errors error;
	Date date;

	public EntryValue(Parts sensor, Errors error) {
		this.sensor = sensor;
		this.error = error;
		this.date = new Date();
	}
}
