package in.ramakant.rpg.domain.world;

import in.ramakant.rpg.common.utils.ToStringBuilder;
import in.ramakant.rpg.domain.exception.ExplorationException;
import in.ramakant.rpg.domain.model.Enemy;
import in.ramakant.rpg.domain.model.Medic;
import in.ramakant.rpg.domain.model.NPC;
import in.ramakant.rpg.domain.world.location.Coordinates;
import in.ramakant.rpg.domain.world.location.Location;
import in.ramakant.rpg.domain.world.location.LocationType;
import in.ramakant.rpg.persistence.dto.EnemyConfiguration;
import in.ramakant.rpg.persistence.dto.MedicConfiguration;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static in.ramakant.rpg.common.utils.IntUtils.isNotBetweenZeroAndMaxExclusive;
import static in.ramakant.rpg.common.utils.IntUtils.randomIntExclusive;

public class World implements Serializable {
    private static final long serialVersionUID = 5441241162354372279L;

    private final String name;
    private final Map<Coordinates, Enemy> enemies;
    private final Map<Coordinates, Medic> medics;
    private final Location[][] map;

    public World(RealmConfiguration realmConfiguration) {
        this.name = realmConfiguration.getName();
        this.enemies = new HashMap<>();
        this.medics = new HashMap<>();
        this.map = new Location[realmConfiguration.getRealmSize()][realmConfiguration.getRealmSize()];

        this.initWorld(realmConfiguration.getEnemies(), realmConfiguration.getMedics());
    }

    static Coordinates randomCoordinates(int mapSize) {
        int randomX = randomIntExclusive(mapSize);
        int randomY = randomIntExclusive(mapSize);
        return new Coordinates(randomX, randomY);
    }

    private void initWorld(List<EnemyConfiguration> enemyConfiguration,
                           List<MedicConfiguration> medics) {
        initMedics(medics);
        initEnemies(enemyConfiguration);
        initMap();
    }

    private void initEnemies(List<EnemyConfiguration> enemyConfiguration) {
        for (EnemyConfiguration configuration : enemyConfiguration) {
            Enemy enemy = new Enemy(configuration);
            Coordinates enemyCoordinates = randomCoordinatesWithoutAnyone();
            enemies.put(enemyCoordinates, enemy);
        }
    }

    private void initMedics(List<MedicConfiguration> medicConfiguration) {
        for (MedicConfiguration medicConfiguration1 : medicConfiguration) {
            Medic medic = new Medic(medicConfiguration1);
            Coordinates medicCoordinates = randomCoordinatesWithoutAnyone();
            medics.put(medicCoordinates, medic);
        }
    }

    private void initMap() {
        for (int x = 0; x < map.length; x++) {
            Location[] column = map[x];
            for (int y = 0; y < column.length; y++) {
                Coordinates currentCoordinates = new Coordinates(x, y);
                NPC someone = searchForNpc(currentCoordinates);
                if (someone != null) {
                    map[x][y] = locationWithNpc(currentCoordinates, someone);
                } else {
                    map[x][y] = emptyLocation(currentCoordinates);
                }
            }
        }
    }

    private NPC searchForNpc(Coordinates currentCoordinates) {
        if (enemies.containsKey(currentCoordinates)) {
            return enemies.get(currentCoordinates);
        } else {
            return medics.get(currentCoordinates);
        }
    }

    private Location locationWithNpc(Coordinates coordinates, NPC someone) {
        return new Location(coordinates, someone);
    }

    private Location emptyLocation(Coordinates coordinates) {
        return new Location(coordinates);
    }

    public Coordinates randomCoordinatesWithoutAnyone() {
        Coordinates coordinates;

        do {
            coordinates = randomCoordinates(map.length);
        } while (someoneIsThere(coordinates));

        return coordinates;
    }

    private boolean someoneIsThere(Coordinates coordinates) {
        return enemies.containsKey(coordinates) || medics.containsKey(coordinates);
    }

    public Location getLocation(Coordinates coordinates) throws ExplorationException {
        return getLocation(coordinates.getX(), coordinates.getY());
    }

    public void setLocation(Coordinates coordinates, Location location) {
        map[coordinates.getX()][coordinates.getY()] = location;
    }

    public Location getLocation(int x, int y) throws ExplorationException {
        validateCoordinates(x, y);
        return map[x][y];
    }

    private void validateCoordinates(int x, int y) throws ExplorationException {
        validateCoordinate(x);
        validateCoordinate(y);
    }

    private void validateCoordinate(int index) throws ExplorationException {
        if (isNotBetweenZeroAndMaxExclusive(index, mapSize())) {
            ExplorationException.cannotGo(index);
        }
    }

    public boolean allEnemiesDead() {
        return aliveEnemiesLeft() == 0;
    }

    public long aliveEnemiesLeft() {
        return enemies.values().stream().filter(Enemy::isAlive).count();
    }

    public String getName() {
        return name;
    }

    public Location[][] getMap() {
        return map;
    }

    public Map<Coordinates, Enemy> getEnemies() {
        return enemies;
    }

    public int mapSize() {
        return map.length;
    }

    @Override
    public String toString() {
        return ToStringBuilder.defaultBuilder(this)
                .append("name", name)
                .append("mapSize", mapSize())
                .build();
    }
}
