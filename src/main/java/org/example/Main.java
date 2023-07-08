package org.example;

import org.example.Service.DatabaseQueryService;

import java.sql.SQLException;
import java.sql.Statement;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var longestProject = new DatabaseQueryService().findLongestProject();
        var maxProject = new DatabaseQueryService().findMaxProjectClient();
        var maxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
        var projectPrices = new DatabaseQueryService().findProjectPrices();
        var youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        System.out.println();
    }

}