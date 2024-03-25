package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.entities.Alien;
import CelestialSiege.entities.Spaceship;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

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
        Alien alien = new Alien(new Coordinate2D(500, 150));
        addEntity(alien);
        addEntity(spaceship);
    }

}
