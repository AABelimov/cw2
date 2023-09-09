package pro.sky.cw.service;

import org.springframework.stereotype.Service;
import pro.sky.cw.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question item = new Question(question, answer);
        questions.add(item);
        return item;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int max = questions.size();
        List<Question> questionsList = new ArrayList<>(questions);
        return questionsList.get((int) (Math.random() * max));
    }
}
