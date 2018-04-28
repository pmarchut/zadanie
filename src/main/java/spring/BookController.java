package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Book;
import spring.service.BookService;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired(required=true)
    @Qualifier(value="bookService")
    public void setBookService(BookService bs){
        this.bookService = bs;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "book";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book b){

        if(b.getId() == 0){
            this.bookService.addBook(b);
        }
        else{
            this.bookService.updateBook(b);
        }

        return "redirect:/books";

    }

    @RequestMapping(value = "/remove/{id}")
    public String removeBook(@PathVariable("id") int id){

        this.bookService.removeBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "book";
    }
}
