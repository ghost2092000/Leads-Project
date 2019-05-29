import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import Email.Email;

public class DateCheck {
	
	static int lock = 0;
	static ArrayList<String> array1 = new ArrayList<String>();
	static String id;
	
	

	public static void main(String[] args) throws Exception {

		
		System.out.println(getCurrentDate() + " inside main");
		
		System.out.println("Select ID " + selectID() + " inside main");
		
		
		if(selectID() != null) {
		checking();	
		EmailMyself();
		}
		
	}
	
	
	
	
	//Connects to database
	public static Connection getConnection() throws Exception{		
		try{
			 String driver = "com.mysql.cj.jdbc.Driver";
			   String url = "jdbc:mysql://localhost:3306/test";
			   String username = "root";
			   String password = "Modesto209";
			   Class.forName(driver);
			   Connection conn = DriverManager.getConnection(url,username,password);
			   System.out.println("Connected");
			return conn;
		}	
		catch(Exception e){
				System.out.println(e);
		}	
		return null;	
	}
	
	
	//this method gets todays day
	private static java.sql.Date getCurrentDate(){
		java.util.Date today=new java.util.Date();
		return new java.sql.Date(today.getTime());
		}

	
	//this uses a query to check if todays date is on table		
	public static String selectID() throws Exception{
			String tron = null ;
			
			try{
				Connection con = getConnection();
				java.sql.PreparedStatement statement = con.prepareStatement("SELECT id  FROM niiim WHERE time = '"+ getCurrentDate() +"' ");
				ResultSet result = statement.executeQuery();
						
				
				while(result.next()){
					System.out.println(array1 + " inside selectID");
					array1.add(result.getString("id"));
					tron = result.getString("id");
					System.out.println(array1 + " This is what i need 2 use, inside selectID");
					lock = 1;
				}

				return tron;
						
			}
			
			catch(Exception e){ 
				System.out.println("e");
			}
			
			finally{ 
				System.out.println("SELECT Completed !");
			}
			
		return tron;	
	}
		
	
	
	public static void checking() throws Exception{
		System.out.println(array1.size() + " inside checking ");
		
		for (int x = 0;  x < array1.size(); x++) {
			System.out.println(array1.get(x) + " inside checking");
			id = array1.get(x);
			PlaceSignal();
		}
		
		
	}
	
	
	//method to change the signal, this adds the symbol ! to the row that has todays date
	public static void PlaceSignal() throws Exception{
			if (lock == 1) {
			try{
				Connection con = getConnection();
			
				java.sql.PreparedStatement statement = con.prepareStatement("UPDATE niiim SET signl = ' ! ' WHERE id = '"+ id +"' ");
																		  
				statement.executeUpdate();
			} 	
			catch(Exception e){
				System.out.println("PlaceSignal did not work");
			}
		    finally{
		    	System.out.println("PlaceSignal Completed");
		    }
		}
	}
		
	
	//method to run email program, which emails me and tells me to follow up with a person 
	public static void EmailMyself() {
		if (lock == 1) {
		try {
			Email d = new Email ( array1 );
		} 
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	  }
	
	}
	
	
	
	

}



	
