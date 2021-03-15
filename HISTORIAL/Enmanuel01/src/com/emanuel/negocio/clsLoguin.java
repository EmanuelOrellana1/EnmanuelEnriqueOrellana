package com.emanuel.negocio;

import com.emanuel.entidades.Loguin;

public class clsLoguin {

	public int acceso(Loguin log) {
		int acceso = 0;
		if (log.getUser().equals("emanuel") && log.getPass().equals("123")) {
			acceso = 1;
		} else {

		}
		return acceso;
	}
}