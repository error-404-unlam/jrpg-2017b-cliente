package edu.unlam.wome.entidades;

/**
 * Clase Nodo de Tiles donde se encuentran todos los tiles del personaje
 */
public class PilaDeTiles {

	private NodoDePila ptrPila;

	/**
	 * Constructor de la Clase Nodo de Tiles
	 */
	public PilaDeTiles() {
		ptrPila = null;
	}

	/**
	 * Establece el nuevo siguiente
	 * @param nodo
	 *            nuevo nodo siguiente
	 */
	public void push(final NodoDePila nodo) {
		nodo.establecerSiguiente(ptrPila);
		ptrPila = nodo;
	}

	/**
	 * Pide el tope
	 * @return un nodo de pila con el tope de la pila
	 */
	public NodoDePila pop() {
		NodoDePila tope = this.ptrPila;
		if (tope == null) {
			return null;
		}
		this.ptrPila = this.ptrPila.obtenerSiguiente();
		return tope;
	}

	/**
	 * Pregunta si esta vacia la pila de tiles
	 * @return true or false
	 */
	public boolean estaVacia() {
		return this.ptrPila == null;
	}

}
