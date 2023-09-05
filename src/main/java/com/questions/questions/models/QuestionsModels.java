package com.questions.questions.models;

import com.questions.questions.validationAnotasyon.UniqeUser;
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
    //@Column(unique = true) //@column database de kolunun uniq olmasini sagliyor//
    @UniqeUser
    private  String title;
    @NotNull
    private  String answerOne;
    @Size(max = 20, min = 3) //bu anotasyon max ve min uzunlukta veri girisini kontrol ediyor//
    private  String answerTwo;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$") //bu anotasyon ile istediginiz datanin patern belitiyorsunuz//
    private  String answerThree;
    private  String answerFour;
    private  String answerFive;
    @Email
    private  String subject;
    private  String correct;
}
