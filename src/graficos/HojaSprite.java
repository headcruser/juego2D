package graficos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** Representa a un sprite
 * @author Headcruser87*/
public class HojaSprite 
{
    private final int ancho;
    private final int alto;
    public final  int [] pixeles;
    
   // coleccion hojas sprites 
    public static final HojaSprite DESIERTO=new HojaSprite
                                        ( "resources/texturas/desierto.png",  320,  320 ); 
        
/**constuctor de la clase
     * @param ruta
     * @param ancho
     * @param alto */
    public HojaSprite( final String ruta , final int ancho, final int alto ) 
    {
       this.ancho=ancho;
       this.alto=alto;
       pixeles=new int [ ancho * alto ];
        BufferedImage imagen;
        
        try 
        {
            imagen=ImageIO.read( new File( ruta ) );
            imagen.getRGB(0, 0, ancho, alto, pixeles,0 , ancho);
        } catch (IOException ex) {  System.out.println( ex.getMessage() ); }
        
    }
    
//Getters
  public int getAncho() { return this.ancho; }
    
} // Fin de la clase 