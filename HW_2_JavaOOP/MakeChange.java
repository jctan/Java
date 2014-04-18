/*


FEATURES: 1. GUI (Swing & AWT) - the user inputs the total amount on the GUI and it makes the change on the GUI with making random colors when clicking 
			on the "Make change" button
			
		  2. Also display the results when user enters the total amount in console
*/


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakeChange extends JFrame {

	


		
/*These methods are called from ChangeRevolver.java */
		
		//private variables for MakeChange
			private double total_amt; 
			private int quarters, dimes, nickels, pennies; 
				
			//set the total amount for user input
			public void setTotalAmount(double total_amt){
				this.total_amt = total_amt; 
			}
			
			//method for calculating quarters.
			public int getQuarters(){
				quarters = (int) (total_amt/25);
				total_amt = total_amt - (quarters*25);
				return quarters;
			}
			
			//method for calculating dimes.
			public int getDimes(){
				dimes = (int)(total_amt/10);
				total_amt = total_amt - (dimes*10);
				return dimes;
			}
			
			//method for calculating nickels
			public int getNickles(){
				nickels = (int)(total_amt/5);
				total_amt = total_amt - (nickels*5);
				return nickels;
			}
			
			//method for calculating pennies.
			public int getPennies(){
				pennies = (int)(total_amt);
				total_amt = total_amt - (pennies);
				return pennies;
			}
	
	
/*----------------------------------------------------------------------------------------------------------------------------*/

	
	JLabel labelName, label, result, result_quarters,result_dimes,result_nickels,result_pennies,result_thankyou; 
	JTextField tf; 
	JButton button; 
	

	//this MakeChange function sets the layout of the frame including the constraints which is "GridBagConstraints"
	public MakeChange(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		labelName = new JLabel ("John Tan - Make Change");
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		add(labelName, c);
		
		label = new JLabel ("Enter a sum of money in cents: ");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 0;
		c.gridy = 2;
		add(label, c);
		
		tf = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3; 
		add(tf, c);
		
		button = new JButton ("Make Change");
		c.gridx = 3; 
		c.gridy = 4;
		add(button,c);
		
		result = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 0;
		c.gridy = 5; 
		c.gridwidth = 4; 
		add(result,c);
		
		
		result_quarters = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 0;
		c.gridy = 6; 
		c.gridwidth = 4; 
		add(result_quarters,c);
		
		result_dimes = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 0;
		c.gridy = 7; 
		c.gridwidth = 4; 
		add(result_dimes,c);
		
		result_nickels = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 0;
		c.gridy = 8; 
		c.gridwidth = 4; 
		add(result_nickels,c);
		
		result_pennies= new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 0;
		c.gridy = 9; 
		c.gridwidth = 4; 
		add(result_pennies,c);
		
		result_thankyou= new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 0;
		c.gridy = 10; 
		c.gridwidth = 4; 
		add(result_thankyou,c);
		
		//set labelName Properties
		labelName.setForeground(Color.BLUE);
		labelName.setSize(22,22);
		
		//set Background properties
		button.setBackground(randomColor());
		button.setForeground(Color.RED);
		
		event e = new event();
		button.addMouseListener((MouseListener) e);
		
		action a = new action();
		button.addActionListener(a);


	}
	//creates random color
	public Color randomColor(){
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		return(new Color(r,g,b));
	}
	//Each time you click on a button, it generates a random color
	public class event implements MouseListener{
		public void mouseClicked (MouseEvent e){
			button.setBackground(randomColor());
		}
		public void mousePressed(MouseEvent e){
		}
		public void mouseReleased(MouseEvent e){
		}
		public void mouseEntered(MouseEvent e){
		}
		public void mouseExited(MouseEvent e){
		}
	}
	
	
	
	//this action listener will make the change based on the total amount you entered and prints on the the Frame
	public class action implements ActionListener {
		public void actionPerformed (ActionEvent a){
			
			double total_amt;
			int quarters,dimes,nickels,pennies;
			
			try{
				total_amt = Double.parseDouble(tf.getText());
			}catch(NumberFormatException e){
				result.setText("Invalid Data");
				result.setForeground(Color.RED);
				return;
			}
			
			String op = a.getActionCommand();
			
			if(op.equals("Make Change")){
				quarters = (int) (total_amt/25);
				total_amt = total_amt - (quarters*25);
				result_quarters.setText("Quarters: " + quarters);
				result_quarters.setForeground(Color.RED);
				
				dimes = (int)(total_amt/10);
				total_amt = total_amt - (dimes*10);
				result_dimes.setText("Dimes: " + dimes);
				result_dimes.setForeground(Color.RED);
				
				nickels = (int)(total_amt/5);
				total_amt = total_amt - (nickels*5);
				result_nickels.setText("Nickels: " + nickels);
				result_nickels.setForeground(Color.RED);
				
				pennies = (int)(total_amt);
				total_amt = total_amt - (pennies);
				result_pennies.setText("Pennies: " + pennies);
				result_pennies.setForeground(Color.RED);
				
				result_thankyou.setText("Thank you");
				result_thankyou.setForeground(Color.RED);
			}
			
			
		}
		
	}

	
	public static void main(String[] args) {
		
		//Create Frame with attributes and properties
		MakeChange gui = new MakeChange();
		gui.setSize(400,350);
		gui.setTitle("John Tan - Make Change");
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocationRelativeTo(null);
		
		//this is the same input/output for making the change and display it on Console.
		System.out.println("java MakeChange");
		System.out.println("----------------");
		
		Scanner input = new Scanner(System.in);
		double total_amt; 
		
		System.out.print("Enter a sum of money in cents: ");
		total_amt = input.nextDouble();
		
		int quarters = (int)(total_amt/25);
		total_amt = total_amt - (quarters*25);
		System.out.println("Quarters: " + quarters);
		
		int dimes = (int)(total_amt/10);
		total_amt = total_amt - (dimes*10);
		System.out.println("Dimes: " + dimes);
		
		int nickels = (int)(total_amt/5);
		total_amt = total_amt - (nickels*5);
		System.out.println("nickels: " + nickels);
		
		int pennies = (int)(total_amt);
		total_amt = total_amt - (pennies);
		System.out.println("Pennies: " + pennies);
		
		System.out.println("Thank you");

		}
	
	}
