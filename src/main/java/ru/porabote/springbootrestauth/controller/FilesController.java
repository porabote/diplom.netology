package ru.porabote.springbootrestauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.porabote.springbootrestauth.model.FileModel;
import ru.porabote.springbootrestauth.service.FileService;

import java.io.IOException;
import java.util.Map;

@Controller
public class FilesController {

    @PostMapping(path="/file")
    public @ResponseBody String addFile (@RequestParam String filename, @RequestParam MultipartFile file) throws IOException {

        FileService.add(file, filename);
        return "Saved";
    }

    @DeleteMapping(path="/file")
    public @ResponseBody String deleteFile (@RequestParam String filename) throws IOException {
        FileService.delete(filename);
        return "Deleted";
    }

//    @GetMapping(path="/file")
//    public @ResponseBody FileModel download(@RequestParam String filename) {
//        return fileRepository.findFirstByFilename(filename);
//    }

    @PutMapping(path="/file")
    public @ResponseBody String edit(@RequestBody Map<String, String> payload, @RequestParam(name="filename") String oldName) {
        String newName = payload.get("filename");
        FileModel f = FileService.edit(oldName, newName);
        return f.getFilename();
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<FileModel> getAllUsers() {
        return FileService.get();
    }
}