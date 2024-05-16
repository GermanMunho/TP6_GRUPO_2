package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.controlador.Controlador;

public class Principal {

	public static void main(String[] args) {

		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(vista, negocio);
		controlador.inicializar();
	}

}
