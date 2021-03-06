package edu.unlam.wome.cliente.recursos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Setea la imagen de carga
 *
 * @author leo
 *
 */
public final class CargadorImagen {
	/**
	 * Constructor no utilizado privado de la clase
	 */
	private CargadorImagen() {
	}
	/**
	 *
	 * @param path parametro path
	 * @return si carga la imagen o no
	 */
	public static BufferedImage cargarImagen(final String path) {
		try {
			return ImageIO.read(CargadorImagen.class.getResource(path));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el archivo " + path);
		}

		return null;
	}
}
