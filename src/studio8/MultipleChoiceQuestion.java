package studio8;

public class MultipleChoiceQuestion extends Question {

    private String[] choices;

    /**
     * Constructor for MultipleChoiceQuestion
     * @param prompt the text of the question
     * @param answer the correct answer
     * @param points the number of points possible
     * @param choices the array of options to display
     */
    public MultipleChoiceQuestion(String prompt, String answer, int points, String[] choices) {
        super(prompt, answer, points);  
        this.choices = choices;         
    }

    /**
     * Displays the question prompt and each of the choices
     * in the format:
     * 1. choice1
     * 2. choice2
     * ...
     */
    @Override
    public void displayPrompt() {
        super.displayPrompt(); // prints prompt and points
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }

    /**
     * Returns the array of answer choices
     */
    public String[] getChoices() {
        return choices;
    }

    public static void main(String[] args) {
        // Use this ONLY for your own testing – not needed for JUnit
        String[] options = {"131", "231", "425"};
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(
            "What is the course code for this class?", "425", 1, options
        );

        mcq.displayPrompt();
        // Do not print anything else here during testing
    }
}
