package by.ginko.builder;

import by.ginko.exception.RepositoryException;
import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
