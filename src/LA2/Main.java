package LA2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int diff = 1;
        double stdAttackDistance = 2.0;

        List<Entity> humanoidz = new ArrayList<>();

        List<World> epicWorlds = List.of(new World(0, "Earth", humanoidz));

        humanoidz = List.of(
                new Entity(
                        "Woman",
                        1.0,
                        1.0,
                        100,
                        100,
                        7,
                        stdAttackDistance,
                        true,
                        null,
                        epicWorlds.get(0)
                ),
                new Entity(
                        "Stranger",
                        11.0,
                        11.0,
                        20,
                        100,
                        1,
                        stdAttackDistance,
                        true,
                        null,
                        epicWorlds.get(0)
                ),
                new Player(
                        "TRUE MAN",
                        1.1,
                        1.1,
                        150,
                        150,
                        30,
                        stdAttackDistance,
                        null,
                        epicWorlds.get(0)
                ),
                new Entity(
                        "EPIC BOSS",
                        16.0,
                        13.0,
                        200,
                        200,
                        15,
                        5.0,
                        true,
                        null,
                        epicWorlds.get(0)
                )
        );

        GameServer coolServer = new GameServer(ip, diff, humanoidz, epicWorlds, 30, 500);

//        coolServer.printEntities();

//        TODO фикс жизнь сервера
//        for (; coolServer.currentUpdate < coolServer.updatesQuantity; coolServer.currentUpdate++) {
//            coolServer.updateServer();
//        }

//        coolServer.printEntities();
    }
}
