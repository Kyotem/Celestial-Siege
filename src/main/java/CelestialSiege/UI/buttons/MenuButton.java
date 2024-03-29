package CelestialSiege.UI.buttons;

import CelestialSiege.CelestialSiege;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class MenuButton extends Button {

    CelestialSiege celestialSiege;

    public MenuButton(Coordinate2D initialLocation, CelestialSiege celestialSiege) {
        super(initialLocation, "Return to Menu");
        this.celestialSiege = celestialSiege;
    }

    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        celestialSiege.setActiveScene(0);
    }

}
