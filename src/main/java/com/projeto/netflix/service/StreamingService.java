package com.projeto.netflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.netflix.dto.StreamingDTO;
import com.projeto.netflix.entity.Streaming;
import com.projeto.netflix.enums.Category;
import com.projeto.netflix.repository.StreamingRepository;

import jakarta.transaction.Transactional;

@Service
public class StreamingService {
	@Autowired
	private StreamingRepository streamingRepository;
	
	public Streaming createStreaming(StreamingDTO streamingDTO) {		
		var create = new Streaming(streamingDTO);
		return streamingRepository.save(create);
		
	}
	 
	public List<Streaming>findMovies(){
		
		var find =  streamingRepository.findByCategory(Category.MOVIES);
		if(find.isEmpty()) {
			throw new RuntimeException();
		}
		return find;
	}

	public List<Streaming>findSeries(){
		var series = streamingRepository.findByCategory(Category.SERIES);
		if(series.isEmpty()) {
			throw new RuntimeException();
		}
		
		return series;
	}
	
	public List<Streaming>findDocumentary(){
		var doc = streamingRepository.findByCategory(Category.DOCUMENTARY);
		if(doc.isEmpty()) {
			throw new RuntimeException();
		}
		
		return doc;
	}
	
	public Streaming findTitle(String title){
		Optional<Streaming> find = streamingRepository.findByTitle(title.trim().toUpperCase());
		return find.orElseThrow(()-> new RuntimeException());
	}
	
	@Transactional
	public Streaming updateStreaming(StreamingDTO streamingDTO,Long id) {
		var update = streamingRepository.getReferenceById(id);
		update.updating(streamingDTO); 
		
		return streamingRepository.save(update);
	}
	
	public void delete(Long id) {
		streamingRepository.deleteById(id);
	}
}
