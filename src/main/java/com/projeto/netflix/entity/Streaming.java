package com.projeto.netflix.entity;

import com.projeto.netflix.dto.StreamingDTO;
import com.projeto.netflix.enums.Category;
import com.projeto.netflix.enums.Style;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Streaming {
   
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Category category;
    private String title;
    private String producer;
    private Style style;
    private Integer season;
    private Integer episode;
    
    public Streaming(StreamingDTO streamingDTO) {
		this.id = streamingDTO.id();
		this.category = streamingDTO.category();
		this.title = streamingDTO.title();
		this.producer = streamingDTO.producer();
		this.style = streamingDTO.style();
		this.season = streamingDTO.season();
		this.episode = streamingDTO.episode();
	}

	public void updating(StreamingDTO streamingDTO) {
		if(streamingDTO.category()!= null) {
			this.category = streamingDTO.category();
			
		}
		if(streamingDTO.title()!= null) {
			this.title = streamingDTO.title();
			
		}
		
		if(streamingDTO.producer()!= null) {
			this.producer = streamingDTO.producer();
		}
		
		if(streamingDTO.style()!= null) {
			this.style = streamingDTO.style();
		}
		
		if(streamingDTO.season() != null) {
			this.season = streamingDTO.season();
		}
		
		if(streamingDTO.episode() != null) {
			this.episode = streamingDTO.episode();
		}
	}
  
	}
	

