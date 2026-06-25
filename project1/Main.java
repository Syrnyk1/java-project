import java.util.ArrayList;

class Player {
    String nick;
    int elo;
    double kd;

    public Player(String nick, int elo, double kd) {
        this.nick = nick;
        this.elo = elo;
        this.kd = kd;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Ініціалізація списку
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("S1mple", 3200, 1.3));
        players.add(new Player("Donk", 2800, 1.5));
        players.add(new Player("M0nesy", 3500, 1.76));

        // 2. Видалення (чистий підхід)
        String removeNick = "Donk";
        if (players.removeIf(p -> p.nick.equals(removeNick))) {
            System.out.println("Player " + removeNick + " was deleted.");
        } else {
            System.out.println("Could not find player: " + removeNick);
        }

        // 3. Оновлення (чистий підхід з прапорцем)
        String updateNick = "S1mple";
        boolean found = false;
        for (Player p : players) {
            if (p.nick.equals(updateNick)) {
                p.elo = 3300;
                found = true;
                break; // Зупиняємо цикл, коли знайшли
            }
        }
        
        if (found) {
            System.out.println("Data for " + updateNick + " updated.");
        } else {
            System.out.println("Could not find player to update: " + updateNick);
        }

        // 4. Фінальний вивід
        System.out.println("\nFinal player list:");
        for (Player p : players) {
            System.out.println("Nick: " + p.nick + ", Elo: " + p.elo + ", K/D: " + p.kd);
        }
    }
}