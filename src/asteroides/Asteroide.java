package asteroides;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 * @author Pablo Ruiz Soria
 */
public class Asteroide extends JPanel {
    private int posX;
    private int posY;
    private int desX = 1;
    private int desY = 1;
    private final int ANCHO = 20;
    private final int ALTO = 20;
    private Juego juego;
    
    public Asteroide(Juego juego){
        this.juego = juego;
        this.posX = (int) (Math.random() * 390);
        this.posY = (int) (Math.random() * 390);
    }

    void mover() {
        if(posX + desX > juego.getWidth() - this.ANCHO ){
            desX = -1;
        }
        if(posX + desX < 0){
            desX = 1;
        }
        if(posY + desY < 0){
            desY = 1;
        }
        if(posY + desY > juego.getHeight() - this.ALTO){
            desY = -1;
        }
        
        posX = posX + desX;
        posY = posY + desY;
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle(posX, posY, ANCHO, ALTO);
    }
    
    @Override
    public void paint(Graphics g){
        g.fillRect(posX, posY, ANCHO, ALTO);
    }

}