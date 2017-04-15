package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/** Representa a un Tile en el juego 
 * @author Headcruser87*/
public abstract class Cuadro 
{
    protected int x; 
    protected int y;
    
    public Sprite sprite;
    
    //coleccion de cuadros 
     public static final Cuadro ASFALTO = new CuadroAsfalto( Sprite.ASFALTO  );
    //fin de la coleccion de cuadros 
    
    public Cuadro( Sprite sprite )
    {
        this.sprite=sprite;
    }
    
    public abstract void mostrar(  int x, int y , Pantalla pantalla ); 
    
    /**Indica si hay obstaculos
     * @return Regresa un valor booleano*/
    public boolean solido() {   return false;   }
    
} // Fin clase abstracta 
