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
    // Will change based on speed of main Alienclass

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
        moveDown(2);
    }

    // Inverts the direction





    private void moveDown(double stepSize) {
        // Calc new Y Coord based on StepSize.
        double newY = getAnchorLocation().getY() + stepSize;
        // Make new anchor location based on the current X pos and new Y pos
        Coordinate2D newAnchorLocation = new Coordinate2D(getAnchorLocation().getX(), newY);
        // Apply new pos to current AnchorLocation
        setAnchorLocation(newAnchorLocation);
    }
    // Implementation is a bit complex, improve if possible.


    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        changeDirection();
    // Reverse direction of alien

    }

    private void setCurrentDirection(Direction newDirection) {
        currentDirection = newDirection;
    }

}
