package study.springbootrestfulapi.user;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private final static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new User(1, "curl", new Date(), "password1", "701010-1111111"));
        users.add(new User(2, "linux", new Date(), "password1", "801010-2222222"));
        users.add(new User(3, "ms", new Date(), "password1", "901010-1111111"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public User save(User user) {
        if (user.getId() == null) user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return  null;
    }

    public User updateUser(User updateUser) {
        for (User user : users) {
            if (user.getId().equals(updateUser.getId()) && StringUtils.hasText(updateUser.getName())) {
                user.setName(updateUser.getName());
                return user;
            }
        }
        return null;
    }
}
