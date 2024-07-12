package com.asuka.nodemoonv1.Lib;

import com.asuka.nodemoonv1.HelloApplication;
import com.asuka.nodemoonv1.Lib.Boxes.MyVBox;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyScene {
    private static float currentSizeW = 600;
    private static float currentSizeH = 400;
    private static MyVBox itemList = new MyVBox();
    private static Pane panel = new Pane();
    private static MyVBox propList = new MyVBox();
    private static HBox root = new HBox();
    private static HashMap<String,Image> sources;



    public static void init() {
        sources = new HashMap<>();
        sources.put("page_icon",new Image(String.valueOf(MyScene.class.getResource("/com/asuka/nodemoonv1/images/structure/pages.png"))));

        setupPanels();
        root.getChildren().addAll(itemList, panel, propList);
        root.setStyle("-fx-background-color: #CCCCCC;");
    }


    private static float[] dimen = {1 / 5f, 3 / 5f, 1 / 5f};

    private static void setupPanels() {
        itemList.setPrefSize(currentSizeW * dimen[0], currentSizeH);
        itemList.widthProperty().addListener((obs, oldVal, newVal) -> {
            dimen[0] = (float) itemList.getPrefWidth() / currentSizeW;
            dimen[1] = 1 - dimen[0] - dimen[2];
            panel.setPrefWidth(currentSizeW * dimen[1]);
        });
        panel.setPrefSize(currentSizeW * dimen[1], currentSizeH);

        propList.setPrefSize(currentSizeW * dimen[2], currentSizeH);
        propList.widthProperty().addListener((obs, oldVal, newVal) -> {
            dimen[2] = (float) propList.getPrefWidth() / currentSizeW;
            dimen[1] = 1 - dimen[0] - dimen[2];
            panel.setPrefWidth(currentSizeW * dimen[1]);
        });
        String
                style0 = "-fx-background-color: #FFFFFF;" +
                "-fx-background-radius: 0 10 10 0;" +
                "-fx-border-radius: 0 10 10 0; " +
                "-fx-border-color: black; " +
                "-fx-border-width: 2;";

        String style1 = "-fx-background-color: #CCCCCC;";

        String style2 = "-fx-background-color: #FFFFFF;" +
                "-fx-background-radius: 10 0 0 10;" +
                "-fx-border-radius: 10 0 0 10;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 2;";

        itemList.setStyle(style0);
        panel.setStyle(style1);
        propList.setStyle(style2);

        panel.setOnMouseClicked(mouseEvent -> {
            Button button = new Button();
            ImageView imageView = new ImageView(sources.get("page_icon"));
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            button.setGraphic(imageView);
            button.setLayoutX(mouseEvent.getX()-imageView.getFitWidth()/2);
            button.setLayoutY(mouseEvent.getY()-imageView.getFitHeight()/2);
            button.setStyle("-fx-background-color: #FFFFFF00;");
            panel.getChildren().add(button);
        });
        panel.setOnKeyPressed(keyEvent -> {
            if(keyEvent.isControlDown()&&keyEvent.getCode() == KeyCode.Z){

            }
        });
    }



    public static void onResizeW(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
        itemList.setPrefWidth(currentSizeW * dimen[0]);
        panel.setPrefWidth(currentSizeW * dimen[1]);
        propList.setPrefWidth(currentSizeW * dimen[2]);
    }

    public static void onResizeH(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
        itemList.setPrefHeight(currentSizeH);
        panel.setPrefHeight(currentSizeH);
        propList.setPrefHeight(currentSizeH);
    }
    public static void setSizeW(float val){
        currentSizeW = val;
    }
    public static void setSizeH(float val){
        currentSizeH = val;
    }


    public static Parent getRoot() {return root;}
    public static Parent getItemList(){return itemList;}
    public static Parent getPanel(){return panel;}
    public static Parent getPropsList(){return propList;}

}
