package pro.sky.cw.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.cw.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("qwe", "ewq"));
        questions.add(new Question("asd", "dsa"));
        questions.add(new Question("zxc", "cxz"));
    }

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
}
