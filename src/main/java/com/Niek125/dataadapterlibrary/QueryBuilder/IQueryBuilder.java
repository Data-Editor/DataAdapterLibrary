package com.Niek125.dataadapterlibrary.QueryBuilder;

public interface IQueryBuilder {
    void clearQuery();
    void storedProcedure(String procedureName);
    void addParameter(Object param);
    String getQuery();
}
