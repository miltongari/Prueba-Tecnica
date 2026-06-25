package com.mx.PruebaTecnica.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mx.PruebaTecnica.Entity.ElementRequest;
import com.mx.PruebaTecnica.Entity.ResumenMontoResponse;

@Service
public class ProcesamientoService {

	public List<ResumenMontoResponse> calcularTotalExitoso(List<ElementRequest> elementos) {
        if (elementos == null || elementos.isEmpty()) {
            return new ArrayList<>();
        }

      // Filtro para status exitoso
        Map<String, Double> agrupadoPorNombre = elementos.stream()
                .filter(e -> "exitoso".equalsIgnoreCase(e.getEstatus()))
                .collect(Collectors.groupingBy(
                        ElementRequest::getNombre,
                        Collectors.summingDouble(ElementRequest::getMonto)));


        List<ResumenMontoResponse> resultadoFinal = new ArrayList<>();
        for (Map.Entry<String, Double> entry : agrupadoPorNombre.entrySet()) {
            resultadoFinal.add(new ResumenMontoResponse(entry.getKey(), entry.getValue()));
        }

        return resultadoFinal;
    }
}