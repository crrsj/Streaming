package com.projeto.netflix.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.netflix.entity.Streaming;
import com.projeto.netflix.enums.Category;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {

	List<Streaming > findByCategory(Category movies);
	@Query(value = "select s from Streaming s where upper(trim(s.title)) like %?1% ") 
	Optional<Streaming> findByTitle(String title);

	

	
}
