package mapa;

import java.util.Random;

/**Clase que genera un mapa
 * @author Headcruser87
 * @see Mapa clase padre que usa la plantilla de mapa 
 */
public class MapaGenerador extends  Mapa
{
    private final Random aleatorio=new Random(); 
    public MapaGenerador(int ancho, int alto) 
    {
        super(ancho, alto);
    }
    
    @Override
    protected void generarMapa()
    {
        for (int y = 0; y < alto; y++) 
        {
            
            for (int x = 0; x < ancho; x++) 
            {
              cuadros[ x+ y * ancho]  = aleatorio.nextInt( 3 ); 
            }
            
        }
        
    }
    

}
