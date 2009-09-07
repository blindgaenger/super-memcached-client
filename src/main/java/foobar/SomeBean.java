package foobar;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import plaindump.Externalizer;

public class SomeBean extends Externalizer {

   @externalize(0)
   protected UUID id;

   @externalize(1)
   protected Date date;

   @externalize(2)
   protected Date[] interval;

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((date == null) ? 0 : date.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + Arrays.hashCode(interval);
      return result;
   }

   @Override
   public boolean equals( Object obj ) {
      if ( this == obj ) return true;
      if ( obj == null ) return false;
      if ( getClass() != obj.getClass() ) return false;
      SomeBean other = (SomeBean)obj;
      if ( date == null ) {
         if ( other.date != null ) return false;
      } else if ( !date.equals(other.date) ) return false;
      if ( id == null ) {
         if ( other.id != null ) return false;
      } else if ( !id.equals(other.id) ) return false;
      if ( !Arrays.equals(interval, other.interval) ) return false;
      return true;
   }
   
   
}
