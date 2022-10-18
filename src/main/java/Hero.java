import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {

    private int x;
    private int y;
    private Screen screen;


    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Screen screen) throws IOException{
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
