package com.company;

import crudOper.ClienteCrud;
import model.Cliente;
import model.DBConnection;
import org.sqlite.SQLiteErrorCode;
import org.sqlite.SQLiteException;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        DBConnection DBWork = new DBConnection();
        DBWork.DBCreateTables();

        Cliente cliente = new Cliente("Rik", "Rod", "9D");
        ClienteCrud crud = new ClienteCrud();

//        crud.insertarCliente(cliente);
        crud.updateCliente(cliente);

    }
}