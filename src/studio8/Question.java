package studio8;

public class Question {

    private String prompt;
    private String answer;
    private int points;

    public Question(String prompt, String answer, int points) {
        this.prompt = prompt;
        this.answer = answer;
        this.points = points;
    }

    public void displayPrompt() {
        System.out.println(this.prompt + " (" + this.points + " points)");
    }

    public int checkAnswer(String givenAnswer) {
        return answer.equalsIgnoreCase(givenAnswer.trim()) ? this.points : 0;
    }

    public int getPoints() {
        return points;
    }

    public String getAnswer() {
        return answer;
    }

    public static void main(String[] args) {
        Question q = new Question("What is your favorite movie?", "500 days of summer", 50);
        q.displayPrompt();
        System.out.println("Points earned: " + q.checkAnswer("500 days of summer"));
        System.out.println("Points earned: " + q.checkAnswer("Anything else"));
    }
}
