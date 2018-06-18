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
        realmConfigurations.add(gta2Realm());
        realmConfigurations.add(lotrRealm());
        return realmConfigurations;
    }

    public static RealmConfiguration lotrRealm() {

        List<EnemyConfiguration> enemies = new ArrayList<>();
        enemies.add(buildEnemy("Sauron", 300, 13, 5));
        enemies.add(buildEnemy("Balrog", 200, 12, 3));
        enemies.add(buildEnemy("Saruman", 200, 13, 0));
        enemies.add(buildEnemy("Gollum", 30, 3, 0));
        enemies.add(buildEnemy("Nazgul", 150, 6, 5));
        enemies.add(buildEnemy("Melkor", 90, 7, 3));
        enemies.add(buildEnemy("Witch-king of Angmar", 60, 7, 2));
        enemies.add(buildEnemy("Smaug", 250, 15, 2));

        List<MedicConfiguration> medics = new ArrayList<>();

        medics.add(buildMedic("Jhon", 100));
        medics.add(buildMedic("Alex", 150));

        return buildRealmConfiguration("Lord of the rings",
                15,
                SerializationRealmConfigurationGenerator::someUrukHai,
                enemies,
                medics
        );
    }

    public static RealmConfiguration gta2Realm() {

        List<EnemyConfiguration> enemies = new ArrayList<>();
        enemies.add(buildEnemy("Johnny Zoo", 300, 15));
        enemies.add(buildEnemy("Trey Welsh", 200, 14));
        enemies.add(buildEnemy("Elmo", 250, 13));
        enemies.add(buildEnemy("Billy Bob Bean", 150, 12));
        enemies.add(buildEnemy("Dr. LaBrat", 170, 10));
        enemies.add(buildEnemy("Red Valdez", 120, 8));
        enemies.add(buildEnemy("Jerkov", 80, 6));
        enemies.add(buildEnemy("Sunbeam", 60, 4));
        enemies.add(buildEnemy("Uno Carb", 20, 2));

        List<MedicConfiguration> medics = new ArrayList<>();

        medics.add(buildMedic("Jhon", 100));
        medics.add(buildMedic("Alex", 150));

        return buildRealmConfiguration("Grand Theft Auto",
                14,
                SerializationRealmConfigurationGenerator::someGangster,
                enemies,
                medics);
    }

    public static MedicConfiguration buildMedic(String name, int healthSupply) {
        return new MedicConfiguration(name, "Medic to supply health", "Let me help you!", healthSupply);
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

    private static EnemyConfiguration someUrukHai() {
        return buildEnemy("Uruk-Hai Warriors", "Wandering Uruk-Hai patrol", "WAAAAAAAGH!",
                randomIntInclusive(50, 250), randomIntInclusive(8, 13), randomIntInclusive(2));
    }

    private static EnemyConfiguration someGangster() {
        return buildEnemy("Gangsters", "Thugs looking for some trouble", "Give me your wallet or DIE!",
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
