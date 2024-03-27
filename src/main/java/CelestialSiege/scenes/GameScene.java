package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.entities.Spaceship;
import CelestialSiege.entities.map.ShieldTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;

public class GameScene extends DynamicScene implements TileMapContainer {
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
        addEntity(spaceship);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new ShieldTileMap());
    }
}
