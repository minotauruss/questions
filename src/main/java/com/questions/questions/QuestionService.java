package com.questions.questions;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionService {


    PasswordEncoder passwordEncoder;
    private SorguMongo sorguMongo;


    public QuestionService(SorguMongo sorguMongo) {

        this.sorguMongo = sorguMongo;
        this.passwordEncoder =  new BCryptPasswordEncoder();
    }


    public  void save ( QuestionsModels questionsModels){
        String bycryptedCorrect =  passwordEncoder.encode(questionsModels.getCorrect());
        questionsModels.setCorrect(bycryptedCorrect);
        sorguMongo.save(questionsModels);

    }

    public List<QuestionsModels> questionAll(){
        List<QuestionsModels> questionList =   sorguMongo.findAll();
        return  questionList;
    }


    public Optional<QuestionsModels> questionOne(int id){
        Optional<QuestionsModels> questionOne =   sorguMongo.findById(id);
        return  questionOne ;
    }

    public void delete(int id){
        sorguMongo.deleteById(id);

    }


}
