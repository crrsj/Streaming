package com.projeto.netflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.netflix.dto.MoviesDTO;
import com.projeto.netflix.dto.StreamingDTO;
import com.projeto.netflix.service.StreamingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("streaming")
public class StreamingController {

	@Autowired
	StreamingService streamingService;
	
	@PostMapping
	@Operation(summary = "Rote responsible for registering a streaming cadastro de streaming") 
    @ApiResponse(responseCode = "201",description = "success",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<StreamingDTO>createStreaming(@RequestBody StreamingDTO streamingDTO){
		var create = streamingService.createStreaming(streamingDTO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().
		path("{id}").buildAndExpand(create.getId())	.toUri();			
		return ResponseEntity.created(uri).body(new StreamingDTO(create));
	}
	
	@GetMapping("movies")
	@Operation(summary = "Rote responsible for seaching for films") 
    @ApiResponse(responseCode = "201",description = "success",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<List<MoviesDTO>>findAllMovies(){
		var find = streamingService.findMovies().stream().map(MoviesDTO::new).toList();
		return ResponseEntity.ok(find);
	}
	
	@GetMapping("series")
	@Operation(summary = "Rote responsible for seaching for series") 
    @ApiResponse(responseCode = "201",description = "success",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<List<StreamingDTO>>findAllSeries(){
		var findSeries = streamingService.findSeries().stream().map(StreamingDTO::new).toList();
		return ResponseEntity.ok(findSeries);
	}
	
	
	@GetMapping("title")
	@Operation(summary = "Rote responsible for seaching for titles") 
    @ApiResponse(responseCode = "201",description = "success",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<StreamingDTO>findByTitle(@RequestParam(name = "title") String title){
		var findTitle = streamingService.findTitle(title);
		return ResponseEntity.ok().body(new StreamingDTO(findTitle));
	}
	
	@PatchMapping("{id}")
	@Operation(summary = "Rote responsible for update for streaming") 
    @ApiResponse(responseCode = "201",description = "success",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<StreamingDTO>updateStream(@RequestBody StreamingDTO streamingDTO,@PathVariable Long id){
		var update = streamingService.updateStreaming(streamingDTO, id);
		return ResponseEntity.ok().body(new StreamingDTO(update));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rote responsible for deleting for streaming") 
    @ApiResponse(responseCode = "201",description = "success",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<Void>deleteStreaming(@PathVariable Long id) {
		 streamingService.delete(id);
     return ResponseEntity.noContent().build();		 
	}
	
	@GetMapping("documentary")
	@Operation(summary = "Rote responsible for seaching for documentary") 
    @ApiResponse(responseCode = "201",description = "success",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class)) 
   		})          
	public ResponseEntity<List<MoviesDTO>>findAllDocumentary(){
		var doc = streamingService.findDocumentary().stream().map(MoviesDTO::new).toList();
		return ResponseEntity.ok().body(doc);
	}
}
