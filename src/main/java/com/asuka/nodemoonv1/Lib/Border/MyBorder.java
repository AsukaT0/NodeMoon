package com.asuka.nodemoonv1.Lib.Border;

import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;

public class MyBorder extends BorderStroke {
    public MyBorder(Paint paint, BorderStrokeStyle borderStrokeStyle, CornerRadii cornerRadii, BorderWidths borderWidths) {
        super(paint, borderStrokeStyle, cornerRadii, borderWidths);
    }

}
