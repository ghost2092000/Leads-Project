//This adds data into database table, just adds to table



//package database;

import java.sql.Connection;
//import com.mysql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.io.*;
import java.sql.*;
//import com.mysql.jdbc.PreparedStatement;


public class TABLE {


	
	public static void main(String[] args) throws Exception {
		
		createTable();
		//delt();
		post();
		day();
		modName();
		select();
		//delt();
		
	}

	
	//////////////////////////////////// connect /////////////////////////////////////////
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
	////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	//////////////////////Create TABLE, which calls connect ///////////////////////////
	
	public static void createTable() throws Exception{
		try{
			
			Connection con = getConnection(); //con is equal to method  getConnection
			
			//I added this to ask user for name of table if there is one then the user  
			Scanner scanner = new Scanner (System.in);
			System.out.println("What is the name of the Table, try 'niiim' ");
			String userInput = scanner.nextLine();
			//
			
			java.sql.PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS niiim" 
					                                               +  " (id INTEGER PRIMARY KEY AUTO_INCREMENT, name varchar(255), docu varchar(255), comment varchar(255), contacted varchar(255), time DATE , time2 DATE, signl varchar(255), accepted varchar(255)  ) ");  //
			//id,name, comment, contacted, sent, time, time2, signal, accepted
			create.executeUpdate();
		}
	
		catch (Exception e){
			System.out.println("create table did not work");
		}
		
		finally{System.out.println("funciton completed");}
		}	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	

	
	
	
	//////////////////////////////Insert New Row///////////////////////////////////////
	
	public static void post() throws Exception{
		
		try{
			Connection con = getConnection();
			final String name = "Name: mee";
			final String comment = "Comment: This is a comment.  I can write whatever I want here.  write anything ";
			final String docu = "yelp";
			final String contacted = "Contacted: Yes";
			final String signl = "Signal: ip";
			final String accepted = "Accepted:  Not Yet";
			
			java.sql.PreparedStatement posted = con.prepareStatement("INSERT INTO niiim (id, name,  docu ,comment,contacted, time, time2, signl, accepted) "
														 + " VALUES ( null,  '"+name+"', '"+docu+"','"+comment+"', '"+contacted+"', '"+getCurrentDate()+"' , '"+getCurrentDate()+"', '"+signl+"', '"+accepted+"' )");
			
			posted.executeUpdate();
		} 	
		catch(Exception e){
			System.out.println("Post did not work");
		}
	    finally{
	    	System.out.println("Insert Completed");
	    }
	}
	
	
    ///////////////////////////////////////////////////////////////////////////////////////////


	public static void day() throws Exception{
		
		try{
			Connection con = getConnection();
		
			java.sql.PreparedStatement statement = con.prepareStatement("UPDATE niiim SET time2 = "
																	  + "DATE_ADD( time2, INTERVAL 400 DAY) WHERE id = '18'");
			
			statement.executeUpdate();
		} 	
		catch(Exception e){
			System.out.println("Daychanged did not work");
		}
	    finally{
	    	System.out.println("Daychanged Completed");
	    }
	}
	
	
	//for date 
	private static java.sql.Date getCurrentDate(){
		java.util.Date today=new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	
	
	
	
	
	
	//////////////////////////////SElECT ///////////////////////////////////////
	
	
	public static ArrayList<String> select() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT * FROM niiim");
	
			
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			ArrayList<String> array1 = new ArrayList<String>();
			ArrayList<String> array2 = new ArrayList<String>();
			ArrayList<String> array3 = new ArrayList<String>();
			ArrayList<String> array4 = new ArrayList<String>();
			ArrayList<String> array5 = new ArrayList<String>();
			ArrayList<String> array6 = new ArrayList<String>();
			ArrayList<String> array7 = new ArrayList<String>();
			ArrayList<String> array8 = new ArrayList<String>();
			
			
			//comment, contacted, time, time2, signl, accepted
			
			while(result.next()){
				String s = result.getString("id");
				//String[] s = {result.getString("id")};
				//System.out.println(s[0] + " hil ");
				System.out.println("------------------------");
				System.out.println("------------------------");
				System.out.print(result.getString("id"));
				System.out.println("|");
				System.out.println(result.getString("name"));
				System.out.println("-");
				System.out.println(result.getString("comment"));
				System.out.println("-");
				System.out.println(result.getString("contacted"));
				System.out.println("-");
				System.out.println(result.getString("time"));
				System.out.println("-");
				System.out.println(result.getString("time2"));
				System.out.println("-");
				System.out.println(result.getString("signl"));
				System.out.println("-");
				System.out.println(result.getString("accepted"));
			//	System.out.println("------------------------");
				
				array1.add(result.getString("id"));
				array.add(result.getString("name"));
				array3.add(result.getString("comment"));
				array4.add(result.getString("contacted"));
				array5.add(result.getString("time"));
				array6.add(result.getString("time2"));
				array7.add(result.getString("signl"));
				array8.add(result.getString("accepted"));
			}
			
			//i should use these for populating the table, i should try and use array.get() and array1.get()
			// also use array size for looping 
		//	System.out.println(array.get(1) + " array.get(1) ");
		//	System.out.println(array1.get(1) + " array1.get(1) ");
	//		System.out.println(array1.get(1) + " array2.get(1) ");
		//	System.out.println(array.size() + " array size ");

			System.out.println("------------------------");
			System.out.println("------------------------");
			return array;
			
		}
		catch(Exception e){ 
			System.out.println("e");
		}
		finally{ 
			System.out.println("SELECT Completed");
		}
		 	return null;
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
public static void delt() throws Exception{
		
		try{
			Connection con = getConnection();
		
			java.sql.PreparedStatement statement = con.prepareStatement("DELETE FROM niiim WHERE id = '8' ");
																	
			
			statement.executeUpdate();
		} 	
		catch(Exception e){
			System.out.println("Delete did not work");
		}
	    finally{
	    	System.out.println("Delete Completed");
	    }
	}
	
//////////////////////////////////////////////////////////////////////////
public static void modName() throws Exception{
	
	try{
		Connection con = getConnection();
	
		java.sql.PreparedStatement statement = con.prepareStatement("UPDATE niiim SET name = ' Roberto ' WHERE id = '4' ");
																  
		
		statement.executeUpdate();
	} 	
	catch(Exception e){
		System.out.println("modName did not work");
	}
    finally{
    	System.out.println("modName Completed");
    }
}



//////////////////////////////////////////////////////////////////////////


	
	

}  //