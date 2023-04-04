package com.jetbrains.marco.photoz.clone.web;

import com.jetbrains.marco.photoz.clone.service.PhotozService;
import com.jetbrains.marco.photoz.clone.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class photozController {

    final private PhotozService photozService;
    public photozController(PhotozService photozService) {
        this.photozService = photozService;
    }
    @GetMapping("/")
    public String hello(){
        return "Hello World!" ;
    }
    @GetMapping("/Photoz")
    public Iterable<Photo> get(){
    return photozService.get();
    }

  @GetMapping("/Photoz/{id}")
  public Photo get(@PathVariable Integer id){
    Photo photo =  photozService.get(id);
    if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return photo;
  }
  @DeleteMapping("/Photoz/{id}")
  public void delete(@PathVariable Integer id){
     photozService.remove(id);
  }
  @PostMapping("/Photoz")
 // @PostMapping(value = "/Photoz", consumes = "multipart/form-data")
  public Photo create(@RequestPart ("data") MultipartFile file) throws IOException {
      System.out.println("Ab photo upload hoga");
     return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
  }
}
