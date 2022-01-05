package cz.polacek.millionar.repository;

import cz.polacek.millionar.model.Question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MockQuestionRepository implements QuestionRepository {

    public static final List<Question> QUESTIONS = new LinkedList<>();

    static {
        QUESTIONS.add(new Question("Kolik je 0+1?", Arrays.asList("1", "2", "4", "10"), "1"));
    }

}
