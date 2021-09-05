package com.springboottest.Service;

import com.springboottest.Dao.BookDao;
import com.springboottest.Utils.CastUtils;
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
    @Autowired
    RedisService redisService;
    //全部书籍
    public List<Book> list(){
        List<Book> Books;
        String key = "bookList";
        Object bookCache=redisService.get(key);
        if(bookCache==null){
            //缓存中没有则查找数据库
            Sort sort = Sort.by(Sort.Direction.DESC,"id");
            Books = bookDao.findAll(sort);
            redisService.set(key,Books);
        }else {
            //使用工具类进行类型转换
            Books = CastUtils.objectConvertToList(bookCache,Book.class);
        }
        return Books;
    }
    //增加修改书籍
    public void addOrUpdate(Book book){
        bookDao.save(book);
        redisService.delete("bookList");
    }
    //删除书籍
    public void deleteById(int id){
        bookDao.deleteById(id);
        redisService.delete("bookList");
    }
    //通过标签查找书籍
    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
    //书籍查询
    public List<Book> search(String keyword){
        return bookDao.findAllByTitleLikeOrAuthorLike('%'+keyword+'%','%'+keyword+'%');
    }
}
