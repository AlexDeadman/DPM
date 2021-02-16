package game;

public class Entity {
    protected String title;
    protected double posX;
    protected double posZ;
    protected int health;
    protected int maxHealth;
    protected int attackDamage;
    protected double attackDistance;

    protected static int idCounter = 0;
    protected final long id;

    private boolean agressive;

    public Entity(String title, double posX, double posZ, int health, int maxHealth, int attackDamage, double attackDistance, boolean agressive) {
        this.title = title;
        this.posX = posX;
        this.posZ = posZ;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.attackDistance = attackDistance;
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

    private double checkDistance(Entity currEntity) {
        return Math.sqrt(Math.pow((this.posX - currEntity.getPosX()), 2) + Math.pow((this.posZ - currEntity.getPosZ()), 2));
    }

    public void attack(Entity attackedEntity) {
        attackedEntity.health -= this.attackDamage + 0.5 * GameServer.getInstance().getDifficulty();

        if (attackedEntity instanceof Player) {
            if (attackedEntity.health > 0) {
                attackedEntity.attack(this);
            }
        }

        if (attackedEntity.health <= 0) {
            String killer = this instanceof Player ? ((Player) this).getNickname() : this.title;
            String victim = attackedEntity instanceof Player ? ((Player) attackedEntity).getNickname() : attackedEntity.title;

            System.out.println(victim + " was slain by " + killer + " (" + killer + " has " + this.health + " HP)");
        }
    }

    public void update() {
        Entity[] entities = GameServer.getInstance().getEntities();

        if (this.health <= 0) {
            entities[(int) this.id] = null;
            return;
        }

        if (this.agressive) {
            double minDistance = Double.MAX_VALUE;
            int nearestId = -1;

            for (int i = 0; i < entities.length; i++) {
                if (i == this.id) {
                    continue;
                }
                if (entities[i] != null) {
                    double distance = checkDistance(entities[i]);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestId = i;
                    }
                }
            }

            if (nearestId != -1) {
                if (minDistance <= attackDistance) {
                    attack(entities[nearestId]);
                } else {
                    if (this.posX - entities[nearestId].posX < 0) {
                        this.posX++;
                    } else {
                        posX--;
                    }

                    if (this.posZ - entities[nearestId].posZ < 0) {
                        this.posZ++;
                    } else {
                        posZ--;
                    }
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

    public double getAttackDistance() {
        return attackDistance;
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

    public void setAttackDistance(double attackDistance) {
        this.attackDistance = attackDistance;
    }
}
