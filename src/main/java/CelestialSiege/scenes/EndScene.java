package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import com.github.hanyaeger.api.scenes.StaticScene;

public class EndScene extends StaticScene {

    private CelestialSiege celestialSiege;

    public EndScene(CelestialSiege celestialSiege) {
        this.celestialSiege = celestialSiege;
    }

    @Override
    public void setupScene() {
//        setBackgroundAudio(); // Trombone
//        setBackgroundImage(); // Insert
    }

    @Override
    public void setupEntities() {

    }
}
