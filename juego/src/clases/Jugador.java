package clases;

import implementacion.juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Jugador extends ObjetoJuego {
	
	private int Vidas;
	
	

	public Jugador(int x, int y, String nombreImagen, int velocidad, int vidas) {
		super(x, y, nombreImagen, velocidad);
		Vidas = vidas;
	}
	public int getVidas() {
		return Vidas;
	}
	public void setVidas(int vidas) {
		Vidas = vidas;
	}
	@Override
	// se ejecuta por cada iteracion del juego
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(juego.imagenes.get(nombreImagen), X, Y);
	}
	@Override
	// se ejecuta por cada iteracion del juego
	public void mover() {
		if(X>700 )
			X=-80;
		if (juego.derecha)
			X+=velocidad;
		if (juego.izquierda)
			X-=velocidad;
	//	if (juego.arriba)
		//	Y-=velocidad;
//		if (juego.abajo)
	//		Y+=velocidad;
	}
	

}
