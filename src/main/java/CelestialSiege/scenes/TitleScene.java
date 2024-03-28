package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;

import CelestialSiege.UI.UIStartScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

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
        setBackgroundImage("backgrounds/background0.png");
    }

    @Override
    public void setupEntities() {

        // Initialise UI for the TitleScene
        UIStartScene uiTitleScene = new UIStartScene(new Coordinate2D(0,0), this, celestialSiege);
        addEntity(uiTitleScene);


    }
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKey) {
        if (pressedKey.contains(KeyCode.ESCAPE)) {
            celestialSiege.quit();
        }
    }
}

