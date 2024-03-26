package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.entities.Alien;
import CelestialSiege.entities.AlienManager;
import CelestialSiege.entities.Spaceship;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class GameScene extends DynamicScene {
    private CelestialSiege celestialSiege;
    public GameScene(CelestialSiege celestialSiege) {
        this.celestialSiege = celestialSiege;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/Audio1.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        Spaceship spaceship = new Spaceship(new Coordinate2D(399, 550));
        AlienManager alienManager = new AlienManager(new Coordinate2D(0, 0));
        addEntity(alienManager);
        addEntity(spaceship);
    }


}
