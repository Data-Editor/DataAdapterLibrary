package com.Niek125.dataadapterlibrary.QueryBuilder.Syntax;

import java.util.ArrayList;
import java.util.List;

public class MySQLSyntax implements ISyntax {
    @Override
    public String getPrefix() {
        return "CALL ";
    }

    @Override
    public String getAppendix() {
        return ")";
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
        } else if (param.getClass().equals(ArrayList.class)){
            syntax += "'";
            for (int i = 0; i < ((List)param).size(); i++) {
                if(i > 0){
                    syntax += ",";
                }
                syntax += "\\'" + ((List)param).get(i) + "\\'";
            }
            syntax += "'";
        } else if (param.getClass().equals(String.class)) {
            syntax += "'" + param + "'";
        } else {
            syntax += param;
        }
        return syntax;
    }
}
