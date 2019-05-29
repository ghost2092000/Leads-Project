//This shows a table


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;




public class WindowsMain extends JFrame {
	 
	
	
	public static void main(String[] args) throws Exception {
		  getConnection();
		  new WindowsMain();	  
	}
	
	
	JTable  table = new JTable()  {
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
  String headers[] = { "ID" ,"Name","Comment", "Sent DocuSign?", "Contacted Us By", "Date of contact", "Follow up again", "Signal", "Accepted" };
  

  
  
  //this makes a table 
  public WindowsMain() throws Exception {    
    model.setColumnIdentifiers(headers);   
    scroll = new JScrollPane(table);
    scroll.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
    table.setModel(model);
    table.getColumnModel().getColumn(0).setPreferredWidth(5);

    
    //calls insert which saves the data into arraylist 
    table.setFont(new Font("Serif", Font.BOLD, 20));
    table.setRowHeight(40);
    
    
    //this is to center the first column ID numbers
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
    
    //Contacted column is centered 
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
    
    //This centers the time column 
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
    
    //this centers the time2 column 
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
    
    //this centers the signl column 
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
    
    //this centers the accepted column 
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
    
    //this centers the name column 
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
    
    
  
    //this makes the columns bigger 
    table.getColumnModel().getColumn(1).setPreferredWidth(150);
    table.getColumnModel().getColumn(2).setPreferredWidth(400);
    table.getColumnModel().getColumn(7).setPreferredWidth(20);
    table.getColumnModel().getColumn(8).setPreferredWidth(20);
    
    //this is to set the size of first column, to make smaller
    TableColumn column = table.getColumnModel().getColumn(0);
    column.setPreferredWidth(40);
    column.setMaxWidth(40);


    insert();
    
    //This is the window box
    SpringLayout springLayout = new SpringLayout();
    springLayout.putConstraint(SpringLayout.NORTH, scroll, 26, SpringLayout.NORTH, getContentPane());
    springLayout.putConstraint(SpringLayout.WEST, scroll, 10, SpringLayout.WEST, getContentPane());
    springLayout.putConstraint(SpringLayout.SOUTH, scroll, 660, SpringLayout.NORTH, getContentPane());
    springLayout.putConstraint(SpringLayout.EAST, scroll, 1430, SpringLayout.WEST, getContentPane());
    getContentPane().setLayout(springLayout);
    getContentPane().add(scroll);
   
    
    buttnz(springLayout);
    
  }

  public void buttnz(SpringLayout springLayout) {
 
	  //Add Button
	    JButton btnNewButton = new JButton("ADD");
	    springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 676, SpringLayout.NORTH, getContentPane());
	    springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 28, SpringLayout.WEST, getContentPane());
	    springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 143, SpringLayout.WEST, getContentPane()); 
	    btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				WindowADD d = null;
				try {
					d = new WindowADD();
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
	    getContentPane().add(btnNewButton);

	    
	    //Modify Button
	    JButton btnNewButton_1 = new JButton("MODIFY ");
	    springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 676, SpringLayout.NORTH, getContentPane());
	    springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 489, SpringLayout.WEST, getContentPane());
	    springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 604, SpringLayout.WEST, getContentPane());
	    btnNewButton_1.addActionListener(new ActionListener() {
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
				//
				//
				/////////////////////////////////////
				System.out.print("dddddddddddddddddddddddddddddd");
				return;
			
			
			}

		});
	    getContentPane().add(btnNewButton_1);
	    
	    //Delete Button
	    JButton btnNewButton_2 = new JButton("DELETE");
	    springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 676, SpringLayout.NORTH, getContentPane());
	    springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 926, SpringLayout.WEST, getContentPane());
	    springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 1041, SpringLayout.WEST, getContentPane());
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		WindowDELETE d = null;
				try {
					d = new WindowDELETE();
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
	    //smaller box
	    getContentPane().add(btnNewButton_2);
	    setSize(2054, 796);
	    setVisible(true);
	  
  }
  
  
  
  public void insert() throws Exception {
	  

	  //save arraylist from method to array1 
	  ArrayList<String> array1 = new ArrayList<String>(selectID());
	  //save arraylist form method to array
	  ArrayList<String> array = new ArrayList<String>(selectName());
	  //save arraylist form method to array
	  ArrayList<String> arrayD = new ArrayList<String>(selectDocu());
	  //save arraylist form method to array
	  ArrayList<String> array2 = new ArrayList<String>(selectComment());
	  //save arraylist form method to array
	  ArrayList<String> array3 = new ArrayList<String>(selectContacted());
	  //save arraylist form method to array
	  ArrayList<String> array5 = new ArrayList<String>(selectTime());
	  //save arraylist form method to array
	  ArrayList<String> array6 = new ArrayList<String>(selectTime2());
	  //save arraylist form method to array
	  ArrayList<String> array7 = new ArrayList<String>(selectSignal());
	  //save arraylist form method to array
	  ArrayList<String> array8 = new ArrayList<String>(selectAccepted());
	  
	  //save method that counts table size to NUM
      int NUM = NUMBER() ;
      
      
      //Loops to save on table 
      for(int x = 0; NUM > x; x++){
          model.addRow(new Object[] { String.valueOf(array1.get(x)), String.valueOf(array.get(x)),String.valueOf(array2.get(x)),String.valueOf(arrayD.get(x)), String.valueOf(array3.get(x)), String.valueOf(array5.get(x)), String.valueOf(array6.get(x)),String.valueOf(array7.get(x)), String.valueOf(array8.get(x)) });
          }
      
  }

