package com.impigier.task;

import java.util.Scanner;

public class AnalogClock {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the hour");
		int hour =scan.nextInt();
		
		System.out.println("Enter the minute");
		int minute =scan.nextInt();
		
		System.out.println("Enter the seconds");
		int seconds =scan.nextInt();
		
		AnalogClockAngle analogclockAngle = new AnalogClockAngle(hour, minute, seconds);
		
		System.out.println("hour and minute:"+analogclockAngle.angleBetweenHourAndMinute());
		System.out.println("hour and seconds:"+analogclockAngle.angleBetweenHourAndSeconds());
		System.out.println("seconds and minute:"+analogclockAngle.angleBetweenMinuteAndSeconds());
		scan.close();
	}

}
