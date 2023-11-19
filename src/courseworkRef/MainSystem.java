package courseworkRef;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainSystem {

	static Scanner scan = new Scanner (System.in);

	// Initialise all needed variables
	
	//Initial Commit

	static int balance =0;

	
	float paymentRequired;

	boolean productCodeVerified;

	static boolean engineerCodeVerified = false;

	static String pickedProduct;
	


	public static void main(String[] args) throws IOException {

		//OPEN BY SHOWING THE MENU OF THE VENDING MACHINE

		Products.showproducts(args);

		System.out.print("Enter your selection \n");

		pickedProduct = scan.next();
		
		
		int chosenProduct = getChosenProduct(pickedProduct);
		
		if ( chosenProduct == 99) {
			System.out.println("Please enter engineer code");
			String code = scan.next();
			EngineerLogin.engineerCodeVerification(code);
			restartFunction() ;
		}	
		
		//HERE I MADE A LOGIN FUNCTION FOR THE ENGINEERS HOWEVER AS I NEVER GOT AROUND TO THE FORMS THIS LEADS NOWHERE
		
		if (chosenProduct != 99) {
			
			// Fetch the product price
		    float productPrice = getPrice(chosenProduct);
		    
		    if (productPrice < 0.00) {
		        System.out.println("Product not found.");
		        return; // Exit if product not found
		    }
			
			System.out.println("Price of the product is: £" + productPrice );

	        boolean transactionCancelled = false;
	        
	        // Convert productPrice to pence
	        int productPriceInPence = (int) (productPrice * 100);

	        
	        while (productPriceInPence > balance && !transactionCancelled) {
	 
		        System.out.println("Please enter coins");
		        System.out.println("1 = 100p");
		        System.out.println("2 = 50p");
		        System.out.println("3 = 20p");
		        System.out.println("4 = 10p");
		        System.out.println("5 = Cancel Transaction");

		        int choice = scan.nextInt();

		        switch (choice) {
		        
		    case 1:
				CoinCollector.add100p();
				CoinCollector.getBalance();
					
				break;

			case 2:
				CoinCollector.add50p();
				CoinCollector.getBalance();
				
				break;

			case 3:
				CoinCollector.add20p();
				CoinCollector.getBalance();
				
				break;

			case 4:
				CoinCollector.add10p();
				CoinCollector.getBalance();
				
				break;
				
			
			case 5:									
				cancelFunction();
				CoinCollector.resetBalance(balance);
				transactionCancelled = true;
				break;
		        }
		           
		        }  
	        
			if (balance >= productPriceInPence) {
            System.out.println("Transaction successful. Dispensing product.");}
            if (balance> productPriceInPence) {
                int change = balance - productPriceInPence;
                System.out.println("Please collect your change: " + change +"p");
                balance = 0;}
	        
		    
		        
		}
		restartFunction(); // Or handle the restart/cancellation appropriately
	}
	

	
	public static float getPrice(int chosenProduct) throws IOException {
	    String path = "/Users/danny/Desktop/Coursework/productList2.csv";
	    BufferedReader br = new BufferedReader(new FileReader(path));
	    String currentLine;
	    
	    br.readLine();

	    while ((currentLine = br.readLine()) != null) {
	        String[] values = currentLine.split("-");
	        int productCode = Integer.parseInt(values[0].trim()); // Assuming the product code is an integer

	        if (productCode == chosenProduct) {
	            float productPrice = Float.parseFloat(values[2].trim());
	            return productPrice;
	        }
	    }

	    br.close();
	    return -1; // Return -1 or throw an exception if the product code is not found
	}
	
	//CHANGING THE DATA TYPE SO THAT IT CAN BE USED TO SEARCH THROUGH PRODUCT ARRAY
	
	public static int getChosenProduct(String pickedProduct) throws IOException {

		int chosenProduct;
		chosenProduct = Integer.parseInt(pickedProduct);
		return chosenProduct;
	}	
	
	
	private static void cancelFunction() {
		CoinCollector.getBalance();
		System.out.println("Transaction canceled.");
		System.out.println("Your balance of " + balance + "p returned");
	}

	private static void restartFunction() {
		System.exit(0);

	}
}	

