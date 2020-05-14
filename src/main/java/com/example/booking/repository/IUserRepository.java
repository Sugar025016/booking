package com.example.booking.repository;

import com.example.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Override
    User getOne(Integer id);

    boolean existsByAccount(String account);

    Optional<User> findByAccount(String account);

    @Query(value = "DELETE order_history_user FROM order_history " +
            "JOIN order_history_user ON order_history.id=order_history_user.order_history_id WHERE order_history.group_id=:groupId AND order_history_user.user_id=:userId AND (order_history.order_id = :orderId OR :orderId IS NUll )", nativeQuery = true)
    void deleteOrderHistory(@Param("orderId") Integer orderId, @Param("groupId") int groupId, @Param("userId") int userId);


}
