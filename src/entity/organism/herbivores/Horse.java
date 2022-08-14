package entity.organism.herbivores;

import abstractions.Animal;
import abstractions.Herbivore;
import controller.Cell;
import controller.CellInitializer;
import controller.Coordinate;
import property.organismproperty.herbivoreproperty.HorseProperties;
import property.util.BornOrganism;
import property.util.EatableAnimal;
import property.util.MovableAnimal;

import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Herbivore implements MovableAnimal, EatableAnimal, BornOrganism {

    public Horse(double weight) {
        super(weight);
    }

    private CellInitializer cellInitializer = new CellInitializer();

    @Override
    public <T extends Animal> void move(Coordinate coordinate, T t) {
        Coordinate newCoordinates = defineNewDirection(coordinate, HorseProperties.STEP);
        if (horseCountIsNotFull(newCoordinates)) {
            cellInitializer.moveAnimalToNewCoordinate(newCoordinates, coordinate, t);
        }
    }

    @Override
    public <T extends Animal> void eat(Coordinate coordinate, T t) {
        Cell currentCell = cellInitializer.island.getCells(coordinate);
        if (currentCell.getPlantList() != null) {
            while (!(currentCell.getPlantList().isEmpty()) && t.getWeight() <= HorseProperties.MAX_WEIGHT_HORSE) {
                eatPlant(t);
                currentCell.getPlantList().remove(0);
            }
        } else {
            dietAnimal(t);
        }
    }

    @Override
    public void bornOrganism(Coordinate coordinate) {
        if (ThreadLocalRandom.current().nextBoolean() && horseCountIsNotFull(coordinate)) {
            Animal newBreadedAnimal = new Horse(HorseProperties.MIN_WEIGHT_HORSE);
            cellInitializer.initializeBreadedAnimalToCell(coordinate, newBreadedAnimal);
        }
    }

    private <T extends Animal> void dietAnimal(T t) {
        if (weightLoss(t) <= 0){
            t = null;
        }
    }

    private boolean horseCountIsNotFull(Coordinate coordinateForCount) {
        int horseCount = 0;

        for (Herbivore horsesInHerbivore : cellInitializer.island.getCells(coordinateForCount).getHerbivoreList()) {
            if (horsesInHerbivore instanceof Horse) {
                horseCount++;
            }
        }

        return horseCount < HorseProperties.MAX_COUNT_HORSE;
    }

}