//this saves ID 
  public static ArrayList<String> selectID() throws Exception{
	  int NUMBER = 0;
	  try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT id, name FROM niiim");
			ResultSet result = statement.executeQuery();
			
			ArrayList<String> array = new ArrayList<String>();
			
			
			while(result.next()){
				NUMBER = NUMBER + 1;
				array.add(result.getString("id"));
			}
					return array;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completedddddddddddd 9809909");}
		 	return null;
		
	}
  
  //this saves Name
  public static ArrayList<String> selectName() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT name FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> array1 = new ArrayList<String>();
			
			while(result.next()){
				array1.add(result.getString("name"));
			}
			return array1;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completed");
				}
		 	return null;
		
	}
  
  //this saves Docu
  public static ArrayList<String> selectDocu() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT docu FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> arrayD = new ArrayList<String>();
			
			while(result.next()){
				arrayD.add(result.getString("docu"));
			}
			return arrayD;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completed");
				}
		 	return null;
		
	}
  
  
  
  
  
  //this saves Comment
  public static ArrayList<String> selectComment() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT comment FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> array2 = new ArrayList<String>();
			
			while(result.next()){
				array2.add(result.getString("comment"));
			}
			return array2;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completed");
				}
		 	return null;
		
	}
  
//this saves Contacted
  public static ArrayList<String> selectContacted() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT contacted FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> array3 = new ArrayList<String>();
			
			while(result.next()){
				array3.add(result.getString("contacted"));
			}
			return array3;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completed");
				}
		 	return null;
		
	}
  
  
//this saves time
  public static ArrayList<String> selectTime() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT time FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> array5 = new ArrayList<String>();
			
			while(result.next()){
				array5.add(result.getString("time"));
			}
			return array5;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completed");
				}
		 	return null;
		
	}
  
  
//this saves time
  public static ArrayList<String> selectTime2() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT time2 FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> array6 = new ArrayList<String>();
			
			while(result.next()){
				array6.add(result.getString("time2"));
			}
			return array6;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completed");
				}
		 	return null;
		
	}
  
  
//this saves signal
  public static ArrayList<String> selectSignal() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT signl FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> array7 = new ArrayList<String>();
			
			while(result.next()){
				array7.add(result.getString("signl"));
			}
			return array7;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Completed");
				}
		 	return null;
		
	}
  
//this saves accepted
  public static ArrayList<String> selectAccepted() throws Exception{
		try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT accepted FROM niiim");
			ResultSet result = statement.executeQuery();
			
	
			ArrayList<String> array8 = new ArrayList<String>();
			
			while(result.next()){
				array8.add(result.getString("accepted"));
			}
			return array8;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				System.out.println("SELECT Complete xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxd");
				}
		 	return null;
		
	}
  
  
  
			
  //this counts the size of the table 
  public static int NUMBER() throws Exception{
	  int NUMBER = 0;
	  try{
			Connection con = getConnection();
			java.sql.PreparedStatement statement = con.prepareStatement("SELECT id, name FROM niiim");
			ResultSet result = statement.executeQuery();
					
			
			while(result.next()){
				NUMBER = NUMBER + 1;
			}
					return NUMBER;
			
		}
		catch(Exception e){ System.out.println("e");}
			finally{ 
				
				
				
				System.out.println("SELECT Completed");
				}
		 	return 0;
		
	}
  
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
			
			
  public static void dateCheck() {
	  
	  	try {
			DateCheck d = new DateCheck ( );
		} 
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	  
		}
  }
  
}
