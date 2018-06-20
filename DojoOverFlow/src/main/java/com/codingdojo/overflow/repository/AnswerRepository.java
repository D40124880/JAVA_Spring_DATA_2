package com.codingdojo.overflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

	List<Answer> findAll();

	List<Answer> findAllByQuestion_id(Long id);
	
}
