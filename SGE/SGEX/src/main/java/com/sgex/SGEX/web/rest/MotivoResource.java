package com.sgex.SGEX.web.rest;


import com.sgex.SGEX.service.MotivoService;
import com.sgex.SGEX.service.dto.EventoDTO;
import com.sgex.SGEX.service.dto.MotivoDTO;
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
@RequestMapping("/api/motivos")

public class MotivoResource {

    private final MotivoService service ;
    @GetMapping
    public ResponseEntity<Page<MotivoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "titulo") String orderBy
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<MotivoDTO> list = service.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MotivoDTO> findById(@PathVariable Long id) {
        MotivoDTO motivoDTO = service.findById(id);
        return ResponseEntity.ok().body(motivoDTO);
    }

    @PostMapping
    public ResponseEntity<MotivoDTO> insert (@RequestBody MotivoDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<EventoDTO> delete (@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
