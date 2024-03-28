package CelestialSiege.entities;

import CelestialSiege.entities.map.Shield;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Bullet extends DynamicSpriteEntity implements Collider, Collided, SceneBorderCrossingWatcher {

    private BulletContainer bulletContainer;

    public Bullet(Coordinate2D initialLocation, int speed, int direction) {
        super("sprites/Bullet.png", initialLocation, new Size(35,100));

        setMotion(speed, direction);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Alien) {
                // Remove the bullet when it collides with an alien
                remove();
                return; // Exit the loop after removing the bullet
            }
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
}

