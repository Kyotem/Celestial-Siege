package CelestialSiege.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;

// TODO
//  Adjust alienSpeed & MOVEMENT_STEP based on in-game balance
//  Change speed based on how many aliens are left
//  Add respawn mechanism

public class AlienManager extends DynamicCompositeEntity implements SceneBorderTouchingWatcher {

    private ArrayList<Alien> aliens;
    private Direction currentDirection = Direction.RIGHT;

    private int alienSpeed = 2;
    private final int TOTAL_COLUMNS = 10;
    private final int STEP_SIZE = 50;
    private final int MOVEMENT_STEP = 5;


    public AlienManager(Coordinate2D initialLocation) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        aliens = new ArrayList<>();
    }

    @Override
    protected void setupEntities() {

        aliens.clear();
        setupAlien(0, 1, 3, "sprites/aliens/Alien1.png");
        setupAlien(50, 2, 2, "sprites/aliens/Alien2.png");
        setupAlien(150, 2, 1, "sprites/aliens/Alien3.png");
        setMotion(alienSpeed, currentDirection);

    }

    // Get X-pos of the CompositeEntity itself
    public double getXPosition() {
        return getAnchorLocation().getX();
    }

    // Get Y-pos of the CompositeEntity itself
    public double getYPosition() {
        return getAnchorLocation().getY();
    }


    // Inverts the direction left & right
    private void changeDirection() {
        if (currentDirection == Direction.LEFT) {
            setCurrentDirection(Direction.RIGHT);
        } else if (currentDirection == Direction.RIGHT) {
            setCurrentDirection(Direction.LEFT);
        }
        setMotion(alienSpeed, currentDirection);
    }

    private void setCurrentDirection(Direction newDirection) {
        currentDirection = newDirection;
    }

    // Moves all Aliens of the CompositeEntity (AlienManager) down by MOVEMENT_STEP
    private void moveAliensDown() {
        // Calc new Y Coord based on StepSize.
        double newY = getAnchorLocation().getY() + MOVEMENT_STEP;
        // Make new anchor location based on the current X pos and new Y pos
        Coordinate2D newAnchorLocation = new Coordinate2D(getAnchorLocation().getX(), newY);
        // Apply new pos to current AnchorLocation
        setAnchorLocation(newAnchorLocation);
    }

    // Called when the AlienManager hits a sceneBorder
    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        changeDirection();
        moveAliensDown();
    }

    // Sets up aliens in a grid based on given parameters
    private void setupAlien(int startY, int totalRows, int alienHP, String spritePath) {
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                int x = column * STEP_SIZE;
                int y = startY + row * STEP_SIZE;
                Coordinate2D position = new Coordinate2D(x, y);
                Alien alien = new Alien(spritePath, position, alienHP, this);
                addAlien(alien);
            }
        }
    }

    // Add the aliens to the scene
    private void addAlien(Alien alien) {
        aliens.add(alien);
        addEntity(alien);
    }

    // TODO remove feature if arrayList remains unused / removed
    // Remove the alien from the list
    public void removeAlien(Alien alien) {
        aliens.remove(alien);
        // removeEntity() is called in the Alien class itself, not the manager.
    }
}

