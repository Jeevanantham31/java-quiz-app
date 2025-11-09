package quizapp.ui;

import quizapp.dao.QuestionDAO;
import quizapp.model.Question;
import quizapp.service.QuizService;
import java.util.List;

public class QuizApp {
    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("     WELCOME TO QUIZ APP");
        System.out.println("==============================");

        QuestionDAO dao = new QuestionDAO();
        List<Question> questions = dao.getAllQuestions();

        if (questions.isEmpty()) {
            System.out.println("⚠️ No questions found in database!");
        } else {
            QuizService service = new QuizService();
            service.startQuiz(questions);
        }
    }
}
