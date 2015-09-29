package houseware.learn.jpa21.noSql.test;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class NoSQLMongoDBTest extends Assert {

    /**
     * please store Starter or RuntimeConfig in a static final field
     * if you want to use artifact store caching (or else disable caching)
     */
    private static final MongodStarter starter = MongodStarter.getDefaultInstance();

    private static MongodExecutable _mongodExe;
    private static MongodProcess _mongod;

    private static MongoClient _mongo;

    @BeforeClass
    public static void setUp() throws Exception {

        _mongodExe = starter.prepare(new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(12345, Network.localhostIsIPv6()))
                .build());
        _mongod = _mongodExe.start();


        _mongo = new MongoClient("localhost", 12345);
    }


    @AfterClass
    public static void tearDown() throws Exception {

        _mongod.stop();
        _mongodExe.stop();
    }

    public Mongo getMongo() {
        return _mongo;
    }

    @Test
    public void test2() {
    }


  /*
      MongodForTestsFactory factory = null;
      try {
          factory = MongodForTestsFactory.with(Version.Main.PRODUCTION);

          MongoClient mongo = factory.newMongo();
          DB db = mongo.getDB("test-" + UUID.randomUUID());
          DBCollection col = db.createCollection("testCol", new BasicDBObject());
          col.save(new BasicDBObject("testDoc", new Date()));

      } finally {
          if (factory != null)
              factory.shutdown();
      }*/
}
