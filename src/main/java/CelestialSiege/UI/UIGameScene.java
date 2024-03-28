package CelestialSiege.UI;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class UIGameScene extends UIComponent {

    public UIGameScene(Coordinate2D initialLocation) {
        super(initialLocation);
        setupEntities();
    }

    protected void setupEntities() {
        createTextEntities();
        createButtonEntities();
    }

    // TODO Fix hardcoded position values, create common constants
    private void createTextEntities() {
        CustomTextEntity healthText = new CustomTextEntity(new Coordinate2D(20, 610),
                "Health: 3", AnchorPoint.TOP_LEFT, "Roboto", FontWeight.BOLD, 30, Color.YELLOW
        );
        CustomTextEntity scoreText = new CustomTextEntity(new Coordinate2D(20, 650),
                "Score: 0", AnchorPoint.TOP_LEFT, "Roboto", FontWeight.BOLD, 30, Color.YELLOW
        );
        addEntity(healthText);
        addEntity(scoreText);

    }

    private void createButtonEntities() {

    }

    public void updateText() {

    }

}
