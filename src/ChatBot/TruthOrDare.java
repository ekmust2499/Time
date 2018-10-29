package ChatBot;
import java.util.HashMap;
import java.util.Random;

public class TruthOrDare {

	public enum StatesGame {
		Correct, Incorrect, About, Stop
	}

	private Brain currentUser;
	Random rnd = new Random();
	public StatesGame currentStateGame;
	public HashMap<String, String> nameArchive;
	public String[] gamers;
	
	public TruthOrDare(Brain brain) {
		nameArchive = new HashMap<>();
		nameArchive.put("правда", "Truth");
		nameArchive.put("действие", "Dare");
		currentUser = brain;
	}

	public String taskForPlayer(String answer){
		checkState(answer);
		switch(currentStateGame) {
		case Correct:
			if (answer.contains("правда")) {
				return TaskMaker.newTask(nameArchive.get("правда")) + "\n";
			} else {
				return TaskMaker.newTask(nameArchive.get("действие")) + "\n";
			}
		case Incorrect:
			return null;
		case About:
			return null;
		case Stop:
			return null;
		}
		return null;
	}
	
	public void checkState(String answer) {
		if (answer.startsWith("стоп")) {
			currentStateGame = StatesGame.Stop;
		} else if (answer.startsWith("правда") || answer.startsWith("действие")) {
			currentStateGame = StatesGame.Correct;
		} else if (answer.startsWith("о себе")) {
			currentStateGame = StatesGame.About;
		} else {
			currentStateGame = StatesGame.Incorrect;
		}
	}

	public String askPlayer() {
		String currentGamer = gamers[rnd.nextInt(gamers.length)];
		return currentGamer + Dialog.INSTANCE.getString("что из");
	}

	public void parseNames(String names) {
		gamers = names.split(",");
	}

	public String truthOrDareAskPlayer(String input) {
		this.checkState(input);
		if (this.currentStateGame == TruthOrDare.StatesGame.Stop) {
			currentUser.fsm.setState(currentUser::startMessage);
			return Dialog.INSTANCE.getString("прощание");
		}
		currentUser.fsm.setState(this::truthOrDareGame);
		return this.askPlayer();
	}

	public String truthOrDareGame(String input) {
		String result = this.taskForPlayer(input);

		switch(this.currentStateGame) {
			case Correct:
				currentUser.fsm.setState(this::truthOrDareAskPlayer);
				return result;
			case Incorrect:
				currentUser.fsm.setState(this::truthOrDareGame);
				return Dialog.INSTANCE.getString("некорректный ввод");
			case About:
				currentUser.fsm.setState(this::truthOrDareGame);
				return Dialog.INSTANCE.getString("расскажи");
			case Stop:
				currentUser.fsm.setState(currentUser::startMessage);
				return Dialog.INSTANCE.getString("прощание");
		}
		return null;
	}

}
