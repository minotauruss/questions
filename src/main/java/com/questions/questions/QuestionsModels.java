package com.questions.questions;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
@AllArgsConstructor
public class QuestionsModels {


    @NotNull
    private  String title;

    private  String answerOne;
    private  String answerTwo;
    private  String answerThree;
    private  String answerFour;
    private  String answerFive;
    private  String subject;
    private  String correct;
}
