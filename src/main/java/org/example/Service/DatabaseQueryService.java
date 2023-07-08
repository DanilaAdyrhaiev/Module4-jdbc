package org.example.Service;

import org.example.DTO.*;
import org.example.Database.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {
    Connection connection;
    public DatabaseQueryService(){
        if(connection == null) {
            try {
                connection = Database.getInstance().getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<LongestProject> findLongestProject(){
        try(Statement statement = connection.createStatement()){
            List<LongestProject> longestProjects = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(getQuery("sql/find_longest_project.sql"));
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int monthCount = resultSet.getInt(2);
                longestProjects.add(new LongestProject(id, monthCount));
            }
            return longestProjects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxProjectClient> findMaxProjectClient(){
        try(Statement statement = connection.createStatement()){
            List<MaxProjectClient> maxProjectClient = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(getQuery("sql/find_max_projects_client.sql"));
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int projectCount = resultSet.getInt(2);
                maxProjectClient.add(new MaxProjectClient(name, projectCount));
            }
            return maxProjectClient;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        try(Statement statment = connection.createStatement()){
            List<MaxSalaryWorker> maxSalaryWorker = new ArrayList<>();
            ResultSet resultSet = statment.executeQuery(getQuery("sql/find_max_salary_worker.sql"));
            while(resultSet.next()){
                String name = resultSet.getString(1);
                int salary = resultSet.getInt(2);
                maxSalaryWorker.add(new MaxSalaryWorker(name, salary));
            }
            return  maxSalaryWorker;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(){
        try(Statement statment = connection.createStatement()){
            List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();
            ResultSet resultSet = statment.executeQuery(getQuery("sql/find_youngest_eldest_workers.sql"));
            while(resultSet.next()){
                String type = resultSet.getString(1);
                String name = resultSet.getString(2);
                Date birthday = resultSet.getDate(3);
                youngestEldestWorkers.add(new YoungestEldestWorkers(type, name, birthday));
            }
            return youngestEldestWorkers;
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProjectPrices> findProjectPrices(){
        try(Statement statement = connection.createStatement()) {
            List<ProjectPrices> projectPrices = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(getQuery("sql/print_project_prices.sql"));
            while(resultSet.next()){
                String name = resultSet.getString(1);
                int price = resultSet.getInt(2);
                projectPrices.add(new ProjectPrices(name, price));
            }
            return projectPrices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayAllWorkers(){
        try(Statement statement = connection.createStatement()){
            String query = "select id, name from worker";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println("ID: " + id + " Name: "+name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getQuery(String path){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            StringBuilder query = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                query.append(line).append(" ");
            }
            return query.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
