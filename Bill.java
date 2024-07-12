package PizzaVerion2;

public class Bill {

		int sno,price,quantity,total;
	   	String items;
public Bill() {
			
		}
		
		public Bill(int sno,String items, int price, int quantity, int total)  //default constructor
		{
			super();
			this.sno=sno;
			this.items = items;
			this.price = price;
			this.quantity = quantity;
			this.total = total;
		} 
		
		public String setlength(String len)
		{
			for(int i=0;i<=len.length();i++)
			{
				if(len.length()==30)
					break;
				else
				{
					len=len+" ";
					setlength(len);
				}
			}
			return len;
				
		}
		public String toString()          // return the string represention values
		{
			String s=Integer.toString(sno);
			String p=Integer.toString(price);
			String q=Integer.toString(quantity);
			String t=Integer.toString(total);
		
            return s+". "+setlength(items)+"               "+p+"           "+q+"       "+t;
		

	}}

