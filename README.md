A squad of robotic rovers are to be landed by NASA on a plateau on Mars.<br> 
This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a 
complete view of the surrounding terrain to send back to Earth. <br>
A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of
the four cardinal compass points. <br>
The plateau is divided up into a grid to simplify navigation. <br>
An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North. <br>
In order to control a rover, NASA sends a simple string of letters. <br>
The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, 
without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading. <br>
Assume that the square directly North from (x, y) is (x, y+1). <br>
Input:<br>
• The first line of input is the upper-right coordinates of the plateau, the lowerleft coordinates are assumed to be 0,0. <br>
• The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of <br>
input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how 
to explore the plateau. <br>
• The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates 
and the rover’s orientation. <br>
• Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one 
has finished moving. <br>
Output:<br>
• The output for each rover should be its final co-ordinates and heading. <br>
Input and Output <br>
Test Input: 5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM <br>
Expected Output: 1 3 N 5 1 E<br>