package com.example.streamapi;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public abstract class QuestionRepositoryImpl implements QuestionRepository {
    private final Set<Question> storageQuestions = new HashSet<>();

    @Override
    public Question addQuestion(Question question) {
        storageQuestions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        storageQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return Collections.unmodifiableSet(storageQuestions);
    }
}
