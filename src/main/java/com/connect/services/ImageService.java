
package com.connect.services;

import com.connect.entities.Image;
import com.connect.repositories.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
    
    @Autowired
    private ImageRepository imaRepo;
    
    @Transactional
    public Image guardar(MultipartFile img) {

        if (img != null) {
            try {
                Image imagen = new Image();
                imagen.setMime(img.getContentType());
                imagen.setNombre(img.getName());
                imagen.setContenido(img.getBytes());

                return imaRepo.save(imagen);

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    
}
