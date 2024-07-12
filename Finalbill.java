package PizzaVerion2;

import Pizza.Main2;
import Pizza.UserInfo;

public class Finalbill {
		UserInfo ui=new UserInfo();
		Main2 m2=new Main2();

		void finalbill() {
		
	    System.out.println("                         RED ❤ BYTE PIZZA :)                               ");
	    System.out.println("-------------------------------------------------------------------------");
	    System.out.println("Name :"+m2.name+ "\t\tMobile no: "+ui.phoneNo);
	    System.out.println("Address : "+ui.address);
	    System.out.println("E-Mail : "+ui.email);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("                            Final Bill 📝                                       ");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Sno         Items                            Price      Quantity  TotalPrice");
		System.out.println("----------------------------------------------------------------------------");

	}
		void quotes() {
			 System.out.println("\tThanks for choosing RED ❤ BYTE PIZZA :), Enjoy your meal !..");
			  System.out.println("\t\tYour order will be delivered within 30 minutes!!!");
			  System.out.println("\t--------------------*x*x*x*x*x*x*x*x*x--------------------"); }
		}
