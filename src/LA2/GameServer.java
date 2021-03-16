package LA2;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private static GameServer instance;

    private String ip;
    private int difficulty;
    private List<Entity> entities;
    private final List<World> worlds;
    private final int updatesQuantity;
    private int currentUpdate = 0;
    private final int updatesDelay;

    public GameServer(
            String ip,
            int difficulty,
            List<Entity> entities,
            List<World> worlds,
            int updatesQuantity,
            int updatesDelay
    ) {
        this.ip = ip;

        if (difficulty < 1) {
            this.difficulty = 1;
        } else {
            this.difficulty = Math.min(difficulty, 3);
        }

        this.entities = entities;
        this.worlds = worlds;
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

    // ----------------------------------------------------------------------------------------------------

    public void updateServer() {
        System.out.print(". ");

        for (World currentWorld : this.worlds) {
            currentWorld.update();
        }

        try {
            Thread.sleep(this.updatesDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    TODO фикс вывод сущностей
//    public void printEntities() {
//            System.out.println( "\n┌──────┬───────────────────┬────────────┬─────────────────────┬──────────────────────┐");
//            System.out.println(   "│  ID  │       Title       │   Health   │   Position X ; Z    │       Nickname       │");
//            System.out.println(   "├──────┼───────────────────┼────────────┼─────────────────────┼──────────────────────┤");
//
//        for (int i = 0; i < entities.length; i++) {
//            if (entities[i] == null) {
//                System.out.printf("│ %-4d │ Dead entity       │            │                     │                      │\n", i);
//            } else {
//                System.out.printf("│ %-4d │ %-17s │ %-10d │ %-9.2f;%9.2f ",
//                                i, entities[i].title, entities[i].health, entities[i].posX, entities[i].posZ
//                );
//                if (entities[i] instanceof Player) {
//                    System.out.printf("│ %-20s │\n", ((Player) entities[i]).getNickname());
//                } else {
//                    System.out.print( "│                      │\n");
//                }
//            }
//        }
//            System.out.println(   "└──────┴───────────────────┴────────────┴─────────────────────┴──────────────────────┘");
//    }

    // ----------------------------------------------------------------------------------------------------

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

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<World> getWorlds() {
        return worlds;
    }

    public int getUpdatesQuantity() {
        return updatesQuantity;
    }

    public int getCurrentUpdate() {
        return currentUpdate;
    }
}
