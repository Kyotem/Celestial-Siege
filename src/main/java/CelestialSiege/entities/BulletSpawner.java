package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

/*
    CompositeEntity (AlienManager) does not update it's dimensions vertically.
    If bottom row of aliens is destroyed, the Y-Pos that bullets are spawned remain the same as in the start.
    Not aware of a direct fix ATM
 */

public class BulletSpawner extends EntitySpawner {

    private final Spaceship SPACESHIP;
    private final AlienManager ALIENMANAGER;
    private final Random RANDOM;
    private int alienBulletSpawnCounter = 1; // Used to determine @ which interval the aliens should be able to shoot a bullet

    private final int SPACESHIP_OFFSET = 60;
    private final int ALIEN_OFFSET = 30;
    private final int ALIEN_INTERVAL = 2;
    private double alienShootChance = 0.5;

    public BulletSpawner(long intervalInMs, Spaceship spaceship, AlienManager alienManager) {
        super(intervalInMs);
        this.SPACESHIP = spaceship;
        this.ALIENMANAGER = alienManager;
        this.RANDOM = new Random();
    }

    @Override
    protected void spawnEntities() {
        spawnBulletAboveSpaceship();
        spawnBulletFromAlienIfNeeded();
    }

    // Spawns a bullet above the spaceship towards the aliens
    private void spawnBulletAboveSpaceship() {
        Bullet bullet = new Bullet(
                new Coordinate2D(
                        SPACESHIP.getAnchorLocation().getX(),
                        SPACESHIP.getAnchorLocation().getY() - SPACESHIP_OFFSET),
                2,
                180
        );
        spawn(bullet);
    }

    // Spawns a bullet under the CompositeEntity AlienManager
    private void spawnBulletFromAlienIfNeeded() {
        if (alienBulletSpawnCounter == ALIEN_INTERVAL) {
            double rolledNum = RANDOM.nextDouble();
            if (rolledNum < alienShootChance) {
                double randomPos = ALIENMANAGER.getXPosition() + RANDOM.nextDouble() * (700 - ALIENMANAGER.getXPosition());
                Bullet bullet = new Bullet(
                        new Coordinate2D(
                                randomPos,
                                // Random x-coordinate between alienManager.getXPosition() and 700 (Sceneborder)
                                ALIENMANAGER.getYPosition() + ALIEN_OFFSET),
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
