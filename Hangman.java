import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
	
	public boolean win;
	
	public void Game() {
		Scanner in = new Scanner(System.in);
		String word = MakingTask.newTask();
		char wordToArray[] = word.toCharArray();
		char currentResult[] = new char[word.length()];
		LifeCounter life = new LifeCounter();
		
		for(int i = 0; i < word.length(); i++) {
			currentResult[i] = '-';
		}
		
		PrintResult(word.length(), currentResult);
		
		while(true) {
			if(life.lifes == 0) {
				win = false;
				life.lifes = 10;
				break;
			}
			
			boolean finish = false;
			String letter = in.nextLine();
			
			boolean isItRightLetter = false;
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for(int i = 0; i < word.length(); i++) {
				if(wordToArray[i] == (letter.charAt(0))) {
					isItRightLetter = true;
					indexes.add(i);
				}
			}
			
			if(isItRightLetter) {
				life.lifes = life.lifeCounter(true);
				for(int i = 0; i < indexes.size(); i++) {
					currentResult[indexes.get(i)] = wordToArray[indexes.get(i)];
					wordToArray[indexes.get(i)] = '-';
				}
			} else life.lifes = life.lifeCounter(false);
			
			System.out.println("У вас осталось жизней: " + life.lifes);
			
			PrintResult(word.length(), currentResult);
			
			int count = 0;
			for(int i = 0; i < currentResult.length; i++) {
				if(currentResult[i] != '-') count++;
			}
			if(count == currentResult.length) finish = true;
			
			if(finish) {
				win = true;
				life.lifes = 10;
				break;
			}
			
		}
	}
	
	private void PrintResult(int n, char[] result) {
		for(int i = 0; i < n; i++) {
			System.out.print(result[i]);
		}
		System.out.print("\n");
	}

}
