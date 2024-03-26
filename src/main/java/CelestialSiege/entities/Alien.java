package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import java.util.List;

// TODO
//  Implement score as separate variable

public class Alien extends DynamicSpriteEntity implements Collided {

    AlienManager alienManager;
    // Use on later date for handling arraylist access
    private int alienHP;
    private int scorePoints;

    // Will change based on speed of main Alienclass

    public Alien(String sprite, Coordinate2D initialLocation, int alienHP, AlienManager alienManager) {
        super(sprite, initialLocation, new Size(40, 40));
        this.alienHP = alienHP;
        scorePoints = alienHP * 100;
        this.alienManager = alienManager;
    }


    // TODO Remove toString debug func
    @Override
    public String toString() {
        return "Alien{" +
                "alienManager=" + alienManager +
                ", alienHP=" + alienHP +
                ", scorePoints=" + scorePoints +
                '}';
    }

    private void decreaseHP() {
        alienHP--;
    }

    private void destroyAndGrantScore() {

        alienManager.removeAlien(this);

        // add score to scoreboard

    }

    private boolean shouldDelete() {
        return alienHP <= 0;
    }

    @Override
    public void onCollision(List<Collider> list) {
        decreaseHP();
        if(shouldDelete()) {
            destroyAndGrantScore();
        }
        // Implement another func to check if it should be deleted
    }
}
