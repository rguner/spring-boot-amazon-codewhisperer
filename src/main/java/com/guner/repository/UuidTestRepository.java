package com.guner.repository;

import com.guner.entity.Product;
import com.guner.entity.UuidTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UuidTestRepository extends JpaRepository<UuidTest, UUID> {

    @Query("SELECT uuidTest FROM UuidTest uuidTest WHERE uuidTest.detailId=?1")
    Optional<UuidTest> findByDetailId(UUID detailId);

    // @Query("SELECT uuidTest FROM UuidTest uuidTest WHERE uuidTest.detailId=?1") need to cast as UUID
    @Query("SELECT uuidTest FROM UuidTest uuidTest WHERE uuidTest.detailId=cast(?1 as uuid)")
    Optional<UuidTest> findByDetailByStringDetailId(String detailId);

    //@Query("SELECT uuidTest FROM UuidTest uuidTest WHERE uuidTest.detailId!=cast(public.uuid_nil() as uuid)")
    @Query("SELECT uuidTest FROM UuidTest uuidTest WHERE uuidTest.detailId!=public.uuid_nil()")
    List<UuidTest> findByDetailByUuidNotUuidNill();
}
