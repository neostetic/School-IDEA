package cz.polacek.millionar.repository;

import cz.polacek.millionar.model.Question;

import java.util.*;

public class MockQuestionRepository implements QuestionRepository {

    public static final List<Question> QUESTIONS = new LinkedList<>();

    static {
        QUESTIONS.add(new Question("Kolik je 0+1?", Arrays.asList("1", "2", "4", "10"), "1"));
        QUESTIONS.add(new Question("Kolik je 1+1?", Arrays.asList("1", "2", "4", "10"), "2"));
        QUESTIONS.add(new Question("Kolik je 2+2?", Arrays.asList("1", "2", "4", "10"), "4"));
    }

    private Set<Question> usedQuestions;

    public MockQuestionRepository() {
        this.usedQuestions = new HashSet<>();
    }

    @Override
    public Question getOneQuestion() {
        Question question;
        boolean containsQuestion;
        do {
            question = QUESTIONS.get(getRandomQuestion());
            containsQuestion = usedQuestions.contains(question);
        } while (containsQuestion);

        usedQuestions.add(question);

        return question;
    }

    @Override
    public boolean hasNextQuestion() {
        return usedQuestions.size() != QUESTIONS.size();
    }

    private int getRandomQuestion() {
        return (int) (Math.random() * QUESTIONS.size());
    }
}
