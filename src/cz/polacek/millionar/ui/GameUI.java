package cz.polacek.millionar.ui;

import cz.polacek.millionar.model.Question;
import cz.polacek.millionar.repository.MockQuestionRepository;
import cz.polacek.millionar.repository.QuestionRepository;

import java.util.Scanner;

public class GameUI {

    private static final int ADD_MONEY = 1000;

    private int currentScore;
    private Question currentQuestion;
    private QuestionRepository questionRepository;

    public GameUI(QuestionRepository QuestionRepository) {
        this.questionRepository = QuestionRepository;
    }

    public void startGame() {
        this.currentScore = 0;
        boolean isCorrectAnswer = false;
        do {
            genNewQuestion();
            showNewQuestion();
            isCorrectAnswer = isCorrectAnswer();
            if (isCorrectAnswer) {
                this.currentScore += ADD_MONEY;
            }
        } while (isCorrectAnswer && getQuestionRepository().hasNextQuestion());

        System.out.println("Uživatel vyhrál: " + this.currentScore);
    }

    private boolean isCorrectAnswer() {
        System.out.print("Zadej odpověď: ");
        String userAnswer = new Scanner(System.in).nextLine();
        return getCurrentQuestion().getCorrectAnswer().compareTo(userAnswer) == 0;
    }

    private void genNewQuestion() {
        this.currentQuestion = getQuestionRepository().getOneQuestion();
    }

    private void showNewQuestion() {
        System.out.println(this.getCurrentQuestion().getQuestion());
        for (int i = 0; i < this.getCurrentQuestion().getOptions().size(); i++) {
            String option = this.getCurrentQuestion().getOptions().get(i);
            System.out.println(i + " - " + option);
        }
    }


    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
}
