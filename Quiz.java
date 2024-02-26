// Quiz.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getText());
            for (int i = 0; i < question.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + question.getOptions()[i]);
            }

            System.out.print("Your choice: ");
            int userChoice = scanner.nextInt();

            if (userChoice - 1 == question.getCorrectOptionIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + (question.getCorrectOptionIndex() + 1) + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        // Example usage
        Quiz quiz = new Quiz();

        // Add questions to the quiz
        Question question1 = new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2);
        Question question2 = new Question("Which planet is known as the Red Planet?", new String[]{"Mars", "Jupiter", "Venus", "Saturn"}, 0);
        Question question3 = new Question("What is the largest mammal?", new String[]{"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"}, 1);
        Question question4 = new Question("Who wrote 'Romeo and Juliet'?", new String[]{"Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"}, 1);

        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);

        // Start the quiz
        quiz.startQuiz();
    }
}
