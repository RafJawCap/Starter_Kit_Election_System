package com.capgemini.StarterKit.SwingClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;




import org.springframework.web.client.RestTemplate;


//import com.capgemini.StarterKit.main.DAOTransfer;
//import com.capgemini.StarterKit.model.Candidate;
import com.capgemini.StarterKit.entities.Candidate;
import com.capgemini.StarterKit.entities.Results;
//import com.capgemini.StarterKit.entities.ZipCode;

public class CandidateChoicePane extends JPanel {
	/**
	 * 
	 */
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Class Fields
	
	private static final long serialVersionUID = 1L;
	
	// Strings
    private  final String textConfirmButton = "Zatwierdź";
    private  final static String textWindow = "Okręg wyborczy";
    
    //Arrays
    
//    private String[] candidates = {"Adam Abacki", "Bronisław Babacki", "Cezary Cabacki", "Damian Dabacki"};
    
    // JComponents
    private JButton buttonConfirm;
	private ButtonGroup jRadioButtonsGroup = new ButtonGroup();
	
    // JPanels
    private JPanel paneJRadioButtons = new JPanel();
    private JPanel paneConfirmButton = new JPanel();
    
    // JFrames
    private MainFrame mainFrame;
    
    // DAO
    
    private List<Candidate> listCandidates;
    //private DAOTransfer daoTransfer;
	//private List<Candidate> selectedListCandidates;
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    // Selected ones
    private static String selectedCandidate = "";
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Constructor
    
    public CandidateChoicePane(MainFrame mainFrame){
    	
    	this.mainFrame = mainFrame;
    	
    	restServiceCandidatesDownload();
    	
   // 	daoTransfer = new DAOTransfer();
   //	listCandidates = daoTransfer.listCandidate;    	
   // 	selectedListCandidates = daoTransfer.selectCandidateByZipCodeId(LoginPane.postalCodeId);
   
    	
    	createCandidateChoicePane();
    	
    };
        
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Downloading data from RestService
    
   public void restServiceCandidatesDownload (){
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	List<Candidate> listCandidates = Arrays.asList(restTemplate.getForObject(RestServiceAdresses.CANDIDATE_FIND_FOR_ZIPCODE
    			+ Integer.toString(LoginPane.postalCodeId), Candidate[].class));
    	
    	this.listCandidates = listCandidates;
    }
    
    
    public void restServiceResultSaveGET (){
    	
    	RestTemplate restTemplate = new RestTemplate();

    	String response = restTemplate.getForObject(RestServiceAdresses.SAVE_RESULTS_TO_DATABASE_GET + returnPathForSavetoDatabase(), String.class);

    	System.out.println(response);
    }
    
    public void restServiceResultSavePOST (){
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
        String tempTab[] = selectedCandidate.split(" ",2);
        
        String firstName = tempTab[0].trim();
        String surname = tempTab[1].trim();
    	
    	restTemplate.postForLocation(RestServiceAdresses.SAVE_RESULTS_TO_DATABASE_POST, new Results(LoginPane.userPesel, surname, firstName, 1));

    }
    
    public String returnPathForSavetoDatabase (){
    	
     String tempTab[] = selectedCandidate.split(" ",2);
        
      String firstName = tempTab[0].trim();
      String surname = tempTab[1].trim();
    
      System.out.println(surname);
      System.out.println(firstName);
      
    	return LoginPane.userPesel + "/" + firstName + "/" + surname + "/1";
    	
    }
    
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Creating Main Interface
    
    private void createCandidateChoicePane() {
        
    	this.setAlignmentX(Box.CENTER_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createVerticalGlue());
		
		this.add(setJRadioButtonsPane(paneJRadioButtons, getJRadioButtonsGroup()));
		this.add(setButtonPane(paneConfirmButton));
		
        this.add(Box.createVerticalGlue());
        
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Add JComponents  & set functionality
    
    private JPanel setButtonPane(JPanel Pane){
    	
    	buttonConfirm = new JButton(textConfirmButton);
    	buttonConfirm.setAlignmentX(CENTER_ALIGNMENT);
    	buttonConfirm.setEnabled(false);
    	buttonConfirm.addActionListener(getButtonConfirmActionListener());
        Pane.add(buttonConfirm);
        Pane.add(Box.createVerticalGlue());
        
        return Pane;
    }
        
    private JPanel setJRadioButtonsPane(JPanel Pane, ActionListener actionListener){
    	
    	Pane.setAlignmentX(Box.CENTER_ALIGNMENT);
		Pane.setLayout(new BoxLayout(Pane, BoxLayout.Y_AXIS));
    	
    	for (Candidate p : listCandidates) {
    		
    		//if (p.getZipCodesId() == LoginPane.postalCodeId){
    		
        	JRadioButton newJRadioButton = new JRadioButton( p.getSurname() + " " + p.getFirstname());
        	newJRadioButton.setAlignmentX(LEFT_ALIGNMENT);
        	newJRadioButton.addActionListener(actionListener);
        	jRadioButtonsGroup.add(newJRadioButton);
        	Pane.add(newJRadioButton);
			Pane.add(Box.createVerticalGlue());
			
    		//}
    	}
    	
    	Pane.add(Box.createVerticalGlue());
    	
    	return Pane;
    }

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Set ActionListeners & Adapters
    
	 private ActionListener getJRadioButtonsGroup() {
			
	    	return new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(e.getSource() instanceof JRadioButton){
			            
						JRadioButton radioButton = (JRadioButton) e.getSource();
			            	if(radioButton.isSelected())
			            		{
			            			selectedCandidate = radioButton.getText();
			            			buttonConfirm.setEnabled(true);
			            		}
			            
			        }
			    }

			
		};
	}
	 
	 private ActionListener getButtonConfirmActionListener() {

			return new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(selectedCandidate.length() != 0)
					{
					
					restServiceResultSaveGET();	
					//restServiceResultSavePOST();	
						
					JOptionPane.showMessageDialog(null, "Wybrałeś okręg wyborczy:  " + LoginPane.selectedPostalCode
													+ "\nWprowadziłeś PESEL:  " + LoginPane.userPesel
													+ "\n\nWybrałeś kandydata:  " + selectedCandidate + "\n\n",
													"Informacja", JOptionPane.INFORMATION_MESSAGE);
					
//					jRadioButtonsGroup.clearSelection();
//					buttonConfirm.setEnabled(false);
					mainFrame.closeWindow();
					}
				}
			};

	}
	 

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Gets & Sets
    
    public static String getPaneName(){ return textWindow; }
    
    public static String getSelectedCandidate(){ return selectedCandidate; }

    
}
