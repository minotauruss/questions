package com.questions.questions;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "questions")
@AllArgsConstructor
public class QuestionsModels {


    @NotNull
    @Column(unique = true)
    private  String title;
    @NotNull
    private  String answerOne;
    @Size(max = 20, min = 3)
    private  String answerTwo;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private  String answerThree;
    private  String answerFour;
    private  String answerFive;
    @Email
    private  String subject;
    private  String correct;
}
