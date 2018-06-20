package com.codingdojo.overflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.TagQuestion;

@Repository
public interface TagQuestionRepository extends CrudRepository<TagQuestion,Long> {

	List<TagQuestion> findAll();
	
	List<TagQuestion> findAllByQuestion_id(Long id);
	List<TagQuestion> findAllByTag_id(Long id);
	
}
