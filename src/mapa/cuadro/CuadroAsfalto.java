package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**Clase que representa a la textura del asfalto
 * @author Headcruser87*/
public class CuadroAsfalto extends Cuadro 
{
    public CuadroAsfalto( Sprite sprite ) 
    {
        super( sprite );
    }

    @Override
    public void mostrar(int x, int y, Pantalla pantalla) 
    {
        pantalla.mostrarCuadro(x, y, this );
    }
    
} // Fin de la clase 
