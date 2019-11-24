package com.Niek125.dataadapterlibrary.DataBase;

import com.Niek125.dataadapterlibrary.Mapper.IObjectMapper;
import com.Niek125.dataadapterlibrary.QueryBuilder.IQueryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private IQueryBuilder queryBuilder;
    private IObjectMapper mapper;
    private Connection conn;
    private String host;
    private String uName;
    private String pWord;
    private String driver;

    public DataBase(IQueryBuilder queryBuilder, IObjectMapper mapper, String host, String uName, String pWord, String driver) {
        this.queryBuilder = queryBuilder;
        this.mapper = mapper;
        this.host = host;
        this.uName = uName;
        this.pWord = pWord;
        this.driver = driver;
    }

    public IQueryBuilder queryBuilder() {
        return queryBuilder;
    }

    private void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        conn = DriverManager.getConnection(host, uName, pWord);
    }

    public void executeNonReturnQuery() {
        try {
            openConnection();
            Statement statement = conn.createStatement();
            statement.executeUpdate(queryBuilder.getQuery());

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> List<T> executeReturnQuery(Class<T> type) {
        ResultSet set;
        List<T> t = new ArrayList<>();
        try {
            openConnection();
            Statement statement = conn.createStatement();
            set = statement.executeQuery(queryBuilder.getQuery());
            t = mapper.map(set, type);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
