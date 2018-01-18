package csv.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CSVReader {

    public static void PrintPrice(String csvFile) {
    	
    	///////////input the information of target stock
    	Scanner scanner = new Scanner( System.in );
    	
    	String symbol = "NONE";
    	String year = null;
    	String month = null;
    	String day = null;
    	String goal = "0";
    	
    	String date = null;
    	int goalindex = 0;
    	String lowercasesymbol = null;
    	
    	boolean bool = false;


    	if (bool ==false){
            System.out.print( "Type the stock symbol for enquiry: " );
            symbol = scanner.nextLine();
            bool = symbol.equals("exit");
    	}

    	if (bool ==false){
        	System.out.print( "Type the year for the stock (yyyy): " );
        	year = scanner.nextLine();
        	bool = year.equals("exit");
    	}

    	if (bool ==false){
        	System.out.print( "Type the month for the stock (mm): " );
        	month = scanner.nextLine();
        	bool = month.equals("exit");
        }

    	if (bool ==false){
        	System.out.print( "Type the day for the stock (dd): " );
        	day = scanner.nextLine();
        	bool = day.equals("exit");
        }

    	if (bool ==false){
        	System.out.print( "Type the index of your goal (open [1] / high [2] / low [3] / close [4] / volume [5] / adj_close [6]): " );
        	goal = scanner.nextLine();
        	bool = goal.equals("exit");
        }

 	
    	date = year + "-" + month + "-" + day;
    	goalindex = Integer.parseInt(goal) + 1;
    	lowercasesymbol = symbol.toLowerCase();
    	
    	
    	/////////////find and print a metric price of a stock on demand

        BufferedReader br = null;
        String line = "";
        String separator = ",";
        int jobcomplete = 0;
        
        if (csvFile.equals("exit")){
        	System.out.println("No record found !");      	
        }else{
        	
            try {

                br = new BufferedReader(new FileReader(csvFile));
                String headerLine = br.readLine();
                String[] header = headerLine.split(separator);
                //System.out.println(headerLine);
                while ((line = br.readLine()) != null) {

                	String[] stock = line.split(separator);
                	
                	if (stock[0].toLowerCase().equals(lowercasesymbol) && stock[1].equals(date)){           		
                		System.out.println("Stock [symbol= " + stock[0] + " , date= " + stock[1] + " , " + header[goalindex] + "= " + stock[goalindex] + "]");
                		jobcomplete = 1;
                	}
                	
                }
                
                if (jobcomplete == 0){
                	System.out.println("No record found !");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        
        }

    }
    	

}
