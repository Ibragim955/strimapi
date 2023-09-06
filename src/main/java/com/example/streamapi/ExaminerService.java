package com.example.streamapi;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ExaminerService {
    Collection<Question> getQuestion(Integer amount);
}
