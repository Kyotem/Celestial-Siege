package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BulletContainer extends EntitySpawner {

    Spaceship spaceship;

    public BulletContainer(long intervalInMs, Spaceship spaceship) {
        super(intervalInMs);
        this.spaceship = spaceship;
        System.out.println("BulletContainer created");
    }


    @Override
    protected void spawnEntities() {

        Bullet bullet = new Bullet(new Coordinate2D(
                spaceship.getAnchorLocation().getX(),
                spaceship.getAnchorLocation().getY()),
                2
                , 180
        );

        spawn(bullet);
    }
}
