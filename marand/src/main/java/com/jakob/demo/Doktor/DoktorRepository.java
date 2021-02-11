package com.jakob.demo.Doktor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoktorRepository extends CrudRepository<Doktor, Long> {
    public List<Doktor> findById(long id);
}
