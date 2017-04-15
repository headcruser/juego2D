package graficos;

/*** @author Headcruser87*/
public class Sprite 
{
    private final int lado;
    
    private int x;
    private int y;
    
    public int [] pixeles;
    private final HojaSprite hoja;
    
    //coleccion de sprites 
    public static final Sprite ASFALTO=new Sprite
                                                (32, 0, 0, HojaSprite.DESIERTO );
    // Fin de coleccion

    /**Constructor de la clase Sprite
     * @param lado 
     * @param columna
     * @param fila
     * @param hoja
     */
    public Sprite( final int lado, final int columna, final int fila , final HojaSprite hoja) 
    {
        this.lado = lado;
        
        pixeles=new int[ lado * lado ];
        
        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;
        
        //avanza de izquierda a derecha
        for( int dy = 0 ; dy < lado; dy ++ )
        {
            //Avanza de arriba a abajo
            for( int dx =0 ; dx < lado; dx ++ )
            {
                pixeles[ dx + dy* lado ]  = hoja.pixeles[  (dx + this.x ) + ( dy+this.y)  * hoja.getAncho() ];
            }
        }
        
    }
    
    
    public int getLado() { return lado; }
    
}
