package pro.sky.cw.service;

import pro.sky.cw.domain.Question;

import java.util.Collection;
import java.util.Random;

public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();

    private final QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
