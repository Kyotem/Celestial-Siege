package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class AlienShootingTimer extends EntitySpawner {

    private final AlienManager alienManager;
    private final Random random;

    public AlienShootingTimer(AlienManager alienManager, long intervalInMs) {
        super(intervalInMs);
        this.alienManager = alienManager;
        this.random = new Random();
    }


    @Override
    protected void spawnEntities() {
        // Randomly decide whether to shoot
        if (random.nextDouble() < 0.5) { // Adjust the probability as needed
            System.out.println("Alien Shot");
            double randomPos = alienManager.getXPosition() + random.nextDouble() * (700 - alienManager.getXPosition());
            Bullet bullet = new Bullet(
                    new Coordinate2D(
                            randomPos, // Change to random pos
                            alienManager.getYPosition() + 30),
                    2,
                    0
            );
            spawn(bullet);

        }
    }
}
