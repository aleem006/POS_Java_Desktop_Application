package com.pos.org;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class pos_application {

	private JFrame frame_JFrame;
	private JTable itemList_JTable;
	private JTextField display_JTextField;
	private JTextField change_JTextField;
	private JTextField total_JTextField;
	private JTextField subTotal_JTextField;
	private JTextField tax_JTextField;
	private JTextField barCode_JText;

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pos_application window = new pos_application();
					window.frame_JFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
 
	/**
	 * Create the application.
	 */
	 public pos_application() {
		initialize();
	 }
	
	/**
	 * Adding the Following Functionality.
	 * - Tax Calculation
	 * - Total
	 * - sub Total 
	 * - Get Bar Code
	 */
	 public void calculateItemCost() {
	     double sum = 0;
	     double tax_Value = 3.9;  
	     // Add sum of Items in JTable Amount Column which is at location 2. Then add the Sum into the subtotal_JTextField.
	     for(int i = 0; i < itemList_JTable.getRowCount(); i++) {
	         sum =  sum + Double.parseDouble(itemList_JTable.getValueAt(i, 2).toString());
	     }
	     subTotal_JTextField.setText(Double.toString(sum));
	     
	     double subTotalinDouble = Double.parseDouble(subTotal_JTextField.getText());
	     
	     double calculated_Tax = (subTotalinDouble * tax_Value)/100;
	     // System.out.print(" calculate item metheod " + calculated_Tax);
	     
	     String tax_Total = String.format("$ %.2f", calculated_Tax);
	     tax_JTextField.setText(tax_Total);
	     
	     String sub_Total = String.format("$ %.2f", subTotalinDouble);
	     subTotal_JTextField.setText(sub_Total);
	     
	     String total = String.format("$ %.2f", calculated_Tax + subTotalinDouble);
	     total_JTextField.setText(total); 
	     
	     String barCode = String.format("Total is %.2f", calculated_Tax + subTotalinDouble);
	     barCode_JText.setText(barCode);
	 }
	
	 /**
	  * Adding the Functionality of return/calculate the Change that customer own.
	  */
	  public void calculateChange() {        
	     double sum = 0;
	     double tax = 3.9;        
	     double cash = Double.parseDouble(display_JTextField.getText());
	     for(int i = 0; i < itemList_JTable.getRowCount(); i++) {
	         sum =  sum + Double.parseDouble(itemList_JTable.getValueAt(i, 2).toString());            
	     }
	     double cTax = (sum * tax)/100;
	     // System.out.print(" calculate change metheod " + cTax);
	     
	     double customerChange = (cash - (sum + cTax));      
	     String ChangeGiven = String.format("$ %.2f", customerChange);
	     change_JTextField.setText(ChangeGiven);     
	}
	  
	/**
	 * Initialize the contents of the frame.
	 * Set the action against the Buttons.
	 */
	private void initialize() {
		frame_JFrame = new JFrame();
		frame_JFrame.setBounds(0, 0, 1450, 800);
		frame_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_JFrame.getContentPane().setLayout(null);
		
		JPanel number_JPanel = new JPanel();
		number_JPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		number_JPanel.setBounds(10, 11, 303, 440);
		frame_JFrame.getContentPane().add(number_JPanel);
		number_JPanel.setLayout(null);
		
		JButton nine_JButton = new JButton("9");
		nine_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(nine_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + nine_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		nine_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		nine_JButton.setBounds(204, 11, 89, 98);
		number_JPanel.add(nine_JButton);
		
		JButton eight_JButton = new JButton("8");
		eight_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(eight_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + eight_JButton.getText();
		            display_JTextField.setText(enter_number);   
		        }
			}
		});
		eight_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		eight_JButton.setBounds(109, 11, 89, 98);
		number_JPanel.add(eight_JButton);
		
		JButton seven_JButton = new JButton("7");
		seven_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();         
		        if (enter_number == "") {
		            display_JTextField.setText(seven_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + seven_JButton.getText();
		            display_JTextField.setText(enter_number);   
		        }
			}
		});
		seven_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		seven_JButton.setBounds(10, 11, 89, 98);
		number_JPanel.add(seven_JButton);
		
		JButton six_JButton = new JButton("6");
		six_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(six_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + six_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		six_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		six_JButton.setBounds(204, 120, 89, 98);
		number_JPanel.add(six_JButton);
		
		JButton five_JButton = new JButton("5");
		five_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(five_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + five_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		five_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		five_JButton.setBounds(109, 120, 89, 98);
		number_JPanel.add(five_JButton);
		
		JButton four_JButton = new JButton("4");
		four_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(four_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + four_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		four_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		four_JButton.setBounds(10, 120, 89, 98);
		number_JPanel.add(four_JButton);
		
		JButton three_JButton = new JButton("3");
		three_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(three_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + three_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		three_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		three_JButton.setBounds(204, 229, 89, 98);
		number_JPanel.add(three_JButton);
		
		JButton two_JButton = new JButton("2");
		two_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(two_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + two_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		two_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		two_JButton.setBounds(109, 229, 89, 98);
		number_JPanel.add(two_JButton);
		
		JButton one_JButton = new JButton("1");
		one_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(one_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + one_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		one_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		one_JButton.setBounds(10, 229, 89, 98);
		number_JPanel.add(one_JButton);
		
		JButton zero_JButton = new JButton("0");
		zero_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String enter_number = display_JTextField.getText();   
		        if (enter_number == "") {
		            display_JTextField.setText(zero_JButton.getText());
		        } else {
		            enter_number = display_JTextField.getText() + zero_JButton.getText();
		             display_JTextField.setText(enter_number);   
		        }
			}
		});
		zero_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		zero_JButton.setBounds(10, 338, 89, 98);
		number_JPanel.add(zero_JButton);
		
		JButton dot_JButton = new JButton(".");
		dot_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(! display_JTextField.getText().contains(".")) {
					display_JTextField.setText(display_JTextField.getText() + dot_JButton.getText());
		        }
			}
		});
		dot_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dot_JButton.setBounds(109, 338, 89, 98);
		number_JPanel.add(dot_JButton);
		
		JButton C_JButton = new JButton("C");
		C_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_JTextField.setText(null);
				change_JTextField.setText(null);
			}
		});
		C_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		C_JButton.setBounds(204, 338, 89, 98);
		number_JPanel.add(C_JButton);
		
		JPanel item_JPanel = new JPanel();
		item_JPanel.setLayout(null);
		item_JPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		item_JPanel.setBounds(631, 11, 729, 440);
		frame_JFrame.getContentPane().add(item_JPanel);
		
		JButton drink_JButton = new JButton("Drink = 0.57");
		drink_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      double PriceOfItem = 0.57;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Can Drink","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		drink_JButton.setIcon(null);
		drink_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		drink_JButton.setBounds(154, 11, 134, 130);
		item_JPanel.add(drink_JButton);
		
		JButton cappuccino_JButton = new JButton("Cappuccino = 2.57");
		cappuccino_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      double PriceOfItem = 2.57;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Cappuccino","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		cappuccino_JButton.setIcon(null);
		cappuccino_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cappuccino_JButton.setBounds(10, 11, 134, 130);
		item_JPanel.add(cappuccino_JButton);
		
		JButton cappuccino_L_JButton = new JButton("Cappuccino = 1.90");
		cappuccino_L_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      double PriceOfItem = 1.90;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Cappuccino","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		cappuccino_L_JButton.setIcon(null);
		cappuccino_L_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cappuccino_L_JButton.setBounds(442, 11, 134, 130);
		item_JPanel.add(cappuccino_L_JButton);
		
		JButton sponge_Cake_JButton = new JButton("Sponge Cake = 2.75");
		sponge_Cake_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double PriceOfItem = 2.75;
		        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
		        model.addRow(new Object[]{"Sponge Cake","1",PriceOfItem});
		        
		        calculateItemCost();
			}
		});
		sponge_Cake_JButton.setIcon(null);
		sponge_Cake_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		sponge_Cake_JButton.setBounds(298, 11, 134, 130);
		item_JPanel.add(sponge_Cake_JButton);
		
		JButton cream_cake_JButton = new JButton("Cream Cake = 2.45");
		cream_cake_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      double PriceOfItem = 2.45;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Cream Cake","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		cream_cake_JButton.setIcon(null);
		cream_cake_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cream_cake_JButton.setBounds(585, 11, 134, 130);
		item_JPanel.add(cream_cake_JButton);
		
		JButton chocolate_cake_JButton = new JButton("Chocolate Cake = 2.99");
		chocolate_cake_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 double PriceOfItem = 2.99;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Chocolate Cake","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		chocolate_cake_JButton.setIcon(null);
		chocolate_cake_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		chocolate_cake_JButton.setBounds(585, 152, 134, 130);
		item_JPanel.add(chocolate_cake_JButton);
		
		JButton milky_JButton = new JButton("Milky = 3.80");
		milky_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			     double PriceOfItem = 3.80;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Milky","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		milky_JButton.setIcon(null);
		milky_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		milky_JButton.setBounds(442, 152, 134, 130);
		item_JPanel.add(milky_JButton);
		
		JButton raw_coffee_JButton = new JButton("Raw Coffee = 3.95");
		raw_coffee_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     double PriceOfItem = 3.95;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Raw Coffee","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		raw_coffee_JButton.setIcon(null);
		raw_coffee_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		raw_coffee_JButton.setBounds(298, 152, 134, 130);
		item_JPanel.add(raw_coffee_JButton);
		
		JButton coffee_JButton = new JButton("Coffee = 0.90");
		coffee_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        double PriceOfItem = 0.90;
		        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
		        model.addRow(new Object[]{"Coffee","1",PriceOfItem});        
		        calculateItemCost();
			}
		});
		coffee_JButton.setIcon(null);
		coffee_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		coffee_JButton.setBounds(154, 152, 134, 130);
		item_JPanel.add(coffee_JButton);
		
		JButton easy_ake_JButton = new JButton("Easy Cake = 2.90");
		easy_ake_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     double PriceOfItem = 2.90;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Easy Cake","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		easy_ake_JButton.setIcon(null);
		easy_ake_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		easy_ake_JButton.setBounds(10, 152, 134, 130);
		item_JPanel.add(easy_ake_JButton);
		
		JButton ice_cream_JButton = new JButton("Ice Cream = 2.95");
		ice_cream_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        double PriceOfItem = 2.95;
		        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
		        model.addRow(new Object[]{"Ice Cream ","1",PriceOfItem});
		        
		        calculateItemCost();
			}
		});
		ice_cream_JButton.setIcon(null);
		ice_cream_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		ice_cream_JButton.setBounds(585, 293, 134, 130);
		item_JPanel.add(ice_cream_JButton);
		
		JButton cake_JButton = new JButton("Cake = 2.78");
		cake_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        double PriceOfItem = 2.78;
		        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
		        model.addRow(new Object[]{"Cake","1",PriceOfItem});        
		        calculateItemCost();
			}
		});
		cake_JButton.setIcon(null);
		cake_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cake_JButton.setBounds(442, 293, 134, 130);
		item_JPanel.add(cake_JButton);
		
		JButton fruit_cake_JButton = new JButton("Fruit Cake = 3.20");
		fruit_cake_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 double PriceOfItem = 3.20;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Fruit Cake","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		fruit_cake_JButton.setIcon(null);
		fruit_cake_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		fruit_cake_JButton.setBounds(298, 293, 134, 130);
		item_JPanel.add(fruit_cake_JButton);
		
		JButton milky_cappuccino_JButton = new JButton("Milky Cappuccino = 2.30");
		milky_cappuccino_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 double PriceOfItem = 2.30;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Milky Cappuccino","1",PriceOfItem});        
			        calculateItemCost();
			}
		});
		milky_cappuccino_JButton.setIcon(null);
		milky_cappuccino_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		milky_cappuccino_JButton.setBounds(154, 293, 134, 130);
		item_JPanel.add(milky_cappuccino_JButton);
		
		JButton orange_drinks_JButton = new JButton("Orange Drinks = 1.20");
		orange_drinks_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 double PriceOfItem = 1.20;
			        DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();
			        model.addRow(new Object[]{"Orange Drinks","1",PriceOfItem});
			        
			        calculateItemCost();
			}
		});
		orange_drinks_JButton.setIcon(null);
		orange_drinks_JButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		orange_drinks_JButton.setBounds(10, 293, 134, 130);
		item_JPanel.add(orange_drinks_JButton);
		
		JPanel calculation_JPanel = new JPanel();
		calculation_JPanel.setLayout(null);
		calculation_JPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		calculation_JPanel.setBounds(10, 453, 1350, 191);
		frame_JFrame.getContentPane().add(calculation_JPanel);
		
		JPanel total_JPanel = new JPanel();
		total_JPanel.setLayout(null);
		total_JPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		total_JPanel.setBounds(10, 11, 413, 167);
		calculation_JPanel.add(total_JPanel);
		
		total_JTextField = new JTextField();
		total_JTextField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		total_JTextField.setColumns(10);
		total_JTextField.setBounds(183, 115, 220, 41);
		total_JPanel.add(total_JTextField);
		
		subTotal_JTextField = new JTextField();
		subTotal_JTextField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		subTotal_JTextField.setColumns(10);
		subTotal_JTextField.setBounds(183, 62, 220, 41);
		total_JPanel.add(subTotal_JTextField);
		
		tax_JTextField = new JTextField();
		tax_JTextField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		tax_JTextField.setColumns(10);
		tax_JTextField.setBounds(183, 10, 220, 41);
		total_JPanel.add(tax_JTextField);
		
		JLabel tax_JLabel = new JLabel("Tax");
		tax_JLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		tax_JLabel.setBounds(23, 10, 73, 28);
		total_JPanel.add(tax_JLabel);
		
		JLabel subTotal_JLabel = new JLabel("SubTotal");
		subTotal_JLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		subTotal_JLabel.setBounds(23, 61, 131, 28);
		total_JPanel.add(subTotal_JLabel);
		
		JLabel total_JLabel = new JLabel("Total");
		total_JLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		total_JLabel.setBounds(23, 114, 73, 28);
		total_JPanel.add(total_JLabel);
		
		JPanel payDisplay_JPanel = new JPanel();
		payDisplay_JPanel.setLayout(null);
		payDisplay_JPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		payDisplay_JPanel.setBounds(433, 11, 468, 167);
		calculation_JPanel.add(payDisplay_JPanel);
		
		JComboBox payMethod_JComboBox = new JComboBox();
		payMethod_JComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Cash", "Visa Card", "Master Card"}));
		payMethod_JComboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		payMethod_JComboBox.setBounds(199, 11, 259, 41);
		payDisplay_JPanel.add(payMethod_JComboBox);
		
		display_JTextField = new JTextField();
		display_JTextField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		display_JTextField.setBounds(199, 62, 259, 41);
		payDisplay_JPanel.add(display_JTextField);
		display_JTextField.setColumns(10);
		
		change_JTextField = new JTextField();
		change_JTextField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		change_JTextField.setColumns(10);
		change_JTextField.setBounds(199, 115, 259, 41);
		payDisplay_JPanel.add(change_JTextField);
		
		JLabel change_JLabel = new JLabel("Change");
		change_JLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		change_JLabel.setBounds(10, 115, 119, 28);
		payDisplay_JPanel.add(change_JLabel);
		
		JLabel displayCash_JLabel = new JLabel("Display Cash");
		displayCash_JLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		displayCash_JLabel.setBounds(10, 62, 154, 28);
		payDisplay_JPanel.add(displayCash_JLabel);
		
		JLabel payMethod_JLabel = new JLabel("Pay Method");
		payMethod_JLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		payMethod_JLabel.setBounds(10, 11, 154, 41);
		payDisplay_JPanel.add(payMethod_JLabel);
		
		JPanel print_JPanel = new JPanel();
		print_JPanel.setLayout(null);
		print_JPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		print_JPanel.setBounds(911, 11, 429, 167);
		calculation_JPanel.add(print_JPanel);
		
		JButton print_JButton = new JButton("Print");
		print_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date today = new Date();
		        Locale.setDefault(Locale.US);
				MessageFormat header = new MessageFormat("Receipt "+ today);
			    MessageFormat footer = new MessageFormat("Page {0, number, integer}");
			        
			        try {
			            itemList_JTable.print(JTable.PrintMode.NORMAL,header, footer);
			        } catch(java.awt.print.PrinterException ex) {
			            System.err.format("No Printer found", ex.getMessage());
			        }
			}
		});
		print_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		print_JButton.setBounds(290, 11, 129, 63);
		print_JPanel.add(print_JButton);
		
		JButton remove_JButton = new JButton("Remove Item");
		remove_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) itemList_JTable.getModel();          
	             
		        int RemoveItem =  itemList_JTable.getSelectedRow();                      
		        if (RemoveItem >= 0) {
		        	model.removeRow(RemoveItem);  
		        }   
		        
		        calculateItemCost();
		        
		        if (payMethod_JComboBox.getSelectedItem().equals("Cash")) {
		        	calculateChange();               
		        }
		        
		        String Enternumber = display_JTextField.getText();
		                       
		        if (Enternumber == "" && payMethod_JComboBox.getSelectedItem().equals("Cash")) {      
		        	change_JTextField.setText("");
		            display_JTextField.setText("");
		        }
				
			}
		});
		remove_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		remove_JButton.setBounds(10, 93, 196, 63);
		print_JPanel.add(remove_JButton);
		
		JButton pay_JButton = new JButton("Pay");
		pay_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (payMethod_JComboBox.getSelectedItem().equals("Cash")) {
	                calculateChange();               
	            } else {
	                change_JTextField.setText("");
	                display_JTextField.setText("");
	            }
			}
		});
		pay_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pay_JButton.setBounds(10, 11, 117, 63);
		print_JPanel.add(pay_JButton);
		
		JButton reset_JButton = new JButton("Reset");
		reset_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        DefaultTableModel RecordTable = (DefaultTableModel) itemList_JTable.getModel();
		        RecordTable.setRowCount(0);
				display_JTextField.setText(null);
				change_JTextField.setText(null);
				tax_JTextField.setText(null);
				subTotal_JTextField.setText(null);
				total_JTextField.setText(null);
				barCode_JText.setText(null);
			}
		});
		reset_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		reset_JButton.setBounds(148, 11, 129, 63);
		print_JPanel.add(reset_JButton);
		
		JButton exit_JButton = new JButton("Exit");
		exit_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame_JFrame = new JFrame("Exit");
		        if (JOptionPane.showConfirmDialog(frame_JFrame, "Confirm if you want to exit","Point of Sale", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
		            System.exit(0);
		        }
			}
		});
		exit_JButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		exit_JButton.setBounds(216, 93, 203, 63);
		print_JPanel.add(exit_JButton);
		
		JScrollPane receipt_JScrollPane = new JScrollPane();
		receipt_JScrollPane.setBounds(323, 11, 298, 376);
		frame_JFrame.getContentPane().add(receipt_JScrollPane);
		
		itemList_JTable = new JTable();
		receipt_JScrollPane.setViewportView(itemList_JTable);
		itemList_JTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item(s)", "Qty", "Amount"
			}
		));
		
		barCode_JText = new JTextField();
		barCode_JText.setFont(new Font("Code39", Font.PLAIN, 36));
		barCode_JText.setColumns(10);
		barCode_JText.setBounds(323, 386, 298, 65);
		frame_JFrame.getContentPane().add(barCode_JText);
	}
}