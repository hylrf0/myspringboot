package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by linrufeng on 2017/3/31.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @Transactional
    public User add(@RequestParam(value = "id", required = true) Integer id,
                    @RequestParam(value = "username", required = true) String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        userMapper.insertUser(user);
        throw new RuntimeException();
//        return user;
    }

    @RequestMapping(value = "/query.do", method = RequestMethod.GET)
    public User query(@RequestParam(value = "id", required = true) Integer id) {
        return  userMapper.selectUser(id);
    }
}
