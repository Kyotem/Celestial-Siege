package CelestialSiege.UI;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomTextEntity extends TextEntity {

    public CustomTextEntity(Coordinate2D initialLocation, String text, AnchorPoint anchorPoint, String font, FontWeight fontWeight, int fontSize, Color color) {
        super(initialLocation);
        setFont(Font.font(font, fontWeight, fontSize));
        setAnchorPoint(anchorPoint);
        setFill(color);
        setText(text);
    }

    // For now only uses int,
    public void setTextWithVariable(String mainText, int variable) {
        setText(mainText + ": " + variable);
    }

}
