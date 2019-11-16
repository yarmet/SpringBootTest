package repositories;

import entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}