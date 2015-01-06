package com.capgemini.StarterKit;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPane extends JPanel {
	
	/**
	 * 
	 */
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Class Fields
	
	private static final long serialVersionUID = 1L;
	
	// Strings
    private final String textlabelPESEL = "Pesel";
    private final String textFieldDefaultPesel = "PESEL";
    private final String textlabelZipCode = "Kod pocztowy";
    private final String textLoginButton = "Login";
    private final String textWindow = "Login";
    
    // Numbers
    private final Dimension sizeComboBox = new Dimension(100,20);
    private final Dimension sizeTextField = new Dimension(150,20);
    
    //Arrays
    private String[] arrayComboBox = {"      ","58-316","02-212","50-362"};
    
    // JComponents
    private JLabel labelZipCode = new JLabel(textlabelZipCode);
    private JLabel labelPESEL = new JLabel(textlabelPESEL);
    
    private JComboBox<String> comboboxPostalCode;
    private JTextField textFieldPesel;
    private JButton buttonLogin;
    
    // JPanels
    private JPanel paneZipCode = new JPanel();
    private JPanel panePeselField = new JPanel();
    
    // Selected ones
    private String selectedPostalCode = "";
    private String userPesel = "";
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Constructor
    
    public LoginPane(){
    	
    	setCombobox();
    	setTextField();
    	setButton();
    	
    	createLoginWindowPane();
    	
    };
  
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Creating Main Interface
    
	private void createLoginWindowPane() {
       
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(Box.createVerticalGlue());
        this.add(addComponentsToHorizontalPane(labelZipCode, comboboxPostalCode, paneZipCode));
        		comboboxPostalCode.setMaximumSize(sizeComboBox);
  
        this.add(Box.createVerticalGlue());
        this.add(addComponentsToHorizontalPane(labelPESEL, textFieldPesel, panePeselField));
        		textFieldPesel.setMaximumSize(sizeTextField);
        
        this.add(Box.createVerticalGlue());
        this.add(buttonLogin);
        this.add(Box.createVerticalGlue());

       
    }

	private JPanel addComponentsToHorizontalPane(JComponent comp1, JComponent comp2, JPanel HorizontalPane) {

		
		HorizontalPane.setLayout(new BoxLayout(HorizontalPane, BoxLayout.X_AXIS));
 
		HorizontalPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		HorizontalPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
		HorizontalPane.add(comp1);
		HorizontalPane.add(Box.createHorizontalStrut(10));
		HorizontalPane.add(comp2);
        
        return HorizontalPane;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Set functionality & content in each JComponent
	
	
	private void setCombobox(){
		
		comboboxPostalCode = new JComboBox<String>();
		addComponentsToComboBox();
		comboboxPostalCode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				selectedPostalCode = (String) comboboxPostalCode.getSelectedItem();
				
				
			}
		});
		
	}
	
	
	private void setTextField(){
		
//		try {
//			
//			textFieldPesel = new JFormattedTextField(new MaskFormatter("###########"));
//		} 
//		
//		catch (ParseException e1) {
//			
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		textFieldPesel = new JTextField(textFieldDefaultPesel);
		
		textFieldPesel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldPesel.setText("");
                userPesel = "";
            }
		});
		
		textFieldPesel.addKeyListener(new KeyAdapter() {
		    
			@Override
			public void keyTyped(KeyEvent e) {
				
				String temp_str = "";
				char c = e.getKeyChar(); 
				
					if (	!(	(c >= '0') && (c <= '9') || 
								(c == KeyEvent.VK_BACK_SPACE) || 
								(c == KeyEvent.VK_DELETE)
																	) 
							||	userPesel.length() > 10	 				)
																
						{
							getToolkit().beep();
							e.consume();
								if (	!( 	(c == KeyEvent.VK_BACK_SPACE) ||
											(c == KeyEvent.VK_DELETE)	)	)
									{
										JOptionPane.showMessageDialog(null, "W polu \"Pesel\" należy wprowadzić 11 cyfr "
																			+ "z zakresu od 0 do 9!\n"  + selectedPostalCode);
									}	
						}
					else
						{
							temp_str = Character.toString(c);
							userPesel += temp_str;
						}
		    }
		  });
	}
	
	private void setButton(){
		
		buttonLogin = new JButton(textLoginButton);
		//buttonLogin.setEnabled(false);
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				if(userPesel.length() == 11 && selectedPostalCode.length() != 0)
//					{
//					buttonLogin.setEnabled(true);
//					JOptionPane.showMessageDialog(null, "Wybrałeś kod: " + selectedPostalCode
//													+ "\nWybrałeś PESEL: " + userPesel);
//					//Window.changePaneInFrame(new CandidateChoicePane());
//					}
//				else
//					JOptionPane.showMessageDialog(null, "Coś jest nie tak!!!! Popraw się!!!  " 
//															+ userPesel.length() + "   " + selectedPostalCode.length());
				
				//Window.changePaneInFrame(new CandidateChoicePane());
				
				
			}
		});
		
	}

	
	private void addComponentsToComboBox(){
		
	  	for (int i = 0; i < arrayComboBox.length; i++) {
			comboboxPostalCode.addItem(arrayComboBox[i]);
	  	}
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Gets & Sets
	

		public String getPaneName() {
		
			return textWindow;
		}
}