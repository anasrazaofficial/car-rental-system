package Mapper;

import java.sql.*;
import java.util.List;

public interface IMapper<T> {
    List<T> resultToList(ResultSet resultSet) throws SQLException;

}
