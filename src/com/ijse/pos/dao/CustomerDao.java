/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) 2021 - present Hasintha Diyaneth. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  *--------------------------------------------------------------------------------------------
 *
 */

package com.ijse.pos.dao;

import com.ijse.pos.model.Customer;

import java.sql.SQLException;

/**
 * @auther Hasintha Diyaneth <diyanethhasintha@gmail.com>
 * @since 10/9/2021
 */
public class CustomerDao {

    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO Customer VALUES(?,?,?)";
        return CrudUtil.executeUpdate(sql,customer.getId(),customer.getName(),customer.getAddress());
    }
}
