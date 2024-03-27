package CelestialSiege.entities;

import CelestialSiege.entities.map.Shield;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import java.util.List;

public class Bullet extends DynamicSpriteEntity implements Collider, Collided {
    public Bullet(Coordinate2D initialLocation) {
        super("sprites/Bullet.png", initialLocation);
    }




    @Override
    public void onCollision(List<Collider> list) {

    }

}

