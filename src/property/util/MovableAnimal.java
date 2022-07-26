package property.util;

import abstractions.Animal;
import controller.Coordinate;
import property.direction.DoubleStepAnimal;
import property.direction.QuadrupleStepAnimal;
import property.direction.SingleStepAnimal;
import property.direction.TripleStepAnimal;

import java.util.concurrent.ThreadLocalRandom;

import static abstractions.Animal.*;
/** This interface has default methods which define new direction for animals. Its methods get coordinate and step params*/
public interface MovableAnimal {
    SingleStepAnimal singleStepAnimal = new SingleStepAnimal();
    DoubleStepAnimal doubleStepAnimal = new DoubleStepAnimal();
    TripleStepAnimal tripleStepAnimal = new TripleStepAnimal();
    QuadrupleStepAnimal quadrupleStepAnimal = new QuadrupleStepAnimal();

    <T extends Animal> void move(Coordinate coordinate, T t);

    default Coordinate defineNewDirection(Coordinate coordinate, int step) {
        Coordinate newCoordinate = new Coordinate();
        int randomNumForDirection = ThreadLocalRandom.current().nextInt(1, 5);

        if (randomNumForDirection == STRAIGHT) {
            newCoordinate = toStraightDirection(coordinate, step);
        } else if (randomNumForDirection == BACK) {
            newCoordinate = toBackDirection(coordinate, step);
        } else if (randomNumForDirection == TO_RIGHT) {
            newCoordinate = toRightDirection(coordinate, step);
        } else if (randomNumForDirection == TO_LEFT){
            newCoordinate = toLeftDirection(coordinate, step);
        }
        return newCoordinate;
    }

    private Coordinate toRightDirection(Coordinate coordinate, int step) {
        Coordinate newCoordinate = new Coordinate();
        if (step == 1) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(singleStepAnimal.
                    defineNewCoordinateRightDirectionForSingleStep(coordinate.getCoordinateY(), step));
        } else if (step == 2) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(doubleStepAnimal.
                    defineNewCoordinateRightDirectionForDoubleStep(coordinate.getCoordinateY(), step));
        } else if (step == 3) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(tripleStepAnimal.
                    defineNewCoordinateRightDirectionForTripleStep(coordinate.getCoordinateY(), step));
        } else if (step == 4) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(quadrupleStepAnimal.
                    defineNewCoordinateRightDirectionForQuadrupleStep(coordinate.getCoordinateY(), step));
        }
        return newCoordinate;
    }

    private Coordinate toLeftDirection(Coordinate coordinate, int step) {
        Coordinate newCoordinate = new Coordinate();
        if (step == 1) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(singleStepAnimal.
                    defineNewCoordinateLeftDirectionForSingleStep(coordinate.getCoordinateY(), step));
        } else if (step == 2) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(doubleStepAnimal.
                    defineNewCoordinateLeftDirectionForDoubleStep(coordinate.getCoordinateY(), step));
        } else if (step == 3) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(tripleStepAnimal.
                    defineNewCoordinateLeftDirectionForTripleStep(coordinate.getCoordinateY(), step));
        } else if (step == 4) {
            newCoordinate.setCoordinateX(coordinate.getCoordinateX());
            newCoordinate.setCoordinateY(quadrupleStepAnimal.
                    defineNewCoordinateLeftDirectionForQuadrupleStep(coordinate.getCoordinateY(), step));
        }
        return newCoordinate;
    }

    private Coordinate toBackDirection(Coordinate coordinate, int step) {
        Coordinate newCoordinate = new Coordinate();
        if (step == 1) {
            newCoordinate.setCoordinateX(singleStepAnimal.
                    defineNewCoordinateBackDirectionForSingleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        } else if (step == 2) {
            newCoordinate.setCoordinateX(doubleStepAnimal.
                    defineNewCoordinateBackDirectionForDoubleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        } else if (step == 3) {
            newCoordinate.setCoordinateX(tripleStepAnimal.
                    defineNewCoordinateBackDirectionForTripleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        } else if (step == 4) {
            newCoordinate.setCoordinateX(quadrupleStepAnimal.
                    defineNewCoordinateBackDirectionForQuadrupleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        }
        return newCoordinate;
    }

    private Coordinate toStraightDirection(Coordinate coordinate, int step) {
        Coordinate newCoordinate = new Coordinate();
        if (step == 1) {
            newCoordinate.setCoordinateX(singleStepAnimal.
                    defineNewCoordinateStraightDirectionForSingleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        } else if (step == 2) {
            newCoordinate.setCoordinateX(doubleStepAnimal.
                    defineNewCoordinateStraightDirectionForDoubleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        } else if (step == 3) {
            newCoordinate.setCoordinateX(tripleStepAnimal.
                    defineNewCoordinateStraightDirectionForTripleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        } else if (step == 4) {
            newCoordinate.setCoordinateX(quadrupleStepAnimal.
                    defineNewCoordinateStraightDirectionForQuadrupleStep(coordinate.getCoordinateX(), step));
            newCoordinate.setCoordinateY(coordinate.getCoordinateY());
        }
        return newCoordinate;
    }

}
