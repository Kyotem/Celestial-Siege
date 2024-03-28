package CelestialSiege.UI;

import CelestialSiege.CelestialSiege;
import CelestialSiege.scenes.TitleScene;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class UIStartMenu extends UIComponent {

    StaticScene titleScene;

    public UIStartMenu(Coordinate2D initialLocation, TitleScene titleScene) {
        super(initialLocation);
        this.titleScene = titleScene;
        setupEntities();
    }

    @Override
    protected void setupEntities() {
        createTextEntities();
    }

    // Method used to initialise all Text entities
    private void createTextEntities() {
        CustomTextEntity titleText = new CustomTextEntity(
                new Coordinate2D(titleScene.getWidth() / 2, titleScene.getHeight() * 0.20), //FIXME calc
                "Celestial Siege",
                AnchorPoint.CENTER_CENTER,"Roboto", FontWeight.SEMI_BOLD, 80, Color.WHITE
        );
        addEntity(titleText); // TODO create a better way to add all these entities
    }


}
