package com.Niek125.datadapterlibrary;

import com.Niek125.dataadapterlibrary.DataBase.DataBase;
import com.Niek125.dataadapterlibrary.MySQLDataBaseBuilder;
import org.junit.Test;

import java.util.List;

public class DataBaseTests {
    @Test
    public void runTest(){
        MySQLDataBaseBuilder builder = new MySQLDataBaseBuilder("jdbc:mysql://127.0.0.1/subpartservice", "root", "");
        DataBase db = builder.getDataBase();
        db.queryBuilder().storedProcedure("Test");
        List<SubPart> s = db.executeReturnQuery(SubPart.class);
        for (SubPart st :
                s) {
            System.out.println(st.getDesc());
        }
    }
}
