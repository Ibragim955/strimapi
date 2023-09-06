package com.example.streamapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class QuestionServiceImplTest {
    private QuestionRepository questionRepository;
    private  QuestionService questionService;
    private Random random;

    @BeforeEach
    public void init() {
        questionRepository = Mockito.mock(QuestionRepository.class);
        random = Mockito.mock(Random.class);


    }

    @Test
    public void testGetRandomQuestion() {
        Question question1 = new Question("test1", "test1");
        Question question2 = new Question("test2", "test2");
        Question question3 = new Question("test3", "test3");

        when(questionRepository.getAllQuestions()).thenReturn(List.of(question1, question2, question3));
        OngoingStubbing<Integer> integerOngoingStubbing = when(random.nextInt(anyInt())).thenReturn(2);

        Question actualQuestion = questionService.getRandomQuestion();

        Assertions.assertEquals(actualQuestion, question3);
    }
}
