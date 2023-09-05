package com.questions.questions.controller;

import com.questions.questions.service.QuestionService;
import com.questions.questions.models.QuestionsModels;
import errors.ValidError;
import jakarta.validation.Valid;
import messages.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/")
@Validated
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<?> getSave( @Valid @RequestBody QuestionsModels questionsModel){
        questionService.save(questionsModel);
 return ResponseEntity.status(HttpStatus.CREATED).body(new Message(200,"this question was created"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidError handleValidationException(MethodArgumentNotValidException exception){
        ValidError validError =  new ValidError(400,"validation error", "/api/save");
        Map<String,String> errors =new HashMap<>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        validError.setValidationErrors(errors);
        return  validError;
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
