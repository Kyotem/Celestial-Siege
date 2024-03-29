package CelestialSiege.UI.buttons;

import CelestialSiege.CelestialSiege;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class StartButton extends Button {
    private final CelestialSiege celestialSiege;

    public StartButton(Coordinate2D initialLocation, CelestialSiege celestialSiege) {
        super(initialLocation, "Start game");

        this.celestialSiege = celestialSiege;
    }

    // Method called when button is pressed -> Sets active scene to the main gamescene
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        celestialSiege.setActiveScene(1);
    }
}
