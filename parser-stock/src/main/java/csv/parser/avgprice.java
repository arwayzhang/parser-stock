package csv.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class avgprice {

	public static void AveragePrice(String csvFile) {
		
		//////////////input the target date
    	Scanner scanner = new Scanner( System.in );
    	
    	String year = null;
    	String month = null;
    	String day = null;
    	String goal = "0";
    	
    	String date = null;
    	int goalindex = 0;
    	
    	boolean bool = false;
    	

    	if (bool ==false){
        	System.out.print( "Type target year for the stock (yyyy): " );
        	year = scanner.nextLine();
        	bool = year.equals("exit");
    	}

    	if (bool ==false){
        	System.out.print( "Type target month for the stock (mm): " );
        	month = scanner.nextLine();
        	bool = month.equals("exit");
        }

    	if (bool ==false){
        	System.out.print( "Type target day for the stock (dd): " );
        	day = scanner.nextLine();
        	bool = day.equals("exit");
        }

    	if (bool ==false){
        	System.out.print( "Type the index of your goal for average value (open [1] / high [2] / low [3] / close [4] / volume [5] / adj_close [6]): " );
        	goal = scanner.nextLine();
        	bool = goal.equals("exit");
        }

 	
    	date = year + "-" + month + "-" + day;
    	goalindex = Integer.parseInt(goal) + 1;
    	

    	////////////////calculate the average price of a metric by a date
    	
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
                float sum = 0;
                int count = 0;
                while ((line = br.readLine()) != null) {

                	String[] stock = line.split(separator);
                	
                	if (stock[1].equals(date)){
                		
                		sum += Float.parseFloat(stock[goalindex]);
                		count += 1;
                        jobcomplete = 1;
                	}
                	
                }
                
        		float avg = 0;     		
                
                if (jobcomplete == 1){
            		avg = sum/count;
            		System.out.println("Stock [date= " + date + " , average " + header[goalindex] + " price equals " + avg + "]");
                }else{
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
