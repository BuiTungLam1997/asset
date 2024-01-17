package com.example.asset.repository;

import com.example.asset.dto.UserDTO;
import com.example.asset.entity.UserEntity;
import com.example.asset.repository.Filter.Filter;
import com.example.asset.repository.Filter.FilterBuilder;
import com.example.asset.repository.specifications.UserSearch;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    UserSearch userSearch = new UserSearch();

    default Page<UserEntity> search(Pageable pageable, String search) {
        Filter searchUserByUsername = new FilterBuilder()
                .buildField(UserEntity.Fields.fullName)
                .buildOperator(Filter.QueryOperator.LIKE)
                .buildValue(search)
                .build();
        Filter searchUserByFullName = new FilterBuilder()
                .buildField(UserEntity.Fields.username)
                .buildOperator(Filter.QueryOperator.LIKE)
                .buildValue(search)
                .build();
        Specification<UserEntity> specification = userSearch.createSpecification(searchUserByUsername)
                .or(userSearch.createSpecification(searchUserByFullName));
        return findAll(specification, pageable);
    }
}
