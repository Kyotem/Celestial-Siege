package CelestialSiege.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;

public abstract class UIComponent extends CompositeEntity {

    protected UIComponent(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    protected void setupEntities() {

    }

    private void createTextEntities() {

    }

    private void createButtonEntities() {

    }

}
