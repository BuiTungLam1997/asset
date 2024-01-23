package com.example.asset.repository;

import com.example.asset.entity.AssetEntity;
import com.example.asset.repository.Filter.Filter;
import com.example.asset.repository.Filter.FilterBuilder;
import com.example.asset.repository.specifications.AssetSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AssetRepository extends JpaRepository<AssetEntity, Long>, JpaSpecificationExecutor<AssetEntity> {

    AssetSearch assetSearch = new AssetSearch();

    default Page<AssetEntity> searchAsset(Pageable pageable, String search) {
        Filter searchByNewId = new FilterBuilder()
                .buildField(AssetEntity.Fields.newAccessTagId)
                .buildOperator(Filter.QueryOperator.LIKE)
                .buildValue(search).build();
        Filter searchByNameModel = new FilterBuilder()
                .buildField(AssetEntity.Fields.assetNameModel)
                .buildOperator(Filter.QueryOperator.LIKE)
                .buildValue(search).build();
        Specification<AssetEntity> specification = assetSearch.createSpecification(searchByNewId)
                .or(assetSearch.createSpecification(searchByNameModel));
        return findAll(specification, pageable);
    }
}
