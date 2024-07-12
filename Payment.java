package PizzaVerion2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Payment {
		UserInfo ui=new UserInfo();
		
		public String validcard(String card) {
			Scanner sc=new Scanner(System.in);
	         card = sc.nextLine();

	         if (card.matches("[0-9]{16}")) {
	             System.out.println("card number accepted");
	      return card;
	         }
	         else
	                 System.out.println(" Re-enter your card number: ");
	         return validcard(card); 
		}
		public String validupi(String upi) {
			Scanner sc=new Scanner(System.in);
	         upi = sc.nextLine();

	         if (upi.matches("[0-9]+@[a-z]{1,10}")) {
	             System.out.println("UPI ID accepted");
	      return upi;
	         }
	         else
	                 System.out.println(" Re-enter your UPI ID: ");
	         return validupi(upi); 
		}

		public String validemail(String Email) {
			Scanner sc=new Scanner(System.in);
			 System.out.println("Enter your email: ");
	         Email = sc.nextLine();

	         if (Email.matches("[\\w[0-9]]+@[\\w]+\\.[a-zA-Z]{2,3}")) {
	             System.out.println("Email accepted");
	      return Email;
	         }
	         else
	                 System.out.println(" Re-enter your email: ");
	         return validemail(Email); 
		}
		public String isvalidMobileNum(String mobileno) {
			Scanner sc=new Scanner(System.in);
			 System.out.println("Enter your Phone number: ");
	         mobileno= sc.nextLine();

	         if (mobileno.matches("[6-9][0-9]{9}")) {
	             System.out.println("Phone number accepted");
	      return mobileno ;
	         }
	         else
	                 System.out.println(" Re-enter your Phone number: ");
	         return isvalidMobileNum(mobileno); 
		}
		public String validname(String Name) {
			Scanner sc=new Scanner(System.in);
	         Name = sc.nextLine();
	         if (Name.matches("[a-zA-z]{1,30}")) {
	           return Name;
	         }
	         else
	                 System.out.println("Alphabets Only!" );
	         return validname(Name); 
		}

}
