package com.asuka.nodemoonv1.Lib.Boxes;

import javafx.scene.Cursor;
import javafx.scene.layout.VBox;

public class MyVBox extends VBox {
    private static final double BORDER_DRAG_THRESHOLD = 5.0;
    private boolean dragging = false;
    private enum Dimen{
        right,left
    }
    Dimen current = null;
    public MyVBox() {
        super();
        setOnMouseMoved(mouseEvent -> {
            if (isInDraggableZone(mouseEvent.getX())) {
                setCursor(Cursor.W_RESIZE);
            } else {
                setCursor(Cursor.DEFAULT);
            }
        });
        setOnMouseDragged(event -> {
            if (isInDraggableZone(event.getX())) {
                dragging = true;
            }
            if (dragging) {
                double newWidth = 0;
                if(current == Dimen.right)
                    newWidth = event.getSceneX();
                else if(current == Dimen.left)
                    newWidth = getScene().getWidth() - event.getSceneX();
                setPrefWidth(newWidth);
            }
        });

        setOnMouseReleased(event -> dragging = false);
    }

    private boolean isInDraggableZone(double mouseX) {
        if(mouseX >= getWidth() - BORDER_DRAG_THRESHOLD){
            current = Dimen.right;
            return true;}
        if(mouseX <= BORDER_DRAG_THRESHOLD){
            current = Dimen.left;
            return true;}
        return false;
    }
}
