package com.Niek125.dataadapterlibrary.DataBase;

import com.Niek125.dataadapterlibrary.Mapper.IObjectMapper;
import com.Niek125.dataadapterlibrary.QueryBuilder.IQueryBuilder;

import java.sql.*;
import java.util.List;

public class DataBase {
    private IQueryBuilder queryBuilder;
    private IObjectMapper mapper;
    private Connection conn;
    private String host;
    private String uName;
    private String pWord;

    public DataBase(IQueryBuilder queryBuilder, IObjectMapper mapper, String host, String uName, String pWord) {
        this.queryBuilder = queryBuilder;
        this.mapper = mapper;
        this.host = host;
        this.uName = uName;
        this.pWord = pWord;
    }

    public IQueryBuilder queryBuilder() {
        return queryBuilder;
    }

    private void openConnection() throws SQLException {
        conn = DriverManager.getConnection(host,uName,pWord);
    }

    public void executeNonReturnQuery() {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(queryBuilder.getQuery());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> List<T> executeReturnQuery(Class<T> type) {
        ResultSet set;
        try {
            Statement statement = conn.createStatement();
            set = statement.executeQuery(queryBuilder.getQuery());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mapper.map(set, type);
    }
}
