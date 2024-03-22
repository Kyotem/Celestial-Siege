package CelestialSiege.scenes;
import CelestialSiege.CelestialSiege;

import CelestialSiege.buttons.StartButton;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    private CelestialSiege celestialSiege;

    public TitleScene(CelestialSiege celestialSiege){
        this.celestialSiege = celestialSiege;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/Audio1.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var CelestialSiegeText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Celestial Siege"
        );
        CelestialSiegeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        CelestialSiegeText.setFill(Color.WHITE);
        CelestialSiegeText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        addEntity(CelestialSiegeText);

        StartButton startbutton = new StartButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 1.5),
                celestialSiege);
        addEntity(startbutton);
    }
}

