/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) 2021 - present Hasintha Diyaneth. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  *--------------------------------------------------------------------------------------------
 *
 */

package com.ijse.pos.controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * @auther Hasintha Diyaneth <diyanethhasintha@gmail.com>
 * @since 10/9/2021
 */
public class HomeController {
    public ImageView customer;
    public ImageView item;
    public AnchorPane root;
    public Label lblMenu;
    public Label lblDesc;

    public void addCustomer(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        try {
            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/com/ijse/pos/views/CustomerForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.centerOnScreen();
    }

    public void addItem(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) this.root.getScene().getWindow();
        try {
            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/com/ijse/pos/views/ItemForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.centerOnScreen();
    }

    public void playMouseExiteAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("Welcome Hasiya Tech");
            lblDesc.setText("Please select one of above main operations to proceed");
        }
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch (icon.getId()) {
                case "customer":
                    lblMenu.setText("Hey Customer !!");
                    lblDesc.setText("Customer Information add section");
                    break;

                case "item":
                    lblMenu.setText("Item Section");
                    lblDesc.setText("Item Management section");
                    break;

            }
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.WHITE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(40);
            icon.setEffect(glow);
        }
    }
}
