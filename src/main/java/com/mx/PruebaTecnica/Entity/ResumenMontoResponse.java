package com.mx.PruebaTecnica.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumenMontoResponse {
	private String nombre;
    private double montoTotal;
}
