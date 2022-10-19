import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;

public class Arena {

    private int width;
    private int height;
    private Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
    }

    public void setPosition(Position position){
        hero.setPosition(position);
    }

    public void draw(TextGraphics screen) throws IOException {
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(screen);
    }

    public Position moveUp(){return hero.moveUp();}
    public Position moveDown(){ return hero.moveDown();}
    public Position moveRight(){return hero.moveRight();}
    public Position moveLeft(){return hero.moveLeft();}

   public boolean canHeroMove(Position position){
        if (position.getX() >= 0 && position.getX() <= width &&
                position.getY() >= 0 && position.getY() <= height){
            return true;
        } else return false;
   }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }


}
