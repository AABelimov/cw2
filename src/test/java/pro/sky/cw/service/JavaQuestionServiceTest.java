package pro.sky.cw.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.cw.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private QuestionService out;

    @BeforeEach
    void beforeEach() {
        out = new JavaQuestionService();
        out.add(new Question("qwe", "ewq"));
        out.add(new Question("asd", "dsa"));
        out.add(new Question("zxc", "cxz"));
    }

    @Test
    void shouldReturnCollectionWithQuestions() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("qwe", "ewq"),
                new Question("asd", "dsa"),
                new Question("zxc", "cxz")
        ));

        assertIterableEquals(expected, out.getAll());
    }

    @Test
    void shouldReturnQuestionAfterAddAndCorrectCollection() {
        Set<Question> expectedSet = new HashSet<>(Set.of(
                new Question("qwe", "ewq"),
                new Question("asd", "dsa"),
                new Question("zxc", "cxz"),
                new Question("iop", "poi")
        ));
        Question expectedQuestion = new Question("iop", "poi");

        assertEquals(expectedQuestion, out.add(new Question("iop", "poi")));
        assertIterableEquals(expectedSet, out.getAll());
    }

    @Test
    void shouldReturnQuestionAfterRemoveAndCorrectCollection() {
        Set<Question> expectedSet = new HashSet<>(Set.of(
                new Question("asd", "dsa"),
                new Question("zxc", "cxz")
        ));
        Question expectedQuestion = new Question("qwe", "ewq");

        assertEquals(expectedQuestion, out.remove(new Question("qwe", "ewq")));
        assertIterableEquals(expectedSet, out.getAll());
    }

    @Test
    void shouldReturnTrueAfterRandom() {
        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }
}