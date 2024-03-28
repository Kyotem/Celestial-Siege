package CelestialSiege.buttons;

import CelestialSiege.scenes.GameScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;


public class PauseButton extends Button implements MouseButtonPressedListener {
    private GameScene gameScene; // Reference to the containing scene

    public PauseButton(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation, "Pause");
        this.gameScene = gameScene;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gameScene.pauseResumeGWU();
    }


    private void pauseResumeGWU() {
        if (gameScene.isActiveGWU()) {
            gameScene.pause();
        } else {
            gameScene.resume();
        }
    }
}
