# Temperature Heatmap Visualizer

An interactive Processing data visualization application written in Java that parses historical temperature data and renders it as a grid-based color heatmap.

## Features

* **Data Parsing:** Reads and processes temperature log data line-by-line from `temps.txt` using Java's `Scanner`.
* **Dynamic Color Scaling:** Automatically calculates the minimum and maximum recorded temperatures across the dataset to dynamically map heat values to corresponding colors.
* **Grid Layout Mapping:** Displays data across a 12-row grid representing the calendar months, organizing days into structured colored tiles.

## How to Run

1. Clone or download this repository.
2. Ensure `temps.txt` is present in the root directory.
3. Open the project in your Java IDE (IntelliJ IDEA, Eclipse, or VS Code).
4. Ensure the **Processing core library** (`core.jar`) is added to your project dependencies/classpath.
5. Run `Main.java`.

## Requirements

* Java JDK 8 or higher
* Processing 3/4 `core.jar` library
