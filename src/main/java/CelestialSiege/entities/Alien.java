package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

//TODO:
//  Implement moveDown
//  Implement new Sprite
//  Implement different Aliens (Make use of multiple constructors?)
//  Create spawner for respective aliens


public class Alien extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {


    private Direction currentDirection;
    private int alienSpeed = 5;

    public Alien(Coordinate2D initialLocation) {
        super("sprites/Alien_Placeholder.png", initialLocation, new Size(40, 40));
        currentDirection = Direction.LEFT;

        setMotion(alienSpeed, currentDirection);
    }

    private void changeDirection() {
        if (currentDirection == Direction.LEFT) {
            setCurrentDirection(Direction.RIGHT);
        } else if (currentDirection == Direction.RIGHT) {
            setCurrentDirection(Direction.LEFT);
        }
        setMotion(alienSpeed, currentDirection);
    }

    // Inverts the direction





    protected void moveDown() {
// Implement on a later date
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        changeDirection();
    // Reverse direction of alien

    }

    private void setCurrentDirection(Direction newDirection) {
        currentDirection = newDirection;
    }

}
