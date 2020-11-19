package clases;

import implementacion.juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObjetoJuego {
	private String nombreImagen2;
	private String nombreImagen3;
	private String nombreImagen4;
	private String nombreImagen5;
	private String nombreImagen6;
	private String nombreImagen7;
	private String nombreImagen8;
	private int x2;
	private int x3;
	private int x4;
	private int x5;
	private int x6;
	private int x7;
	private int x8;
	

	public Fondo(int x, int y, String nombreImagen,String nombreImagen2,String nombreImagen3, String nombreImagen4,String nombreImagen5,String nombreImagen6,String nombreImagen7,String nombreImagen8, int velocidad) {
		super(x, y, nombreImagen, velocidad);
		this.nombreImagen2=nombreImagen2;
		this.nombreImagen3=nombreImagen3;
		this.nombreImagen4=nombreImagen4;
		this.nombreImagen5=nombreImagen5;
		this.nombreImagen6=nombreImagen6;
	    this.nombreImagen7=nombreImagen7;
		this.nombreImagen8=nombreImagen8;
		this.ancho=(int)juego.imagenes.get("cloudySky").getWidth();
		this.alto=(int)juego.imagenes.get("cloudySky").getHeight();
	
		this.x2=this.ancho+this.X;
		this.x6=this.ancho+this.x3;
		this.x7=this.ancho+this.x4;
		this.x8=this.ancho+this.x5;
		
		
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(juego.imagenes.get(this.nombreImagen), this.X,this.Y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen2), this.x2,this.Y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen3), this.x3,this.Y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen4), this.x4,this.Y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen5), this.x5,this.Y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen6), this.x6,this.Y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen7), this.x7,this.Y);
		graficos.drawImage(juego.imagenes.get(this.nombreImagen8), this.x8,this.Y);

		
	}

	@Override
	public void mover() {
		if(X<= -1*ancho) {
			X=ancho;
		}
		if(x2<= -1*ancho) {
			x2=ancho;
			
		
			
		}
		if(juego.derecha) {
			X-=velocidad;
			x2-=velocidad;
			
		}
		

		if(juego.izquierda) {
			X+=velocidad;
			x2+=velocidad;
			
		}
		
		////////////////////////
		if(x3<= -1*ancho) {
			x3=ancho;
			
		
			
		}
		
		if(x6<= -1*ancho) {
			x6=ancho;
			
		
			
		}
		
		if(juego.derecha) {
			x3-=velocidad;
			x6-=velocidad;
			
		}
		

		if(juego.izquierda) {
			x3+=velocidad;
			x6+=velocidad;
			
		}
		
	////////////////////////////////////
		if(x4<= -1*ancho) {
			x4=ancho;
			
		
			
		}
		
		if(x7<= -1*ancho) {
			x7=ancho;
			
		
			
		}
		
		if(juego.derecha) {
			x4-=velocidad;
			x7-=velocidad;
			
		}
		

		if(juego.izquierda) {
			x4+=velocidad;
			x7+=velocidad;
			
		}
		////////////////////////////////////////////
		if(x5<= -1*ancho) {
			x5=ancho;
			
		
			
		}
		
		if(x8<= -1*ancho) {
			x8=ancho;
			
		
			
		}
		
		if(juego.derecha) {
			x5-=velocidad;
			x8-=velocidad;
			
		}
		

		if(juego.izquierda) {
			x5+=velocidad;
			x8+=velocidad;
			
		}
		
	
		
		
			
	}

	

}
