package cz.polacek.millionar;

import cz.polacek.millionar.repository.FileQuestionRepository;
import cz.polacek.millionar.ui.GameUI;

import java.io.File;

public class Application {

    public static final String QUESTION_FILE_PATH = "./src/cz/polacek/millionar/questions.csv";

    public static void main(String[] arg) throws Exception {
        GameUI gameUi = new GameUI(new FileQuestionRepository(new File(QUESTION_FILE_PATH)));
        gameUi.startGame();
    }
}
