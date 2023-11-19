package courseworkRef;

public class CoinCollector {
		

	public static void getBalance () {
		
		
		System.out.println("Balance = " + MainSystem.balance + "p");
	}
		
	public static int add10p() 	{
		
		return MainSystem.balance += 10;
	}
	
	public static int add20p() 	{
		
		return MainSystem.balance += 20; // Update balance in MainSystem
	}
	
	public static int add50p()	{
		
		return MainSystem.balance += 50; // Update balance in MainSystem
	}
	
	public static int add100p()	{
		
		return MainSystem.balance += 100; // Update balance in MainSystem
	}
	public static int resetBalance(int balance) {
		MainSystem.balance = 0;
		return balance;
	}
	}

 