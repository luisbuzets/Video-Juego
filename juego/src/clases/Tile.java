package clases;

import implementacion.juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego{
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	
	public Tile(int tipoTile,int x, int y, String nombreImagen, int velocidad,  int ancho, int alto) {
		super(x, y, nombreImagen, velocidad);
		this.alto = alto;
		this.ancho = ancho;
		
		
		switch(tipoTile) {
		case 1:
			this.xImagen = 8;
			this.yImagen = 200;
			break;
		case 2:
			this.xImagen = 213;
			this.yImagen = 131;
			break;
		case 3:
			this.xImagen = 272;
			this.yImagen =130;
			break;
		case 4:
			this.xImagen = 1;
			this.yImagen = 4;
			break;
		case 5:
			this.xImagen = 332;
			this.yImagen = 132;
		    break;
		case 6:
			this.xImagen =393;
			this.yImagen = 132;
		    break;
		case 7:
			this.xImagen = 454;
			this.yImagen = 132;
		    break;
		case 8:
			this.xImagen = 197;
			this.yImagen = 0;
		    break;
			
		}
		
	}
	
	
	public int getxImagen() {
		return xImagen;
	}




	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}




	public int getyImagen() {
		return yImagen;
	}




	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}



	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(juego.imagenes.get(nombreImagen),xImagen,yImagen,ancho,alto,X,Y,ancho,alto);
		
	}
	@Override
	public void mover() {
		
		
	}
	

}
