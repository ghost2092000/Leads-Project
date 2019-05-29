import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import java.awt.Checkbox;

public class WindowMOD extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	
	static String NameFromID ;
	static String CommentFromID ;
	static String DocuFromID ;
	static String ContactedFromID ;
	static String SignedFromID ;
	static String IDD;
	static String AcceptedFromID;
	
	
	
	static int x;
	
	
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
	

		
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMOD frame = new WindowMOD( NameFromID,CommentFromID,DocuFromID,ContactedFromID,SignedFromID,IDD,AcceptedFromID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

  
	
	
	/**
	 * Create the frame.
	 */
	public WindowMOD(String name , String comment, String docu, String contacted, String signed, String ID, String accepted) {
				
		
		
		NameFromID = name;	
		System.out.println("2nd name "+ name);
		CommentFromID = comment;
		System.out.println("2nd comment "+comment);
		DocuFromID = docu;
		System.out.println("2nd docu "+docu);
		ContactedFromID = contacted;
		System.out.println("2nd contacted "+contacted);
		SignedFromID = signed;
		System.out.println("2nd signed "+signed);
		IDD = ID;
		System.out.println(ID + signed + " ID From Second: " +IDD);
		AcceptedFromID = accepted;
		System.out.println(accepted);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/////////////////////////////////////////////////////////////////
		textField = new JTextField();
		textField.setBounds(168, 110, 263, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(NameFromID);
		
		
	
		
		
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 467, 403, 117);
		contentPane.add(textField_1);
		textField_1.setColumns(10);    
		textField_1.setText(CommentFromID);
		
		
		
		
		
		
		
		
		/////////////////////////////////////////////////////////////////////////////////
		
		
		String[] choices = {"Not Yet", "Yelp", "Voice", "DOCU" };	
		JComboBox comboBox = new JComboBox(choices);
		comboBox.setBackground(SystemColor.window);
		comboBox.setBounds(168, 236, 242, 29);
		
		System.out.println(DocuFromID + " this is on choices");
		
		
		if (DocuFromID.contentEquals("Not Yet")) {
		
			comboBox.setSelectedIndex(0);
			System.out.println("12121212112121212121212112121212121121");
		}
		
		if (DocuFromID.contentEquals("Yelp")) {
			
			comboBox.setSelectedIndex(1);
			System.out.println("00-==-=-=-=-");

		}
			
		if (DocuFromID.contentEquals("Voice")) {
			
			comboBox.setSelectedIndex(2);
			System.out.println(" tnjllllllllllllllll");


		}
		
		if (DocuFromID.contentEquals("DOCU")) {
			
			comboBox.setSelectedIndex(3);
			System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwww");

		}
		
		
		comboBox.addActionListener(new ActionListener() {
			 
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	String selectedProv = (String)comboBox.getSelectedItem();
	                System.out.println(selectedProv);
	                DocuFromID = selectedProv;
	                
	            }
	        });
		
		
		contentPane.add(comboBox);
		
		
		//System.out.println("Docu??? " + DocuToUse);
		
		///////////////////////////////////////////////////////////////////////////////////
		
		
		String[] choic = {"Yelp", "Angel Email", "Chris Email", "Voice", "Call" };	
		JComboBox contactedBox = new JComboBox(choic);
		contactedBox.setBackground(SystemColor.window);
		contactedBox.setBounds(600, 121, 155, 29);
		//ContactedFromID
		
		if (ContactedFromID.contentEquals("Yelp")) {
			
			contactedBox.setSelectedIndex(0);

		}
		
		if (ContactedFromID.contentEquals("Angel Email")) {
			
			contactedBox.setSelectedIndex(1);

		}
		if (ContactedFromID.contentEquals("Chris Email")) {
			
			contactedBox.setSelectedIndex(2);

		}
		if (ContactedFromID.contentEquals("Voice")) {
			
			contactedBox.setSelectedIndex(3);

		}
		if (ContactedFromID.contentEquals("Call")) {
			
			contactedBox.setSelectedIndex(4);

		}
		
			contactedBox.addActionListener(new ActionListener() {
			 
		          @Override
		          public void actionPerformed(ActionEvent e) {
		            	String selectedProv = (String)contactedBox.getSelectedItem();
		                System.out.println(selectedProv);
		                ContactedFromID = selectedProv;
		                
		            }
		        });
		
		contentPane.add(contactedBox);
		
	//	System.out.println("Contacted ?? " + ContactToUse);
		
		
/////////////////////////////////////////////		
		JButton btnAdd = new JButton("Mod");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.println(DocuFromID);
				System.out.println("O_o");
				System.out.println(ContactedFromID);
			
				
				
				int input = JOptionPane.showOptionDialog(null, "This will be added \n Name: " + textField.getText() +  " \n Docu sent? " + DocuFromID + " \n Comment: "+  textField_1.getText() + "\n Contacted Us: "+ ContactedFromID, "Add", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
				
				if(input == JOptionPane.OK_OPTION)	
					{	
					
		
					
													
						//Make code go back to start screen// 
						//
						//
						try {
							update();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						try {
							day();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						
						WindowsMain d = null;
						try {
							d = new WindowsMain();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
							
							d.setVisible(true);
					
						
						setVisible(false);
						
						
						
						
						
						
						
						//
						//
						//
						/////////////////////////////////////

					}
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnAdd.setBounds(846, 620, 115, 29);
		contentPane.add(btnAdd);
		
		
////		
		
		
		JButton btnNewButton = new JButton("<-- Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				WinMODmain d = null;
				try {
					d = new WinMODmain();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
					
					d.setVisible(true);
			
				
				setVisible(false);
		
			}
		});
		btnNewButton.setBounds(168, 620, 115, 29);
		contentPane.add(btnNewButton);
		
		
		
///////////////////////////////////////////////////////////////////
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD,25));
		lblName.setBounds(168, 66, 86, 40);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("How did they contact us?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD,25));
		lblNewLabel.setBounds(593, 66, 342, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblDidWeSent = new JLabel("Did we send a Docu?");
		lblDidWeSent.setFont(new Font("Arial", Font.BOLD,25));
		lblDidWeSent.setBounds(168, 193, 301, 40);
		contentPane.add(lblDidWeSent);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setFont(new Font("Arial", Font.BOLD,25));
		lblComments.setBounds(168, 405, 155, 46);
		contentPane.add(lblComments);
		
		
///////////////////////////////////////////////////////////////////
		
//////////////////////////////////////////Weeks//////////////////////////////////////////////////
		
		
		JLabel lblHowManyWeeks = new JLabel("How Many Weeks Out?");
		lblHowManyWeeks.setFont(new Font("Arial", Font.BOLD, 25));
		lblHowManyWeeks.setBounds(168, 312, 301, 40);
		contentPane.add(lblHowManyWeeks);
		
		
		
		
		String[] choicess = {"--","1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		
		JComboBox comboBox_1 = new JComboBox(choicess);
		comboBox_1.setBackground(SystemColor.window);
		comboBox_1.setBounds(168, 356, 242, 26);	
		contentPane.add(comboBox_1);
		
		
		comboBox_1.addActionListener(new ActionListener() {
			 
	          @Override
	          public void actionPerformed(ActionEvent e) {
	            	String selectedProv = (String)comboBox_1.getSelectedItem();
	                System.out.println(selectedProv);
	                
	                
	                if (selectedProv.contentEquals("--")) {
	        			System.out.println("NOthing happens");
	        			x = 0;
	        		}
	        		if (selectedProv.contentEquals("1")) {
	        			x = 1 * 7;
	        		}
	        		if (selectedProv.contentEquals("2")) {
	        			x = 2 * 7;
	        		}
	        		if (selectedProv.contentEquals("3")) {
	        			x = 3 * 7;
	        		}
	        		if (selectedProv.contentEquals("4")) {
	        			x = 4 * 7;
	        		}
	        		if (selectedProv.contentEquals("5")) {
	        			x = 5 * 7;
	        		}
	        		if (selectedProv.contentEquals("6")) {
	        			x = 6 * 7;
	        		}
	        		if (selectedProv.contentEquals("7")) {
	        			x = 7 * 7;
	        		}
	        		if (selectedProv.contentEquals("8")) {
	        			x = 8 * 7;
	        		}
	        		if (selectedProv.contentEquals("9")) {
	        			x = 9 * 7;
	        		}
	        		if (selectedProv.contentEquals("10")) {
	        			x = 10 * 7;
	        		}	                
	            }
	        });
		
		
		
		
		System.out.println(x);
		
		////////////////////////////////////////////Signed//////////////////////////////////////////////		
		

		JLabel lblIsItSigned = new JLabel("Is it signed ?");
		lblIsItSigned.setFont(new Font("Arial", Font.BOLD, 25));
		lblIsItSigned.setBounds(600, 312, 198, 40);
		contentPane.add(lblIsItSigned);
		
		
			
			
			
			
			String[] twoChoices = {"No","Yes"};
			JComboBox comboBox_2 = new JComboBox(twoChoices);
			comboBox_2.setBackground(SystemColor.window);
			comboBox_2.setBounds(610, 356, 100, 26);
			
			if (AcceptedFromID.contentEquals("No")) {
				
				comboBox_2.setSelectedIndex(0);

			}
			
			if (AcceptedFromID.contentEquals("Yes")) {
				
				comboBox_2.setSelectedIndex(1);

			}
			
			
				comboBox_2.addActionListener(new ActionListener() {
				 
			          @Override
			          public void actionPerformed(ActionEvent e) {
			            	String selectedProv = (String)comboBox_2.getSelectedItem();
			                System.out.println(selectedProv);
			                SignedFromID = selectedProv;
			                
			                System.out.println(SignedFromID);
			            }
			        });
			contentPane.add(comboBox_2);
			
			
	
	
	
	
	
	System.out.println("Contact/Signed 2nd = " + ContactedFromID);
		
		
		
		
		System.out.println(" \n k");
		System.out.println(ID + ID);
	}
	
	

		
		
	
	public static void update() throws Exception{
		
			String Namee = textField.getText();
			String Commentss = textField_1.getText();
			String id = IDD;
			System.out.println("34 " + SignedFromID + " 34 34 34 34 34 34 34 34 34");
		
		try{
			Connection con = getConnection();
		
			java.sql.PreparedStatement statement = con.prepareStatement("UPDATE niiim SET name = '"+Namee+"' WHERE id = '"+id+"' ");
			java.sql.PreparedStatement statement1 = con.prepareStatement("UPDATE niiim SET comment = '"+Commentss+"' WHERE id = '"+id+"' ");								  
			java.sql.PreparedStatement statement2 = con.prepareStatement("UPDATE niiim SET contacted = '"+ContactedFromID+"' WHERE id = '"+id+"' ");						
			java.sql.PreparedStatement statement3 = con.prepareStatement("UPDATE niiim SET accepted = '"+SignedFromID+"' WHERE id = '"+id+"' ");						
			java.sql.PreparedStatement statement4 = con.prepareStatement("UPDATE niiim SET docu = '"+DocuFromID+"' WHERE id = '"+id+"' ");						

			
			statement.executeUpdate();
			statement1.executeUpdate();
			statement2.executeUpdate();
			statement3.executeUpdate();
			statement4.executeUpdate();

			
			
		} 	
		catch(Exception e){
			System.out.println("modName did not work");
		}
	    finally{
	    	System.out.println("modName Completed");
	    }
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	public static void day() throws Exception{
		
		try{
			Connection con = getConnection();
		
			java.sql.PreparedStatement statement = con.prepareStatement("UPDATE niiim SET time2 = "
																	  + "DATE_ADD( time2, INTERVAL '"+x+"' DAY) WHERE id = '"+ IDD +"' ");
			
			statement.executeUpdate();
		} 	
		catch(Exception e){
			System.out.println("Daychanged did not work");
		}
	    finally{
	    	System.out.println("Daychanged Completed");
	    }
	
		
		
		
		System.out.println(selectTime() + " first time " + x);
		System.out.println(selectTime2()+ " second time "+ x+ " here");
		
		
	}


	
	
	//this saves Comment
	  public static String selectTime2() throws Exception{
		String tron = null;
		  try{
			 
				Connection con = getConnection();
				java.sql.PreparedStatement statement = con.prepareStatement(" SELECT time2  FROM niiim WHERE id = '"+ IDD +"' ");
				ResultSet result = statement.executeQuery();
				
				ArrayList<String> array = new ArrayList<String>();
				
				while(result.next()){
					array.add(result.getString("time2"));
					tron = result.getString("time2");
				}
				
				return tron;
				
			}
			catch(Exception e){ System.out.println("e");}
				finally{ 
					System.out.println("SELECT Completed");
					}
			 	return null;
		}
	  
	  
	//this saves Comment
	  public static String selectTime() throws Exception{
		String tron = null;
		  try{
			 
				Connection con = getConnection();
				java.sql.PreparedStatement statement = con.prepareStatement(" SELECT time  FROM niiim WHERE id = '"+ IDD +"' ");
				ResultSet result = statement.executeQuery();
				
				ArrayList<String> array = new ArrayList<String>();
				
				while(result.next()){
					array.add(result.getString("time"));
					tron = result.getString("time");
				}
				
				return tron;
				
			}
			catch(Exception e){ System.out.println("e");}
				finally{ 
					System.out.println("SELECT Completed");
					}
			 	return null;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
