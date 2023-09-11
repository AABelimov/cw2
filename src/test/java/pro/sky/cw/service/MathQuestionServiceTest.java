package pro.sky.cw.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.cw.domain.Question;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private Random randomMock;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void shouldReturnTrueAfterRandom() {
        when(randomMock.nextInt(anyInt())).thenReturn(123);

        assertEquals(new Question("123", "321"), out.getRandomQuestion());
    }
}