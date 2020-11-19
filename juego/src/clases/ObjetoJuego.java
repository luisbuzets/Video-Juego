package clases;

import javafx.scene.canvas.GraphicsContext;

public abstract class ObjetoJuego {
	protected int X;
	protected int Y;
	protected String nombreImagen;
	protected int velocidad = 6;
	protected int ancho;
	protected int alto;
	
	
	public ObjetoJuego(int x, int y, String nombreImagen, int velocidad) {
		super();
		X = x;
		Y = y;
		this.nombreImagen = nombreImagen;
		this.velocidad = velocidad;
	}
	

	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		Y = y;
	}


	public String getNombreImagen() {
		return nombreImagen;
	}


	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public abstract void pintar(GraphicsContext  graficos);
	
	public abstract void mover();

}
