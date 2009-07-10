package pangora;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;


public class App {
   private static final String ADDRESS = "localhost:11211";

   public static void main( String[] args ) throws IOException {
      MemcachedClient client = new MemcachedClient(AddrUtil.getAddresses(ADDRESS));
      try {
         SomeBean bean = new SomeBean();
         bean.id = UUID.randomUUID();
         bean.date = new Date();
         bean.interval = new Date[] {new Date(123), new Date(456)};
   
         final String id = bean.id.toString();
         client.set(id, 0, bean);
   
         SomeBean copy = (SomeBean)client.get(id);
         assert bean.equals(copy);

      } finally {
         client.shutdown();
      }
   }
}
