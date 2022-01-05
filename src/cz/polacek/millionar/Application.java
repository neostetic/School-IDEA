package cz.polacek.millionar;

import cz.polacek.millionar.repository.MockQuestionRepository;
import cz.polacek.millionar.ui.GameUI;

public class Application {

    public static void main(String[] args) {
        GameUI gameUI = new GameUI(new MockQuestionRepository());
        gameUI.startGame();
    }

}
