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

    private AlienManager alienManager;
  
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

    // Removes the entity (Alien) from the AlienManager's list & the currently active scene
    private void destroyAndGrantScore() {

        alienManager.removeAlien(this);
        remove();
        scoreboard.addPoints(scorePoints);


        // FIXME Scoreboard interaction is broken
    }

    private void decreaseHP() {
        alienHP--;
    }
    private boolean shouldDestroy() {
        return alienHP <= 0;
    }

    // Called when player collides with a bullet
    @Override
    public void onCollision(List<Collider> list) {
        decreaseHP();
        if (shouldDestroy()) {
            destroyAndGrantScore();
        }
        // Decreases HP, then checks if it's under 0 to see if it should be deleted, then the function grants the score.
    }
}
