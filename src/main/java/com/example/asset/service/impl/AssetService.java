package com.example.asset.service.impl;

import com.example.asset.dto.AssetDTO;
import com.example.asset.entity.AssetEntity;
import com.example.asset.mapper.AssetMapper;
import com.example.asset.repository.AssetRepository;
import com.example.asset.service.IAssetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AssetService implements IAssetService {

    AssetRepository assetRepository;

    AssetMapper assetMapper;

    @Override
    public AssetDTO insert(AssetDTO assetDTO) {
        return assetMapper.toDTO(assetRepository.save(assetMapper.toEntity(assetDTO)));
    }

    @Override
    public AssetDTO update(AssetDTO assetDTO) {
        return assetMapper.toDTO(assetRepository.save(assetMapper.toEntity(assetDTO)));
    }

    @Override
    public void delete(List<Long> ids) {
        assetRepository.deleteAllById(ids);
    }

    @Override
    public AssetDTO findById(Long id) {
        AssetEntity asset = assetRepository.findById(id).orElseThrow(NullPointerException::new);
        return assetMapper.toDTO(asset);
    }

    @Override
    public List<AssetDTO> findAll() {
        return assetRepository.findAll().stream().map(assetMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<AssetDTO> findAll(Pageable pageable) {
        return assetRepository.findAll(pageable).map(assetMapper::toDTO);
    }

    @Override
    public Page<AssetDTO> search(Pageable pageable, String search) {
        return assetRepository.searchAsset(pageable, search).map(assetMapper::toDTO);
    }
}
