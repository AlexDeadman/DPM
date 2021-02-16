package game;

public class Entity {
    protected String title;
    protected double posX;
    protected double posZ;
    protected int health;
    protected int maxHealth;
    protected int attackDamage;

    protected static int idCounter = 0;
    protected final long id;

    private boolean agressive;

    public Entity(String title, double posX, double posZ, int health, int maxHealth, int attackDamage, boolean agressive) {
        this.title = title;
        this.posX = posX;
        this.posZ = posZ;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.agressive = agressive;

        this.id = idCounter++;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "title='" + title + '\'' +
                ", posX=" + posX +
                ", posZ=" + posZ +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", attackDamage=" + attackDamage +
                ", id=" + id +
                ", agressive=" + agressive +
                '}';
    }

    // ------------------------------------------------------------------------------------------

    private boolean isNear(Entity currEntity) {
        return (double) Math.sqrt(
                Math.pow((this.posX - currEntity.getPosX()), 2) +
                Math.pow((this.posZ - currEntity.getPosZ()), 2)
        ) <= 2.0;
    }

    public void attack(Entity attackedEntity) {
        attackedEntity.health -= this.attackDamage + 0.5 * GameServer.getInstance().getDifficulty();

        // TODO: игнорируется instanceof
        if (attackedEntity instanceof Player) {
            if (attackedEntity.health > 0) {
                attackedEntity.attack(this);
            } else {
                System.out.println(
                        ((Player) attackedEntity).getNickname()  + " was slain by " + this.title
                );
            }
        }

        if (attackedEntity.health <= 0) {
            System.out.println(
                    attackedEntity.title + " was slain by " + this.title
            );
        }
    }

    public void update() {
        Entity[] entities = GameServer.getInstance().getEntities();

        if (this.health <= 0) {
            entities[(int) this.id] = null;
            return;
        }

        // TODO: прописать движение агрессора
        if (this.agressive) {
            for (int i = 0; i < entities.length; i++) {
                if(i != this.id && entities[i] != null && isNear(entities[i])) {
                        this.attack(entities[i]);
                }
            }
        }
    }

    // ------------------------------------------------------------------------------------------

    public String getTitle() {
        return title;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosZ() {
        return posZ;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public long getId() {
        return id;
    }

    public boolean isAgressive() {
        return agressive;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setAgressive(boolean agressive) {
        this.agressive = agressive;
    }
}
