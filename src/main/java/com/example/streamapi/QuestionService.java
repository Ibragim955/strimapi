package com.example.streamapi;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);

    Collection<Question> getAllQuestions();

    Question remove(Question question);

    Question getRandomQuestion();
}
