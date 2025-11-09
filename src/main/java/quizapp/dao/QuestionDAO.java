package quizapp.dao;

import quizapp.model.Question;
import java.sql.*;
import java.util.*;

public class QuestionDAO {

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM questions";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Question q = new Question(
                    rs.getInt("id"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_option")
                );
                questions.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
}
