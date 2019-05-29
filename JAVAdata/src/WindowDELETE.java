import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class WindowDELETE extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private static JTable table;
	static String userwordd;


	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowDELETE frame = new WindowDELETE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
	//This method has to be used if you are using SQL
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
	 * Create the frame.
	 */
	public WindowDELETE() {
			
	    
	    JTable  table = new JTable()  {
		  	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			//you add this so u can see different colors for rows 
		    public Component prepareRenderer(TableCellRenderer renderer, int Index_row, int Index_col) {
		        // get the current row
		        Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
		        // even index, not selected
		        if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
		            comp.setBackground(Color.lightGray);
		        } else {
		            comp.setBackground(Color.white);
		        }
		        return comp;
		              
		    }
		};
	 
		
		
		
	  DefaultTableModel model = new DefaultTableModel(); //model object can be seen as what you will add to table 
	  JScrollPane scroll;
	  String headers[] = { "ID", "NAME" };
		  
	  	model.setColumnIdentifiers(headers);   
	    scroll = new JScrollPane(table);
	    table.setModel(model);	    

	    //This section is for displaying the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//This displays the text field 
		textField = new JTextField();
		textField.setBounds(363, 122, 308, 46);
		contentPane.add(textField);
		textField.setColumns(10);	
		
		//this displays the words: ID That will be Deleted 
		JLabel lblIdThatWill = new JLabel("ID That will be Deleted");
		lblIdThatWill.setFont(new Font("Arial", Font.BOLD,25));
		lblIdThatWill.setBounds(385, 186, 264, 20);
		contentPane.add(lblIdThatWill);
			
		//This displays the button: Delete
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(554,253,117,29);
		btnNewButton.addActionListener(new ActionListener() {
			
			// ***if person presses Delete***  
			public void actionPerformed(ActionEvent e)
			{
				userwordd = textField.getText();

				//make sql statement that Selects what i want to delete 
				//it will display for userwordd
				try {
					System.out.println ( "Name: " + selectNAME() + " This is from selectNAME( )");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					System.out.println ("ID: " + selectID() + "  -  "   + selectID()  +   " This is from selectID( )");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
				
				
				///////////////////////// Calls selectNAME() and selectID to save into string NAMEE  and IDD
				String NAMEE = "";
				try {
					NAMEE = selectNAME();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//		
				String IDD = "";
				try {
					IDD = selectID();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/////////////////////////
				
				
								
					String userwordd = textField.getText();
				
					//Delete ID and Name are displayed in box, ID can be printed out to console
					// ***********This is if they press OK **********
					if(IDD != null){
						
					int input = JOptionPane.showOptionDialog(null, "Deletee : ID = " + IDD + "    Name = " + NAMEE , "DELETE", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					
				
						//If person presses Ok
						if(input == JOptionPane.OK_OPTION)	
							{	
								//Call method that will delete if the person presses ok 
								try {
									DeleteROW();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
								//Make code go back to start screen// 
								//
								//		
							
								WindowsMain d = null;
								try {
									d = new WindowsMain();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
									d.setVisible(true); //Makes Main window visible 
							
									setVisible(false);  //Closes current window
							
							//
							/////////////////////////////////////
	
						}
					}
					//If there is nothing that comes back for the ID
					if(IDD == null){
						int input = JOptionPane.showOptionDialog(null, "There is no Row with the ID: " + userwordd , "DELETE", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					} 					
			}
			
		});
		
		contentPane.add(btnNewButton);
		
		
		
		//this section displays the button: <-- Back   , when the button is pressed it closes the current window and opens up the Main window 
		JButton btnBack = new JButton("<-- Back");
		btnBack.setBounds(363, 253, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
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
				/////////////////////////////////////
				System.out.print("dddddddddddddddddddddddddddddd");
				return;
			
			}

		});
				
		contentPane.add(btnBack);
		
} // End of WindowDELETE()
	

	//This retrieves the name from the table 
	  public static String selectNAME() throws Exception{
		String tron = null;
		  try{
			 
				Connection con = getConnection();
				java.sql.PreparedStatement statement = con.prepareStatement(" SELECT name  FROM niiim WHERE id = '"+ userwordd +"' ");
				ResultSet result = statement.executeQuery();
				
				ArrayList<String> array = new ArrayList<String>();
				
				while(result.next()){
					array.add(result.getString("name"));
					tron = result.getString("name");
				}
				
				return tron;
				
			}
			catch(Exception e){ System.out.println("e");}
				finally{ 
					System.out.println("SELECT Completed");
					}
			 	return null;
		}
	
	  
	  //This retrieves the id from the table niiim, using the user input number *it is not need because the user input number is the id number
	  public static String selectID() throws Exception{
			String tron = null;
			  try{
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT id  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
			
					ArrayList<String> array1 = new ArrayList<String>();
					
					while(result.next()){
						array1.add(result.getString("id"));
						tron = result.getString("id");
					}
					return tron;
					
				}
				catch(Exception e){ System.out.println("e");}
					finally{ 
						System.out.println("SELECT Completed");
						}
				 	return null;	
			}
	  
	  //This method deletes a row from table
	  public static void DeleteROW() throws Exception{
			
			try{
				Connection con = getConnection();
			
				java.sql.PreparedStatement statement = con.prepareStatement("DELETE FROM niiim WHERE id = '"+ userwordd +"' ");
																		
				
				statement.executeUpdate();
			} 	
			catch(Exception e){
				System.out.println("Delete did not work");
			}
		    finally{
		    	System.out.println("Delete Completed");
		    }
		}
		
	  
	  
	}

