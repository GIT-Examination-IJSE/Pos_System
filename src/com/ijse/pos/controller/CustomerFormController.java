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
import com.ijse.pos.dao.CustomerDao;
import com.ijse.pos.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
public class CustomerFormController {
    public AnchorPane customerRoot;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtId;

    CustomerDao customerDao=new CustomerDao();

    public void saveCustomer(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        Customer customer=new Customer(id,name,address);
        try {
            boolean b = customerDao.addCustomer(customer);
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

    public void back(MouseEvent mouseEvent) throws IOException {
        Stage window = (Stage) this.customerRoot.getScene().getWindow();
        try {
            window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/com/ijse/pos/views/HomeForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.centerOnScreen();
    }
}
