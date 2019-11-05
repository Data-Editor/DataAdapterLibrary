package com.Niek125.dataadapterlibrary.QueryBuilder.Syntax;

public interface ISyntax {
    String getPrefix();
    String getAppendix();
    String toStoredProcedure(String storedProcedure);
    String toParam(Object param, Boolean firstParam);
}
