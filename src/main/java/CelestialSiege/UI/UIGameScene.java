package CelestialSiege.UI;

import CelestialSiege.UI.buttons.PauseButton;
import CelestialSiege.scenes.GameScene;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class UIGameScene extends UIComponent {

    GameScene gameScene;
    CustomTextEntity healthText;
    CustomTextEntity scoreText;

    public UIGameScene(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        this.gameScene = gameScene;
        setupEntities();
    }

    protected void setupEntities() {
        createTextEntities();
        createButtonEntities();
    }

    // TODO Fix hardcoded position values, create common constants
    private void createTextEntities() {
        healthText = new CustomTextEntity(new Coordinate2D(20, 610),
                "Health: 3", AnchorPoint.TOP_LEFT, "Roboto", FontWeight.BOLD, 30, Color.YELLOW
        );
        scoreText = new CustomTextEntity(new Coordinate2D(20, 650),
                "Score: ", AnchorPoint.TOP_LEFT, "Roboto", FontWeight.BOLD, 30, Color.YELLOW
        );
        addEntity(healthText);
        addEntity(scoreText);

    }

    private void createButtonEntities() {
        PauseButton pauseButton = new PauseButton(new Coordinate2D(550, 650), gameScene);
        addEntity(pauseButton);

    }


    // FIXME Fix overlap
    public void updateScoreText(int score) {
        scoreText.setText("Score: " + score);
    }
}