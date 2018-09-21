package crudOper;

import model.Cliente;
import model.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteCrud {

    Connection connection = null;
    Statement statement = null;

    public ClienteCrud(){
    }

    public boolean insertarCliente(Cliente cliente){
        DBConnection dbConnection = new DBConnection();
        this.connection = dbConnection.getDriverConnection(this.connection);
        this.statement = dbConnection.createStatement(this.statement, this.connection);

        String firstName = cliente.getFirstName();
        String lastName = cliente.getLastName();
        String homeNumber = cliente.getHomeNumber();
        String phoneNumber = cliente.getPhoneNumber();

        String insertQuery = "INSERT INTO Cliente (firstName, lastName, homeNumber, phoneNumber)" +
                "VALUES('" + firstName + "','" + lastName + "','" + homeNumber + "','" + phoneNumber + "');";

        try {
            this.statement.executeUpdate(insertQuery);
            statement.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCliente(Cliente cliente){
        DBConnection dbConnection = new DBConnection();

        this.connection = dbConnection.getDriverConnection(this.connection);
        this.statement = dbConnection.createStatement(this.statement, this.connection);

        String firstName = cliente.getFirstName();
        String lastName = cliente.getLastName();
        String homeNumber = cliente.getHomeNumber();
        String phoneNumber = cliente.getPhoneNumber();
        int idCliente = getClientId(homeNumber);

        String sqlUpdateClienteFirstName = "UPDATE Cliente SET firstName = '"+ firstName +" ' WHERE idCliente = " + idCliente + " ;";
        String sqlUpdateClienteLastName = "UPDATE Cliente SET lastName = '"+ lastName +" ' WHERE idCliente = " + idCliente + " ;";
        String sqlUpdateClienteHomeNumber = "UPDATE Cliente SET homeNumber = '"+ homeNumber +" ' WHERE idCliente = " + idCliente + " ;";
        String sqlUpdateClientePhoneNumber = "UPDATE Cliente SET phoneNumber = '"+ phoneNumber +" ' WHERE idCliente = " + idCliente + " ;";

        try {
            statement.executeUpdate(sqlUpdateClienteFirstName);
            statement.executeUpdate(sqlUpdateClienteLastName);
            statement.executeUpdate(sqlUpdateClienteHomeNumber);
            statement.executeUpdate(sqlUpdateClientePhoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return true;
    }

    private boolean removeCliente(Cliente cliente){

        return true;
    }

    private boolean queryCliente(Cliente cliente){

        return true;
    }

    public int getClientId(String homeNumber){

        int idCliente = 0;
        ResultSet resultSet;

        String sqlGetClienteId = "SELECT idCliente FROM Cliente WHERE homeNumber = '"+ homeNumber +"';";

        try {
            resultSet = this.statement.executeQuery(sqlGetClienteId);

            while (resultSet.next()){
                idCliente = resultSet.getInt("idCliente");
                System.out.println("This is the loop of the resulset: " + idCliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCliente;
    }

}
