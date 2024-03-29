package CelestialSiege.UI.buttons;

import CelestialSiege.scenes.GameScene;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/* Unsure how to fix at this point in time, but timer bug explained:
    When GWU's are paused, timers themselves are not paused.
    This results in features that make use of a timer can technically "bypass" their timer state during the pause screen.
    Example of how it works normally: Ship shoots laser... 1000ms pass ... Ship shoots another laser
    Example of the issue: Ship shoots laser... Game paused... 1000ms (or more) pass... Game unpaused... 2 lasers fired in proximity.
*/

public class PauseButton extends Button {
    private final GameScene GAMESCENE;

    private boolean isGamePaused = false;
    private final int BUTTON_SIZE = 50;

    public PauseButton(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation, "Test");
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, BUTTON_SIZE));
        setText("Pause");
        this.GAMESCENE = gameScene;
    }

    // Method called when button is pressed -> toggles pause state & buttontext
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        toggleGameState();
    }

    // Toggle the game state between paused and resumed
    private void toggleGameState() {
        if (!isGamePaused) {
            GAMESCENE.pause();
            isGamePaused = true;
        } else {
            GAMESCENE.resume();
            isGamePaused = false;
        }
    }
}
