package com.springboottest.Controller;

import com.springboottest.Service.BookService;
import com.springboottest.Utils.StringUtils;
import com.springboottest.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/8/18
 **/
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> list(){
        return bookService.list();
    }

    @PostMapping("/books")
    public Book addOrUpdate(@RequestBody Book book){
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }

    @GetMapping("/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int id){
        if(0!=id){
            return bookService.listByCategory(id);
        }else {
            return list();
        }
    }

    @GetMapping("/search")
    public List<Book> searchResult(@RequestParam("keywords") String keyword){
        if("".equals(keyword)){
            return bookService.list();
        }else {
            return bookService.search(keyword);
        }
    }

    @CrossOrigin
    @PostMapping("/covers")
    public String coversUpload(MultipartFile file){
        String folder = "D:/2021/springboot+vue/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(10) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8088/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
