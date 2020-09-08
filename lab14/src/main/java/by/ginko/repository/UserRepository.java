package by.ginko.repository;

import by.ginko.builder.UserBuilder;
import by.ginko.exception.RepositoryException;
import by.ginko.model.User;
import by.ginko.repository.dbconstants.UserTableConstants;
import by.ginko.repository.paramspecification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository  extends AbstractRepository <User>{

    public UserRepository(Connection connection){
        super(connection);
    }

    @Override
    protected String getTableName() {
        return SQLHelper.USER_TABLE;
    }


    @Override
    public List<User> query(String sqlString, Parameter paramater) throws RepositoryException {

        List<User> users = executeQuery(sqlString,new UserBuilder(), paramater.getParameters());
        return users;
    }

    @Override
    public Optional<User> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException {
        List<User> user = query(sqlString, parameter);
        return user.size() == 1 ?
                Optional.of(user.get(0)) :
                Optional.empty();
    }

    public Map<String,Object> getFields(User user) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(UserTableConstants.LOGIN.getFieldName(), user.getLogin());
        fields.put(UserTableConstants.PASSWORD.getFieldName(), user.getPassw());
        return fields;
    }
}
