package courseworkRef;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Products {


	public static void showproducts (String[] args) throws IOException  {

		MainSystem mainObject = new MainSystem();

		String path = "/Users/danny/Desktop/Coursework/productList2.csv";

		BufferedReader br = new BufferedReader(new FileReader(path));

		String currentLine;



		while ((currentLine = br.readLine()) != null)
		{ String []values = currentLine.split("-");
		System.out.println (currentLine);

		}

	}
	


}

