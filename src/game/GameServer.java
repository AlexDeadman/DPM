package game;

import java.util.Arrays;

public class GameServer {
    private static GameServer instance;

    private String ip;
    private int difficulty;
    private Entity[] entities;
    private final int updatesQuantity;
    private int currentUpdate = 0;

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int diff = 1;
        Entity[] humanoidz = new Entity[]{
                new Entity("stranger_1", 1.0, 1.0, 100, 100, 0, true),
                new Entity("stranger_2", 5.0, 1.0, 1, 100, 1, true),
                new Player("CoolNickName_2002", 1.1, 1.1, 100, 100, 20)
        };

        GameServer coolServer = new GameServer(ip, diff, humanoidz, 30);

        for (; coolServer.currentUpdate < coolServer.updatesQuantity; coolServer.currentUpdate++) {
            coolServer.updateServer();
        }
    }

    public GameServer(String ip, int difficulty, Entity[] entities, int updatesQuantity) {
        this.ip = ip;
        this.difficulty = difficulty;
        this.entities = entities;
        this.updatesQuantity = updatesQuantity;

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
        for (Entity currEntity : this.entities) {
            if (currEntity != null) {
                currEntity.update();
            }
        }

        System.out.println("Server uptime: " + this.getCurrentUpdate());

        try {
            Thread.sleep(1000);
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
