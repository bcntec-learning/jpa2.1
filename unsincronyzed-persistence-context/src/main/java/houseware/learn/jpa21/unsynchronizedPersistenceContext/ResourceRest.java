package houseware.learn.jpa21.unsynchronizedPersistenceContext;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.Serializable;
import java.util.List;

@Path("rest")
@Produces("text/json")
@SessionScoped
public class ResourceRest implements Serializable {
    @EJB
    private Controller controller;


    @GET
    @Path("parent/list")
    public List<Parent> list() {
        return controller.parentList();
    }

    @GET
    @Path("parent/{parent}/add")
    public Parent parentAdd(@PathParam("parent") String parent ) {
        return controller.parentAdd(parent);
    }
    @GET
    @Path("parent/{parent}/remove")
    public Parent parentRemove(@PathParam("parent") String parent ){
        return controller.parentRemove(parent);
    }

    @GET
    @Path("parent/{parent}/{child}/add")
    public Parent childAdd(@PathParam("parent") String parent, @PathParam("child") String child ) {
        return controller.childAdd(parent, child);
    }
    @GET
    @Path("parent/{parent}/{child}/remove")
    public Parent childRemove(@PathParam("parent") String parent, @PathParam("child") String child  ){
        return controller.childRemove(parent, child);
    }



    @GET
    @Path("myCommit")
    public void commit() {
        controller.myCommit();
    }

    @PreDestroy
    public void preDestroy() {

    }
}
