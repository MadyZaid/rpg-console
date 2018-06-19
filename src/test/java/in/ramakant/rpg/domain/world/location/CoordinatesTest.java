package in.ramakant.rpg.domain.world.location;

import in.ramakant.rpg.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class CoordinatesTest {

    private Coordinates coordinates;

    @Before
    public void dataSetup(){
        coordinates = new Coordinates(5,5);
    }

    @Test
    public void Coordinates_getX() {
        assertThat(coordinates.getX()).isEqualTo(5);
    }

    @Test
    public void Coordinates_getY() {
        assertThat(coordinates.getY()).isEqualTo(5);
    }

    @Test
    public void Coordinates_up() {
        Coordinates newCoordinates = coordinates.up();
        assertThat(newCoordinates.getX()).isEqualTo(5);
        assertThat(newCoordinates.getY()).isEqualTo(4);
    }

    @Test
    public void Coordinates_down() {
        Coordinates newCoordinates = coordinates.down();
        assertThat(newCoordinates.getX()).isEqualTo(5);
        assertThat(newCoordinates.getY()).isEqualTo(6);
    }

    @Test
    public void Coordinates_left() {
        Coordinates newCoordinates = coordinates.left();
        assertThat(newCoordinates.getX()).isEqualTo(4);
        assertThat(newCoordinates.getY()).isEqualTo(5);
    }

    @Test
    public void Coordinates_right() {
        Coordinates newCoordinates = coordinates.right();
        assertThat(newCoordinates.getX()).isEqualTo(6);
        assertThat(newCoordinates.getY()).isEqualTo(5);
    }

    @Test
    public void Coordinates_toString() {
        String result = coordinates.toString();
        assertThat(result).isEqualTo("[x=5,y=5]");
    }

    @Test
    public void Coordinates_equals_ReturnsFalse_WhenNotEqual() {
        assertThat(coordinates.equals(3,3)).isFalse();
    }

    @Test
    public void Coordinates_equals_ReturnsTrue_WhenEqual() {
        assertThat(coordinates.equals(5,5)).isTrue();
    }

    @Test
    public void Coordinates_equalsObject_ReturnsTrue_WhenEqual() {
        assertThat(coordinates.equals(new Coordinates(5,5))).isTrue();
    }

    @Test
    public void Coordinates_hashCode() {
        assertThat(coordinates.hashCode()).isEqualTo(1121);
    }
}