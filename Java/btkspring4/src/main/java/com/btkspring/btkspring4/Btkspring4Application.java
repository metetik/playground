package com.btkspring.btkspring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Btkspring4Application {

	public static void main(String[] args) {
		//SpringApplication.run(Btkspring4Application.class, args);
		Class1 c1 = new	Class1();
		System.out.println(c1.method1());
		System.out.println(c1.method1(1));
	}

}
