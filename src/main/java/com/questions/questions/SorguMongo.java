package com.questions.questions;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SorguMongo  extends MongoRepository<QuestionsModels ,Integer> {

}
