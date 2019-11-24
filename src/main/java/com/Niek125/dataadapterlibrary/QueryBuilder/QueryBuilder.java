package com.Niek125.dataadapterlibrary.QueryBuilder;

import com.Niek125.dataadapterlibrary.QueryBuilder.Syntax.ISyntax;

public class QueryBuilder implements IQueryBuilder {
    private ISyntax syntax;
    private String query;
    private Boolean firstParam;

    public QueryBuilder(ISyntax syntax) {
        this.syntax = syntax;
        clearQuery();
    }

    @Override
    public void clearQuery() {
        query = syntax.getPrefix();
        firstParam = true;
    }

    @Override
    public void storedProcedure(String procedureName) {
        query += syntax.toStoredProcedure(procedureName);
    }

    @Override
    public void addParameter(Object param) {
        query += syntax.toParam(param, firstParam);
        this.firstParam = false;
    }

    @Override
    public String getQuery() {
        String q = query + syntax.getAppendix();
        clearQuery();
        return q;
    }
}
