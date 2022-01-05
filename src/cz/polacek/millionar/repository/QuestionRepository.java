package cz.polacek.millionar.repository;

import cz.polacek.millionar.model.Question;

public interface QuestionRepository {

    Question getOneQuestion();
    boolean hasNextQuestion();

}
