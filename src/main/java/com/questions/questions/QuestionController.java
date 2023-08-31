package com.questions.questions;

import errors.validationError;
import jakarta.validation.Valid;
import messages.Message;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/")
@Validated
public class QuestionController {

    private  QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> getSave( @Valid @RequestBody QuestionsModels questionsModel){
        String correct = questionsModel.getCorrect();
        String title = questionsModel.getTitle();
        if((correct == null || correct.isEmpty())  || (title==null || title.isEmpty())   ){
            validationError validationErrors = new validationError(400, "validation is bad","/api/save");
            Map<String, String> validationErrorsMessage = new HashMap<>();
            validationErrorsMessage.put("correct","this area is not be empty");
            validationErrors.setValidationErrors(validationErrorsMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
        }
        questionService.save(questionsModel);


        return ResponseEntity.status(HttpStatus.CREATED).body(new Message(200,"this question was created"));
    }


    @CrossOrigin
    @GetMapping("/questions")
    public List<QuestionsModels> questionALL (){
        List<QuestionsModels> questionsList = questionService.questionAll();
        return  questionsList;
    }


    @GetMapping("/question/{id}")
    public Optional<QuestionsModels> questionOne (@PathVariable("id") int id){
        Optional<QuestionsModels> questionOne = questionService.questionOne(id);
        return  questionOne;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> delete (@PathVariable("id") int id){
        questionService.delete(id);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new Message(200,"this question was created"));
    }


}
