package com.mx.PruebaTecnica.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mx.PruebaTecnica.Entity.ElementRequest;
import com.mx.PruebaTecnica.Entity.ResumenMontoResponse;

@Service
public class ProcesamientoService {

	public ResumenMontoResponse calcularTotalExitoso(List<ElementRequest> elementos) {
		if (elementos == null || elementos.isEmpty()) {
			return new ResumenMontoResponse("Sin datos", 0.0);
		}

		// nombre del primer registro
		String nombrePersona = elementos.get(0).getNombre();

		// filtrado para solo exitoso
		double sumaTotal = elementos.stream().filter(e -> "exitoso".equalsIgnoreCase(e.getEstatus()))
				.mapToDouble(ElementRequest::getMonto).sum();

		return new ResumenMontoResponse(nombrePersona, sumaTotal);
	}
}