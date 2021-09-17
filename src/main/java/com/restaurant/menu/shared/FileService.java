package com.restaurant.menu.shared;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileService {

    public byte[] convertBase64ToByte(String fileBase64){
        byte[] bytes = Base64.getDecoder().decode(fileBase64);
        return bytes;
    }

    public String writeToFile(byte[] bytes,String IdForFolder) throws IOException {
        String fileName = createUUID();
        String filePath = "picture-storage/";

        if (IdForFolder != null){

            filePath = filePath + IdForFolder + "/";

            File folder = new File(filePath);
            boolean folderExists = folder.exists() && folder.isDirectory();
            if (!folderExists) {
                folder.mkdir();
            }
        }

        File file = new File(filePath + fileName);
        OutputStream outputStream = new FileOutputStream(file);

        outputStream.write(bytes);
        outputStream.close();

        return fileName;
    }

    public String createUUID(){

        String fileName = UUID.randomUUID().toString().replace("-","");
        return fileName;
    }

    public String convertAndWriteBase64ToFile(String base64){
        String fileName = null;
        try {
            fileName = writeToFile(convertBase64ToByte(base64),null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    public String convertAndWriteBase64ToFile(String base64,String IdForDirectory){
        String fileName = null;
        try {
            fileName = writeToFile(convertBase64ToByte(base64),IdForDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    public  void deleteFile(String fileName,String idForFolder)  {
        if (fileName == null){
            return;
        }
        String filePath = "picture-storage/";

        if (idForFolder != null){
            filePath = filePath + idForFolder + "/";
        }
        try {
            Files.deleteIfExists(Paths.get(filePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
