package PizzaVerion2;

	import java.util.ArrayDeque;
	import java.util.Scanner;

	public class Rating {
		void rating() {
			
			
			ArrayDeque<String> deque = new ArrayDeque<String>();  
			   deque.add("We Would Like To know Your feedback?");    
			   deque.add("Select a no based on our services so that we can serve you etter next time");     
			   deque.add("5-Excellent Service");    
			   deque.add("4-Very Good Service");
			   deque.add("3-Good Service");
			   deque.add("2-Satisfactory");
			   deque.add("1-Poor");
			   deque.add("USE NUMBERS BETWEEN 1 TO 5 TO RATE OUR SERVICES");
			   for (String str : deque) {  
			   System.out.println(str);  
			   }  
		Scanner s=new Scanner(System.in);
		
		int fdno=s.nextInt();
		try
		{
		if(fdno<=5)
		  System.out.println("Thank You for your feedback ,We are pleased to know your kind feedback.\n HOPE TO SEE YOU AGAIN!");
		   
		else {
			System.out.println("Kindly enter a No. between 0 to 5.....");
			s.nextInt();
		}
		}
	catch( ArithmeticException e)
		    {
			System.out.println("Kindly enter a No. between 0 to 5");
			s.nextInt();
		    }

		}
		
		public static void main(String[] args) {
			
	}
	

}
