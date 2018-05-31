# Mars Rover 

Your goal is to develop an api that moves a rover around the Mars planet.

The previous team work their best on the rover program before they went out 
on burnout leave. They were competent developers and the management is quite 
confident in their skills. But as the time is lacking before launch you have 
to compete the program.

## Already implemented features

The rover programs already work basically : 
 - you initialize the landing point (x, y) of the rover and it's direction
 (N, S, E, W) it is facing at start
 - you also give at start the commands the rover will exectute.
 - then the rover moves sequentially following your orders, returning back the 
 position at every steps.
 
### Acceptable commands

The rover receives a character array of commands.
Implement commands that move the rover forward/backward (f, b).
Implement commands that turn the rover left/right (l, r).

### Acceptable moves

The planet is a sphere of 10x10 'positions' and as such the map wraps over from 
one edge to one another. 

Example of the planet map representation:

```
   1 2 3 4 5 6 7 8 9 0
 +---------------------+
1|                     |
2|   ^                 |
3|                     |
4|                     |
5|                     |
6|                     |
7|                     |
8|                     |
9|                     |
0|                     |
 +---------------------+
```
The mars rover is in the example at the (x:2, y:2) position and facing North.

## Additional features to implement

- The mars planet in winter has to much carbonic snow on it's poles. The 
rover cannot cross everywhere, only on the westernmost and the easternmost 
positons (only crossable on the y axis on the 1st & 10th column).
- The rover should also be able to run on smaller celestial bodies such as 
asteroids. (map 5x5)
- If we are to believe the lastest data there are mountains on Mars, as such 
the 1x8, 2x4, 2x5, 4x2, 7x9, 8x10 positions are not accessible for the rover
. If the rover should detect the absence of obstacles on the position it 
tries to access at every step. If it detects an obstacle, it should warn 
Houston and stop.
- The motor division added the posibility to move forward faster. A new move
 is now available `ff` for fast-forward.
- The wheel division improved the rover mobility that can now execute a half 
turn (hl, lr)

The planning is tight, and might change at the lastest notice. Always refer 
to your P.O. on what the priority is and on the expected behaviour.

Best of luck.
