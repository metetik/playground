package com.luv2code.springdemo1;

public class MyApp {

	public static void main(String[] args) {
		ICoach theCoach = new BaseballCoach();

		System.out.println(theCoach.getDailyWorkout());
	}

}
