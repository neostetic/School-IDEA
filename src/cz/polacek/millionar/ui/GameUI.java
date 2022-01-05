package cz.polacek.millionar.ui;

import cz.polacek.millionar.model.Question;
import cz.polacek.millionar.repository.MockQuestionRepository;
import cz.polacek.millionar.repository.QuestionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameUI {

    private static final int ADD_MONEY = 1000;
    private static final Map<Integer, Integer> PRICE_MAP;

    static {
        PRICE_MAP = new HashMap<>();

        int round = 0;
        PRICE_MAP.put(round++, 0);
        PRICE_MAP.put(round++, 1_000);
        PRICE_MAP.put(round++, 2_000);
        PRICE_MAP.put(round++, 5_000);
        PRICE_MAP.put(round++, 10_000);
        PRICE_MAP.put(round++, 20_000);
    }

    private int currentScore;
    private int currentRound = 0;
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
                this.currentRound++;
                // this.currentScore += PRICE_MAP.get(this.currentScore);
            }
        } while (isCorrectAnswer && getQuestionRepository().hasNextQuestion());

        // System.out.println("Uživatel vyhrál: " + this.currentScore);
        System.out.println("Uživatel vyhrál: " + PRICE_MAP.get(this.currentRound));
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
