package com.thoughtworks.conference.tracker.helper;

public class TimeSlotsDTO {
	
	private int startTimeMinutes;
	private int endTimeMinutes;
	
	/*
	 * @params startTimeMinutes, endTimeMinutes is the minute representation from 
	 * 12AM midnight
	 */
	public TimeSlotsDTO(int startTimeMinutes, int endTimeMinutes) {
		this.startTimeMinutes = startTimeMinutes;
		this.endTimeMinutes = endTimeMinutes;
	}

	public int getStartTimeMinutes() {
		return startTimeMinutes;
	}

	public void setStartTimeMinutes(int startTimeMinutes) {
		this.startTimeMinutes = startTimeMinutes;
	}

	public int getEndTimeMinutes() {
		return endTimeMinutes;
	}

	public void setEndTimeMinutes(int endTimeMinutes) {
		this.endTimeMinutes = endTimeMinutes;
	}
	
	public String resolveTimeFromMins(int minutes) {
		String zeroPad="0";
		String timeDur="AM";
		int hrs= minutes/ 60;
		String hrString="";
		String minString="";
		if(hrs>12){
			hrs= hrs-12;
			timeDur= "PM";
		}
		hrString=String.valueOf(hrs);
		
		if(hrString.length() !=2) {
			hrString= zeroPad.concat(hrString);
		}
		minString=String.valueOf(minutes%60);
		
		if(minString.length() != 2) {
			minString= zeroPad.concat(minString);
		}
		return hrString + ":"+ minString + timeDur;
	}
	
}
