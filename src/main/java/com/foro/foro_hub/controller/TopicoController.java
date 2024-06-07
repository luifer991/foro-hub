package com.foro.foro_hub.controller;

import com.foro.foro_hub.domain.topic.DatosRegistroTopico;
import com.foro.foro_hub.domain.topic.DatosRespuestaTopico;
import com.foro.foro_hub.domain.topic.Topico;
import com.foro.foro_hub.domain.topic.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ( "/topicos" )
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity <DatosRespuestaTopico> enviarTopico (
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico ) {
        Topico topico = topicoRepository.save( new Topico( datosRegistroTopico ) );
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getTitulo(), topico.getMensaje(), topico.getFecha(),
                topico.getUsuario(), topico.getCurso(), topico.getStatus());
        return ResponseEntity.ok().body(datosRespuestaTopico);
    }
}
