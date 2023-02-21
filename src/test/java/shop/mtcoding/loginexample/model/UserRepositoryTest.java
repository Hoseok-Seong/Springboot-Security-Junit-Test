package shop.mtcoding.loginexample.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

// Transactional이 내부 어노테이션 되어 있음.
@MybatisTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findById_test() throws Exception {
        // given
        int id = 1;

        assertNotNull(id);
        assertNotEquals(0, id);

        // when
        User user = userRepository.findById(id);

        // then
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getUsername()).isEqualTo("ssar");
        assertThat(user.getPassword()).isEqualTo("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
    }

    @Test
    public void findAll_test() throws Exception {
        // given

        // when
        List<User> user = userRepository.findAll();

        // then
        assertThat(user.get(0).getUsername()).isEqualTo("ssar");
        assertThat(user.get(1).getUsername()).isEqualTo("cos");

    }

    @Test
    public void findByUsernameAndPassword_test() throws Exception {
        // given
        String username = "ssar";
        String password = "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4";

        assertNotNull(username);
        assertFalse(username.isEmpty());
        assertNotNull(password);
        assertFalse(password.isEmpty());

        // when
        User user = userRepository.findByUsernameAndPassword(username, password);

        // then
        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getUsername()).isEqualTo("ssar");
        assertThat(user.getPassword()).isEqualTo("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
    }
}
