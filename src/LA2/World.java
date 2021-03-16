package LA2;

import java.util.ArrayList;
import java.util.List;

public class World {
    private int id;
    private String worldName;
    private List<Entity> entities;

    public World(int id, String worldName, List<Entity> entities) {
        this.id = id;
        this.worldName = worldName;
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "World{" +
                "id=" + id +
                ", worldName='" + worldName + '\'' +
                ", entities=" + entities +
                '}';
    }

    // ----------------------------------------------------------------------------------------------------

    public void update() {
        entities.forEach(Entity::update);
    }

    public List<Entity> getEntitiesInRegion(int x, int z, double range) {
        // TODO возращает отсортированный в порядке близости точке x/z список сущностей

        return new ArrayList<Entity>(); // временно
    }

    public List<Entity> getEntitiesNearEntity(Entity entity, double range) {
        // TODO возращает отсортированный в порядке близости точке entity.posX/entity.posZ список сущностей

        return new ArrayList<Entity>(); // временно
    }

    // ----------------------------------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
