package cz.polacek.millionar.repository;

import cz.polacek.millionar.model.Question;

public interface QuestionRepository {

    /**
     * Returns only a one question
     *
     * @return question
     */
    Question getOneQuestion();


    boolean hasNextQuestion();
}
