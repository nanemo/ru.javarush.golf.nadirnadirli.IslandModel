package entity.organism.herbivores;

import abstractions.Animal;
import abstractions.Herbivore;
import controller.Cell;
import controller.CellInitializer;
import controller.Coordinate;
import property.organismproperty.herbivoreproperty.CaterpillarProperties;
import property.util.BornOrganism;
import property.util.EatableAnimal;

import java.util.concurrent.ThreadLocalRandom;

public class Caterpillar extends Herbivore implements EatableAnimal, BornOrganism {

    private CellInitializer cellInitializer = new CellInitializer();

    public Caterpillar(double weight) {
        super(weight);
    }

    @Override
    public <T extends Animal> void move(Coordinate coordinate, T t) {
    }

    @Override
    public void eat(Coordinate coordinate) {
        Cell currentCell = cellInitializer.island.getCells(coordinate);

        if (currentCell.getPlantList() != null) {
            while (!(currentCell.getPlantList().isEmpty())) {
                currentCell.getPlantList().remove(0);
            }
        } else {
            dietAnimal(coordinate, this);
        }
    }

    @Override
    public void bornOrganism(Coordinate coordinate) {
        if (ThreadLocalRandom.current().nextBoolean() && caterpillarCountIsNotFull(coordinate)) {
            Animal newBreadedAnimal = new Caterpillar(CaterpillarProperties.MIN_WEIGHT_CATERPILLAR);
            cellInitializer.initializeBreadedAnimalToCell(coordinate, newBreadedAnimal);
        }
    }

    private boolean caterpillarCountIsNotFull(Coordinate coordinateForCount) {
        int caterpillarCount = 0;

        for (Herbivore caterpillarInHerbivore : cellInitializer.island.getCells(coordinateForCount).getHerbivoreList())
        {
            if (caterpillarInHerbivore instanceof Caterpillar) {
                caterpillarCount++;
            }
        }

        return caterpillarCount < CaterpillarProperties.MAX_COUNT_CATERPILLAR;
    }

}
