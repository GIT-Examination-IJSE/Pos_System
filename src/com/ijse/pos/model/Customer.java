/*
 *
 *  * ---------------------------------------------------------------------------------------------
 *  *  *  Copyright (c) 2021 - present Hasintha Diyaneth. All rights reserved.
 *  *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *  *--------------------------------------------------------------------------------------------
 *
 */

package com.ijse.pos.model;

/**
 * @auther Hasintha Diyaneth <diyanethhasintha@gmail.com>
 * @since 10/9/2021
 */
public class Customer {
    private String id;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
