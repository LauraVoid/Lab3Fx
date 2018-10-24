package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import modelo.FIBA;
import modelo.Player;

public class SampleController {
	
	private FIBA fiba;

    @FXML
    private ImageView PanelPlayerFoun;

    @FXML
    private TextField TxtValorB;

    @FXML
    private Label labTimeValue;

    @FXML
    private Button butSearch;

    @FXML
    private RadioButton RdRebotes;

    @FXML
    private RadioButton RdAsistencias;

    @FXML
    private RadioButton RdRobos;

    @FXML
    private RadioButton RdBloqueos;

    @FXML
    private RadioButton RdABB;

    @FXML
    private RadioButton RdRB;

    @FXML
    private RadioButton RdAVL;

    @FXML
    void butSearch(ActionEvent event) {
    	
    	if(RdRobos.isSelected()) {
    		
    		try {
				String info =playerFoundInfoRobos();
				System.out.println(info);
			} catch (IOException e) {
				
				JOptionPane.showMessageDialog(null,"Jugador no encontrado"  );
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	else if (RdRebotes.isSelected()) {
    		
    		try {
				String info= playerFoundInfoRebounds();
				System.out.println(info);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,"Jugador no encontrado"  );
				e.printStackTrace();
			}
    	}
    }
    
    
    private void toggleGroup1() {
		// TODO Auto-generated method stub
    	ToggleGroup g1=new ToggleGroup();
    	RdABB.setToggleGroup(g1);
    	RdRB.setToggleGroup(g1);
    	RdAVL.setToggleGroup(g1);
    	
	}
    
    private void toggleGroup2() {
		// TODO Auto-generated method stub
    	ToggleGroup g2=new ToggleGroup();
    	RdRebotes.setToggleGroup(g2);
    	RdAsistencias.setToggleGroup(g2);
    	RdBloqueos.setToggleGroup(g2);
    	RdRobos.setToggleGroup(g2);

    	
	}

    public void initialize() {
    	
    	try {
			fiba= new FIBA();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	toggleGroup1();
    	toggleGroup2();
    }
    
    public String playerFoundInfoRobos() throws IOException {
    	
    	String info= TxtValorB.getText();
    	Double steal= Double.parseDouble(info);
    	Player found=null;
    	if(RdAVL.isSelected()) {
    		
    		 found= fiba.searchStealAVL(steal);
    	}
    	else if(RdRB.isSelected()) {
    		 found= fiba.searchStealRB(steal);
    	}
    	 
    	String player= "Name "+found.getName()+" steal " +found.getSteal();
    	return player;
    	
    	
    	
    }
public String playerFoundInfoRebounds() throws IOException {
    	
    	String info= TxtValorB.getText();
    	Double rebounds= Double.parseDouble(info);
    	Player found=null;
    	if(RdAVL.isSelected()) {
    		
    		 found= fiba.searchReboundsAVL(rebounds);
    	}
    	// ABB
    	 
    	String player= "Name "+found.getName()+" steal " +found.getSteal();
    	return player;
    	
    	
    	
    }
    
    @FXML
    void rdAsistencias(ActionEvent event) {

    	RdRB.setDisable(true);
    	RdAVL.setDisable(true);
    	
    }

    @FXML
    void rdRebotes(ActionEvent event) {

    	RdRB.setDisable(true);
    }

    @FXML
    void rdRobos(ActionEvent event) {
    	RdABB.setDisable(true);
    }
    @FXML
    void rdBloqueos(ActionEvent event) {
    	RdAVL.setDisable(true);
    	RdABB.setDisable(true);

    }
    
    
}

