import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }

        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0; // ничья
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1; // победа первого игрока
        } else {
            return 2; // победа второго игрока
        }
    }

    private Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }
}
