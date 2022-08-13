package property.util;

import abstractions.Animal;

import java.util.concurrent.ThreadLocalRandom;

public interface DietAnimal { // Bunu isle

    default <T extends Animal> void weightLoss(T t) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            t.setWeight(t.getWeight() - 1);
        }
    }
}