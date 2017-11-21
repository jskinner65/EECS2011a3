package eecs2011a3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntryValue {
	Parts sensor;
	int priority;
	Errors error;
	Date date;

	public EntryValue(Parts sensor, Errors error) {
		this.sensor = sensor;
		this.error = error;
		this.date = new Date();
		setPriority();
	}
	
	public EntryValue(String fromLog) {
		System.out.println(fromLog.substring(fromLog.indexOf(" ")+1,fromLog.indexOf(",")));
		this.sensor = Parts.valueOf(fromLog.substring(fromLog.indexOf(" ")+1,fromLog.indexOf(",")));
		fromLog = fromLog.substring(fromLog.indexOf(",")+1);
		System.out.println(fromLog.substring(fromLog.indexOf(" ")+1,fromLog.indexOf(",")));
		this.error = Errors.valueOf(fromLog.substring(fromLog.indexOf(" ")+1,fromLog.indexOf(",")));
		fromLog = fromLog.substring(fromLog.indexOf(",")+1);
		DateFormat format = new SimpleDateFormat("MMM dd HH:mm:ss yyyy");
		try {
			System.out.println(fromLog.substring(11,26) + " " +  fromLog.substring(31));
			this.date = format.parse(fromLog.substring(11,26) + " " + fromLog.substring(31));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPriority();
	}
	
	public void setPriority() {
		this.priority = Integer.parseInt(error.toString().substring(1,2));
	}
	
	public String toString() {
		return "Part: " + sensor.toString() + ",Error: " + error.toString() + ", Date: " + date;
	}

}

