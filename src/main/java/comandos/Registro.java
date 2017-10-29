package comandos;

import javax.swing.JOptionPane;

import frames.MenuCreacionPj;
import mensajeria.Paquete;

/**
 * Clase Registro: Encargada de registrar al usuario.
 * @author Miguel
 */
public class Registro extends ComandosCliente {

	@Override
	public void ejecutar() {
		synchronized (this) {

			Paquete paquete = (Paquete) gson.fromJson(cadenaLeida, Paquete.class);
			if (paquete.getMensaje().equals(Paquete.msjExito)) {

				// Abro el menu para la creaci�n del personaje
				MenuCreacionPj menuCreacionPJ = new MenuCreacionPj(
						this.getCliente(), this.getCliente().getPaquetePersonaje(), gson);
				menuCreacionPJ.setVisible(true);

				// Espero a que el usuario cree el personaje

				// Recibo el paquete personaje con los datos (la id incluida)

				// Indico que el usuario ya inicio sesion

			} else {
				if (paquete.getMensaje().equals(Paquete.msjFracaso)) {
					JOptionPane.showMessageDialog(null, "No se pudo registrar.");
				}
				// El usuario no pudo iniciar sesión
				this.getCliente().getPaqueteUsuario().setInicioSesion(false);
			}

		}
	}

}
