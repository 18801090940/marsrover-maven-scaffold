import Point.Point;

public class Rover {
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    private int x;
    private int y;
    private String direction;
    public void land(Area area, int x, int y, String direction)
    {
    /*    if(!(x < area.containsPointWidth(x)))
        {
            throw new IllegalArgumentException("x=" + x+"is out of a");
        }*/
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public String getPosition()
    {
        return ""+ x + y + direction;
    }
    public void move() {
        if (direction.equals(EAST)) {
            x += 1;
        } else if(direction.equals(WEST)){
            x -= 1;
        }else if(direction.equals(NORTH))
            y += 1;
        else
            y -= 1;
    }

    public void turnLeft()
    {
        if(direction.equals((SOUTH))) {
            direction = EAST;
            return;
        }
        if(direction.equals((EAST))) {
            direction = NORTH;
            return;
        }
        if(direction.equals((NORTH))) {
            direction = WEST;
            return;
        }
        if(direction.equals((WEST))) {
            direction = SOUTH;
            return;
        }
    }

    public void turnRight()
    {
        if(direction.equals((SOUTH))) {
            direction = WEST;
            return;
        }
        if(direction.equals((EAST))) {
            direction = NORTH;
            return;
        }
        if(direction.equals((NORTH))) {
            direction = WEST;
            return;
        }
        if(direction.equals((WEST))) {
            direction = SOUTH;
            return;
        }
    }

}
