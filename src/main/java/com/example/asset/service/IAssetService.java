package com.example.asset.service;

import com.example.asset.dto.AssetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAssetService {
    AssetDTO insert(AssetDTO assetDTO);

    AssetDTO update(AssetDTO assetDTO);

    void delete(List<Long> ids);

    AssetDTO findById(Long id);

    List<AssetDTO> findAll();

    Page<AssetDTO> findAll(Pageable pageable);
    Page<AssetDTO> search(Pageable pageable,String search);

}
