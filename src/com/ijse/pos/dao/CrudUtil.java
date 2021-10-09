/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) 2021 - present Hasintha Diyaneth. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  *--------------------------------------------------------------------------------------------
 *
 */

package com.ijse.pos.dao;

import com.ijse.pos.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther Hasintha Diyaneth <diyanethhasintha@gmail.com>
 * @since 10/9/2021
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql, Object... ob) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);

        for (int i=0;i<ob.length;i++){
            pstm.setObject(i+1,ob[i]);
        }
        return pstm;

    }
    public static boolean executeUpdate(String sql,Object... ob) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm=getPreparedStatement(sql,ob);
        return pstm.executeUpdate()>0;
    }
    public static ResultSet executeQuery(String sql, Object... ob) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm=getPreparedStatement(sql,ob);
        return pstm.executeQuery();
    }
}
