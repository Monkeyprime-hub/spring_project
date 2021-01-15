package com.example.soulmate.repo;

import com.example.soulmate.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByFirstNameAndAgeTest() {
        assertTrue(!userRepository.findAll().iterator().hasNext());
        User user = userRepository.save(new User(1L, "V", "V", "V", 13));
        assertTrue(userRepository.findByFirstNameAndAge("V", 13).get().getIdUser().equals(user.getIdUser()));
    }


    @Test
    public void findAll() {
        assertTrue(!userRepository.findAll().iterator().hasNext());
        userRepository.save(new User(1L, "V", "V", "V", 13));
        userRepository.save(new User(2L, "N", "N", "N", 14));
        userRepository.save(new User(3L, "Z", "Z", "Z", 15));

        assertTrue(StreamSupport.stream(userRepository.findAll().spliterator(), false).count() == 3);
    }

    @Test
    public void saveNewUser() {
        assertTrue(!userRepository.findAll().iterator().hasNext());
        User user1 = userRepository.save(new User(1L, "V", "V", "V", 13));
        User user2 = userRepository.save(new User(2L, "N", "N", "N", 14));

        assertTrue(userRepository.save(user1).getFirstName().equals("V"));
        assertFalse(userRepository.save(user1).getAge() == (1));


    }

}