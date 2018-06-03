public class Rover {

    private final Console console;
    private Position position;

    public Rover(Position position, Console console) {
        this.position = position;
        this.console = console;
    }

    public String display() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   0 1 2 3 4 5 6 7 8 9\n");
        stringBuilder.append(" +---------------------+\n");

        for (int y = 0; y < 10; y++) {
            stringBuilder.append(y + "| ");

            for (int x = 0; x < 10; x++) {

                if (this.position.x == x && this.position.y == y) {
                    if (this.position.direction == 'N') {
                        stringBuilder.append("^ ");
                    } else if (this.position.direction == 'E') {
                        stringBuilder.append("> ");
                    } else if (this.position.direction == 'W') {
                        stringBuilder.append("< ");
                    } else if (this.position.direction == 'S') {
                        stringBuilder.append("v ");
                    }
                } else {
                    stringBuilder.append("  ");
                }

            }

            stringBuilder.append("|\n");
        }

        stringBuilder.append(" +---------------------+");
        return stringBuilder.toString();
    }

    public void run(String[] commands) {

        this.console.print(this.display());

        for (String command : commands) {

            if (command == "f") {
                if (this.position.direction == 'N') {

                    this.position.y -= 1;
                    if(this.position.y < 0) {
                        this.position.y += 10;
                    }

                } else if (this.position.direction == 'W') {
                    this.position.x -= 1;
                    if(this.position.x < 0) {
                        this.position.x += 10;
                    }
                } else if (this.position.direction == 'E') {
                    this.position.x += 1;
                    if(this.position.x >= 10) {
                        this.position.x -= 10;
                    }
                } else if (this.position.direction == 'S') {
                    this.position.y += 1;
                    if(this.position.y >= 10) {
                        this.position.y -= 10;
                    }
                }
            } else if(command == "b") {

                if (this.position.direction == 'N') {
                    this.position.y += 1;
                    if(this.position.y >= 10) {
                        this.position.y -= 10;
                    }
                } else if (this.position.direction == 'W') {

                    this.position.x += 1;
                    if(this.position.x >= 10) {
                        this.position.x -= 10;
                    }

                } else if (this.position.direction == 'E') {

                    this.position.x -= 1;
                    if(this.position.x < 0) {
                        this.position.x += 10;
                    }

                } else if (this.position.direction == 'S') {
                    this.position.y -= 1;
                    if(this.position.y < 0) {
                        this.position.y += 10;
                    }
                }

            } else if(command == "r") {
                if (this.position.direction == 'N') {
                    this.position.direction = 'E';
                } else if (this.position.direction == 'W') {
                    this.position.direction = 'N';
                } else if (this.position.direction == 'E') {
                    this.position.direction = 'S';
                } else if (this.position.direction == 'S') {
                    this.position.direction = 'W';
                }
            }  else if(command == "l") {
                if (this.position.direction == 'N') {
                    this.position.direction = 'W';
                } else if (this.position.direction == 'W') {
                    this.position.direction = 'S';
                } else if (this.position.direction == 'E') {
                    this.position.direction = 'N';
                } else if (this.position.direction == 'S') {
                    this.position.direction = 'E';
                }
            }

            this.console.print(this.display());
        }
    }
}
