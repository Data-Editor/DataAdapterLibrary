package com.Niek125.dataadapterlibrary.QueryBuilder.Syntax;

public class MySQLSyntax implements ISyntax {
    @Override
    public String getPrefix() {
        return "CALL ";
    }

    @Override
    public String getAppendix() {
        return ");";
    }

    @Override
    public String toStoredProcedure(String storedProcedure) {
        return storedProcedure += "(";
    }

    @Override
    public String toParam(Object param, Boolean firstParam) {
        String syntax = new String();
        if (!firstParam) {
            syntax += ",";
        }
        if (param == null) {
            syntax += "NULL";
        } else if (param.getClass().equals(String.class)) {
            syntax += "'" + param + "'";
        } else {
            syntax += param;
        }
        return syntax;
    }
}
