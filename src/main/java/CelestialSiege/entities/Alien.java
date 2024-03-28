package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import java.util.List;

// TODO
//  Parse Score through to Scoreborad class
//  add loss condition (aliens pass certain y point)


public class Alien extends DynamicSpriteEntity implements Collided, Collider {

    AlienManager alienManager;
    // Use on later date for handling arraylist access
  
    private ScoreBoard scoreboard; // Add a scoreboard field (Refactor later)
  
    private int alienHP;
    private int scorePoints = 0;

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

    private void destroyAndGrantScore() {

        alienManager.removeAlien(this);
        remove();
        scoreboard.addPoints(scorePoints);
        // Removes the entity from the AlienManager's list & currentscene

        // TODO add func to send score to scoreboard
    }




    private void decreaseHP() {
        alienHP--;
    }

    private boolean shouldDelete() {
        return alienHP <= 0;
    }

    @Override
    public void onCollision(List<Collider> list) {
        decreaseHP();
        if (shouldDelete()) {
            destroyAndGrantScore();
        }
        // Decreases HP, then checks if it's under 0 to see if it should be deleted, then the function grants the score.
    }
}
