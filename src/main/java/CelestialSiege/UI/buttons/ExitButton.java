package CelestialSiege.UI.buttons;

import CelestialSiege.CelestialSiege;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class ExitButton extends Button {
    private final CelestialSiege CELESTIALSIEGE;

    public ExitButton(Coordinate2D initialLocation, CelestialSiege celestialSiege) {
        super(initialLocation, "Exit Game");
        this.CELESTIALSIEGE = celestialSiege;
    }

    // Method called when button is pressed -> Closes game
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        CELESTIALSIEGE.quit();
    }
}
