## Benjamin Lukens ReadMe File 9/21/25

Levels Completed: 3

# Running the files
To compile this application: 
javac --module-path /usr/share/openjfx/lib --add-modules=javafx.controls Main.java

To run this application (hopefully):
java-clean --module-path /usr/share/openjfx/lib --add-modules=javafx.controls Main

# Using the application
Clicking the buttons at the bottom of the screen will add shapes.
Each shape will change depending on what button is pressed. 
Clicking the "Colors" combo box will open a menu of colors to choose from, changing the shape color
when the next one is created. 

Pressing the 'c' key removes the last created shape.

Shape count is tracked by adding and subtracting. There is a label at the bottom right
of the application that shows the amount of shapes that are on the pane. 

Shapes can be dragged with the mouse, and shift clicking moves the shape to the forefront 
of the pane. 
