

import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void shouldGetWinPlayer1() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 200);
        Player player2 = new Player(2, "Alex", 100);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("John", "Alex");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetWinPlayer2() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 200);
        Player player2 = new Player(2, "Alex", 300);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("John", "Alex");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMakeDrawGame() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 100);
        Player player2 = new Player(2, "Alex", 100);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("John", "Alex");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegistatePlayer1() {
        Game game = new Game();
        Player player1 = new Player(1, "John", 200);
        game.register(player1);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("John", "Alex");
        });
    }

    @Test
    void shouldNotRegistatePlayer2() {
        Game game = new Game();
        Player player2 = new Player(2, "Alex", 200);
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("John", "Alex");
        });
    }


}
