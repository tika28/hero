import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private Screen screen;
    private Hero hero;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
            hero = new Hero(10, 10);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void draw() throws IOException{
            screen.clear();
            hero.draw(screen);
            screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.ArrowUp) {
            hero.setY(hero.getY() - 1);
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            hero.setY(hero.getY() + 1);
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            hero.setX(hero.getX() - 1);
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            hero.setX(hero.getX() + 1);
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }
    }
    public void run() throws IOException{
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if(key.getKeyType() == KeyType.EOF){
                break;
            }
        }

    }

}
