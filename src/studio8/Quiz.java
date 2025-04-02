package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;

	public Quiz(Question[] questions) {
		this.questions = questions;
	}

	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		return in.nextLine(); // Allows full input with spaces
	}

	public int getTotalPoints() {
		int total = 0;
		for (Question q : questions) {
			total += q.getPoints();
		}
		return total;
	}

	public void takeQuiz(Scanner in) {
		int earned = 0;
		for (Question q : questions) {
			q.displayPrompt();
			String response = getUserAnswer(in);
			earned += q.checkAnswer(response);
		}
		System.out.println("You earned " + earned + " out of " + getTotalPoints() + " points.");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Question q1 = new Question("What is your favorite movie?", "500 days of summer", 50);

		String[] mcOptions = {"131", "231", "425"};
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(
			"What is the course code for this class?", "425", 1, mcOptions
		);

		String[] saOptions = {"A", "B", "C", "D"};
		SelectAllQuestion q3 = new SelectAllQuestion(
			"Which letters represent CS TAs who should watch 500 Days of Summer?", "AC", saOptions
		);

		Question[] allQuestions = {q1, q2, q3};
		Quiz quiz = new Quiz(allQuestions);
		quiz.takeQuiz(scanner);
		scanner.close();
	}
}
