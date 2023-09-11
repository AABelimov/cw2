package pro.sky.cw.service;

import org.springframework.stereotype.Service;
import pro.sky.cw.domain.Question;
import pro.sky.cw.exception.MethodNotAllowedException;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final Random random;

    public MathQuestionService(Random random) {
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        String question = Integer.toString(random.nextInt(900) + 100);
        StringBuilder answer = new StringBuilder(question);
        answer.reverse();
        return new Question(question, answer.toString());
    }
}
