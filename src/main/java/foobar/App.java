package foobar;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.UUID;

import net.spy.memcached.MemcachedClient;

import com.thimbleware.jmemcached.Cache;
import com.thimbleware.jmemcached.MemCacheDaemon;
import com.thimbleware.jmemcached.storage.hash.LRUCacheStorageDelegate;


public class App {

   private static final InetSocketAddress INET_SOCKET_ADDRESS = new InetSocketAddress("localhost", 11211);
   private static MemCacheDaemon          daemon;
   private static long                    maxBytes            = 2000000;
   private static int                     maxSize             = 100;

   private static void startDaemon() throws IOException {
      daemon = new MemCacheDaemon();
      LRUCacheStorageDelegate cacheStorage = new LRUCacheStorageDelegate(maxSize, maxBytes, 1024000);
      daemon.setCache(new Cache(cacheStorage));
      daemon.setAddr(INET_SOCKET_ADDRESS);
      daemon.setIdleTime(60); // disconnect after idle <x> seconds
      daemon.setVerbose(true);
      daemon.start();
      if ( daemon.isRunning() ) {
         System.out.println("daemon is running");
      } else {
         throw new RuntimeException("WTF?");
      }
   }


   private static void stopDaemon() {
      daemon.stop();
      daemon = null;
   }

   public static void main( String[] args ) throws IOException {

      startDaemon();

      MemcachedClient client = new MemcachedClient(INET_SOCKET_ADDRESS);
      try {
         SomeBean bean = new SomeBean();
         bean.id = UUID.randomUUID();
         bean.date = new Date();
         bean.interval = new Date[] {new Date(123), new Date(456)};

         final String id = bean.id.toString();
         client.set(id, 0, bean);
         System.out.println("set: " + bean.id);

         SomeBean copy = (SomeBean)client.get(id);
         assert bean.equals(copy);
         System.out.println("got: " + copy.id);

      }
      finally {
         client.shutdown();
         stopDaemon();
      }
   }

}
