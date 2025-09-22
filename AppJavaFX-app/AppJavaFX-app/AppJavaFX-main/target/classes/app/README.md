# AppJavaFX - Drawing App

## Overview
This is a small JavaFX drawing application that allows you to click to draw rectangles and circles on a canvas. It includes live shape stats and keyboard shortcuts.

Features:
- Click to draw rectangles and circles.
- Choose shape type via RadioButtons (Rectangle / Circle).
- Clear the canvas using the Clear button or keyboard shortcut.
- Live information panel: shape count and total area.
- Status label shows currently selected shape.
- Keyboard shortcuts:
  - `R` — select Rectangle
  - `O` — select Circle
  - `C` — clear canvas

## Project structure

AppJavaFX-main/
├─ pom.xml
└─ src/
└─ main/
└─ java/
└─ app/
├─ MainApp.java
├─ DrawingController.java
├─ DrawableShape.java
├─ RectangleShape.java
└─ CircleShape.java

## How to compile and run
Requirements:
- JDK 21
- Maven

From the project root run:
mvn clean javafx:run