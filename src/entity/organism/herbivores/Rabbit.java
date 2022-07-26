package entity.organism.herbivores;

import abstractions.Animal;
import abstractions.Herbivore;
import controller.Cell;
import controller.CellInitializer;
import controller.Coordinate;
import property.organismproperty.herbivoreproperty.RabbitProperties;
import property.util.BornOrganism;
import property.util.EatableAnimal;
import property.util.MovableAnimal;

import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivore implements MovableAnimal, EatableAnimal, BornOrganism {

    public Rabbit(double weight) {
        super(weight);
    }

    private CellInitializer cellInitializer = new CellInitializer();

    @Override
    public <T extends Animal> void move(Coordinate coordinate, T t) {
        Coordinate newCoordinates = defineNewDirection(coordinate, RabbitProperties.STEP);
        if (rabbitCountIsNotFull(newCoordinates)) {
            cellInitializer.moveAnimalToNewCoordinate(newCoordinates, coordinate, t);
        }
    }

    @Override
    public void eat(Coordinate coordinate) {
        Cell currentCell = cellInitializer.island.getCells(coordinate);
        if (currentCell.getPlantList() != null) {
            while (!(currentCell.getPlantList().isEmpty()) && this.getWeight() <= RabbitProperties.MAX_WEIGHT_RABBIT) {
                eatPlant(this);
                currentCell.getPlantList().remove(this);
            }
        } else {
            dietAnimal(coordinate, this);
        }
    }

    @Override
    public void bornOrganism(Coordinate coordinate) {
        if (ThreadLocalRandom.current().nextBoolean() && rabbitCountIsNotFull(coordinate)) {
            Animal newBreadedAnimal = new Rabbit(RabbitProperties.MIN_WEIGHT_RABBIT);
            cellInitializer.initializeBreadedAnimalToCell(coordinate, newBreadedAnimal);
        }
    }

    private boolean rabbitCountIsNotFull(Coordinate coordinateForCount) {
        int rabbitCount = 0;

        for (Herbivore rabbitsInHerbivore : cellInitializer.island.getCells(coordinateForCount).getHerbivoreList()) {
            if (rabbitsInHerbivore instanceof Rabbit) {
                rabbitCount++;
            }
        }
        return rabbitCount < RabbitProperties.MAX_COUNT_RABBIT;
    }

}
