package game;

import java.util.Arrays;

public class GameServer {
    private static GameServer instance;

    private String ip;
    private int difficulty;
    private Entity[] entities;
    private final int updatesQuantity;
    private int currentUpdate = 0;
    private final int updatesDelay;

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int diff = 1;
        double stdAttackDistance = 2.0;
        Entity[] humanoidz = new Entity[]{
                new Entity("Woman", 1.0, 1.0, 100, 100, 13, stdAttackDistance, true),
                new Entity("Stranger", 11.0, 11.0, 20, 100, 1, stdAttackDistance, true),
                new Player("TRUE MAN", 1.1, 1.1, 200, 200, 20, stdAttackDistance),
                new Entity("EPIC BOSS", 16.0, 13.0, 500, 500, 25, 5.0, true),
        };

        GameServer coolServer = new GameServer(ip, diff, humanoidz, 30, 500);

        for (; coolServer.currentUpdate < coolServer.updatesQuantity; coolServer.currentUpdate++) {
            coolServer.updateServer();
        }
    }

    public GameServer(String ip, int difficulty, Entity[] entities, int updatesQuantity, int updatesDelay) {
        this.ip = ip;
        this.difficulty = difficulty;
        this.entities = entities;
        this.updatesQuantity = updatesQuantity;
        this.updatesDelay = updatesDelay;

        instance = this;
    }

    @Override
    public String toString() {
        return "GameServer{" +
                "ip='" + ip + '\'' +
                ", difficulty=" + difficulty +
                ", currentUpdate=" + currentUpdate +
                '}';
    }

// --------------------------------------------------------------------------------

    public void updateServer() {
        System.out.println("Server uptime: " + this.getCurrentUpdate());

        for (Entity currEntity : this.entities) {
            if (currEntity != null) {
                currEntity.update();
            }
        }

        try {
            Thread.sleep(this.updatesDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // --------------------------------------------------------------------------------

    public static GameServer getInstance() {
        return instance;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Entity[] getEntities() {
        return entities;
    }

    public int getUpdatesQuantity() {
        return updatesQuantity;
    }

    public int getCurrentUpdate() {
        return currentUpdate;
    }
}
