package com.app;
import java.util.Scanner;

public class CalculatorApp {
	public static void main(String[] args) {
		try (Scanner scn= new Scanner(System.in)){
			while(true) {
				
				System.out.println("");
				System.out.println("Enter the numbers to perform the operation");
				
				System.out.println("Enter the first number : ");
				int x=scn.nextInt();
				
				System.out.println("Enter the second number :");
				int y=scn.nextInt();
				
				System.out.println("Choose the operation you want to perform ");
				System.out.println("Choose 1 for ADDITION");
				System.out.println("Choose 2 for SUBTRACTION");
				System.out.println("Choose 3 for DIVISION");
				System.out.println("Choose 4 for MULTIPLICATION");
				System.out.println("Choose 5 for MODULUS");
				System.out.println("Choose 6 to EXIT");
				
				int n=scn.nextInt();
				switch (n) {
				
				case 1: 
					int add;
					add=x + y;
					System.out.println("Result: "+add);   
					break;
					
				case 2: 
					int sub;
					sub=x - y;
					System.out.println("Result: "+sub);   
					break;
					
				case 3: 
					int div;
					div=x / y;
					System.out.println("Result: "+div);   
					break;
					
				case 4: 
					int mul;
					mul=x * y;
					System.out.println("Result: "+mul);   
					break;
					
				case 5: 
					int mod;
					mod=x % y;
					System.out.println("Result: "+mod);   
					break;
					
				case 6: 
					System.exit(0);
					
					
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + n);
				}
			}
		}
	}
}



