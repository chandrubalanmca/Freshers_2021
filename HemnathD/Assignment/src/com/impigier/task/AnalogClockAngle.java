package com.impigier.task;



public class AnalogClockAngle {
	public int angle;
	private int hourneedle;
	private int minuteneedle;
	private int secondsneedle;
	
	public AnalogClockAngle(int hour, int minute, int seconds) {
		
		hourneedle=(hour%12+(minute/60))*30;
		
		minuteneedle=(minute * 6)+(seconds/10);
		
		secondsneedle=(seconds* 6);
	}

	
	
	public int angleBetweenHourAndMinute(){
		angle= Math.abs(hourneedle-minuteneedle);
		if(angle>180) {
			angle = 360 - angle;
		}
		return angle;
	}
	
	public int angleBetweenHourAndSeconds(){
		angle= Math.abs(hourneedle-secondsneedle);
		if(angle>180) {
			angle = 360 - angle;
		}
		return angle;
	}
	
	public int angleBetweenMinuteAndSeconds(){
		angle= Math.abs(minuteneedle-secondsneedle);
		if(angle>180) {
			angle = 360 - angle;
		}
		return angle;
	}
	
}
