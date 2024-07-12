package com.asuka.nodemoonv1.Lib;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class MyToolbar {
    private static ToolBar toolBar = new ToolBar();
    public static void init(){
        toolBar.setPadding(new Insets(0));
        toolBar.getItems().addAll(new Button("Файл"));
    }
    public static Parent getToolbar(){return toolBar;}
}
