package vendingSystem;

public class EngineerLogin extends MainSystem {
	
	int engineerID[] ,engineerCode;
	String engineerName;
	
	static int [] engineerCodes = {672519, 576839, 001100};
	
	int[][] engineers = {
			{1 , 672519,},
			{2 , 576839,},
			{3 , 001100,}
			
	};
	
	// THESE ARRAYS WHERE ENDED TO BE USED AS WAYS OF CHECKING WHICH ENGINEERS HAD ACCESSED THE SYSTEM
	
	String[][] engineerNames = {
			{"1" , "John",},
			{"2" , "Sarah",},
			{"3" , "Callum",}
			
	};
	
		public static boolean engineerCodeVerification (String code)  {
			
			int newCode = Integer.parseInt(code);
			
			for (int i = 0; i ==3; i++) {
				if ( engineerCodes[i] == newCode  ) {
					
					System.out.println("code verified");
					engineerCodeVerified = true;
					
				}
				else {
					System.out.println("code not verified");
					engineerCodeVerified = false;
				}
		}
			return engineerCodeVerified;
	
	}

}

	

