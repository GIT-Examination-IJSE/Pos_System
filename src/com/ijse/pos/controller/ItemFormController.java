/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) 2021 - present Hasintha Diyaneth. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  *--------------------------------------------------------------------------------------------
 *
 */

package com.ijse.pos.controller;

import com.ijse.pos.NotificationAlert;
import com.ijse.pos.dao.ItemDao;
import com.ijse.pos.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @auther Hasintha Diyaneth <diyanethhasintha@gmail.com>
 * @since 10/9/2021
 */
public class ItemFormController {
    public AnchorPane itemRoot;
    public TextField txtCode;
    public TextField txtDes;
    public TextField txtPrice;
    public TextField txtQty;

    ItemDao itemDao=new ItemDao();

    public void back(MouseEvent mouseEvent) {
        Stage window = (Stage) this.itemRoot.getScene().getWindow();
        try {
            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/com/ijse/pos/views/HomeForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.centerOnScreen();
    }

    public void saveItem(ActionEvent actionEvent) {
        String id = txtCode.getText();
        String description = txtDes.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());

        Item item=new Item(id,description,price,qty);
        try {
            boolean b = itemDao.addItem(item);
            if (b){
                NotificationAlert.yesAlert();
            }else{
                NotificationAlert.noAlert();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
