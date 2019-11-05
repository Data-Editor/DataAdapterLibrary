package com.Niek125.dataadapterlibrary.Mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper implements IObjectMapper {
    @Override
    public <T> List<T> map(ResultSet set, Class<T> type) {
        try {
            List<String> columns = new ArrayList<>();
            ResultSetMetaData setMetaData = set.getMetaData();
            for (int i = 0; i < setMetaData.getColumnCount(); i++) {
                columns.add(setMetaData.getColumnLabel(i));
            }
            List<T> objs = new ArrayList<>();
            while (set.next()){
                T obj = type.newInstance();
                for (String p :
                        columns) {
                    Field fP = type.getClass().getField(p);
                    fP.setAccessible(true);
                    fP.set(obj, set.getObject(p));
                }
                objs.add(obj);
            }
            return objs;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
