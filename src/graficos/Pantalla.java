package graficos;

import mapa.cuadro.Cuadro;

/** @author Headcruser87*/
public  final class Pantalla 
{
    private final int ancho;
    private final int alto;
    
    //temporal 
    private final static int LADO_SPRITE=32;
    private final static int MASCARA_SPRITE=LADO_SPRITE-1;
    
    public final int [] pixeles;

    /**constructor
     * @param ancho 
     * @param alto*/
    public Pantalla( final int ancho, final int alto ) 
    {
        this.ancho = ancho;
        this.alto = alto;
        this.pixeles = new int [ ancho * alto ] ;
    }
    
    /**Metodo para limpiar la pantalla*/
    public void limpiar ()
    {
        for (int i = 0; i < pixeles.length ; i++) 
            pixeles[ i ] = 0 ;            
    }
    
    //Temporal
    public void  mostrar ( final int compesacionX, final int compensacionY)
    {
        for (int y = 0; y < this.alto; y++) 
        {
            int posocionY=y+compensacionY;
            
            if( posocionY< 0 || posocionY >= alto)
                continue;
            
            for (int x = 0; x < this.ancho; x++) 
            {
                int posicionX= x + compesacionX;
                
                if ( posicionX < 0 || posicionX>= ancho){
                       continue;
                }
                   
                // código para dibujar 
                pixeles[ posicionX + posocionY * ancho ] =Sprite.ASFALTO.pixeles
                            [ (x &  MASCARA_SPRITE ) + (y & MASCARA_SPRITE) * LADO_SPRITE];
            }
        }
    }
    
    public void mostrarCuadro ( int compensacionX , int compensacionY , Cuadro cuadro)
    {
        //pantalla se actualiza de izq a der
        for ( int y = 0; y < cuadro.sprite.getLado() ; y++ ) 
        {
            int posiciony = y+compensacionY;
            for (int x = 0; x < cuadro.sprite.getLado();  x++ ) 
            {
                int posicionx= x + compensacionX;
                //Controla el dibujo fuera de la pantall 
                if( posicionx < 0 || posicionx > ancho || posiciony < 0 || posiciony > alto ) 
                    break;
                
                pixeles[ posicionx + posiciony * ancho ] = cuadro.sprite.pixeles[ x + y * cuadro.sprite.getLado() ];
                
            }
            
        }
    }
    
    
  
    
}
