package com.example.streamapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/j")
public class JavaQuestionController {  private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    //как параметры получаем вопрос - ответ
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(new Question(question, answer));
    }

    @GetMapping("/getAll")
    //метод для получения всех вопросов
    private Collection<Question> getAll() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/remove")
    //метод для удаления вопроса
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping("/getRandom")
    //метод для получения рандомного вопроса
    public Question getRandomQuestion() {
        return questionService.getRandomQuestion();
    }

}


