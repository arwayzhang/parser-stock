package csv.parser;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		/////////input the filename and its path
		
		Scanner scanner = new Scanner( System.in );
		boolean bool = false;
		
    	String csvFile = "exit";
    	String PorC = "NULL";
    	int PorCindex = 0;
    	
    	System.out.print( "Type 'exit' if you want to quit.");
    	System.out.print("\n");
    	
    	if (bool ==false){
        	System.out.print( "Type the stock filename (including file path): " );
        	csvFile = scanner.nextLine();
        	bool = csvFile.equals("exit");
        }
    	
    	////////////choose the function to use
    	
    	while (bool ==false){
        	System.out.print( "Print the price of certain stock? [1]  OR Calculate the average price of certain date? [2]: " );
        	PorC = scanner.nextLine();
        	bool = PorC.equals("exit");
        	
        	if (!bool){
            	if (PorC.equals("1") || PorC.equals("2")){
            		if(PorC.equals("1")){
                        System.out.println("Print the price of certain stock!");
                        CSVReader.PrintPrice(csvFile);
            		}
            		if(PorC.equals("2")){
                        System.out.println("Calculate the average price of certain date!");
                        avgprice.AveragePrice(csvFile);
            		}
            		
            	}else{
            		System.out.println("No record found !");      		
            	}
        	}else{
        		System.out.println("No record found !");
        		scanner.close();
        		break;
        	}
        	
     	
        }
    		
    	scanner.close();
    	
	}

}
