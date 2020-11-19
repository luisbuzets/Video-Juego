package clases;

import implementacion.juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends ObjetoJuego {

//	private int cantidadPuntos;
	private int cantidadVidas;
//	private boolean capturado=false;

	public Item(int x, int y, String nombreImagen, int velocidad, int cantidadVidas) {
		super(x, y, nombreImagen, velocidad);
//		this.cantidadPuntos = cantidadPuntos ;
		this.cantidadVidas = cantidadVidas;
		this.ancho=(int)juego.imagenes.get("frm1").getWidth();	
		this.alto=(int)juego.imagenes.get("frm1").getHeight();	
		}

	@Override
	public void pintar(GraphicsContext graficos) {
	//	if(this.capturado)
		//	return;
		//else {
		graficos.drawImage(juego.imagenes.get("frm1"),this.X,this.Y);
		graficos.setStroke(Color.YELLOW);
		graficos.strokeRect(X,Y,ancho,alto);
	//	}
		
	}
	

	@Override
	public void mover() {
		
		
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(X,Y,ancho,alto);
	}

	public int getCantidadVidas() {
		return cantidadVidas;
	}

	public void setCantidadVidas(int cantidadVidas) {
		this.cantidadVidas = cantidadVidas;
	}

//	public boolean isCapturado() {
//		return capturado;
	//}

//	public void setCapturado(boolean capturado) {
//		this.capturado = capturado;
	//}

//	public int getCantidadPuntos() {
//		return cantidadPuntos;
//	}

//	public void setCantidadPuntos(int cantidadPuntos) {
//		this.cantidadPuntos = cantidadPuntos;
//	}
	
	
}
