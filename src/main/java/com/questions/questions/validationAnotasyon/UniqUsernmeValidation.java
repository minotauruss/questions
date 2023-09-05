package com.questions.questions.validationAnotasyon;

import com.questions.questions.models.QuestionsModels;
import com.questions.questions.repository.SorguMongo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqUsernmeValidation  implements  ConstraintValidator<UniqeUser, String> {

    @Autowired
    SorguMongo sorguMongo;
    @Override
    public void initialize(UniqeUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
    QuestionsModels titles =   sorguMongo.findByTitle(title);
    if(titles !=null){
        return  false;
    }
        return true;
    }
}
