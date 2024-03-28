package CelestialSiege.buttons;

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

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private final Color PRIMARY_COLOR = Color.YELLOW;
    private final Color SECONDARY_COLOR = Color.VIOLET;
    private final int BUTTON_SIZE = 45;

    public Button(Coordinate2D initialLocation, String label) {
        super(initialLocation, label);
        setFill(PRIMARY_COLOR);
        setFont(Font.font("Roboto", FontWeight.BOLD, BUTTON_SIZE));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
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
