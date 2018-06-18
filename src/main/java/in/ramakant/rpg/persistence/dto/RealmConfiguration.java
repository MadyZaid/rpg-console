package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.common.utils.ToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class RealmConfiguration implements Serializable {
    private static final long serialVersionUID = 4590433645393752706L;

    private final String name;
    private final int realmSize;
    private final List<EnemyConfiguration> enemies;
    private final List<MedicConfiguration> medics;

    public RealmConfiguration(String name, int realmSize, List<EnemyConfiguration> enemies, List<MedicConfiguration> medics) {
        this.name = name;
        this.realmSize = realmSize;
        this.enemies = enemies;
        this.medics = medics;
    }

    public String getName() {
        return name;
    }

    public int getRealmSize() {
        return realmSize;
    }

    public List<EnemyConfiguration> getEnemies() {
        return enemies;
    }

    public List<MedicConfiguration> getMedics() {
        return medics;
    }

    @Override
    public String toString() {
        return name;
    }

    public String detailedToString() {
        return ToStringBuilder.defaultBuilder(this)
                .append("name", name)
                .append("realmSize", realmSize)
                .append("enemies", buildEnemiesToString())
                .append("medics", buildMedicsToString())
                .buildWithClassName();
    }

    private String buildEnemiesToString() {
        if (enemies == null || enemies.isEmpty()) {
            return "no enemies defined";
        }

        return enemies.stream()
                .map(enemy -> "\n\t" + enemy.toString())
                .collect(Collectors.joining());
    }

    private String buildMedicsToString() {
        if (medics == null || medics.isEmpty()) {
            return "no medics defined";
        }

        return medics.stream()
                .map(medic -> "\n\t" + medic.toString())
                .collect(Collectors.joining());
    }

    public String shortDesc() {
        return String.format("%s this is the map", name, realmSize, realmSize);
    }
}
