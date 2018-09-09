package com.texo.importer;

import com.opencsv.CSVReader;
import com.texo.util.DatabaseConnection;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataImporter {

    public void loadData()
    {

        try {
            CSVReader reader = new CSVReader( new FileReader(getClass().getClassLoader().getResource("cidades.csv").getFile()), ',');
            Connection connection = DatabaseConnection.getConnection();

            String insertQuery = "Insert into city (ibge_id, name, capital, uf_code, latitude, longitude, name_no_diacritics, alternative_names, microregion, mesoregion) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            String[] rowData = null;
            int i = 0;
            while((rowData = reader.readNext()) != null)
            {
                for (String data : rowData)
                {
                    pstmt.setString((i % 3) + 1, data);

                    if (++i % 3 == 0)
                        pstmt.addBatch();// add batch

                    if (i % 30 == 0)// insert when the batch size is 10
                        pstmt.executeBatch();
                }
            }
            System.out.println("Data Successfully Uploaded");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

        }

    }
}
