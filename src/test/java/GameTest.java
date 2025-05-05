import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldWinFirstPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 100);
        Player player2 = new Player(2, "Игрок 2", 80);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Игрок 1", "Игрок 2");

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 80);
        Player player2 = new Player(2, "Игрок 2", 100);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Игрок 1", "Игрок 2");

        Assertions.assertEquals(2, actual);
    }

    @Test
    public void shouldBeDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 100);
        Player player2 = new Player(2, "Игрок 2", 100);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Игрок 1", "Игрок 2");

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void shouldThrowExceptionIfFirstPlayerNotRegistered() {
        Game game = new Game();
        Player player2 = new Player(2, "Игрок 2", 100);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Игрок 1", "Игрок 2")
        );
    }

    @Test
    public void shouldThrowExceptionIfSecondPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Игрок 1", 100);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Игрок 1", "Игрок 2")
        );
    }

    @Test
    public void shouldThrowExceptionIfBothPlayersNotRegistered() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Игрок 1", "Игрок 2")
        );
    }
}
