package application;

import java.io.IOException;

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
    private RadioButton RdRN;

    @FXML
    private RadioButton RdAVL;

    @FXML
    void butSearch(ActionEvent event) {
    	
    	if(RdRobos.isSelected()) {
    		
    		if(RdAVL.isSelected()){
    			String val= TxtValorB.getText();
    			try {
					Player p=fiba.searchStealAVL(Double.parseDouble(val));
					System.out.println(p.getName());
					System.out.println(p.getSteal());
//					System.out.println(p.get);
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
    		}
    		
    	}
    }
    
    
    private void toggleGroup1() {
		// TODO Auto-generated method stub
    	ToggleGroup g1=new ToggleGroup();
    	RdABB.setToggleGroup(g1);
    	RdRN.setToggleGroup(g1);
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
    
    public void playerFoundInfo() {
    	
    	
    	
    	
    }
    
    @FXML
    void rdAsistencias(ActionEvent event) {

    	
    }

    @FXML
    void rdRebotes(ActionEvent event) {

    }

    @FXML
    void rdRobos(ActionEvent event) {
    	RdABB.setDisable(true);
    }
    
    
}

