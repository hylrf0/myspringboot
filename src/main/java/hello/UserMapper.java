package hello;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by linrufeng on 2017/3/31.
 */
@Mapper
@Repository
public interface UserMapper {

    User selectUser(Integer id);
    User selectAllUsers();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
