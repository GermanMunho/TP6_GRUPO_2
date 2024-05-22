package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.ControladorVentPrinc;
import presentacion.vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {

		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		ControladorVentPrinc controlador = new ControladorVentPrinc(vista, negocio);
		controlador.inicializar();
	}

}
