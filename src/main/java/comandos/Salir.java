package comandos;

import java.io.IOException;

import javax.swing.JOptionPane;

import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * Clase Salir. Encargada de salir del Juego.
 * @author Miguel
 */
public class Salir extends ComandosCliente {

	@Override
	public void ejecutar() {
		try {
			this.getCliente().getPaqueteUsuario().setInicioSesion(false);
			this.getCliente().getSal().writeObject(getGson().toJson(
					new Paquete(Comando.DESCONECTAR), Paquete.class));
			this.getCliente().getSocket().close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al salir");

		}

	}

}
