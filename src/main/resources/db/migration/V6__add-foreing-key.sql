ALTER TABLE respuestas
ADD CONSTRAINT fk_respuestas_topico_id
FOREIGN KEY (topico_id) REFERENCES topicos(id);