package LA2;

import java.util.List;

public class Entity {
    protected String title;
    protected double posX;
    protected double posZ;
    protected int health;
    protected int maxHealth;
    protected int attackDamage;
    protected double attackDistance;
    protected Entity target;
    protected World world;

    protected static int idCounter = 0;
    protected final long id;

    private boolean agressive;

    public Entity(
            String title,
            double posX,
            double posZ,
            int health,
            int maxHealth,
            int attackDamage,
            double attackDistance,
            boolean agressive,
            Entity target,
            World world
    ) {
        this.title = title;
        this.posX = posX;
        this.posZ = posZ;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.attackDistance = attackDistance;
        this.agressive = agressive;
        this.target = target;
        this.world = world;

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
        return Math.sqrt(
                Math.pow((this.posX - currEntity.getPosX()), 2)
                        + Math.pow((this.posZ - currEntity.getPosZ()), 2)
        );
    }

    public void attack(Entity targetToBeAttacked) {
        targetToBeAttacked.health -= this.attackDamage + 0.5 * GameServer.getInstance().getDifficulty();

        if (targetToBeAttacked instanceof Player) {
            if (targetToBeAttacked.health > 0) {
                targetToBeAttacked.attack(this);
            }
        }

        if (targetToBeAttacked.health <= 0) {

            String killer;

            if (this instanceof Player) {
                killer = ((Player) this).getNickname();
            } else {
                killer = this.title;
            }

            String victim;

            if (targetToBeAttacked instanceof Player) {
                victim = ((Player) targetToBeAttacked).getNickname();
            } else {
                victim = targetToBeAttacked.title;
            }

            System.out.println("\n" + victim + " was slain by " + killer + " (" + killer + " has " + this.health + " HP)");
        }
    }

    private void searchTarget() {
//        TODO searchTarget()
    }

    public void update() {
        List<Entity> entities = GameServer.getInstance().getEntities();

        if (this.health <= 0) {
            entities.remove(this);
            return;
        }

        if (this.agressive && this.target == null) {
            searchTarget();

//            double minDistance = Double.MAX_VALUE;
//            long nearestId = -1;
//
//            for (Entity currentEntity : entities) {
//                if (currentEntity.id == this.id) {
//                    continue;
//                }
//                double distance = checkDistance(currentEntity);
//                if (distance < minDistance) {
//                    minDistance = distance;
//                    nearestId = currentEntity.id;
//                }
//            }

//            TODO преобразовать движение
//            if (nearestId != -1) {
//                if (minDistance <= attackDistance) {
//                    attack(entities[nearestId]);
//                } else {
//
////                    double dirX = (enemy.getPosX() - posX) / distance;
////                    double dirZ = (enemy.getPosZ() - posZ) / distance;
////                    posX += dirX;
////                    posZ += dirZ;
//
//                    if (this.posX - entities[nearestId].posX < 0) {
//                        this.posX++;
//                    } else {
//                        posX--;
//                    }
//
//                    if (this.posZ - entities[nearestId].posZ < 0) {
//                        this.posZ++;
//                    } else {
//                        posZ--;
//                    }
//                }
//            }
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
