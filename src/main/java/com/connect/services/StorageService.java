
package com.connect.services;

import com.connect.exceptions.FileNotFoundException;
import com.connect.exceptions.StorageException;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
    
    @Value("${storage.location}")
    private String storageLocation;
    
    @PostConstruct
    public void starFileStorage(){
        try {
            Files.createDirectories(Paths.get(storageLocation));
        } catch (IOException exception) {
            throw new StorageException("Error initializing file store location");
        }
    }
    
    public String storageFile(MultipartFile file){
        String fileName = file.getOriginalFilename();
        if(file.isEmpty()){
            throw new StorageException("Cannot storage an empty file");
        }
        try{
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, Paths.get(storageLocation).resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException exception){
            throw new StorageException("Error saving file " + fileName, exception);
        }
        
        return fileName;
    }
    
    public Path loadFile(String fileName){
        return Paths.get(storageLocation).resolve(fileName);
    }
    
    public Resource loadAsResource(String fileName){
        try {
            Path file = loadFile(fileName);
            Resource resouce = new UrlResource(file.toUri());
            
            if(resouce.exists() || resouce.isReadable() ){
                return resouce;
            }else{
                throw new FileNotFoundException("Could not find file");
            }
            
        } catch (MalformedURLException exception) {
            throw new FileNotFoundException("Could not find file " + fileName, exception);
        }
    }
    
    public void deleteFile(String fileName){
        Path file = loadFile(fileName);
        try {
            FileSystemUtils.deleteRecursively(file);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
