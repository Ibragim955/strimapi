package com.example.streamapi;

import java.util.Collection;

public interface QuestionRepository {
    Question addQuestion(Question question);

    Question removeQuestion(Question question);

    Collection<Question> getAllQuestions();
}
