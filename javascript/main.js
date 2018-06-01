#!/usr/bin/env node
process.env.NODE_ENV === 'production';
const Rover = require('./lib/rover');

const argv = require('yargs')
  .group(['positionX', 'positionY', 'direction'], 'Rover initialization:')
  .group(['commands'], 'Rover commands:')
  .option('positionX', {
    alias: 'x',
    describe: 'initial X landing rover position',
  })
  .option('positionY', {
    alias: 'y',
    describe: 'initial Y landing rover position',
  })
  .option('direction', {
    alias: 'd',
    describe: 'initial landing rover direction',
  })
  .option('commands', {
    alias: 'c',
    describe: 'provide an array of commands for the rover to execute',
    type: 'array',
  })
  .demandOption(['x', 'y', 'direction'], 'Please provide the initial rover' +
    ' position and direction for the rover to start')
  .help()
  .wrap(72)
  .argv;

const initialPosition = { x: argv.x, y: argv.y, d: argv.d };
const dependencies = { console };

console.log('~~~~~ ROVER INITIALIZATION ~~~~~\n');

const rover = new Rover(initialPosition, dependencies);

rover.run(argv.c)
  .then(() => {
    console.log('\n~~~~~ ROVER TERMINATED ~~~~~\n');
  });

