package com.example.asset.service.impl;

import com.example.asset.dto.AssetDTO;
import com.example.asset.dto.UserDTO;
import com.example.asset.service.IUserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class inputFile {
    ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    static DataFormatter dataFormatter = new DataFormatter();
    final UserService userService;
    final AssetService assetService;

    inputFile(UserService userService, AssetService assetService) {
        this.userService = userService;
        this.assetService = assetService;
        //scheduledExecutorService.scheduleAtFixedRate(this::job, 0, 5, TimeUnit.MILLISECONDS);
    }

    private void job() {
        try {
            final String excelFile = "C:\\Users\\Admin\\Desktop\\javaweb\\setup\\asset.xlsx";
            final List<AssetDTO> assetDTOS = readExcel(excelFile);
            for (AssetDTO asset : assetDTOS) {
                assetService.insert(asset);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    private Runnable insertUser(UserDTO user) {
        return () -> {
            try {
                if (user.getLevel() == null) {
                    user.setLevel(1);
                }
                userService.insert(user);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static List<AssetDTO> readExcel(String excelFile) throws IOException {
        List<AssetDTO> list = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = datatypeSheet.iterator();
            Row firstRow = iterator.next();
            Cell firstCell = firstRow.getCell(0);
            System.out.println(firstCell.getStringCellValue());
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                AssetDTO assetDTO = new AssetDTO();
                list.add(setValueAsset(assetDTO, currentRow));
            }
            return list;
        } catch (Exception exception) {
            throw new RemoteException(exception.getMessage());
        }
    }

    private static AssetDTO setValueAsset(AssetDTO assetDTO, Row currentRow) {
        try {
            assetDTO.setNewAccessTagId(dataFormatter.formatCellValue(currentRow.getCell(0)));
            assetDTO.setOldAccessTagId(dataFormatter.formatCellValue(currentRow.getCell(1)));
            assetDTO.setAssetNameModel(dataFormatter.formatCellValue(currentRow.getCell(2)));
            assetDTO.setQuantity(1);
            assetDTO.setUnitOfMeasurement(dataFormatter.formatCellValue(currentRow.getCell(4)));
            assetDTO.setAssetType(dataFormatter.formatCellValue(currentRow.getCell(5)));
            assetDTO.setUserId(81L);
            assetDTO.setDay(dataFormatter.formatCellValue(currentRow.getCell(11)));
            assetDTO.setInventory(dataFormatter.formatCellValue(currentRow.getCell(12)));
            assetDTO.setStatus(dataFormatter.formatCellValue(currentRow.getCell(13)));
            assetDTO.setMac(dataFormatter.formatCellValue(currentRow.getCell(14)));
            assetDTO.setServiceProvider(dataFormatter.formatCellValue(currentRow.getCell(15)));
            assetDTO.setStatusUpdate(dataFormatter.formatCellValue(currentRow.getCell(16)));
            LocalDate localDate = currentRow.getCell(17).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            assetDTO.setPurchaseDate(localDate);
            assetDTO.setLevel(dataFormatter.formatCellValue(currentRow.getCell(18)));
            assetDTO.setExpectedLifeCycle(dataFormatter.formatCellValue(currentRow.getCell(19)));
            assetDTO.setOriginalCost(dataFormatter.formatCellValue(currentRow.getCell(20)));
            assetDTO.setDepreciationValue(dataFormatter.formatCellValue(currentRow.getCell(21)));
            assetDTO.setRemainingAssetValue(dataFormatter.formatCellValue(currentRow.getCell(22)));
            assetDTO.setExpiredLifeCycleDate(dataFormatter.formatCellValue(currentRow.getCell(23)));
            assetDTO.setAccount(dataFormatter.formatCellValue(currentRow.getCell(24)));
            assetDTO.setSapId(dataFormatter.formatCellValue(currentRow.getCell(25)));
            return assetDTO;
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    private static UserDTO setValueUser(UserDTO userDTO, Row currentRow) {
        userDTO.setFullName(currentRow.getCell(0).getStringCellValue());
        userDTO.setUsername(currentRow.getCell(1).getStringCellValue());
        userDTO.setSite(currentRow.getCell(2).getStringCellValue());
        userDTO.setLocation(currentRow.getCell(3).getStringCellValue());
        userDTO.setJobPosition(currentRow.getCell(4).getStringCellValue());
        userDTO.setStatus("ACTIVE");
        userDTO.setLevel(1);
        userDTO.setEmail(currentRow.getCell(8).getStringCellValue());
        return userDTO;
    }
}
