package CelestialSiege.UI;

import CelestialSiege.CelestialSiege;
import CelestialSiege.UI.buttons.ExitButton;
import CelestialSiege.UI.buttons.StartButton;
import CelestialSiege.scenes.TitleScene;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class UITitleScene extends UIComponent {

    CelestialSiege celestialSiege;

    // Use positions from titleScene in-case it has different dimensions from maingame
    StaticScene titleScene;

    public UITitleScene(Coordinate2D initialLocation, TitleScene titleScene, CelestialSiege celestialSiege) {
        super(initialLocation);
        this.celestialSiege = celestialSiege;
        this.titleScene = titleScene;
        setupEntities();
    }

    @Override
    protected void setupEntities() {
        createTextEntities();
        createButtonEntities();
    }

    // Method used to initialise all Text entities
    @Override
    protected void createTextEntities() {
        CustomTextEntity titleText = new CustomTextEntity(
                new Coordinate2D(titleScene.getWidth() / 2, titleScene.getHeight() * 0.20),
                "Celestial Siege",
                AnchorPoint.CENTER_CENTER, "Roboto", FontWeight.SEMI_BOLD, 80, Color.WHITE
        );
        addEntity(titleText);
    }

    // Method used to initialise all Button entities
    @Override
    protected void createButtonEntities() {
        StartButton startButton = new StartButton(new Coordinate2D(
                titleScene.getWidth() / 2, titleScene.getHeight() * 0.5), celestialSiege);

        ExitButton exitButton = new ExitButton(
                new Coordinate2D(titleScene.getWidth() / 2, titleScene.getHeight() * 0.7), celestialSiege);

        addEntity(startButton);
        addEntity(exitButton);
    }

}
