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
    private Arena arena;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
            arena = new Arena(40, 20);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void draw() throws IOException{
            screen.clear();
            arena.draw(screen);
            screen.refresh();
    }




    private void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.ArrowUp) {
            arena.moveHero(arena.moveUp());
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            arena.moveHero(arena.moveDown());
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            arena.moveHero(arena.moveLeft());
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            arena.moveHero(arena.moveRight());
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
