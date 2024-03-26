package CelestialSiege.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class AlienManager extends DynamicCompositeEntity implements SceneBorderTouchingWatcher {

    private final int TOTAL_COLUMNS = 11;
    private final int STEP_SIZE = 50;

    public AlienManager(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {

        setupStrongAliens();
        setupStandardAliens();
        setupWeakAliens();

    }

    private void setupStrongAliens() {
        int START_Y_STRONG = 50;
        for (int column = 0; column < TOTAL_COLUMNS; column++) {
            Alien alien = new Alien(
                    "sprites/aliens/Alien1_Placeholder.png",
                    new Coordinate2D((50 + column * STEP_SIZE), START_Y_STRONG));
            addEntity(alien);
        }
    }
    // Used to setup all enemies with an HP value of 3


    private void setupStandardAliens() {
        int START_Y_STANDARD = 100;
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                int x = 50 + column * STEP_SIZE; // Calculate the x coordinate
                int y = START_Y_STANDARD + row * STEP_SIZE; // Calculate the y coordinate
                Alien alien = new Alien(
                        "sprites/aliens/Alien2_Placeholder.png",
                        new Coordinate2D(x, y));
                addEntity(alien);
            }
        }
    }
    // Used to setup all enemies with an HP value of 2

    private void setupWeakAliens() {
        int START_Y_WEAK = 200;
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                int x = 50 + column * STEP_SIZE; // Calculate the x coordinate
                int y = START_Y_WEAK + row * STEP_SIZE; // Calculate the y coordinate
                Alien alien = new Alien(
                        "sprites/aliens/Alien3_Placeholder.png",
                        new Coordinate2D(x, y));
                addEntity(alien);
            }
        }
    }
    // Used to setup all enemies with an HP value of 1

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

    }
}
