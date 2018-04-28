package spring.dao;

import java.util.List;

import org.hibernate.*;
import org.slf4j.*;
import org.springframework.stereotype.Repository;

import spring.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {

        private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

        private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

        @Override
        public void addBook(Book b) {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(b);
            logger.info("Book saved successfully, Book details="+b);
        }

        @Override
        public void updateBook(Book b) {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(b);
            logger.info("Book updated successfully, Book details="+b);
        }

        @SuppressWarnings("unchecked")
        @Override
        public List<Book> listBooks() {
            Session session = this.sessionFactory.getCurrentSession();
            List<Book> personsList = session.createQuery("from Person").list();
            for(Book p : personsList){
                logger.info("Person List::"+p);
            }
            return personsList;
        }

        @Override
        public Book getBookById(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Book b = (Book) session.load(Book.class, new Integer(id));
            logger.info("Book loaded successfully, Book details="+b);
            return b;
        }

        @Override
        public void removeBook(int id) {
            Session session = this.sessionFactory.getCurrentSession();
            Book b = (Book) session.load(Book.class, new Integer(id));
            if(null != b){
                session.delete(b);
            }
            logger.info("Book deleted successfully, person details="+b);
        }
}
