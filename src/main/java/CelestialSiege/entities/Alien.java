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

    public Alien(String sprite, Coordinate2D initialLocation, int alienHP, int scorePoints, AlienManager alienManager) {
        super(sprite, initialLocation, new Size(40, 40));
        this.alienHP = alienHP;
        this.scorePoints = scorePoints;
        this.alienManager = alienManager;

    }




}
