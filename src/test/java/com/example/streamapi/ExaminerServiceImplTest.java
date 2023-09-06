package com.example.streamapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ExaminerServiceImplTest {
    private ExaminerService examinerService;
    private QuestionService questionService;

    private Question question1;
    private Question question2;
    private Question question3;
    @BeforeEach
    public void init() {
        questionService = Mockito.mock(QuestionService.class);


        question1 = new Question("test1", "test1");
        question2 = new Question("test2", "test2");
        question3 = new Question("test3", "test3");
    }

    @Test
    public void testQuestionWhenServiceReturnUniqueQuestions() {
        when(questionService.getRandomQuestion())
                .thenReturn(question1)//при первом вызове вернет первый вопрос
                .thenReturn(question2)//при втором вызове вернет втором вопрос
                .thenReturn(question3);//при третьем вызове вернет третьем вопрос
        when(questionService.getAllQuestions()).thenReturn(List.of(question1, question2, question3));

        Collection<Question> questions =  examinerService.getQuestion(3);

        Assertions.assertEquals(3, questions.size());
        Mockito.verify(questionService, times(3)).getRandomQuestion();
    }

    @Test
    public void testQuestionWhenServiceReturnDuplicateQuestions() {
        when(questionService.getRandomQuestion())
                .thenReturn(question1)//при первом вызове вернет первый вопрос
                .thenReturn(question1)//при первом вызове вернет первый вопрос
                .thenReturn(question1)//при первом вызове вернет первый вопрос
                .thenReturn(question2)//при втором вызове вернет втором вопрос
                .thenReturn(question2)//при втором вызове вернет втором вопрос
                .thenReturn(question3);//при третьем вызове вернет третьем вопрос
        when(questionService.getAllQuestions()).thenReturn(List.of(question1, question2, question3));

        Collection<Question> questions =  examinerService.getQuestion(3);

        Assertions.assertEquals(3, questions.size());
        Mockito.verify(questionService, times(6)).getRandomQuestion();
    }

    @Test
    public void testGetQuestionWhenRequestedMoreThanExists() {
        when(questionService.getAllQuestions()).thenReturn(new ArrayList<>());

        Assertions.assertThrows(NotEnoughQuestionExeption.class, () -> examinerService.getQuestion(3));

    }
}
