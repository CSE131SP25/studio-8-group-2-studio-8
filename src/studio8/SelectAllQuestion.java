package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

    public SelectAllQuestion(String prompt, String answer, String[] choices) {
        super(prompt, answer, answer.length(), choices); // Points = num of correct answers
    }

    @Override
    public int checkAnswer(String givenAnswer) {
        int missed = findMissingCorrectAnswers(givenAnswer);   // Correct answers not selected
        int wrong = findIncorrectGivenAnswers(givenAnswer);    // Wrong answers selected
        int score = this.getPoints() - missed - wrong;
        System.out.println(missed);
        System.out.println(wrong);
        System.out.println(score);
        return Math.max(0, score);
    }

    private int findMissingCorrectAnswers(String givenAnswer) {
        String correctAnswer = this.getAnswer();
        return findMissingCharacters(givenAnswer, correctAnswer);
    }

    private int findIncorrectGivenAnswers(String givenAnswer) {
        String correctAnswer = this.getAnswer();
        return findMissingCharacters(correctAnswer, givenAnswer);
    }

    private static int findMissingCharacters(String baseString, String toCheck) {
        int missingValues = 0;
        for (int i = 0; i < toCheck.length(); i++) {
            char characterToLocate = toCheck.charAt(i);
            if (baseString.indexOf(characterToLocate) == -1) {
                missingValues++;
            }
        }
        return missingValues;
    }

    public static void main(String[] args) {
        // Optional: manual test
        String[] choices = {"instance variables", "git", "methods", "eclipse"};
        SelectAllQuestion saq = new SelectAllQuestion(
            "Select all of the following that can be found within a class:", "13", choices
        );

        saq.displayPrompt();
        System.out.println("Score for '13': " + saq.checkAnswer("13"));  // full
        System.out.println("Score for '1': " + saq.checkAnswer("1"));    // partial
        System.out.println("Score for '2': " + saq.checkAnswer("2"));    // wrong
        System.out.println("Score for '1234': " + saq.checkAnswer("1234")); // overselect
    }
}
