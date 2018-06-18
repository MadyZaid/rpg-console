package in.ramakant.rpg.domain.model;

import in.ramakant.rpg.common.constants.ConfigurationConstants;
import in.ramakant.rpg.common.utils.ToStringBuilder;
import in.ramakant.rpg.domain.exception.PlayerDied;
import in.ramakant.rpg.domain.world.location.Coordinates;
import in.ramakant.rpg.persistence.dto.PlayerConfiguration;

public class Player extends Character {
    private static final long serialVersionUID = -192721880115940836L;
    private Coordinates coordinates;
    private Experience experience;

    public Player(String name, String description, int healthBonus, int damageBonus, int damageVariationBonus, Coordinates initialCoordinates) {
        super(name, description, ConfigurationConstants.BASE_HEALTH + healthBonus, ConfigurationConstants.BASE_DAMAGE + damageBonus, ConfigurationConstants.BASE_DAMAGE_VARIATION + damageVariationBonus);
        this.coordinates = initialCoordinates;
        this.experience = new Experience();
    }

    public Player(PlayerConfiguration conf, Coordinates initialCoordinates) {
        this(conf.getName(), conf.getDesc(), conf.getHpBonus(), conf.getDamageBonus(), conf.getDamageVariationBonus(), initialCoordinates);
    }

    public Coordinates up() {
        return coordinates.up();
    }

    public Coordinates down() {
        return coordinates.down();
    }

    public Coordinates left() {
        return coordinates.left();
    }

    public Coordinates right() {
        return coordinates.right();
    }

    public String killed(NPC npc) {
        ExperienceStatus experienceStatus = experience.addKillReward(npc.getExpReward());
        switch (experienceStatus) {
            case DIDNT_LEVEL_UP:
                break;
            case LEVELED_UP:
                playerLevelUp();
                break;
            case DOUBLE_LEVELED_UP:
                playerLevelUp();
                playerLevelUp();
                break;
        }

        resetFightStatus();
        return String.format(experienceStatus.toString(), npc.getExpReward());
    }

    public void getMedicHelp(Medic medic) {
        if (medic.isAlive) {
            currentHealth = currentHealth + medic.maxHealth;
            maxHealth = maxHealth + medic.maxHealth;
            medic.isAlive = false;
        }
    }

    private void playerLevelUp() {
        maxHealth += ConfigurationConstants.LEVEL_UP_BONUS;
        damage += 2;
        damageVariation++;
    }

    public String flee() {
        maxHealth = maxHealth - ConfigurationConstants.FIGHT_FLEEING_HP_REDUCTION;
        resetFightStatus();
        return "You lost some health while retreating from battle field";
    }

    private void resetFightStatus() {
        currentHealth = maxHealth;
    }

    @Override
    public void die() {
        super.die();
        throw new PlayerDied();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Experience getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return super.toString() + toStringCommon().build();
    }

    @Override
    public String toStringWithColors() {
        return super.toStringWithColors() + toStringCommon().build(true);
    }

    private ToStringBuilder toStringCommon() {
        return ToStringBuilder.fieldsWithNewlinesAndTabs(this)
                .append("coordinates", coordinates.toString())
                .append("experience", experience.toString());
    }
}
