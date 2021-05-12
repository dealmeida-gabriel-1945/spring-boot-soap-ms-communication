package com.gabrielalmeida.springbootsoapmsconsumer.web;

import com.gabrielalmeida.springbootsoapmsconsumer.dataShape.dto.CarLogDTO;
import com.gabrielalmeida.springbootsoapmsconsumer.dataShape.dto.LogRequestDTO;
import com.gabrielalmeida.springbootsoapmsconsumer.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/logs")
public class LogResource {

    @Autowired
    private LogService logService;

    /**
     * GET: /api/evento/{id} Busca um evento por id
     *
     * @params: id - id do evento
     * @return: o evento
     */
    @PostMapping
    public ResponseEntity<CarLogDTO> generate(@RequestBody LogRequestDTO request) {
        return ResponseEntity.ok(this.logService.generate(request));
    }
}
