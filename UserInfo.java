package PizzaVerion2;


import java.util.ArrayDeque;
	import java.util.Scanner;
public class UserInfo {
		public String name;
		public static String address;
		public static String email;
		public String Email;
		public static String phoneNo;
		public static String mobileno;

		public void Userinfo() {
	        Scanner sc=new Scanner(System.in);
			Payment p=new Payment();
			
		    System.out.println("Enter Your Address :");
		    address=sc.nextLine();
		   email= p.validemail(Email);
		   phoneNo= p.isvalidMobileNum(mobileno);
		      
		}

		@Override
		public String toString() {
			return "UserInfo [ address=" + address + ", email=" + email + ", phoneNo=" + phoneNo + "]";
		}
		static void user_input() {
			ArrayDeque<UserInfo> adq=new ArrayDeque<UserInfo>();
			adq.push(new UserInfo());
			for(UserInfo elements:adq) {
			System.out.println(elements+"\n");
		}
		}
				
}
