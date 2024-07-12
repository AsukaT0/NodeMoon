package com.asuka.nodemoonv1;

import com.asuka.nodemoonv1.Lib.MyScene;
import com.asuka.nodemoonv1.Lib.MyToolbar;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {
    float currentSizeW = 960*1.5f;
    float currentSizeH = 540*1.5f;

    @Override
    public void start(Stage stage) {
        MyScene.init();
        MyToolbar.init();
        VBox buttons = new VBox();
        Group screens = new Group(MyScene.getRoot());
        HBox preroot1 = new HBox(buttons,screens);

        VBox preroot0 = new VBox(MyToolbar.getToolbar(),preroot1);
        Scene scene = new Scene(preroot0, currentSizeW, currentSizeH);
        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            if (Objects.equals(oldVal, newVal)) return;
            float customW = newVal.floatValue();
            MyScene.setSizeW(customW);
            MyScene.onResizeW(obs, oldVal, newVal);
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            if (Objects.equals(oldVal, newVal)) return;
            float customH = newVal.floatValue();
            MyScene.setSizeH(customH);
            MyScene.onResizeH(obs, oldVal, newVal);
        });
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public enum Metric1 {
        height, width
    }

    public static void main(String[] args) {
        launch();
    }
}