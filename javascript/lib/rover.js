MOVE_TIME = process.env.NODE_ENV === 'test' ? 0 : 1000;

function positiveModulo10(number) {
  return ((number % 10) + 10) % 10;
}

function moving() {
  return new Promise((resolve) => {
    setTimeout(resolve, MOVE_TIME);
  });
}

class Rover {

  constructor(initialPosition, dependencies) {
    this.position = initialPosition;
    this.console = dependencies.console;

    this.console.log('Initial Position');
    this.displayPosition();
  }

  async run(commands) {

    for (let index = 0; index < commands.length; index++) {
      const command = commands[index];
      await this.execute(command);
    }
    return Promise.resolve()
  }

  async execute(command) {
    this.console.log('Move: ' + command);

    switch (command) {
      case 'f':
        this.moveForward();
        break;
      case 'b':
        this.moveBackward();
        break;
      case 'r':
        this.turnRight();
        break;
      case 'l':
        this.turnLeft();
        break;
    }

    this.displayPosition();

    await moving();
  }

  moveForward() {
    switch (this.position.d) {
      case 'N':
        this.position.y = positiveModulo10(this.position.y - 1);
        break;
      case 'E':
        this.position.x = positiveModulo10(this.position.x + 1);
        break;
      case 'S':
        this.position.y = positiveModulo10(this.position.y + 1);
        break;
      case 'W':
        this.position.x = positiveModulo10(this.position.x - 1);
        break;
    }
  }

  moveBackward() {
    switch (this.position.d) {
      case 'N':
        this.position.y = positiveModulo10(this.position.y + 1);
        break;
      case 'E':
        this.position.x = positiveModulo10(this.position.x - 1);
        break;
      case 'S':
        this.position.y = positiveModulo10(this.position.y - 1);
        break;
      case 'W':
        this.position.x = positiveModulo10(this.position.x + 1);
        break;
    }
  }

  turnRight() {
    switch (this.position.d) {
      case 'N':
        this.position.d = 'E';
        break;
      case 'E':
        this.position.d = 'S';
        break;
      case 'S':
        this.position.d = 'W';
        break;
      case 'W':
        this.position.d = 'N';
        break;
    }
  }

  turnLeft() {
    switch (this.position.d) {
      case 'N':
        this.position.d = 'W';
        break;
      case 'E':
        this.position.d = 'N';
        break;
      case 'S':
        this.position.d = 'E';
        break;
      case 'W':
        this.position.d = 'S';
        break;
    }
  }

  displayPosition() {

    let roverChar = ' ';
    switch (this.position.d) {
      case 'N':
        roverChar = '^';
        break;
      case 'E':
        roverChar = '>';
        break;
      case 'S':
        roverChar = 'v';
        break;
      case 'W':
        roverChar = '<';
        break;
    }

    const mapTemplate = '' +
      '   0 1 2 3 4 5 6 7 8 9\n' +
      ' +---------------------+\n' +
      '0|                     |\n' +
      '1|                     |\n' +
      '2|                     |\n' +
      '3|                     |\n' +
      '4|                     |\n' +
      '5|                     |\n' +
      '6|                     |\n' +
      '7|                     |\n' +
      '8|                     |\n' +
      '9|                     |\n' +
      ' +---------------------+\n';

    const mapBuilderArray = mapTemplate.split('');
    const index = (this.position.x + 1) * 2 +
      25 * (this.position.y + 2) - 1;
    mapBuilderArray[index] = roverChar;
    const map = mapBuilderArray.join('');

    this.console.log(map);
  }
}

module.exports = Rover;
