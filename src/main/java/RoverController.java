public class RoverController {
    private Rover rover;
    public  RoverController(Rover rover)
    {
        this.rover = rover;
    }
    public String execute(String mission) {
        String[] commands = mission.split(",");
        int areaWidth = Integer.parseInt(commands[0]);
        int areaHeight = Integer.parseInt(commands[1]);
        int x = Integer.parseInt(commands[2]);
        int y = Integer.parseInt(commands[3]);
        String direction = commands[4];
        rover.land(new Area(areaWidth, areaHeight), x, y, direction);

        for (int i = 5; i < commands.length; i++) {
            executeOneCommand(commands[i]);
        }
        return rover.getPosition();
    }
    private void executeOneCommand(String command)
    {
        if(command.equals("M")||command.equals("S")||command.equals("E")||command.equals("W")) {
            rover.move();
        }
        if(command.equals("L")) {
            rover.turnLeft();
        }
        if(command.equals("R")) {
            rover.turnRight();
        }
    }
}
