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

# Orientation of the App
Shape.java is the abstract class, and the individual shapes extend the shape class. 
The Main.java creates the Hbox and the canvas. Shapes cannot interact with the hbox. 
The hbox (tools) contains all of the buttons to create shapes, change colors, and 
contains a counter for the shapes. The canvas pane is shaped in a rectangle and always
has a white background, but that could be set symantically to any other color. 
Adding and removing shapes is also placed inside of App.java.
