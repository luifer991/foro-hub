package com.foro.foro_hub.controller;

import com.foro.foro_hub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ( "/topicos" )
public class TopicoController {
    
    @Autowired
    private RegistroTopicoService registroTopicoService;
    @Autowired
    private ActualizarTopicoService actualizarTopicoService;
    @Autowired
    private TopicoRepository topicoRepository;
    
    @PostMapping
    @Transactional
    public ResponseEntity nuevoTopico (
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico ) {
        var response = registroTopicoService.registrar( datosRegistroTopico );
        return ResponseEntity.ok( response );
    }
    
    @GetMapping
    public ResponseEntity <Page <DatosListadoTopico>> listarTopicos (
            @PageableDefault ( size = 10, sort = { "fecha" }, direction = Sort.Direction.ASC ) Pageable paginacion ) {
        var page = topicoRepository.findAllByFechaTrue( paginacion ).map( DatosListadoTopico::new );
        return ResponseEntity.ok( page );
    }
    
    @GetMapping ( "/{id}" )
    public ResponseEntity detallar ( @PathVariable Long id ) {
        var topico = topicoRepository.getReferenceById( id );
        return ResponseEntity.ok( new DatosListadoTopico( topico ) );
    }
    
    @PutMapping ( "/{id}" )
    @Transactional
    public ResponseEntity actualizar ( @PathVariable Long id,
                                       @RequestBody @Valid DatosActualizarTopico datosActualizarTopico ) {
        var response = actualizarTopicoService.actualizar( id, datosActualizarTopico );
        return ResponseEntity.ok( response );
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar ( @PathVariable Long id ) {
        topicoRepository.deleteById( id );
        return ResponseEntity.noContent().build();
    }
}
