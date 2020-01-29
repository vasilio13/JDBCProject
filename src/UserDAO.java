import java.util.List;

public interface UserDAO {
    List<User> findAllUsers();
    User findUser(Long id);
    void save(User user);
    void remove(Long id);
}
