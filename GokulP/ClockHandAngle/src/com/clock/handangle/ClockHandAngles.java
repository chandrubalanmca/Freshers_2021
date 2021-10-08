package com.clock.handangle;

public class ClockHandAngles {
	private int hours;
	private int minutes;
	private int seconds;
	private float hourHandAngle;
	private float minuteHandAngle;
	private float secondsHandAngle;
	public float requiredAngle;

	public ClockHandAngles(int hours, int minutes, int seconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		hourHandAngle=(hours%12+(float)(minutes/60))*30;
		minuteHandAngle=(minutes*6)+(seconds/10);
		secondsHandAngle=seconds*6;
	}
	
	public float hourAndMinuteAngle() {
		requiredAngle=Math.abs(hourHandAngle-minuteHandAngle);
		return requiredAngle>180?360-requiredAngle:requiredAngle;
	}
	
	
	public float hourAndSecondsAngle() {
		requiredAngle=Math.abs(hourHandAngle-secondsHandAngle);
		return requiredAngle>180?360-requiredAngle:requiredAngle;
	}
	
	public float secondsAndMinuteAngle() {
		requiredAngle=Math.abs(secondsHandAngle-minuteHandAngle);
		return requiredAngle>180?360-requiredAngle:requiredAngle;
	}

}
