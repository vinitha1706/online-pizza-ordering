package PizzaVerion2;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
		
		public static String name = "",cardNo,id;
		public String total_amount;
		public static void main(String[] args) throws Exception
		{int pizzaprice=0,beverageprice=0, sidesprice=0;
		int ch,selectitem,sno=1;
		int total_amount=0;
		int size;
		String query1,query2,query3;
		String itemname=" ",number = " ";
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");		  
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL","system","system");	
			Statement statement=connection.createStatement();
			 
			ArrayDeque<Bill> billingdata =new ArrayDeque<>();		   //To store the user choice of pizza                                   
			Calculations cal=new Calculations();      //Object declaration of classes
			Main m=new Main();
			Bill bill=new Bill();
		    Payment p=new Payment();
		    Cart cart=new Cart();
			UserInfo ui=new UserInfo();
			Rating r=new Rating();
			Finalbill fb=new Finalbill();
			Scanner sc=new Scanner(System.in);
			boolean user_input1 = false;
			System.out.println("=========Red ❤️ Byte Pizza🍕 :)==========");
			System.out.println("    Meals made Better Together :)    ");
			System.out.println();
		  	 Scanner scan = new Scanner(System.in);
		       System.out.println("HELLO,My name is Red❤!. May i know your good name?");
		   	 name=p.validname(name);
		   
			boolean user_input = false;
			int choice=0;
			while(!user_input){
				try {
					System.out.println("Good day! "+name+"('◕‿◕') , Would you like to order anything.");
					System.out.println("1.Yes   2.No");
					 choice=sc.nextInt();
			     	user_input=true;
				}catch(InputMismatchException ime) {	
					System.out.println("Enter a valid number....");
					user_input=false;
					sc.nextLine();
					continue;
				}
			}
			try {
			while(choice>=0 |choice<0) {
				if(choice==1) {		
					while( !user_input1)
			{
				try 
				{
					System.out.println("What do you like to order ?");
					System.out.println("1.Veg Pizza   2.Non Veg Pizza  3.Beverages  4.Sides  5.Exit ");
				selectitem=sc.nextInt();
				
				while(selectitem>5 |selectitem<=0 )
				{
					System.out.println("Enter a valid choice");
					ch=sc.nextInt();
				}	
				if(selectitem==1) {
					number="veg_menu";}
				else if(selectitem==2) {
					number="nonveg_menu";}
				if(selectitem==1)//For Veg Pizza
				{
					System.out.println("============Veg 🍕 Menu==============");
					System.out.println("S.No\tItems\t\t\tSmall\tMedium\tLarge");
					query1="select * from "+number;
					ResultSet resultset11=statement.executeQuery(query1);
					while(resultset11.next() !=false) {
				        System.out.println(resultset11.getInt(1)+"\t"+resultset11.getString(2)+"\t  "+resultset11.getInt(3)+"\t "+resultset11.getInt(4)+"\t"+resultset11.getInt(5));}
					System.out.println("---------------------------------------------------------");
					System.out.println("Whoooo good choice!!Select the item from the menu:");}	
				else if(selectitem==2) {
					System.out.println("==============Non Veg 🍗 Menu===========");
					System.out.println("S.No\tItems\t\t\tSmall\tMedium\tLarge");
					query1="select * from "+number;
					ResultSet resultset11=statement.executeQuery(query1);
					while(resultset11.next() !=false) {
				        System.out.println(resultset11.getInt(1)+"\t"+resultset11.getString(2)+"\t  "+resultset11.getInt(3)+"\t "+resultset11.getInt(4)+"\t"+resultset11.getInt(5));}
					System.out.println("---------------------------------------------------------");		
					System.out.println("Good selection!!!Select the item from the menu:");}	
				if(selectitem==1|selectitem==2) {
					
					ch=sc.nextInt();
				while(ch>4 |ch<=0 )
				{
					System.out.println("Enter a valid choice");
					ch=sc.nextInt();
				}		
				System.out.println("Enter size:  1.Small  2.Medium  3.Large  ");		
				size = sc.nextInt();
				while(size>3 |size<=0 )
				{
					System.out.println("Enter a valid choice");
					size=sc.nextInt();
				}
				if(size==1)
				{query1="select * from "+number;
				ResultSet resultset1=statement.executeQuery(query1);
					while(resultset1.next())
					{
						query2="SELECT ITEMS from "+number+" where sno="+ch;
						query3 ="SELECT SMALL from "+number+" where sno="+ch;

						ResultSet resultset2=statement.executeQuery(query2);
						while(resultset2.next())
						{
							itemname=resultset2.getString("ITEMS");
							ResultSet resultset3=statement.executeQuery(query3);
							while(resultset3.next())
							{
								pizzaprice=resultset3.getInt("SMALL");
							}
						}
						
					}				
				}				
				if(size==2) 
				{query1="select * from "+number;
				ResultSet resultset1=statement.executeQuery(query1);
					while(resultset1.next())
					{
						query2="select Items from "+number+" where sno="+ch;
						query3 ="select medium from "+number+" where sno="+ch;

						ResultSet resultset2=statement.executeQuery(query2);
						while(resultset2.next())
						{
							itemname=resultset2.getString("ITEMS");
							ResultSet resultset3=statement.executeQuery(query3);
							while(resultset3.next())
							{
								pizzaprice=resultset3.getInt("MEDIUM");
							}
						}
					}						
				}
				if(size==3) 
				{query1="select * from "+number;
				ResultSet resultset1=statement.executeQuery(query1);
					while(resultset1.next())
					{
						query2="select Items from "+number+" where sno="+ch;
						query3 ="select large from "+number+" where sno="+ch;
						ResultSet resultset2=statement.executeQuery(query2);
						while(resultset2.next())
						{
							itemname=resultset2.getString("Items");
							ResultSet resultset3=statement.executeQuery(query3);
							while(resultset3.next())
							{
								pizzaprice=resultset3.getInt("LARGE");
							}
						}
					}						
				}
				System.out.println("Enter the quantity ");
				cal.pizzaquantity=sc.nextInt();
				while(cal.pizzaquantity<=0)
				{
					System.out.println("Enter a valid choice");
					cal.pizzaquantity=sc.nextInt();
				}
				cal.pizzatotal=cal.pizzaquantity*pizzaprice;
				billingdata.add(new Bill(sno++,itemname,pizzaprice,cal.pizzaquantity,cal.pizzatotal));              //calls by using the arraydeque object and add that into Bill class   
			    total_amount+=(cal.pizzatotal);         
			    }

				else if(selectitem==3)//For Beverages
				{
					System.out.println("=========BEVARAGES MENU==========");
					System.out.println("SNO\tITEMS\t\tPRICE");
					query1="select * from bevarages";
					ResultSet resultset11=statement.executeQuery(query1);	
					  while(resultset11.next() !=false) {
					        System.out.println(resultset11.getInt(1)+"\t"+resultset11.getString(2)+"\t "+resultset11.getInt(3));
				       }
					System.out.println("----------------------------------");
					System.out.println("What do you wonna order:)");		
					ch=sc.nextInt();
					
					
					while(ch>4 |ch<=0)
					{
						System.out.println("Enter a valid choice");
						ch=sc.nextInt();
					}query1="select * from bevarages";
					ResultSet resultset1=statement.executeQuery(query1);
					while(resultset1.next())
					{
						query2="select ITEMS from bevarages where sno="+ch;
						query3 ="select price from bevarages where sno="+ch;
						ResultSet resultset2=statement.executeQuery(query2);
						while(resultset2.next())
						{
							itemname=resultset2.getString("ITEMS");
							ResultSet resultset3=statement.executeQuery(query3);
							while(resultset3.next())
							{
								beverageprice=resultset3.getInt("price");
							}
						}
					}			
					System.out.println("How many  juices do you want to order : ");
					cal.beveragesquantity=sc.nextInt();		
					while(cal.beveragesquantity<=0)
					{
						System.out.println("Enter a valid choice");
						cal.beveragesquantity=sc.nextInt();
					}
					cal.beveragestotal=cal.beveragesquantity*beverageprice;
				    billingdata.add(new Bill(sno++,itemname,beverageprice,cal.beveragesquantity,cal.beveragestotal));    			//calls by using the arraydeque object and add that into Bill class 
				    total_amount+=(cal.beveragestotal);  
				}
				else if(selectitem==4)//For sides
				{
					System.out.println("=========SIDES MENU==========");
					System.out.println("SNO\tITEMS\t\tPRICE");	
					query1="select * from sides";
					ResultSet resultset11=statement.executeQuery(query1);
					  while(resultset11.next() !=false) {
					        System.out.println(resultset11.getInt(1)+"\t"+resultset11.getString(2)+"\t "+resultset11.getInt(3));
				       }
					System.out.println("----------------------------------");
					System.out.println("Which Side item do you like to order");		
					ch=sc.nextInt();
						
					while(ch>4)
					{
						System.out.println("Enter a valid choice");
						ch=sc.nextInt();
					}query1="select * from sides";
					ResultSet resultset1=statement.executeQuery(query1);
					while(resultset1.next())
					{
						query2="select ITEMS from sides where sno="+ch;
						query3 ="select price from sides where sno="+ch;
						ResultSet resultset2=statement.executeQuery( "select items from sides where sno="+ch);
						while(resultset2.next())
						{
							itemname=resultset2.getString("ITEMS");
							ResultSet resultset3=statement.executeQuery(query3);
							while(resultset3.next())
							{
								sidesprice=resultset3.getInt("price");
							}
						}
					}			
					System.out.println("Enter the quantity ");
					cal.sidesquantity=sc.nextInt();
					while(cal.sidesquantity<=0)
					{
						System.out.println("Enter a valid choice");
						cal.sidesquantity=sc.nextInt();
					}
					cal.sidestotal=cal.sidesquantity*sidesprice;
				    billingdata.add(new Bill(sno++,itemname,sidesprice,cal.sidesquantity,cal.sidestotal));    			//calls by using the arraydeque object and add that into Bill class 
				    total_amount+=(cal.sidestotal);		
				}
				
				else if(selectitem==5){                                                     //to exit after completing the order
						System.out.println("Please check for any selected items to checkout...");
						System.out.println("1.yes  2.no");
						int select=sc.nextInt();
						if(select==1) {
							break;
						}
						else
							System.out.println("Thanks for visiting .....");
						    return;
					} }						    
				catch(InputMismatchException ime) 
				{	
					System.out.println("Please give a number not letters");
					user_input1 = false;
					sc.nextLine();
					continue;
				}
				
			   
				}
			
			 ui.Userinfo();
	         fb.finalbill();
			for (Bill elements : billingdata)                                                                                //Displays the bill
				System.out.println(elements + "\n");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                                          Grand Total:                "+total_amount);		
			System.out.println("----------------------------------------------------------------------------");
			
				System.out.println("Please Enter the mode of Payement:");
				System.out.println("1.UPI  2.Card  3.Cash on Delivery");
				int pay=sc.nextInt();
				switch(pay) {
				case 1:{
				System.out.println("Enter your UPI id:");
					id=p.validupi(id);
					fb.quotes();
				r.rating();
					
				PrintStream console = new PrintStream("E:\\BILL.txt");
				System.setOut(console);
			         fb.finalbill();
					for (Bill elements : billingdata)                                                                                //Displays the bill
						System.out.println(elements + "\n");
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("                                          Grand Total:                "+total_amount);		
					System.out.println("----------------------------------------------------------------------------");
					fb.quotes();
					console.close();
					break;}
			case 2:
			{
		    	System.out.println("Enter 16-Digit number: ");
		       
		           cardNo = p.validcard(cardNo);
				
					fb.quotes();
					 r.rating();
					  PrintStream console = new PrintStream("E:\\BILL.txt");
					System.setOut(console);

			         fb.finalbill();
					for (Bill elements : billingdata)                                                                                //Displays the bill
						System.out.println(elements + "\n");
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("                                          Grand Total:                "+total_amount);		
					System.out.println("----------------------------------------------------------------------------");
					fb.quotes();
					
					 console.close();}
				
			case 3: {
			           fb.quotes();
			           r.rating();
				PrintStream console = new PrintStream("E:\\BILL.txt");
				System.setOut(console);
				fb.finalbill();
				for (Bill elements : billingdata)                                                                                //Displays the bill
					System.out.println(elements + "\n");
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                          Grand Total:                "+total_amount);		
				System.out.println("----------------------------------------------------------------------------");
				fb.quotes();
				console.close();
			}
		}}else if(choice==2)
		{
			System.out.println("Please try to order next time....");
			return;
			
		}else {
			System.out.println("Please enter a valid input...");
			System.out.println("Good day! "+name+"('◕‿◕') , Would you like to order anything.");
			System.out.println("1.Yes   2.No");
			 choice=sc.nextInt();
			continue;
		}}}catch(InputMismatchException ime) {
			System.out.println("Looking like you entered something wrong ....");
			sc.nextInt();
			
		
		}
	}

		

}
