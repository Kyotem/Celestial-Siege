package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.UI.UIEndScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;

public class EndScene extends StaticScene {

    private final CelestialSiege CELESTIALSIEGE;

    public EndScene(CelestialSiege celestialSiege) {
        this.CELESTIALSIEGE = celestialSiege;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/GameOverMusic.mp3");
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        UIEndScene uiEndScene = new UIEndScene(new Coordinate2D(0,0), this, CELESTIALSIEGE);
        addEntity(uiEndScene);
    }
}
