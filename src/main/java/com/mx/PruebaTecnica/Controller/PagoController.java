package com.mx.PruebaTecnica.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.PruebaTecnica.Entity.ElementRequest;
import com.mx.PruebaTecnica.Entity.ResumenMontoResponse;
import com.mx.PruebaTecnica.Service.ProcesamientoService;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private ProcesamientoService procesamientoService; 

    // http://localhost:9001/api/pagos/calcularTotal
    @PostMapping(value = "/calcularTotal")
    public ResponseEntity<ResumenMontoResponse> procesarElementos(@RequestBody List<ElementRequest> request) {
        ResumenMontoResponse respuesta = procesamientoService.calcularTotalExitoso(request);
        return ResponseEntity.ok(respuesta);
    }
}