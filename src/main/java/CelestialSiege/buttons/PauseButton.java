package CelestialSiege.buttons;

import CelestialSiege.scenes.GameScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PauseButton extends Button implements MouseButtonPressedListener {
    private GameScene gameScene;

    private boolean isGamePaused = false;

    public PauseButton(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation, "Pause");
        setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));
        this.gameScene = gameScene;
    }

    // Method called when button is pressed -> toggles pause state & buttontext
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        updateButtonText();
        toggleGameState();
    }

    // Toggle the game state between paused and resumed
    private void toggleGameState() {
        if (!isGamePaused) {
            gameScene.pause();
            isGamePaused = true;
        } else {
            gameScene.resume();
            isGamePaused = false;
        }
    }

    // Update the button text based on the current game state
    private void updateButtonText() {
        if (gameScene.isActiveGWU()) {
            setText("Resume");
        } else {
            setText("Pause");
        }
    }
}
