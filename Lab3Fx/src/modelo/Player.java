package modelo;

public class Player {
	
	private String name;
	private int edad;
	private String team;
	private Integer points;
	private double rebounds;
	private double assists;
	private double steal;
	private double locks;
	private int index;
	public Player(String name, int edad, String team, Integer points, double rebounds, double assists, double steal, double locks) {
		super();
		this.name = name;
		this.edad = edad;
		this.team = team;
		this.points = points;
		this.rebounds=rebounds;
		this.assists = assists;
		this.steal = steal;
		this.locks = locks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public double getAssists() {
		return assists;
	}
	public void setAssists(double assists) {
		this.assists = assists;
	}
	public double getSteal() {
		return steal;
	}
	public void setSteal(double steal) {
		this.steal = steal;
	}
	public double getLocks() {
		return locks;
	}
	public void setLocks(double locks) {
		this.locks = locks;
	}
	public double getRebounds() {
		return rebounds;
	}
	public void setRebounds(double rebounds) {
		this.rebounds = rebounds;
	}
	
	
	

}
