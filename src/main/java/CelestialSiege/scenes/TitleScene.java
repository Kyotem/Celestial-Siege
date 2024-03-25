package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;

import CelestialSiege.buttons.ExitButton;
import CelestialSiege.buttons.StartButton;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Set;

public class TitleScene extends StaticScene implements KeyListener {
    private CelestialSiege celestialSiege;

    public TitleScene(CelestialSiege celestialSiege) {
        this.celestialSiege = celestialSiege;
    }

    // TODO Change resource names to be more descriptive
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/Audio1.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var CelestialSiegeText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() * 0.20),
                "Celestial Siege"
        );
        CelestialSiegeText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        CelestialSiegeText.setFill(Color.WHITE);
        CelestialSiegeText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        addEntity(CelestialSiegeText);

        // TODO Fix Ypos being hardcoded for buttons, use standard offset
        StartButton startButton = new StartButton(
                new Coordinate2D(getWidth() / 2, getHeight() * 0.5), celestialSiege);
        ExitButton exitButton = new ExitButton(
                new Coordinate2D(getWidth() / 2, getHeight() * 0.7), celestialSiege);
        addEntity(startButton);
        addEntity(exitButton);
    }
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKey) {
        if (pressedKey.contains(KeyCode.ESCAPE)) {
            celestialSiege.quit();
        }
    }
}

