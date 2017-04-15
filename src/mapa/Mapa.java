package mapa;

/*** Plantilla para generar mapas 
 * @author Headcruser87 */
public abstract class Mapa 
{
    protected int ancho;
    protected int alto;
    
    protected int [] cuadros;

    //Genera un mapa aleatorio 
    public Mapa(  final int ancho,  final int alto ) 
    {
        this.ancho=ancho;
        this.alto=alto;
        
        this.cuadros=new int[ alto* ancho ];
        generarMapa();
    }
       
   /** Cargar un mapa de la ruta 
    * @param ruta*/
    public Mapa(String ruta) 
    {
        cargarMapa( ruta );
    }
    
    protected void generarMapa()
    {
    }
    private void cargarMapa( final String ruta)
    {
    }
    
   public void actualizar()
   {
       
   }
   public void mostrar( final int compensacionX, final int compensacionY) 
   {
   }
    
    
    
    
    
    
}
