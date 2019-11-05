package com.Niek125.dataadapterlibrary.Mapper;

import java.sql.ResultSet;
import java.util.List;

public interface IObjectMapper {
    <T> List<T> map(ResultSet set, Class<T> type);
}
