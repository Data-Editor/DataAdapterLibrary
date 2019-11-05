package com.Niek125.dataadapterlibrary;

import com.Niek125.dataadapterlibrary.DataBase.DataBase;
import com.Niek125.dataadapterlibrary.Mapper.IObjectMapper;
import com.Niek125.dataadapterlibrary.QueryBuilder.IQueryBuilder;

public abstract class DataBaseBuilder {
    DataBase getDataBase(){
        return new DataBase(
                getQueryBuilder(),
                getObjectMapper(),
                getHost(),
                getUName(),
                getPWord());
    }

    abstract IQueryBuilder getQueryBuilder();
    abstract IObjectMapper getObjectMapper();
    abstract String getHost();
    abstract String getUName();
    abstract String getPWord();
}
