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
	private Label labFoundPlayer;

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
	private TextField txtName;

	@FXML
	private TextField txtAge;

	@FXML
	private TextField txtTeam;

	@FXML
	private TextField txtPoints;

	@FXML
	private TextField txtRebounds;

	@FXML
	private TextField txtAssists;

	@FXML
	private TextField txtSteal;

	@FXML
	private TextField txtLocks;

	@FXML
	private Button butAddPlayer;
	
	   @FXML
	    private RadioButton rdStealsDelete;

	    @FXML
	    private RadioButton rdReboundsDelete;

	    @FXML
	    private RadioButton rdLocksDelete;

	    @FXML
	    private RadioButton rdAssistsDelete;

	    @FXML
	    private TextField txtEliminar;

	    @FXML
	    private Button butEliminar;

	@FXML
	void butSearch(ActionEvent event) {
 
		if (RdRobos.isSelected()) {

			try {
				labTimeValue.setText(" "); 
				String info = playerFoundInfoRobos();
				labFoundPlayer.setText(info);
				System.out.println(info);
			} catch (IOException e ) {

				JOptionPane.showMessageDialog(null, "Jugador no encontrado");
				// TODO Auto-generated catch block
			}

		} else if (RdRebotes.isSelected()) {

			try {
				labTimeValue.setText(" "); 
				String info = playerFoundInfoRebounds();
				System.out.println(info);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Jugador no encontrado");
			}
		} else if (RdBloqueos.isSelected()) {
			try {
				labTimeValue.setText(" "); 
				String info = playerFoundInfoLocks();
				System.out.println(info);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Jugador no encontrado");
			}

		}
	}

	@FXML
	void butAddPlayerE(ActionEvent event) {

		String name = txtName.getText();
		Integer age = Integer.parseInt(txtAge.getText());
		String team = txtTeam.getText();
		Integer points = Integer.parseInt(txtPoints.getText());
		Double rebounds = Double.parseDouble(txtRebounds.getText());
		Double assists = Double.parseDouble(txtAssists.getText());
		Double steal = Double.parseDouble(txtSteal.getText());
		Double locks = Double.parseDouble(txtLocks.getText());

		Player player = new Player(name, age, team, points, rebounds, assists, steal, locks);
		try {
			fiba.addNewPlayer(player);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El jugador no se ha agregar correctamente");
		}

	}

	private void toggleGroup1() {
		// TODO Auto-generated method stub
		ToggleGroup g1 = new ToggleGroup();
		RdABB.setToggleGroup(g1);
		RdRB.setToggleGroup(g1);
		RdAVL.setToggleGroup(g1);

	}

	private void toggleGroup2() {
		// TODO Auto-generated method stub
		ToggleGroup g2 = new ToggleGroup();
		RdRebotes.setToggleGroup(g2);
		RdAsistencias.setToggleGroup(g2);
		RdBloqueos.setToggleGroup(g2);
		RdRobos.setToggleGroup(g2);

	}
	
	private void toggleGroup3() {
		// TODO Auto-generated method stub
		ToggleGroup g3 = new ToggleGroup();
		rdStealsDelete.setToggleGroup(g3);
		rdReboundsDelete.setToggleGroup(g3);
		rdLocksDelete.setToggleGroup(g3);
		rdAssistsDelete.setToggleGroup(g3);


	}

	public void initialize() {

		try {
			fiba = new FIBA();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toggleGroup1();
		toggleGroup2();
		toggleGroup3();
	}

	public String playerFoundInfoRobos() throws IOException {

		String info = TxtValorB.getText();
		Double steal = Double.parseDouble(info);
		Player found = null;
		if (RdAVL.isSelected()) {
			long start = System.nanoTime(); 
			found = fiba.searchStealAVL(steal);
			long end = System.nanoTime(); 
			long total=fiba.executionTime(start, end);
			labTimeValue.setText(total+" AVL");
		} else if (RdRB.isSelected()) {
			long start = System.nanoTime(); 
			found = fiba.searchStealRB(steal);
			long end = System.nanoTime(); 
			long total=fiba.executionTime(start, end);
			labTimeValue.setText(total+" RB");
		}

		String player = "Nombre: " + found.getName() + " \n Edad: " + found.getEdad() + "\n Equipo: " + found.getTeam() + "\n Puntos:"
				+ found.getPoints() + "\n Rebotes:" + found.getRebounds() + "\n Asistencias:" + found.getAssists() + "\n Robos:" + found.getSteal()
				+ "\n Bloqueos: " + found.getLocks();
		return player;

	}

	public String playerFoundInfoRebounds() throws Exception {

		String info = TxtValorB.getText();
		Double rebounds = Double.parseDouble(info);
		Player found = null;
		if (RdAVL.isSelected()) {
			long start = System.nanoTime(); 
			found = fiba.searchReboundsAVL(rebounds);
			long end = System.nanoTime(); 
			long total=fiba.executionTime(start, end);
			labTimeValue.setText(total+" AVL");
		} else if (RdABB.isSelected()) {
			long start = System.nanoTime(); 
			found = fiba.searchReboundsABB(rebounds);
			long end = System.nanoTime(); 
			long total=fiba.executionTime(start, end);
			labTimeValue.setText(total+" ABB");
		}
		// ABB


		String player = "Nombre: " + found.getName() + " \n Edad: " + found.getEdad() + "\n Equipo: " + found.getTeam() + "\n Puntos:"
				+ found.getPoints() + "\n Rebotes:" + found.getRebounds() + "\n Asistencias:" + found.getAssists() + "\n Robos:" + found.getSteal()
				+ "\n Bloqueos: " + found.getLocks();
		return player;

	}

	public String playerFoundInfoLocks() throws IOException {
		labTimeValue.setText(" "); 
		String info = TxtValorB.getText();
		Double rebounds = Double.parseDouble(info);
		Player found = null;
		long start = System.nanoTime(); 
		found = fiba.searchLocksRB(rebounds);
		long end = System.nanoTime(); 
		long total=fiba.executionTime(start, end);
		labTimeValue.setText(total+" RB" );

		String player = "Nombre: " + found.getName() + " \n Edad: " + found.getEdad() + "\n Equipo: " + found.getTeam() + "\n Puntos:"
				+ found.getPoints() + "\n Rebotes:" + found.getRebounds() + "\n Asistencias:" + found.getAssists() + "\n Robos:" + found.getSteal()
				+ "\n Bloqueos: " + found.getLocks();
		return player;

	}

	@FXML
	void rdAsistencias(ActionEvent event) {

		RdRB.setDisable(true);
		RdAVL.setDisable(true);
		RdABB.setDisable(false);

	}

	@FXML
	void rdRebotes(ActionEvent event) {

		RdRB.setDisable(true);
		RdAVL.setDisable(false);
		RdABB.setDisable(false);
	}

	@FXML
	void rdRobos(ActionEvent event) {
		RdABB.setDisable(true);
		RdAVL.setDisable(false);
		RdRB.setDisable(false);
	}

	@FXML
	void rdBloqueos(ActionEvent event) {
		RdAVL.setDisable(true);
		RdABB.setDisable(true);
		RdRB.setDisable(false);

	}
	@FXML
    void butEliminar(ActionEvent event) {
		String info = txtEliminar.getText();
		Double eliminar = Double.parseDouble(info);
		if(rdAssistsDelete.isSelected()) {
			fiba.getAssistsABBTree().deleteAbb(eliminar);
			
		}
		else if(rdLocksDelete.isSelected()) {
			
			fiba.getRBLocksTree().RBDelete(eliminar);
		}
		else if(rdStealsDelete.isSelected()) {
			fiba.deleteStealAVL(eliminar);
			fiba.getStealRBTree().RBDelete(eliminar);
		}
		else if(rdReboundsDelete.isSelected()) {
			fiba.getReboundsABBTree().deleteAbb(eliminar);
			fiba.deleteReboundsAVL(eliminar);
		}
		
		

    }
	 @FXML
	    void rdAssistsDelete(ActionEvent event) {

	    }

	  

	    @FXML
	    void rdLocksDelete(ActionEvent event) {

	    }

	   

	    @FXML
	    void rdReboundsDelete(ActionEvent event) {

	    }

	  

	    @FXML
	    void rdStealsDelete(ActionEvent event) {

	    }



    

}
