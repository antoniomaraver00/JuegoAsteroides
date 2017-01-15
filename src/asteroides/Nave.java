package asteroides;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 * @author Pablo Ruiz Soria
 */
public class Nave extends JPanel {
    private int posX;
    private int posY;
    private int desX;
    private int desY;
    private final int ANCHO = 10;
    private final int ALTO = 10;
    private Juego juego;
    
    public Nave(Juego juego){
        this.juego = juego;
        this.posX = 195;
        this.posY = 195;
    }

    void mover() {
        if(posX + desX > juego.getWidth() - this.ANCHO ){
            desX = 0;
        }
        if(posX + desX < 0){
            desX = 0;
        }
        if(posY + desY < 0){
            desY = 0;
        }
        if(posY + desY > juego.getHeight() - this.ALTO){
            desY = 0;
        }
        if(choque()){
            juego.gameOver();
        }
        posX = posX + desX;
        posY = posY + desY;
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(posX, posY, ANCHO, ALTO);
    }

    void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            desX = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            desX = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            desY = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            desY = 1;
        }
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle(posX, posY, ANCHO, ALTO);
    }

    private boolean choque() {
        for(Asteroide asteroide:juego.getAsteroides()){
            if(asteroide.getBounds().intersects(this.getBounds())){
                return true;
            }
        }
        return false;
    }
}