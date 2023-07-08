package org.example.Service;

import org.example.Database.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String path = "sql/populate_db.sql";
        try {
            Statement statement = Database.getInstance().getConnection().createStatement();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(path));
                String line;
                StringBuilder query = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    query.append(line);
                    if (line.trim().endsWith(";")) {
                        statement.executeUpdate(query.toString());//
                        query.setLength(0);
                    }
                }
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            statement.close();
            System.out.println("Усі запити з файлу успішно виконані.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
