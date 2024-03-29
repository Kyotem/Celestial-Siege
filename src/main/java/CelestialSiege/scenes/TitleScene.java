package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;

import CelestialSiege.UI.UITitleScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class TitleScene extends StaticScene implements KeyListener {
    private final CelestialSiege CELESTIALSIEGE;

    public TitleScene(CelestialSiege celestialSiege) {
        this.CELESTIALSIEGE = celestialSiege;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/BackgroundAudio.mp3");
        setBackgroundImage("backgrounds/TitleScreenBackground.png");
    }

    @Override
    public void setupEntities() {

        // Initialise UI for the TitleScene
        UITitleScene uiTitleScene = new UITitleScene(new Coordinate2D(0, 0), this, CELESTIALSIEGE);
        addEntity(uiTitleScene);

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKey) {
        if (pressedKey.contains(KeyCode.ESCAPE)) {
            CELESTIALSIEGE.quit();
        }
    }
}

