package CelestialSiege.buttons;

import CelestialSiege.CelestialSiege;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class ExitButton extends Button {
    private CelestialSiege celestialSiege;

    public ExitButton(Coordinate2D initialLocation, CelestialSiege celestialSiege) {
        super(initialLocation, "Spel Verlaten");
        this.celestialSiege = celestialSiege;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        celestialSiege.quit();
    }
}
