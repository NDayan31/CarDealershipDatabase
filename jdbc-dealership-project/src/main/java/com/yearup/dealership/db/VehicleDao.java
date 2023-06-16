package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        // TODO: Implement the logic to add a vehicle

        // Vin, make, model, year, sold, color, vehicleType, odometer, price
        String sql = "INSERT INTO vehicles VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int rows = 0;

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setBoolean(5, vehicle.isSold());
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setString(7, vehicle.getVehicleType());
            preparedStatement.setInt(8, vehicle.getOdometer());
            preparedStatement.setDouble(9, vehicle.getPrice());

            rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeVehicle(String VIN) {
        // TODO: Implement the logic to remove a vehicle

        String sql = "DELETE FROM vehicle WHERE VIN = ?";
        int rows = 0;

        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,VIN);

            rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) updated!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        // TODO: Implement the logic to search vehicles by price range
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1,minPrice);
            preparedStatement.setDouble(2,maxPrice);

            // Vin, make, model, year, sold, color, vehicleType, odometer, price
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    String vin = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");

                    Vehicle vehicle = new Vehicle(vin, make, model, year, sold, color, vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        // TODO: Implement the logic to search vehicles by make and model
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,make);
            preparedStatement.setString(2,model);

            // Vin, make, model, year, sold, color, vehicleType, odometer, price
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    String vin = resultSet.getString("VIN");
                    String vehicleMake = resultSet.getString("make");
                    String vehicleModel = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");

                    Vehicle vehicle = new Vehicle(vin, vehicleMake, vehicleModel, year, sold, color, vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        // TODO: Implement the logic to search vehicles by year range
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,minYear);
            preparedStatement.setInt(2,maxYear);

            // Vin, make, model, year, sold, color, vehicleType, odometer, price
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    String vin = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");

                    Vehicle vehicle = new Vehicle(vin, make, model, year, sold, color, vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByColor(String color) {
        // TODO: Implement the logic to search vehicles by color
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE color = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,color);

            // Vin, make, model, year, sold, color, vehicleType, odometer, price
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    String vin = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    boolean sold = resultSet.getBoolean("SOLD");
                    String vehicleColor = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");

                    Vehicle vehicle = new Vehicle(vin, make, model, year, sold, vehicleColor, vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        // TODO: Implement the logic to search vehicles by mileage range
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,minMileage);
            preparedStatement.setInt(2,maxMileage);

            // Vin, make, model, year, sold, color, vehicleType, odometer, price
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    String vin = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");

                    Vehicle vehicle = new Vehicle(vin, make, model, year, sold, color, vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByType(String type) {
        // TODO: Implement the logic to search vehicles by type
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE vehicleType = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,type);

            // Vin, make, model, year, sold, color, vehicleType, odometer, price
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    String vin = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");

                    Vehicle vehicle = new Vehicle(vin, make, model, year, sold, color, vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
