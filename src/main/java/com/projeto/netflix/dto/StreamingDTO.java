package com.projeto.netflix.dto;

import com.projeto.netflix.entity.Streaming;
import com.projeto.netflix.enums.Category;
import com.projeto.netflix.enums.Style;

public record StreamingDTO(
		
		Long id,
		
		Category category,
		
		String title,
		
		String producer,
		
		Style style,
		
		Integer season,
		
		Integer episode) {

	public StreamingDTO(Streaming create) {
		this(
				create.getId(),
				create.getCategory(),
				create.getTitle(),
				create.getProducer(),
				create.getStyle(),
				create.getSeason(),
				create.getEpisode());
		
	}

}
