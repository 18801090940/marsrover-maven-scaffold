
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRoverTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_land_the_rover_on_area() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void should_move_forward_when_direction_to_west() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "W");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("45W");
    }

    @Test
    public void should_move_forward_when_direction_to_east() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void should_move_forward_when_direction_to_north() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "N");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("56N");
    }

    @Test
    public void should_move_forward_when_direction_to_south() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "S");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("54S");
    }

    @Test
    public void turnLeft() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "W");
        rover.turnLeft();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55S");
        rover.turnLeft();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void turnRight() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "W");
        rover.turnRight();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55N");
        rover.turnRight();
        position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void should_execute_batch_commands() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,M,L,M";
        String position = roverController.execute(mission);
        assertThat(position).isEqualTo("66N");
    }

    @Test
    public void should_warning_when_land_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("x=20 is out of area width 10");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 20, 30, Rover.SOUTH);
    }
}
