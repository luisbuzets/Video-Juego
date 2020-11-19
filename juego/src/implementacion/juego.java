package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.KeyAgreement;

import clases.Fondo;
import clases.Item;
import clases.Jugador;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class juego extends Application{
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas lienzo;
	private Fondo fondo;
	//private int x=0;
//	private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	private Item item;

	
	public static HashMap<String, Image> imagenes;
	
	private ArrayList<Tile> tiles;
	
	private int tilemap[][] = {
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,1},
			{4,2,3,5,6,7,4,8,1,1,0},
			
			};
	public static void main(String[] args) {
		launch(args);

		}

		@Override
		public void start(Stage ventana) throws Exception {
			
		incializarComponentes();
			pintar();
			gestionEventos();
			ventana.setScene(escena);
			ventana.setTitle("THE GOON");
			ventana.show();
			ciclojuego();
			
			

	}
		public void ciclojuego() {
			long tiempoInicial = System.nanoTime();
			AnimationTimer animationTimer = new AnimationTimer(){

				@Override
				public void handle(long tiempoActual) {
					double t = (tiempoActual - tiempoInicial) / 1000000000.0;
					actualizarEstado(t);
					pintar();
					
					
				}
				
				
			};
			animationTimer.start();
			
		}
	    public void actualizarEstado(double t) {
	    
	    	jugadorAnimado.verificarColisionesItem(item);
	    	jugadorAnimado.calcularFrame(t);
	    	jugadorAnimado.mover();
	    	fondo.mover();
			
		}
		
		public void incializarComponentes() {
			imagenes = new HashMap<String, Image>();
			cargarImagenes();
			jugadorAnimado = new JugadorAnimado(9, 195,"HeroKnight",2,0,"descanso");
			fondo = new Fondo(0,0,"cloudySky","cloudySky2", "par1_tileable", "par2_tileable ","par3_tileable", "par11_tileable", "par22_tileable ","par33_tileable", 6);
			inicializarTiles();
			item =  new Item(290,180,"frm1",0,1);
			
			root = new Group();
			 escena = new Scene(root, 640, 360);
			 lienzo = new Canvas(640, 360);
			 root.getChildren().add(lienzo);
			graficos = lienzo.getGraphicsContext2D();
			item =  new Item(290,180,"frm1",0,1);
		
			
		}
		public void inicializarTiles() {
			tiles = new ArrayList<Tile>();
		for(int i=0;i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if(tilemap[i][j]!=0)
				this.tiles.add(new Tile(tilemap[i][j],j*61,i*57, "groundTilemap",0,61,57));
					
			}
		}
		tiles = new ArrayList<Tile>();
		for(int i=0;i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if(tilemap[i][j]!=0)
				this.tiles.add(new Tile(tilemap[i][j],j*60,i*121, "groundTilemap",0,60,121));
			}
		}
		
			
			
		}
		public void cargarImagenes() {
			imagenes.put("HeroKnight", new Image("HeroKnight.png"));
			
			imagenes.put("cloudySky",new Image("cloudySky_640x360px.png"));
			imagenes.put("cloudySky2",new Image("cloudySky2_640x360px.png"));
			imagenes.put("par1_tileable",new Image("par1_tileable_640x360px.png"));
		    imagenes.put("par2_tileable",new Image("par2_tileable_640x360px.png"));
			imagenes.put("par3_tileable",new Image("par3_tileable_640x360px.png"));
			imagenes.put("par11_tileable",new Image("par11_tileable_640x360px.png"));
		    imagenes.put("par22_tileable",new Image("par22_tileable_640x360px.png"));
			imagenes.put("par33_tileable",new Image("par33_tileable_640x360px.png"));
		    imagenes.put("groundTilemap",new Image("groundTilemap_64px.png"));
		    imagenes.put("tree",new Image("tree_128px.png"));
		    imagenes.put("rockpile",new Image("rockpile_128px.png"));
		    imagenes.put("sable",new Image("bonfire_frm1_64.png"));
		    imagenes.put("frm1",new Image("frm1.png"));
		    imagenes.put("Heart_strip2",new Image("Heart_strip2.png"));
		   
		    
		}
	
		public void pintar() {
			
			fondo.pintar(graficos);
			for(int i=0;i<tiles.size();i++)
				tiles.get(i).pintar(graficos);
			//	jugador.pintar(graficos);
			jugadorAnimado.pintar(graficos);
			graficos.drawImage(imagenes.get("tree"),390,134);
	//		graficos.drawImage(imagenes.get("rockpile"),234,180);
			graficos.drawImage(imagenes.get("sable"),590,78);
			item.pintar(graficos);
			graficos.drawImage(imagenes.get("Heart_strip2"),20,10);
			graficos.fillText("Vidas: "+jugadorAnimado.getVidas(),50,20);
		//	graficos.fillText("Puntos: "+jugadorAnimado.getPuntos(),40,20);
			
		}
		public void gestionEventos() {
		
			escena.setOnKeyPressed(new EventHandler<KeyEvent>(){

				@Override
				public void handle(KeyEvent evento) {
					
					switch(evento.getCode().toString()) {
					case "RIGHT":
					    derecha = true;
					    jugadorAnimado.setDireccion(1);
					    jugadorAnimado.setAnimacionActual("correr");
						break;
					case "LEFT":
						izquierda = true;
						  jugadorAnimado.setDireccion(-1);
						 jugadorAnimado.setAnimacionActual("correr");
						break;
					case "UP":
					     arriba = true;
						break;
					case "DOWN":
						abajo = true;
						break;
					case"SPACE":
						jugadorAnimado.setVelocidad(6);
					    
						break;
					
					}
					
				}
				
			});
			
			escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
				//este se ejecuta cuando se suelta una tecla

				@Override
				public void handle(KeyEvent evento) {
					switch(evento.getCode().toString()) {
					case "RIGHT":
						derecha = false;
						  jugadorAnimado.setAnimacionActual("descanso");
						break;
					case "LEFT":
						izquierda = false;
						  jugadorAnimado.setAnimacionActual("descanso");
						break;
					case "UP":
					     arriba = false;
						break;
					case "DOWN":
						abajo = false;
						break;
					case"SPACE":
						jugadorAnimado.setVelocidad(4);
						
						break;
					
					
					}
			
					
				}


				
				
				
				
				
			});
		
				
			}
			
		}
		


