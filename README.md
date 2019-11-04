# MowItNow

Simulation of the movements of a mower on a field.

## Getting Started

``` 
git clone https://github.com/FaithFeather/MowItNow.git
```

## Compiling and running

``` 
mvn compile
```

``` 
mvn exec:java
```

## Functioning

* The files used for moving the mower should be under the following format, with :
    * the first line being the maximum coordinates of the field
    * the second line being the starting coordinates and the direction it faced
    * the third line being the actions that the mower need to follow : 
        * A to go in the direction the mower is facing
        * D to turn to the right
        * G to turn to the left
* The file can have more than one mower : repeat the second and third lines for each mower.
* The files need to be in the */src/main/java/resources* folder with a *.txt* extension.
```
5 5
1 2 N
GAGAGAGAA
```

* Once the program is launched, the resources folder will be scanned and the program will display the list of the files available. The user can choose a file between the ones available.

* [IntellijIdea] (https://www.jetbrains.com/idea/)

## Authors

* ** FaithFeather ** - *Initial work* - [FaithFeather](https://github.com/FaithFeather)

