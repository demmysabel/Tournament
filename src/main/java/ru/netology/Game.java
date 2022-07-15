package ru.netology;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    public Game() {

    }

    private Collection<Player> players = new ArrayList<Player>();

    private Player getPlayer(String playerName) {
        for (Player pl : players) {
            if (pl.getName() == playerName)
                return pl;
        }
        return null;
    }

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = getPlayer(playerName1);
        Player player2 = getPlayer(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Player is not registered!");
        }
        if (player1.getStrength() - player2.getStrength() == 0) {
            return 0;
        }
        if (player1.getStrength() - player2.getStrength() > 0) {
            return 1;
        } else
            return 2;
    }


}


