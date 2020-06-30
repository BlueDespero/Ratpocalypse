package ratpocalypse.backend;

public class GameVariableManager {

	private Handler handler;
	public boolean[] unlocked;
	public int selectedUnit;
	public static int yellowRoses;
	public static int lastYellowRoses;
	public static int difficulty;
	
	public GameVariableManager(Handler handler) {
		this.handler=handler;
		this.unlocked = new boolean[9];
		this.unlocked[0] = true;
		this.selectedUnit = 0;
		GameVariableManager.yellowRoses = 200;
		GameVariableManager.difficulty=1;
	}

	public int getSelectedUnit() {
		return selectedUnit;
	}

	public void setSelectedUnit(int selectedUnit) {
		this.selectedUnit = selectedUnit;
	}

	public static int getYellowRoses() {
		return yellowRoses;
	}

	public static void setYellowRoses(int yellowRoses) {
		GameVariableManager.yellowRoses = yellowRoses;
	}

	public static int getLastYellowRoses() {
		return lastYellowRoses;
	}

	public static void setLastYellowRoses(int lastYellowRoses) {
		GameVariableManager.lastYellowRoses = lastYellowRoses;
	}

	public static int getDifficulty() {
		return difficulty;
	}

	public static void setDifficulty(int difficulty) {
		GameVariableManager.difficulty = difficulty;
	}
	
	public static void incrementDifficulty() {
		GameVariableManager.difficulty+=1;
	}
	
	public static void decrementDifficulty() {
		GameVariableManager.difficulty-=1;
	}
	
}
