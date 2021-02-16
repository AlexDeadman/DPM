package game;

public class Player extends Entity{
    private String nickname;

    public Player(String nickname, double posX, double posZ, int health, int maxHealth, int attackDamage, double attackDistance) {
        super("player", posX, posZ, health, maxHealth, attackDamage, attackDistance, false);
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Player{" +
                "title='" + title + '\'' +
                ", posX=" + posX +
                ", posZ=" + posZ +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", attackDamage=" + attackDamage +
                ", id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }

// ----------------------------------------------------------------------------------------------------

    @Override
    public void update() {
        super.update();
        if(GameServer.getInstance().getCurrentUpdate() % 2 == 0) {
            if (this.health < this.maxHealth) {
                this.health++;
            }
        }
    }


    // ----------------------------------------------------------------------------------------------------

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
