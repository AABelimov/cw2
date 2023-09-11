package pro.sky.cw.service;

import pro.sky.cw.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
