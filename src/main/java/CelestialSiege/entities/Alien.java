package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

//TODO:
//  Implement moveDown
//  Implement different Aliens (Make use of multiple constructors?)
//  Create spawner for respective aliens

;

public class Alien extends DynamicSpriteEntity  {

    AlienManager alienManager;
    // Use on later date for handling arraylist access
    private int alienHP;

    // Will change based on speed of main Alienclass

    public Alien(String sprite, Coordinate2D initialLocation, int alienHP, AlienManager alienManager) {
        super(sprite, initialLocation, new Size(40, 40));
        this.alienHP = alienHP;
        this.alienManager = alienManager;

    }

}
