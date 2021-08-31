package com.springboottest.Service;

import com.springboottest.Dao.BookDao;
import com.springboottest.pojo.Book;
import com.springboottest.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user:lufei
 * DATE:2021/8/18
 **/
@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    @Autowired
    CategoryService categoryService;

    public List<Book> list(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book){
        bookDao.save(book);
    }

    public void deleteById(int id){
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }

    public List<Book> search(String keyword){
        return bookDao.findAllByTitleLikeOrAuthorLike('%'+keyword+'%','%'+keyword+'%');
    }
}
