package CelestialSiege.UI;

import CelestialSiege.CelestialSiege;
import CelestialSiege.UI.buttons.ExitButton;
import CelestialSiege.UI.buttons.MenuButton;
import CelestialSiege.scenes.EndScene;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class UIEndScene extends UIComponent {

    StaticScene endScene;
    CelestialSiege celestialSiege;


    public UIEndScene(Coordinate2D initialLocation, EndScene endScene, CelestialSiege celestialSiege) {
        super(initialLocation);
        this.endScene = endScene;
        this.celestialSiege = celestialSiege;
    }

    public void setupEntities() {
        createTextEntities();
        createButtonEntities();
    }

    private void createTextEntities() {

        CustomTextEntity gameOverText = new CustomTextEntity(new Coordinate2D(
                endScene.getWidth() / 2, endScene.getHeight() * 0.15),
                "GAME OVER", AnchorPoint.CENTER_CENTER, "Roboto", FontWeight.BOLD, 80, Color.WHITE
        );


        // Score can't be passed through yet, using UNK as placeholder.
        CustomTextEntity scoreText = new CustomTextEntity(new Coordinate2D(
                endScene.getWidth() / 2, endScene.getHeight() * 0.40),
                "Your Score: " + "UNK.", AnchorPoint.CENTER_CENTER, "Roboto", FontWeight.SEMI_BOLD, 60, Color.WHITE
        );

        addEntity(gameOverText);
        addEntity(scoreText);
    }

    private void createButtonEntities() {

        ExitButton exitButton = new ExitButton(
                new Coordinate2D(
                        endScene.getWidth() / 2, endScene.getHeight() * 0.85), celestialSiege);

        MenuButton menuButton = new MenuButton(
                new Coordinate2D(endScene.getWidth() / 2, endScene.getHeight() * 0.65), celestialSiege);

        addEntity(exitButton);
        addEntity(menuButton);
    }

}
