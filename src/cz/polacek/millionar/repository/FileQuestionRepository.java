package cz.polacek.millionar.repository;

import cz.polacek.millionar.model.Question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class FileQuestionRepository implements QuestionRepository {

    private File file;
    private Scanner scanner;
    private List<Question> list;

    public FileQuestionRepository(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(new FileInputStream(file));

        this.usedQuestions = new HashSet<>();

        loadQuestions();
        this.scanner.close();
    }

    private void loadQuestions() {
        this.list = new LinkedList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String question = line.split(";")[0];
            List<String> options = List.of(line.split(";")[2].split(","));
            String answer = line.split(";")[1].replace("\"", "");

            list.add(new Question(question, options, answer));
        }
    }

    private Set<Question> usedQuestions;

    @Override
    public Question getOneQuestion() {
        Question newQuestion;
        boolean isQuestionUsed;
        do {
            newQuestion = list.get(new Random().nextInt(list.size()));
            isQuestionUsed = usedQuestions.contains(newQuestion);
        } while (isQuestionUsed);

        usedQuestions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public boolean hasNextQuestion() {
        return usedQuestions.size() != list.size();
    }
}
