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

    // TODO Resolve height spawn issue when spawning bullets under aliens (CompositEntity doesn't seem to rescale, see 1.1 @ spawnBulletFromAlienIfNeeded() )
    private final Spaceship spaceship;
    private final AlienManager alienManager;
    private final Random random;
    private int alienBulletSpawnCounter = 1; // Used to determine @ which interval the aliens should be able to shoot a bullet

    private final int SPACESHIP_OFFSET = 60;
    private final int ALIEN_OFFSET = 30;
    private final int ALIEN_INTERVAL = 2;
    private double alienShootChance = 0.5;

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

    // Spawns a bullet above the spaceship towards the aliens
    private void spawnBulletAboveSpaceship() {
        Bullet bullet = new Bullet(
                new Coordinate2D(
                        spaceship.getAnchorLocation().getX(),
                        spaceship.getAnchorLocation().getY() - SPACESHIP_OFFSET),
                2,
                180
        );
        spawn(bullet);
    }

    // Spawns a bullet under the CompositeEntity AlienManager
    private void spawnBulletFromAlienIfNeeded() {
        if (alienBulletSpawnCounter == ALIEN_INTERVAL) {
            double rolledNum = random.nextDouble();
            if (rolledNum < alienShootChance) {
                double randomPos = alienManager.getXPosition() + random.nextDouble() * (700 - alienManager.getXPosition());
                Bullet bullet = new Bullet(
                        new Coordinate2D(
                                randomPos, // TODO Fix this hack calculation
                                // Random x-coordinate between alienManager.getXPosition() and 700 (Sceneborder)
                                alienManager.getYPosition() + ALIEN_OFFSET),
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
