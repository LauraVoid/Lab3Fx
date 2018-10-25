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
	void butSearch(ActionEvent event) {

		if (RdRobos.isSelected()) {

			try {
				String info = playerFoundInfoRobos();
				labFoundPlayer.setText(info);
				System.out.println(info);
			} catch (IOException e ) {

				JOptionPane.showMessageDialog(null, "Jugador no encontrado");
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}

		} else if (RdRebotes.isSelected()) {

			try {
				String info = playerFoundInfoRebounds();
				System.out.println(info);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Jugador no encontrado");
				e.printStackTrace();
			}
		} else if (RdBloqueos.isSelected()) {
			try {
				String info = playerFoundInfoLocks();
				System.out.println(info);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Jugador no encontrado");
				e.printStackTrace();
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

	public void initialize() {

		try {
			fiba = new FIBA();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toggleGroup1();
		toggleGroup2();
	}

	public String playerFoundInfoRobos() throws IOException {

		String info = TxtValorB.getText();
		Double steal = Double.parseDouble(info);
		Player found = null;
		if (RdAVL.isSelected()) {

			found = fiba.searchStealAVL(steal);
		} else if (RdRB.isSelected()) {
			found = fiba.searchStealRB(steal);
		}

		String player = "Nombre: " + found.getName() + " \n Edad: " + found.getEdad() + "\n Equipo: " + found.getTeam() + "\n Puntos:"
				+ found.getPoints() + "\n Rebotes:" + found.getRebounds() + "\n Asistencias:" + found.getAssists() + "\n Robos:" + found.getSteal()
				+ "\n Bloqueos: " + found.getLocks();
		return player;

	}

	public String playerFoundInfoRebounds() throws IOException {

		String info = TxtValorB.getText();
		Double rebounds = Double.parseDouble(info);
		Player found = null;
		if (RdAVL.isSelected()) {

			found = fiba.searchReboundsAVL(rebounds);
		} else if (RdABB.isSelected()) {
			found = fiba.searchReboundsABB(rebounds);
		}
		// ABB

		String player = "Name " + found.getName() + " steal " + found.getSteal();
		return player;

	}

	public String playerFoundInfoLocks() throws IOException {

		String info = TxtValorB.getText();
		Double rebounds = Double.parseDouble(info);
		Player found = null;

		found = fiba.searchLocksRB(rebounds);

		String player = "Name " + found.getName() + " steal " + found.getSteal();
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
