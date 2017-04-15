package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**Clase que detecta el teclado del juego *
 * @author Headcruser87
 * @see KeyListener Implementa el escuchador de teclas
 * @version 1.0 */
public final class Teclado implements KeyListener
{
    private final static int numeroTeclas = 120; 
    private final boolean [] teclas = new boolean [ numeroTeclas ]; 
    
    // Movimiento de los controles 
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    
    /**Actualiza la  tecla presionada por el usuario */
    public void actualizar()
    {
        arriba = teclas [ KeyEvent.VK_W ];
        abajo = teclas [ KeyEvent.VK_S ];
        izquierda = teclas [ KeyEvent.VK_A ];
        derecha = teclas [ KeyEvent.VK_D ];
    } 
 
    //Sobrescritura de metodos 
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[ e.getKeyCode() ]= true; 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[ e.getKeyCode() ]= false; 
    }
    
} // Fin de la clase 
