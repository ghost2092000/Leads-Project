import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ItemSelectable;

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class WindowADD extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	
	static String DocuDefault = "Not Yet";
	static String ContactDefault = "Yelp";
	
	
	
///////////////////////////Get Connection
	
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
	
	/////////////////////////////////

	
//////////////////////////////Insert New Row///////////////////////////////////////
	
public static void post() throws Exception{

try{
	Connection con = getConnection();
	final String name = textField.getText();
	final String docu = DocuDefault;
	final String comment = textField_1.getText();
	final String contacted = ContactDefault;
	final String signl = " ";
	final String accepted = "No";

	java.sql.PreparedStatement posted = con.prepareStatement("INSERT INTO niiim (id, name, docu, comment, contacted, time, time2, signl, accepted) "
								 + " VALUES ( null,  '"+name+"','"+docu+"' ,'"+comment+"', '"+contacted+"', '"+getCurrentDate()+"' , '"+getCurrentDate()+"', '"+signl+"', '"+accepted+"' )");

	posted.executeUpdate();
} 	
	catch(Exception e){
		System.out.println("Post did not work");
	}
	finally{
		System.out.println("Insert Completed");
	}

	day();
}


///////////////////////////////////////////////////////////////////////////////////////////


public static void day() throws Exception{

	try{
		Connection con = getConnection();

		java.sql.PreparedStatement statement = con.prepareStatement("UPDATE niim SET time = "
											  + "DATE_ADD( time, INTERVAL 2 DAY) WHERE name =  '"+textField.getText()+"' )" );

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


	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowADD frame = new WindowADD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	static private String selectedString(ItemSelectable is) {
	    Object selected[] = is.getSelectedObjects();
	    return ((selected.length == 0) ? "null" : (String) selected[0]);
	  }

	
	
	/**
	 * Create the frame.
	 */
	public WindowADD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
////////// Text Field for Name 		
		textField = new JTextField();
		textField.setBounds(168, 110, 263, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
//////////////////////////////////////
		
		
		
////////// Text Field for Comments	
		textField_1 = new JTextField();
		textField_1.setBounds(168, 467, 403, 117);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
//////////////////////////////////////
		
		
	

////////////////Did We Send Docu? /////		
		String[] choices = {"Not Yet", "Yelp", "Voice", "DOCU" };
		
		JComboBox<?> comboBox = new JComboBox<Object>(choices);
		comboBox.setBackground(SystemColor.window);
		comboBox.setBounds(168, 319, 242, 29);
		contentPane.add(comboBox);
		

		   comboBox.addActionListener(new ActionListener() {
			 
	       //   @Override
	          public void actionPerformed(ActionEvent e) {
	            	String selectedProv = (String)comboBox.getSelectedItem();
	                System.out.println(selectedProv);
	                DocuDefault = selectedProv;
	                
	            }
	        });
		   
 /////////////////////////////////////////		
		    
		
		
////////////////How Did They Contact Us /////		
	String[] choices2 = {"Yelp", "Angel Email", "Chris Email", "Voice", "Call" };
	
	JComboBox<?> comboBox2 = new JComboBox<Object>(choices2);
	comboBox2.setBackground(SystemColor.window);
	comboBox2.setBounds(525, 118, 155, 29);
	contentPane.add(comboBox2);
	    
	    comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProv2 = (String)comboBox2.getSelectedItem();
                System.out.println(selectedProv2);
                ContactDefault = selectedProv2;
            }
        });
/////////////////////////////////////////
		
		
		
		
		
		
/////////////Add Button 		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Name = textField.getText();
				String Comments = textField_1.getText();
				
				
			
					int input = JOptionPane.showOptionDialog(null, "This will be added \n Name: " + Name +  " \n Docu sent? " + DocuDefault + " \n Comment: "+  Comments + "\n Contacted Us: "+ ContactDefault, "Add", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					
				
					if(input == JOptionPane.OK_OPTION)	
						{	
						
			
						
														
							//Make code go back to start screen// 
							//
							//
							try {
								post();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
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
		btnAdd.setBounds(752, 620, 115, 29);
		contentPane.add(btnAdd);
/////////////////////////////////////		

		
/////////////Back Button 
		JButton btnNewButton = new JButton("<-- Back");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(168, 620, 115, 29);
		contentPane.add(btnNewButton);
/////////////////////////////////////		


		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD,25));
		lblName.setBounds(168, 66, 86, 40);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("How did they contact us?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD,25));
		lblNewLabel.setBounds(525, 66, 342, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblDidWeSent = new JLabel("Did we send a Docu?");
		lblDidWeSent.setFont(new Font("Arial", Font.BOLD,25));
		lblDidWeSent.setBounds(168, 263, 301, 40);
		contentPane.add(lblDidWeSent);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setFont(new Font("Arial", Font.BOLD,25));
		lblComments.setBounds(168, 405, 155, 46);
		contentPane.add(lblComments);
		
	}
}
