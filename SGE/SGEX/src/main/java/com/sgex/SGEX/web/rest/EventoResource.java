package com.sgex.SGEX.web.rest;

import com.sgex.SGEX.service.EventoService;
import com.sgex.SGEX.service.dto.EventoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eventos")

public class EventoResource {

    private final EventoService service;

    @GetMapping
    public ResponseEntity<Page<EventoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "patrocinador") String orderBy
    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<EventoDTO> list = service.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EventoDTO> findById(@PathVariable Long id) {
        EventoDTO eventoDTO = service.findById(id);
        return ResponseEntity.ok().body(eventoDTO);
    }

    @PostMapping
    public ResponseEntity<EventoDTO> insert(@RequestBody EventoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EventoDTO>delete(@PathVariable Long id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
