package com.guner.repository;

import com.guner.entity.Product;
import com.guner.entity.User;
import jakarta.persistence.LockModeType;
import org.hibernate.annotations.OptimisticLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Optional<Product> findByTitleAndPrice(String title, int price);

    // yukarıdaki satır ile aynı işi yapar
    @Query("select p from Product p where p.title = ?1 and p.price = ?2")
    Optional<Product> findByTitleAndPrice(String title, int price);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Product p where p.id = :id")
    Optional<Product> findByIdWithLocked(@Param("id") Long id);

    /*
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    bu kayıt için başka sessionda update yapılamaz
    normal select yapılabilir
    locklı select, for no key update veya for share yapılamaz.

    select
        p1_0.id,
        p1_0.description,
        p1_0.price,
        p1_0.title
    from
        product p1_0
    where
        p1_0.id=? for no key update
     */

    /*
    @Lock(LockModeType.PESSIMISTIC_READ)
    bu kayıt için başka sessionda update yapılamaz
    normal select yapılabilir
    locklı select, for no key update yapılamaz.  for share  yapılabilir


    select
        p1_0.id,
        p1_0.description,
        p1_0.price,
        p1_0.title
    from
        product p1_0
    where
        p1_0.id=? for share
     */


}
