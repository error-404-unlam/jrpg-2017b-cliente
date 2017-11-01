package comandos;

import mensajeria.PaqueteAtacar;

/**
 * Comando Atacar.
 * @author Miguel
 */
public class Atacar extends ComandosEscucha {

	@Override
	public void ejecutar() {
		PaqueteAtacar paqueteAtacar = (PaqueteAtacar) getGson().fromJson(getCadenaLeida(), PaqueteAtacar.class);
		this.getJuego().getEstadoBatalla().getEnemigo().actualizarAtributos(paqueteAtacar.getMapPersonaje());
		this.getJuego().getEstadoBatalla().getPersonaje().actualizarAtributos(paqueteAtacar.getMapEnemigo());
		this.getJuego().getEstadoBatalla().setMiTurno(true);

	}

}
