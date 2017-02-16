package io.redspark.repository;

import io.redspark.domain.FacebookLocal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacebookRepository extends JpaRepository<FacebookLocal, Long> {

}
