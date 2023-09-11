package pro.sky.cw.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.cw.domain.Question;
import pro.sky.cw.exception.IncorrectAmountOfQuestionsException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        questionServices = new ArrayList<>();
        questionServices.add(javaQuestionService);
        questionServices.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionServices.get(0).getAll().size() * 2) {
            throw new IncorrectAmountOfQuestionsException();
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionServices.get(0).getRandomQuestion());
            if (questions.size() < amount) {
                questions.add(questionServices.get(1).getRandomQuestion());
            }
        }
        return questions;
    }
}
