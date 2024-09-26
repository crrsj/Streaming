package com.projeto.netflix.dto;

import com.projeto.netflix.entity.Streaming;
import com.projeto.netflix.enums.Category;
import com.projeto.netflix.enums.Style;

public record MoviesDTO( 		
	
	
	Category category,
	
	String title,
	
	String producer,
	
	Style style) {
	
	public MoviesDTO(Streaming streaming) {
		this(
				streaming.getCategory(),
				streaming.getTitle(),
				streaming.getProducer(),
				streaming.getStyle());
	}
}
