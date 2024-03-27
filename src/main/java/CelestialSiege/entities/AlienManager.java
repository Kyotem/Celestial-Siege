package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;

// TODO
//  Adjust alienSpeed & MOVEMENT_STEP based on in-game balance
//  Change speed based on how many aliens are left


public class AlienManager extends DynamicCompositeEntity implements SceneBorderTouchingWatcher {

    private ArrayList<Alien> aliens;
    private int alienSpeed = 2;
    Direction currentDirection = Direction.RIGHT;

    private final int TOTAL_COLUMNS = 11;
    private final int STEP_SIZE = 50;
    private final int MOVEMENT_STEP = 5;


    public AlienManager(Coordinate2D initialLocation) {
        super(initialLocation);
        aliens = new ArrayList<>();
    }

    @Override
    protected void setupEntities() {

        setupStrongAliens();
        setupStandardAliens();
        setupWeakAliens();
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

    private void setCurrentDirection(Direction newDirection) {
        currentDirection = newDirection;
    }

    private void moveAliensDown() {
        // Calc new Y Coord based on StepSize.
        double newY = getAnchorLocation().getY() + MOVEMENT_STEP;
        // Make new anchor location based on the current X pos and new Y pos
        Coordinate2D newAnchorLocation = new Coordinate2D(getAnchorLocation().getX(), newY);
        // Apply new pos to current AnchorLocation
        setAnchorLocation(newAnchorLocation);
    }
    // Moves all Aliens of the CompositeEntity (AlienManager) down by MOVEMENT_STEP

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        changeDirection();
        moveAliensDown();
    }




    // All types of aliens are initialised below this section

    private void setupStrongAliens() {
        int START_Y_STRONG = 0;
        for (int column = 0; column < TOTAL_COLUMNS; column++) {
            Alien alien = new Alien(
                    "sprites/aliens/Alien1.png",
                    new Coordinate2D((column * STEP_SIZE), START_Y_STRONG),
                    3,
                    this
            );
            addAlien(alien);
        }
    }
    // Used to set up all enemies with an HP value of 3

    private void setupStandardAliens() {
        int START_Y_STANDARD = 50;
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                int x = column * STEP_SIZE; // Calculate the x coordinate
                int y = START_Y_STANDARD + row * STEP_SIZE; // Calculate the y coordinate
                Alien alien = new Alien(
                        "sprites/aliens/Alien2.png",
                        new Coordinate2D(x, y),
                        2,
                        this
                );
                addAlien(alien);
            }
        }
    }
    // Used to set up all enemies with an HP value of 2

    private void setupWeakAliens() {
        int START_Y_WEAK = 150;
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                int x = column * STEP_SIZE; // Calculate the x coordinate
                int y = START_Y_WEAK + row * STEP_SIZE; // Calculate the y coordinate
                Alien alien = new Alien(
                        "sprites/aliens/Alien3.png",
                        new Coordinate2D(x, y),
                        1,
                        this
                );
                addAlien(alien);
            }
        }
    }
    // Used to set up all enemies with an HP value of 1

    // Add the aliens to the scene
    private void addAlien(Alien alien) {
        aliens.add(alien);
        addEntity(alien);
    }

    public void removeAlien(Alien alien) {
        aliens.remove(alien); // Remove the alien from the list
    }



}

