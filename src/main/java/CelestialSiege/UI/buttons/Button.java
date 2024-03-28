package CelestialSiege.UI.buttons;

import CelestialSiege.UI.CustomTextEntity;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// TODO can Button be changed to use CustomTextEntity?

public abstract class Button extends CustomTextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private final Color PRIMARY_COLOR = Color.YELLOW;
    private final Color SECONDARY_COLOR = Color.VIOLET;
    private final int BUTTON_SIZE = 45;

    public Button(Coordinate2D initialLocation, String label) {
        super(initialLocation, label, AnchorPoint.CENTER_CENTER, "Roboto", FontWeight.BOLD, 45, Color.YELLOW);
        // Can't use the in super initialisation, kind of defeats the purpose... oh well, it works!
    }

    // Used to handle logic when button is clicked
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
    }

    // When mouse enters button, change color.
    @Override
    public void onMouseEntered() {
        setFill(SECONDARY_COLOR);
        setCursor(Cursor.HAND);
    }

    // When mouse exists button, reset color to default.
    @Override
    public void onMouseExited() {
        setFill(PRIMARY_COLOR);
        setCursor(Cursor.DEFAULT);
    }
}
