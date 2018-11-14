package bcntec.learning.jpa21.generatingDbSchema.test;

import org.junit.Test;

import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * @author francisco.philip@gmail.com
 */
public class SchemaGenerationTest {


    @Test
    public void simple() {
        schema("jpa21:simple");
    }

    @Test
    public void collections() {
        schema("jpa21:collections");
    }

    @Test
    public void relations() {
        schema("jpa21:relations");
    }

    @Test
    public void secondary_table() {
        schema("jpa21:secondary-table");
    }

    @Test
    public void inheritance() {
        schema("jpa21:inheritance");
    }


    @Test
    public void polymorphic() {
        schema("jpa21:polymorphic");
    }

    private void schema(String pu) {

        Map<String, Object> p = new HashMap<>();

        p.put("javax.persistence.schema-generation.database.action", "drop-and-create");
        p.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
        p.put("javax.persistence.schema-generation.scripts.drop-target", "./target/" + pu.replace(':','_') + ".ddl");
        p.put("javax.persistence.schema-generation.scripts.create-target", "./target/" + pu.replace(':','_') + ".ddl");

         Persistence.generateSchema(pu, p);

    }
}
