package com.sgex.SGEX.web.rest;

import com.sgex.SGEX.service.UsuarioService;
import com.sgex.SGEX.service.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")

public class UsuarioResource {

    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> findAllPaged(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10")Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy

    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<UsuarioDTO>list = service.findAllPaged(pageRequest);

        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO>finById(@PathVariable Long id){
        UsuarioDTO usuarioDTO = service.findById(id);
        return ResponseEntity.ok().body(usuarioDTO);
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO>insert(@RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(service.insert(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
