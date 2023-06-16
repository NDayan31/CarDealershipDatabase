package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        // TODO: Implement the logic to add a vehicle to the inventory

        String sql = "INSERT INTO inventory VALUES (?,?)";
        int rows = 0;

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,vin);
            preparedStatement.setInt(2, dealershipId);

            rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeVehicleFromInventory(String vin) {
        // TODO: Implement the logic to remove a vehicle from the inventory

        String sql = "DELETE FROM inventory WHEN VIN = ?";
        int rows = 0;

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,vin);

            rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
