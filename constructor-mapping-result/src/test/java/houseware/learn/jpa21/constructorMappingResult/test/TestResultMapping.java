package houseware.learn.jpa21.constructorMappingResult.test;

import houseware.learn.jpa21.constructorMappingResult.Author;
import houseware.learn.jpa21.constructorMappingResult.Book;
import houseware.learn.jpa21.constructorMappingResult.Queries;
import houseware.learn.jpa21.constructorMappingResult.TotalBook;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
@RunWith(Arquillian.class)
@Slf4j
public class TestResultMapping {

    @PersistenceContext
    private EntityManager em;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive j = ShrinkWrap
                .create(JavaArchive.class)
                .addClasses(Author.class, Book.class, Queries.class, TotalBook.class)
                .addAsManifestResource("META-INF/persistence.xml",
                        "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("META-INF/orm.xml",
                        "orm.xml");
         log.info(j.toString(true));
        return j;
    }






    @Test
    @UsingDataSet("data/test.yml")
    public void query_with_book_and_author_without_entity_mapping() {

        List<Object[]> results = this.em.createNativeQuery(
                "SELECT b.id, b.title, b.author_id, b.version, a.id as authorId, a.firstName, a.lastName, a.version as authorVersion "+
                        "FROM Book b JOIN Author a ON b.author_id = a.id").getResultList();
        results.stream().forEach((record) -> {
            System.out.println("Author: ID [" + record[3] + "] firstName [" + record[4]
                    + "] lastName [" + record[5] + "] Book: ID [" + record[0] + "] Title [" + record[1] + "]");

        });
    }
    @Test
    @UsingDataSet("data/test.yml")
    public void query_with_author_with_entity_mapping() {

        List<Author> results = this.em.createNativeQuery(
                "SELECT a.id as authorId, a.firstName, a.lastName, a.version  "+
                        "FROM Author a  ", Author.class).getResultList();
        results.stream().forEach((record) -> {
            System.out.println("Author: ID [" + record.getId() + "] firstName [" + record.getFirstName()
                    + "] lastName [" + record.getLastName() + "]");

        });
    }


//
//
//
//
//


    @Test
    @UsingDataSet("data/test.yml")
    public void query_with_author_book_entity_mapping() {
        List<Object[]> results = this.em.createNativeQuery(
                "SELECT b.id, b.title, b.author_id, b.version, a.id as authorId, a.firstName, a.lastName, a.version as authorVersion " +
                        "FROM Book b JOIN Author a ON b.author_id = a.id", "BookAuthorMapping").getResultList();
        results.stream().forEach((record) -> {
            Book book = (Book) record[0];
            Author author = (Author) record[1];
            System.out.println("Author: ID [" + author.getId() + "] firstName [" + author.getFirstName() + "] lastName [" + author.getLastName() + "]");
            System.out.println("Book: ID [" + book.getId() + "] title[" + book.getTitle() + "] author [" + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() + "]");
        });
    }

    @Test
    @UsingDataSet("data/test.yml")
    public void query_with_AuthorBookEntityXmlMapping() {
        List<Object[]> results = this.em.createNativeQuery(
                "SELECT b.id, b.title, b.author_id, b.version, a.id as authorId, a.firstName, a.lastName, a.version as authorVersion " +
                        "FROM Book b JOIN Author a ON b.author_id = a.id", "BookAuthorMappingXml").getResultList();
        results.stream().forEach((record) -> {
            Book book = (Book) record[1];
            Author author = (Author) record[0];
            System.out.println("Author: ID [" + author.getId() + "] firstName [" + author.getFirstName() + "] lastName [" + author.getLastName() + "]");
            System.out.println("Book: ID [" + book.getId() + "] title[" + book.getTitle() + "]");
        });
    }

    @Test
    @UsingDataSet("data/test.yml")
    public void namedquery_with_author_book_entity_mapping() {
//        List<Object[]> results = this.em.createNamedQuery("BookAuthor", "BookAuthorMapping").getResultList();
        List<Object[]> results = this.em.createNamedQuery("BookAuthor").getResultList();
        results.stream().forEach((record) -> {
            Book book = (Book) record[0];
            Author author = (Author) record[1];
            System.out.println("Author: ID [" + author.getId() + "] firstName [" + author.getFirstName() + "] lastName [" + author.getLastName() + "]");
            System.out.println("Book: ID [" + book.getId() + "] title[" + book.getTitle() + "] author [" + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() + "]");
        });
    }

    @Test
    @UsingDataSet("data/test.yml")
    public void namedquery_with_author_book_entity_xml_mapping() {
//        List<Object[]> results = this.em.createNamedQuery("BookAuthor", "BookAuthorMappingXml").getResultList();
        List<Object[]> results = this.em.createNamedQuery("BookAuthor").getResultList();
        results.stream().forEach((record) -> {
            Book book = (Book) record[0];
            Author author = (Author) record[1];
            System.out.println("Author: ID [" + author.getId() + "] firstName [" + author.getFirstName() + "] lastName [" + author.getLastName() + "]");
            System.out.println("Book: ID [" + book.getId() + "] title[" + book.getTitle() + "]");
        });
    }



    @Test
    @UsingDataSet("data/test.yml")
    public void query_autor_total_without_totalbean() {
        List<Object[]> results = this.em.createNamedQuery("AuthorBookCountXml").getResultList();
        results.stream().forEach((record) -> {
            Author author = (Author) record[0];
            Long bookCount = (Long) record[1];
            System.out.println("Author: ID [" + author.getId() + "] firstName [" + author.getFirstName() + "] lastName [" + author.getLastName() + "] number of books [" + bookCount + "]");
        });
    }

    @Test
    @UsingDataSet("data/test.yml")
    public void query_autor_total_with_totalbean() {
        List<TotalBook> results = this.em.createNamedQuery("TotalBookMappingXml").getResultList();
        results.stream().forEach((record) -> {

                    System.out.println("Author: ID [" + record.getId() + "] firstName [" + record.getFirstName() + "] lastName [" + record.getLastName() + "] number of books [" + record.getTotal() + "]");
        });
    }

}