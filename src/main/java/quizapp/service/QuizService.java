package quizapp.service;

import quizapp.model.Question;
import java.util.List;
import java.util.Scanner;

public class QuizService {

    public void startQuiz(List<Question> questions) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

      
        System.out.println("          QUIZ START");

        for (Question q : questions) {
            System.out.println("\n" + q.getQuestionText());
            System.out.println("A) " + q.getOptionA());
            System.out.println("B) " + q.getOptionB());
            System.out.println("C) " + q.getOptionC());
            System.out.println("D) " + q.getOptionD());
            System.out.print("Enter your answer (A/B/C/D): ");
            String answer = sc.nextLine().trim().toUpperCase();

            if (answer.equals(q.getCorrectOption())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.getCorrectOption());
            }
        }

        System.out.println("\n        QUIZ FINISHED");
        System.out.println("=========================");
        System.out.println("You scored: " + score + " / " + questions.size());
        System.out.println("=========================");
    }
}
