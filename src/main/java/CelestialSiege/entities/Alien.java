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
    // FIXME add scoreboard reference via constructor
  
    private int alienHP;
    private int scorePoints = 0;

    // Will change based on speed of main Alienclass

    public Alien(String sprite, Coordinate2D initialLocation, int alienHP, AlienManager alienManager) {
        super(sprite, initialLocation, new Size(40, 40));
        this.alienHP = alienHP;
        scorePoints = alienHP * 100;

        this.alienManager = alienManager;
    }

    private void decreaseHP() {
        alienHP--;
    }

    // Removes the entity (Alien) from the AlienManager's list & the currently active scene
    private void destroy() {
        alienManager.removeAlien(this);
        remove();
    }

    // Adds points from this instance to the scoreboard
    private void grantScore() {
        scoreboard.addPoints(scorePoints);
    }
    private boolean shouldDestroy() {
        return alienHP <= 0;
    }

    // Called when player collides with a bullet
    @Override
    public void onCollision(List<Collider> list) {
        decreaseHP();
        if (shouldDestroy()) {
            grantScore();
            destroy();
        }
        // Decreases HP, then checks if it's under 0 to see if it should be deleted, then the function grants the score.
    }
}
