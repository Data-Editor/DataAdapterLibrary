package com.Niek125.dataadapterlibrary;

import com.Niek125.dataadapterlibrary.Mapper.IObjectMapper;
import com.Niek125.dataadapterlibrary.Mapper.Mapper;
import com.Niek125.dataadapterlibrary.QueryBuilder.IQueryBuilder;
import com.Niek125.dataadapterlibrary.QueryBuilder.QueryBuilder;
import com.Niek125.dataadapterlibrary.QueryBuilder.Syntax.MySQLSyntax;

public class MySQLDataBaseBuilder extends DataBaseBuilder {
    private String host;
    private String uName;
    private String pWord;

    public MySQLDataBaseBuilder(String host, String uName, String pWord) {
        this.host = host;
        this.uName = uName;
        this.pWord = pWord;
    }

    @Override
    IQueryBuilder getQueryBuilder() {
        return new QueryBuilder(new MySQLSyntax());
    }

    @Override
    IObjectMapper getObjectMapper() {
        return new Mapper();
    }

    @Override
    String getHost() {
        return host;
    }

    @Override
    String getUName() {
        return uName;
    }

    @Override
    String getPWord() {
        return pWord;
    }
}
