package CelestialSiege.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;

public abstract class UIComponent extends CompositeEntity {

    protected UIComponent(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    protected void setupEntities() {
        createTextEntities();
        createButtonEntities();
    }

    // Method to initialize text entities
    protected abstract void createTextEntities();

    // Method to initialize button entities
    protected abstract void createButtonEntities();

    // Method to update text entities if needed
    public void updateText() {

    }

}
