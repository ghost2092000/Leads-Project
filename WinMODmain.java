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

import Email.Email;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class WinMODmain extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	static String userwordd;
	static String ID;

 


	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinMODmain frame = new WinMODmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Connection getConnection() throws Exception{		
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
			   String url = "jdbc:mysql://localhost:3306/test";
			   String username = "root";
			   String password = "Modesto209";
			   Class.forName(driver);
			   Connection conn = DriverManager.getConnection(url,username,password);
			   System.out.println("FIRST Connected76");
			return conn;
		}	
		catch(Exception e){
				System.out.println("FIRST "+ e);
		}	
		return null;	
	}		
	
	
	
	/**
	 * Create the frame.
	 */
	public WinMODmain() {
		
		
	    
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
	  //y
	  DefaultTableModel model = new DefaultTableModel(); //model can be seen as what you will add to table 
	  JScrollPane scroll;
	  String headers[] = { "ID", "NAME" };
		
	  model.setColumnIdentifiers(headers);   
	    scroll = new JScrollPane(table);
	    table.setModel(model);
		
		
	    
	    
	    
	    
	    
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(363, 122, 308, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblIdThatWill = new JLabel("ID That will be Modified");
		lblIdThatWill.setFont(new Font("Arial", Font.BOLD,25));
		lblIdThatWill.setBounds(385, 186, 364, 20);
		contentPane.add(lblIdThatWill);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.setBounds(554,253,117,29);
		btnNewButton.addActionListener(new ActionListener() {
			
			// ***if person presses Delete***  
			public void actionPerformed(ActionEvent e)
			{
				userwordd = textField.getText();

				//make sql statement that Selects what i want to delete 
				//it will display for userwordd
				try {
					System.out.println ( "		FIRST  Name: " + selectNAME() + " This is from selectNAME( )");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					System.out.println (" 		FIRST  ID: " + selectID() + "  -  "   + selectID()  +   " This is from selectID( )");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
				
				
				///////////////////////// Calls selectNAME() to save string NAMEE 
				String NAMEE = "";
				try {
					NAMEE = selectNAME();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
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
					int input = JOptionPane.showOptionDialog(null, "MODIFY : ID = " + IDD + "    Name = " + NAMEE , "Modify", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
					if(input == JOptionPane.OK_OPTION)	
						{	
							//Make sql statement that will delete if the person presses ok 
							//	
								
						try {
							WindowMOD d = new WindowMOD(selectNAME(), selectComment(),selectDocu(),selectContacted(), selectSignal(),userwordd, selectAccepted());
							d.setVisible(true);
							setVisible(false);
	
						} 
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}		
							//
							/////////////////////////////////////
	
						}
					}
					if(IDD == null){
						int input = JOptionPane.showOptionDialog(null, "There is no Row with the ID: " + userwordd , "MODIFY", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					} 
					
					
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		
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
		
		
		
		
		
		
		
		
		
		
		
}
	
	
	


	//this saves Comment
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
			catch(Exception e){ System.out.println("		FIRST   e NAme");}
				finally{ 
			//		System.out.println("SELECT Completed");
					}
			 	return null;
		}
	

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
				catch(Exception e){ System.out.println("FIRST e ID");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;	
			}
	  
	  public static String selectDocu() throws Exception{
			String tron = null;
			  try{
				 
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT docu  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
					ArrayList<String> array = new ArrayList<String>();
					
					while(result.next()){
						array.add(result.getString("docu"));
						tron = result.getString("docu");
					}
					
					return tron;
					
				}
				catch(Exception e){ System.out.println("		FIRST   e docu");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;
			}
	  
	  public static String selectComment() throws Exception{
			String tron = null;
			  try{
				 
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT comment  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
					ArrayList<String> array = new ArrayList<String>();
					
					while(result.next()){
						array.add(result.getString("comment"));
						tron = result.getString("comment");
					}
					
					return tron;
					
				}
				catch(Exception e){ System.out.println("		FIRST   e comment");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;
			}
	  
	  public static String selectContacted() throws Exception{
			String tron = null;
			  try{
				 
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT contacted  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
					ArrayList<String> array = new ArrayList<String>();
					
					while(result.next()){
						array.add(result.getString("contacted"));
						tron = result.getString("contacted");
					}
					
					return tron;
					
				}
				catch(Exception e){ System.out.println("FIRST e contact");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;
			}
	  
	  public static String selectTime() throws Exception{
			String tron = null;
			  try{
				 
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT time  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
					ArrayList<String> array = new ArrayList<String>();
					
					while(result.next()){
						array.add(result.getString("time"));
						tron = result.getString("time");
					}
					
					return tron;
					
				}
				catch(Exception e){ System.out.println("		FIRST   e Time");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;
			}
	  
	  public static String selectTime2() throws Exception{
			String tron = null;
			  try{
				 
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT time2  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
					ArrayList<String> array = new ArrayList<String>();
					
					while(result.next()){
						array.add(result.getString("time2"));
						tron = result.getString("time2");
					}
					
					return tron;
					
				}
				catch(Exception e){ System.out.println("		FIRST   e time2");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;
			}
	  
	  public static String selectSignal() throws Exception{
			String tron = null;
			  try{
				 
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT signl  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
					ArrayList<String> array = new ArrayList<String>();
					
					while(result.next()){
						array.add(result.getString("signl"));
						tron = result.getString("signl");
					}
					
					return tron;
					
				}
				catch(Exception e){ System.out.println("		FIRST   e Signal");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;
			}
	  
	  public static String selectAccepted() throws Exception{
			String tron = null;
			  try{
				 
					Connection con = getConnection();
					java.sql.PreparedStatement statement = con.prepareStatement(" SELECT accepted  FROM niiim WHERE id = '"+ userwordd +"' ");
					ResultSet result = statement.executeQuery();
					
					ArrayList<String> array = new ArrayList<String>();
					
					while(result.next()){
						array.add(result.getString("accepted"));
						tron = result.getString("accepted");
					}
					
					System.out.println(tron + " This is what is from accepteddddd");
					return tron;
					
				}
				catch(Exception e){ System.out.println("		FIRST   e Accepted ");}
					finally{ 
				//		System.out.println("SELECT Completed");
						}
				 	return null;
			}
	  
	  /////////////////////////////////////////////////////////////////////////////////
	  
	 
	  
	}

