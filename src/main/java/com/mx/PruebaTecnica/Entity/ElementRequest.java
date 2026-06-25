package com.mx.PruebaTecnica.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementRequest {
	private String id;
    private String nombre;
    private double monto;
    private String estatus;
}
