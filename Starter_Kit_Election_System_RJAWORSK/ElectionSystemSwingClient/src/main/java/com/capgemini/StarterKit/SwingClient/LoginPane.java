package com.capgemini.StarterKit.SwingClient;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.capgemini.StarterKit.main.DAOTransfer;
import com.capgemini.StarterKit.model.ZipCode;

public class LoginPane extends JPanel {
	
	
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
    // private String[] arrayComboBox = {"      ","58-316","02-212","50-362"};
    
    // JComponents
    private JLabel labelZipCode = new JLabel(textlabelZipCode);
    private JLabel labelPESEL = new JLabel(textlabelPESEL);
    
    private JComboBox<String> comboboxPostalCode;
    private static JTextField textFieldPesel;
    private JButton buttonLogin;
    
    // JPanels
    private JPanel paneZipCode = new JPanel();
    private JPanel panePeselField = new JPanel();

    // Objects from foreign classes 
	private MainFrame mainFrame;
    private PeselValidation peselValidation = new PeselValidation();

	private List<ZipCode> listZipCodes = null;
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    // Selected ones
    public static  String selectedPostalCode = "";
    public static  String userPesel = "";
    public static int postalCodeId;
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Constructor
    
	public LoginPane(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		
		listZipCodes = new DAOTransfer().listZipCode;
		
		setCombobox();
		setTextField();
		setButton();
		
		createLoginWindowPane();
		
	}
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Creating Main Interface
    
	private void createLoginWindowPane() {
       
		this.setAlignmentX(CENTER_ALIGNMENT);
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
		comboboxPostalCode.addActionListener(getComboboxPostalCodeActionListener());
		
	}
	
	
	private void setTextField(){
		
		textFieldPesel = new JTextField(textFieldDefaultPesel);
		textFieldPesel.addMouseListener(getTextFieldPeselMouseListener());
		textFieldPesel.addKeyListener(getTextFieldPeselKeyListener());
	}
	
	private void setButton(){
		
		buttonLogin = new JButton(textLoginButton);
		buttonLogin.setEnabled(false);
		buttonLogin.addActionListener(getButtonLoginActionListener());
		
	}

	
//	private void addComponentsToComboBox(){
//		
//	  	for (int i = 0; i < arrayComboBox.length; i++) {
//			comboboxPostalCode.addItem(arrayComboBox[i]);
//	  	}
//	}
	
	private void addComponentsToComboBox(){
	
		for (ZipCode p : listZipCodes ) {
			comboboxPostalCode.addItem(p.getZipCode().toString());
  	}
}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Set ActionListeners & Adapters
	
	private ActionListener getComboboxPostalCodeActionListener(){
	
	return new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			selectedPostalCode = comboboxPostalCode.getSelectedItem().toString();
				
				for (ZipCode p : listZipCodes)
				{
					if(comboboxPostalCode.getSelectedItem().toString() == p.getZipCode())
						postalCodeId = p.getId();
				}
		}
	};
	
}
	
	
	private MouseAdapter getTextFieldPeselMouseListener(){
	
	return new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            textFieldPesel.setText("");
            userPesel = "";
            buttonLogin.setEnabled(false);
        }
	};
}
	
	private KeyAdapter getTextFieldPeselKeyListener(){
	
	return new KeyAdapter() {
	    
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
							if (userPesel.length() == 11)
							{
								buttonLogin.setEnabled(true);
							}
					}
	    }
		
	  };
	  
}
	
	
	private ActionListener getButtonLoginActionListener(){
	
	return new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			peselValidation.setPeselNumber(userPesel);
			
			if(selectedPostalCode.length() != 0 && peselValidation.peselCorrectionTest())
				{
				
				JOptionPane.showMessageDialog(null, "Wybrałeś okręg wyborczy: " + selectedPostalCode
												+ "\nWprowadziłeś PESEL: " + userPesel
												+ "\n\nTeraz zagłosuj na swojego kandydata!\n\n",
												"Informacja", JOptionPane.INFORMATION_MESSAGE);
				
				mainFrame.changePaneInFrame(new CandidateChoicePane(mainFrame));
				mainFrame.changeTitleInFrame(CandidateChoicePane.getPaneName() + " " +selectedPostalCode);
				
				}
			else
			{
				JOptionPane.showMessageDialog(null, "Brak kodu pocztowego lub nieprawidłowy Pesel!"
													+ "\nSpróbuj jeszcze raz!" );
												//		+ userPesel.length() + "   " + selectedPostalCode.length());
				

			
					textFieldPesel.setText("");
					userPesel = "";
			}
							
		}
	};
	
}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Gets & Sets
	

		public String getPaneName() {
		
			return textWindow;
		}
		
		public static JTextField getTextFieldPesel(){
			
			return textFieldPesel;
			
		}

		
}