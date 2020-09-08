package by.ginko.repository;

        import by.ginko.exception.RepositoryException;
        import by.ginko.repository.paramspecification.Parameter;
        import java.util.List;
        import java.util.Optional;

public interface Repository <T> {
       List<T> query(String sqlString, Parameter parameter) throws RepositoryException;
       Optional<T> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException;
       List<T> findAll() throws RepositoryException;
       Integer save(T object) throws RepositoryException;
}
