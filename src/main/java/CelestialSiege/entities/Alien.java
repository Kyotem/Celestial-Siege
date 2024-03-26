package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

// TODO
//  Implement score as separate variable

public class Alien extends DynamicSpriteEntity {

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
}
