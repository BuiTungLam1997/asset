package com.example.asset.service.impl;

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
import java.util.ArrayList;
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
    final UserService userService;

    inputFile(UserService userService) {
        this.userService = userService;
        //scheduledExecutorService.scheduleAtFixedRate(this::job, 0, 5, TimeUnit.MILLISECONDS);
    }

    private void job() {
        try {
            final String excelFile = "C:\\Users\\Thinkpad\\OneDrive\\Desktop\\File\\TXT\\user.xlsx";
            final List<UserDTO> users = readExcel(excelFile);
            for (UserDTO user : users) {
                userService.insert(user);
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

    public static List<UserDTO> readExcel(String excelFile) throws IOException {
        List<UserDTO> list = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = datatypeSheet.iterator();
            Row firstRow = iterator.next();
            Cell firstCell = firstRow.getCell(0);
            System.out.println(firstCell.getStringCellValue());
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                UserDTO userDTO = new UserDTO();
                userDTO.setFullName(currentRow.getCell(0).getStringCellValue());
                userDTO.setUsername(currentRow.getCell(1).getStringCellValue());
                userDTO.setSite(currentRow.getCell(2).getStringCellValue());
                userDTO.setLocation(currentRow.getCell(3).getStringCellValue());
                userDTO.setJobPosition(currentRow.getCell(4).getStringCellValue());
                userDTO.setStatus("ACTIVE");
                userDTO.setLevel(1);
                userDTO.setEmail(currentRow.getCell(8).getStringCellValue());
                list.add(userDTO);
            }
            return list;
        } catch (Exception exception) {
            throw new RemoteException(exception.getMessage());
        }

    }
}
