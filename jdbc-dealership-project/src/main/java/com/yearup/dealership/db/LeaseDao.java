package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.*;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        // TODO: Implement the logic to add a lease contract

        String sql = "INSERT INTO lease_contracts (VIN, lease_start, lease_end, monthly_payment)" +
                "VALUES (?, ?, ?, ?)";
        int rows = 0;

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, leaseContract.getVin());
            preparedStatement.setDate(2, Date.valueOf(leaseContract.getLeaseStart()));
            preparedStatement.setDate(3, Date.valueOf(leaseContract.getLeaseEnd()));
            preparedStatement.setDouble(4, leaseContract.getMonthlyPayment());

            rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated!");

            try (ResultSet key = preparedStatement.getGeneratedKeys()) {
                while (key.next()) {
                    System.out.printf("%d key was added\n",
                            key.getLong(1));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
