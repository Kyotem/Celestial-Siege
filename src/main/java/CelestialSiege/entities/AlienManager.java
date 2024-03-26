package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlienManager extends DynamicCompositeEntity implements SceneBorderTouchingWatcher {

    private final int TOTAL_COLUMNS = 11;
    private final int STEP_SIZE = 50;

    private int alienSpeed = 2;
    Direction currentDirection = Direction.RIGHT;

    private List<Alien> aliens;


    public AlienManager(Coordinate2D initialLocation) {
        super(initialLocation);
        aliens = new ArrayList<>();

    }

    @Override
    protected void setupEntities() {

        setupStrongAliens();
        setupStandardAliens();
        setupWeakAliens();
        setMotion(2, currentDirection);

    }

    private void setupStrongAliens() {
        int START_Y_STRONG = 50;
        for (int column = 0; column < TOTAL_COLUMNS; column++) {
            Alien alien = new Alien(
                    "sprites/aliens/Alien1_Placeholder.png",
                    new Coordinate2D((column * STEP_SIZE), START_Y_STRONG),
                    3,
                    this
            );
            addAlien(alien);
        }
    }
    // Used to set up all enemies with an HP value of 3


    private void setupStandardAliens() {
        int START_Y_STANDARD = 100;
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                int x = column * STEP_SIZE; // Calculate the x coordinate
                int y = START_Y_STANDARD + row * STEP_SIZE; // Calculate the y coordinate
                Alien alien = new Alien(
                        "sprites/aliens/Alien2_Placeholder.png",
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
        int START_Y_WEAK = 200;
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                int x = column * STEP_SIZE; // Calculate the x coordinate
                int y = START_Y_WEAK + row * STEP_SIZE; // Calculate the y coordinate
                Alien alien = new Alien(
                        "sprites/aliens/Alien3_Placeholder.png",
                        new Coordinate2D(x, y),
                        1,
                        this
                );
                addAlien(alien);
            }
        }
    }
    // Used to set up all enemies with an HP value of 1


    private void addAlien(Alien alien) {
        aliens.add(alien);
        addEntity(alien);
    }

    public void adjustAlienSpeed(int speed) {
        for(Alien  a : aliens) {
            a.setAlienSpeed(speed);
            a.moveAlien(currentDirection);
        }
    }


    public void handleAlienCollision(Alien alien) {
        System.out.println("Alien hit the wall");
        changeDirection();

    }


    private void changeDirection() {
        if (currentDirection == Direction.LEFT) {
            setCurrentDirection(Direction.RIGHT);
        } else if (currentDirection == Direction.RIGHT) {
            setCurrentDirection(Direction.LEFT);
        }
        setMotion(alienSpeed, currentDirection);
    }

    void setCurrentDirection(Direction newDirection) {
        currentDirection = newDirection;
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

    }
}
