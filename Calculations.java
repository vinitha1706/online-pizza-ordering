package PizzaVerion2;

import Pizza.Cart;

public class Calculations extends Cart {

			int pizzaquantity,sidesquantity,beveragesquantity;
			int pizzatotal,sidestotal,beveragestotal,size;
			String totalQuantity() 
			{
				int totalquantity =pizzaquantity+sidesquantity+beveragesquantity;
				return "Total quantity is: " + totalquantity;
			}

			String totalPrice() 
			{
				int totalprice = pizzatotal+sidestotal+beveragestotal;
				return "Total price: " + totalprice;
			}

}
