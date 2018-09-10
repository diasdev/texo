package com.texo.importer;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.texo.util.DatabaseConnection;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataImporter {

    private final static String FILE_NAME = "cidades.csv";

    public void loadData()
    {

        try (   Reader reader = Files.newBufferedReader(Paths.get(getClass().getClassLoader().getResource(FILE_NAME).toURI()));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
                Connection connection = DatabaseConnection.getConnection();)
        {
            connection.setAutoCommit(false);

            String insertQuery = "Insert into city (ibge_id, uf_code, name, capital,  latitude, longitude, name_no_diacritics, alternative_names, microregion, mesoregion) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            String[] rowData = null;

            int i = 0;
            while((rowData = csvReader.readNext()) != null)
            {
                pstmt.setLong(1, Long.valueOf(rowData[0]));
                pstmt.setString(2, rowData[1]);
                pstmt.setString(3, rowData[2]);
                pstmt.setBoolean(4, Boolean.valueOf(rowData[3]));
                pstmt.setDouble(5, Double.valueOf(rowData[4]));
                pstmt.setDouble(6, Double.valueOf(rowData[5]));
                pstmt.setString(7, rowData[6]);
                pstmt.setString(8, rowData[7]);
                pstmt.setString(9, rowData[8]);
                pstmt.setString(10, rowData[9]);

                pstmt.addBatch();

                if (++i % 50 == 0)
                    pstmt.executeBatch();
            }

            connection.commit();
            System.out.println("Data Successfully loaded");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
