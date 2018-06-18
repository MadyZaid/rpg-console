package in.ramakant.rpg.persistence;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.persistence.dto.EnemyConfiguration;
import in.ramakant.rpg.persistence.dto.MedicConfiguration;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;
import in.ramakant.rpg.persistence.impl.SerializedRealmConfigurationProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static in.ramakant.rpg.common.utils.IntUtils.randomIntInclusive;

public class SerializationRealmConfigurationGenerator {
    public static void main(String[] args) throws ConfigurationException {
        generateRealms();
    }

    public static void generateRealms() throws ConfigurationException {
        SerializedRealmConfigurationProvider provider = new SerializedRealmConfigurationProvider();

        ArrayList<RealmConfiguration> realms = realms();
        provider.save(realms);
        realms.forEach(realm -> System.out.println(realm.detailedToString()));
    }

    public static ArrayList<RealmConfiguration> realms() {
        ArrayList<RealmConfiguration> realmConfigurations = new ArrayList<>();
        realmConfigurations.add(gotRealm());
        realmConfigurations.add(dungeonsRealm());
        return realmConfigurations;
    }

    public static RealmConfiguration dungeonsRealm() {
        List<EnemyConfiguration> enemies = new ArrayList<>();
        enemies.add(buildEnemy("Druid", 300, 13, 5));
        enemies.add(buildEnemy("Iggwilv", 200, 12, 3));
        enemies.add(buildEnemy("Tiamat", 200, 13, 0));
        enemies.add(buildEnemy("Warduke", 30, 3, 0));
        enemies.add(buildEnemy("Lolth", 150, 6, 5));
        enemies.add(buildEnemy("Rary", 90, 7, 3));
        enemies.add(buildEnemy("Jarlaxle", 60, 7, 2));
        enemies.add(buildEnemy("Mordenkainen\n", 250, 15, 2));

        List<MedicConfiguration> medics = new ArrayList<>();

        medics.add(buildMedic("Jhon", 100));
        medics.add(buildMedic("Alex", 150));

        return buildRealmConfiguration("Dungeons and Dragons",
                10,
                SerializationRealmConfigurationGenerator::someDragon,
                enemies,
                medics
        );
    }

    public static RealmConfiguration gotRealm() {

        List<EnemyConfiguration> enemies = new ArrayList<>();
        enemies.add(buildEnemy("Gregor Clegane", 300, 15));
        enemies.add(buildEnemy("The Night King", 200, 14));
        enemies.add(buildEnemy("Jaime Lannister", 250, 13));
        enemies.add(buildEnemy("Stannis Baratheon", 150, 12));
        enemies.add(buildEnemy("Euron Greyjoy", 170, 10));
        enemies.add(buildEnemy("Craster", 120, 8));
        enemies.add(buildEnemy("Warlocks", 80, 6));
        enemies.add(buildEnemy("Orell", 60, 4));
        enemies.add(buildEnemy("Olly", 20, 2));

        List<MedicConfiguration> medics = new ArrayList<>();

        medics.add(buildMedic("Melisandre", 150));
        medics.add(buildMedic("Myranda", 100));

        return buildRealmConfiguration("Game Of Thrones",
                10,
                SerializationRealmConfigurationGenerator::someLannister,
                enemies,
                medics);
    }

    public static MedicConfiguration buildMedic(String name, int healthSupply) {
        return new MedicConfiguration(name, "Medic to supply health", "Taken health from " + name, healthSupply);
    }

    public static EnemyConfiguration buildEnemy(String name, int hp, int damage) {
        return buildEnemy(name, hp, damage, damage / 5);
    }

    public static EnemyConfiguration buildEnemy(String name, int hp, int damage, int dmgVariation) {
        return buildEnemy(name, "empty for now", "I'll crush you like an insect!", hp, damage, dmgVariation);
    }

    public static EnemyConfiguration buildEnemy(String name, String desc, String greeting, int hp, int damage, int dmgVariation) {
        return new EnemyConfiguration(name, desc, greeting, hp, damage, dmgVariation);
    }

    private static EnemyConfiguration someDragon() {
        return buildEnemy("Beholder", "One eye monster", "Let me eat you!",
                randomIntInclusive(50, 250), randomIntInclusive(8, 13), randomIntInclusive(2));
    }

    private static EnemyConfiguration someLannister() {
        return buildEnemy("Lannister", "Lannisters always pays their debt!", "Die you son of a poor!",
                randomIntInclusive(50, 250), randomIntInclusive(8, 13), randomIntInclusive(2));
    }

    public static RealmConfiguration buildRealmConfiguration(String name,
                                                             int numberOFRandomEnemies,
                                                             Supplier<EnemyConfiguration> enemySupplier,
                                                             List<EnemyConfiguration> definedEnemies,
                                                             List<MedicConfiguration> medics) {
        List<EnemyConfiguration> enemies = randomEnemies(numberOFRandomEnemies, enemySupplier);
        enemies.addAll(definedEnemies);

        return new RealmConfiguration(name, enemies.size() - 10, enemies, medics);
    }

    private static List<EnemyConfiguration> randomEnemies(int numberOFRandomEnemies, Supplier<EnemyConfiguration> enemySupplier) {
        List<EnemyConfiguration> randomEnemies = new ArrayList<>();
        for (int i = 0; i < numberOFRandomEnemies; i++) {
            randomEnemies.add(enemySupplier.get());
        }
        return randomEnemies;
    }
}
