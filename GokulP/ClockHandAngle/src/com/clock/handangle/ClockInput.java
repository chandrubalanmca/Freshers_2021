package com.clock.handangle;

import java.util.*;

public class ClockInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String timeInput = sc.next();
		String[] time = timeInput.split(":");
		int hours = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		int seconds = Integer.parseInt(time[2]);

		ClockHandAngles clockHandAngles = new ClockHandAngles(hours, minutes, seconds);
		
		//Angle between HoursHand and MinuteHand
		System.out.println("� HM ="+clockHandAngles.hourAndMinuteAngle()+"�");
		
		//Angle between HoursHand and SecondsHand
		System.out.println("� HS ="+clockHandAngles.hourAndSecondsAngle()+"�");
		
		//Angle between SecondsHand and MinuteHand
		System.out.println("� SM ="+clockHandAngles.secondsAndMinuteAngle()+"�");

	}

}
