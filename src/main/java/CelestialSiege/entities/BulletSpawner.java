package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class BulletSpawner extends EntitySpawner {


    // TODO Resolve height spawn issue (Base on compentity / aliens?)

    private final Spaceship spaceship;
    private final AlienManager alienManager;
    private final Random random;
    private int alienBulletSpawnCounter = 1;

    public BulletSpawner(long intervalInMs, Spaceship spaceship, AlienManager alienManager) {
        super(intervalInMs);
        this.spaceship = spaceship;
        this.alienManager = alienManager;
        this.random = new Random();

    }

    @Override
    protected void spawnEntities() {
        spawnBulletAboveSpaceship();
        spawnBulletFromAlienIfNeeded();
    }

    private void spawnBulletAboveSpaceship() {
        Bullet bullet = new Bullet(
                new Coordinate2D(
                        spaceship.getAnchorLocation().getX(),
                        spaceship.getAnchorLocation().getY() - 60),
                2,
                180
        );
        spawn(bullet);
    }

    private void spawnBulletFromAlienIfNeeded() { // Change method if possible
        if (alienBulletSpawnCounter == 2) {

            if (random.nextDouble() < 0.5) {
                double randomPos = alienManager.getXPosition() + random.nextDouble() * (700 - alienManager.getXPosition());
                Bullet bullet = new Bullet(
                        new Coordinate2D(
                                randomPos, // Random x-coordinate between alienManager.getXPosition() and 700
                                alienManager.getYPosition() + 30),
                        2,
                        0
                );
                spawn(bullet);
                alienBulletSpawnCounter = 1;
            }

        } else {
            alienBulletSpawnCounter++;
        }
    }
}
