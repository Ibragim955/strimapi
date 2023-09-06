package com.example.streamapi;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public interface ExaminerServiceImpl extends ExaminerService {
    final QuestionService javaQuestionService = null;

    @Override
    public default Collection<Question> getQuestion(Integer amount) {
        if (amount > javaQuestionService.getAllQuestions().size()) {
            throw new NotEnoughQuestionExeption("Requested more questions than exists");
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }
}
