package houseware.learn.jpa21.constructorMappingResult;

/**
 * @author fphilip@houseware.es
 */

import javax.persistence.*;

@NamedNativeQueries({
        @NamedNativeQuery (name="BookAuthor", resultSetMapping = "BookAuthorMapping",
                query="SELECT b.id, b.title, b.author_id, b.version, a.id as authorId, a.firstName, a.lastName, a.version as authorVersion " +
                        "FROM Book b JOIN Author a ON b.author_id = a.id") ,
        @NamedNativeQuery (name="AuthorBookCount",
                query="SELECT a.id, a.firstName, a.lastName, a.version, count(b.id) as bookCount " +
                        "FROM Book b JOIN Author a ON b.author_id = a.id GROUP BY a.id, a.firstName, a.lastName, a.version"),
        @NamedNativeQuery (name="AuthorBookCountXml",  resultSetMapping = "AuthorBookCountMappingXml",
                query="SELECT a.id, a.firstName, a.lastName, a.version, count(b.id) as bookCount " +
                        "FROM Book b JOIN Author a ON b.author_id = a.id GROUP BY a.id, a.firstName, a.lastName, a.version")})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "BookAuthorMapping",
                entities = {
                        @EntityResult(
                                entityClass = Book.class,
                                fields = {
                                        @FieldResult(name = "id", column = "id"),
                                        @FieldResult(name = "title", column = "title"),
                                        @FieldResult(name = "author", column = "author_id"),
                                        @FieldResult(name = "version", column = "version")}),
                        @EntityResult(
                                entityClass = Author.class,
                                fields = {
                                        @FieldResult(name = "id", column = "authorId"),
                                        @FieldResult(name = "firstName", column = "firstName"),
                                        @FieldResult(name = "lastName", column = "lastName"),
                                        @FieldResult(name = "version", column = "authorVersion")})}),

})
@MappedSuperclass
public class Queries {

}
