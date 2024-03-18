package com.guner.service;

import com.guner.entity.Product;
import com.guner.entity.UuidTest;
import com.guner.repository.ProductRepository;
import com.guner.repository.UuidTestRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UuidTestService {

    private UuidTestRepository uuidTestRepository;

    public UuidTest getUuidById(UUID uuid) {
        Optional<UuidTest> optionalUuidTest = uuidTestRepository.findById(uuid);
        return optionalUuidTest.get();
    }

    public UuidTest getUuidByDetailId(UUID uuid) {
        Optional<UuidTest> optionalUuidTest = uuidTestRepository.findByDetailId(uuid);
        return optionalUuidTest.get();
    }

    public UuidTest findByDetailByStringDetailId(String uuidString) {
        Optional<UuidTest> optionalUuidTest = uuidTestRepository.findByDetailByStringDetailId(uuidString);
        return optionalUuidTest.get();
    }

    public List<UuidTest> findByDetailByUuidNotUuidNill() {
        return uuidTestRepository.findByDetailByUuidNotUuidNill();
    }

    public List<UuidTest> getAllUuids() {
        return uuidTestRepository.findAll();
    }

}
