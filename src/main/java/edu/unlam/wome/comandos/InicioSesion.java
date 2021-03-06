package edu.unlam.wome.comandos;

import javax.swing.JOptionPane;

import edu.unlam.wome.mensajeria.Paquete;
import edu.unlam.wome.mensajeria.PaquetePersonaje;

/**
 * Clase InicioSesion. Encargada de iniciar la sesion del juego.
 * @author Miguel
 */
public class InicioSesion extends ComandosCliente {

	@Override
	public void ejecutar() {
		Paquete paquete = (Paquete) getGson().fromJson(getCadenaLeida(), Paquete.class);
		if (paquete.getMensaje().equals(Paquete.getMsjExito())) {

			// El usuario ya inicio sesi�n
			this.getCliente().getPaqueteUsuario().setInicioSesion(true);

			// Recibo el paquete personaje con los datos
			this.getCliente().setPaquetePersonaje(getGson().fromJson(getCadenaLeida(), PaquetePersonaje.class));

		} else {
			if (paquete.getMensaje().equals(Paquete.getMsjFracaso())) {
				JOptionPane.showMessageDialog(null, "Error al iniciar sesión."
						+ "Revise el usuario y la contraseña");
			}

			// El usuario no pudo iniciar sesión
			this.getCliente().getPaqueteUsuario().setInicioSesion(false);
		}

	}

}
