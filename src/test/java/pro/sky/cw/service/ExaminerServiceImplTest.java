package pro.sky.cw.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.cw.domain.Question;
import pro.sky.cw.exception.IncorrectAmountOfQuestionsException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    private final Collection<Question> questions = new HashSet<>(Set.of(
            new Question("qwe", "ewq"),
            new Question("asd", "dsa"),
            new Question("zxc", "cxz")));

    @Test
    void shouldReturnExceptionWhenAmountIncorrect() {
        when(questionServiceMock.getAll()).thenReturn(questions);

        assertThrows(IncorrectAmountOfQuestionsException.class, () -> out.getQuestions(questions.size() + 1));
    }

    @Test
    void shouldReturnSetWithAmountQuestions() {
        when(questionServiceMock.getAll()).thenReturn(questions);
        when(questionServiceMock.getRandomQuestion()).thenReturn(
                new Question("qwe", "ewq"),
                new Question("zxc", "cxz"),
                new Question("zxc", "cxz"),
                new Question("asd", "dsa"),
                new Question("qwe", "ewq")
        );

        assertIterableEquals(questions, out.getQuestions(3));
    }
}