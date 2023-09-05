package com.questions.questions.repository;

import com.questions.questions.models.QuestionsModels;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SorguMongo  extends MongoRepository<QuestionsModels,Integer> {

    QuestionsModels findByTitle( String title);

}
