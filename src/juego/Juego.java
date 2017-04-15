package juego;

import control.Teclado;
import graficos.Pantalla;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Un juego que no es de mi autotia, simplemente es para aprender
 * @author Headcruser87
 */
public class Juego extends Canvas implements Runnable
{
    private static final long serialVersionID=2L;
    private static final int ANCHO=400;
    private static final int ALTO=300;
    
   //volatile: se asegura que la variable no se use en multiples threads al mismo tiempo
    private static  volatile boolean enFuncionamiento=false;
    private static final String NOMBRE="Juego";
    private static int aps = 0;
    private static int fps=0;

    private static int x=0;
    private static int y=0;

    private static JFrame ventana;
    private static Thread thread;
    private static Teclado teclado;
    private static Pantalla pantalla;
   
   private static BufferedImage imageIcon = new 
                    BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
  private static int [] pixeles = ( ( DataBufferInt )
                                    imageIcon.getRaster().getDataBuffer() ).getData();
  private static final ImageIcon icono=new ImageIcon(  "resources/icono/icono.png");
    
    private Juego()
    {
        setPreferredSize( new Dimension( ANCHO, ALTO ) );
        
        pantalla= new Pantalla( ANCHO, ALTO );
        teclado = new Teclado();
        addKeyListener( teclado ); 
        
        ventana=new JFrame( NOMBRE );
        ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ventana.setResizable( true );
        ventana.setIconImage( icono.getImage()  );
        ventana.setLayout( new BorderLayout() );
        ventana.add( this, BorderLayout.CENTER );
        ventana.pack();
        ventana.setLocationRelativeTo( null );
        ventana.setVisible( true );
        
    }
    
    //Synchronized se asegura que no se ejecuten al mismo tiempo 
    public synchronized void iniciar()
    {
        enFuncionamiento=true;
        
        thread=new Thread( this, "Graficos" );
        thread.start();
    }
   
    public synchronized void detener()
    {
        enFuncionamiento=false;
        try 
        {
            thread.join();
        } catch (InterruptedException ex) {}
        
    }
    
    private void actualizar()
    {
        teclado.actualizar();
        if( teclado.arriba )
                ++y ;
        
        if( teclado.abajo )
                -- y;
        
        if( teclado.izquierda )
            ++ x ;
        
        if( teclado.derecha )
            -- x;
        
        ++ aps;
    }
    
    private void mostrar()
    {
        BufferStrategy estrategia =getBufferStrategy();
        
        if( estrategia == null){
            createBufferStrategy( 3 );
            return;
        }
        pantalla.limpiar();
        pantalla.mostrar( x, y );
        
        System.arraycopy ( pantalla.pixeles, 0,  pixeles, 0 , pixeles.length );
        
         Graphics g = estrategia.getDrawGraphics();
        
        g.drawImage( imageIcon, 0, 0, getWidth() , getHeight(), null );
        g.dispose();
        estrategia.show();
        ++ fps;
    } 
    
    
    @Override
    public void run() 
    {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        
        long referenciaActializacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        
        double  tiempoTranscurrido;
        double delta = 0;
        
        requestFocus();
        
        while( enFuncionamiento )
        {
            final long inicioBucle=System.nanoTime();
            
            tiempoTranscurrido = inicioBucle - referenciaActializacion;
            referenciaActializacion=inicioBucle;
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            
            while( delta >= 1)
            {
                actualizar();
                -- delta;
            }
          
          mostrar();
          
          if( System.nanoTime() - referenciaContador > NS_POR_SEGUNDO )
          {
              ventana.setTitle(NOMBRE + "  ||  APS: "+  aps+" ||  FPS:"+ fps );
              aps=0;
              fps=0;
              referenciaContador=System.nanoTime();
          }
        }
    }
    
    public static void main(String[] args) 
    {
        Juego juego=new Juego();
        juego.iniciar();
        
    }
}
