wget -N -O /tmp/jmemcached-parent-0.8.pom http://thimbleware.com/maven/com/thimbleware/jmemcached/jmemcached-parent/0.8/jmemcached-parent-0.8.pom

wget -N -O /tmp/jmemcached-core-0.8.jar http://thimbleware.com/maven/com/thimbleware/jmemcached/jmemcached-core/0.8/jmemcached-core-0.8.jar
wget -N -O /tmp/jmemcached-core-0.8-sources.jar http://thimbleware.com/maven/com/thimbleware/jmemcached/jmemcached-core/0.8/jmemcached-core-0.8-sources.jar
wget -N -O /tmp/jmemcached-core-0.8-javadoc.jar http://thimbleware.com/maven/com/thimbleware/jmemcached/jmemcached-core/0.8/jmemcached-core-0.8-javadoc.jar
wget -N -O /tmp/jmemcached-core-0.8.pom http://thimbleware.com/maven/com/thimbleware/jmemcached/jmemcached-core/0.8/jmemcached-core-0.8.pom

mvn install:install-file -DgroupId=com.thimbleware.jmemcached -DartifactId=jmemcached-parent -Dversion=0.8 -Dpackaging=jar -DpomFile=/tmp/jmemcached-parent-0.8.pom -Dfile=/dev/null
mvn install:install-file -DgroupId=com.thimbleware.jmemcached -DartifactId=jmemcached-core -Dversion=0.8 -Dpackaging=jar -DpomFile=/tmp/jmemcached-core-0.8.pom -Dfile=/tmp/jmemcached-core-0.8.jar
mvn install:install-file -DgroupId=com.thimbleware.jmemcached -DartifactId=jmemcached-core -Dversion=0.8 -Dpackaging=jar -DgeneratePom=false -Dfile=/tmp/jmemcached-core-0.8-javadoc.jar -Dclassifier=javadoc
mvn install:install-file -DgroupId=com.thimbleware.jmemcached -DartifactId=jmemcached-core -Dversion=0.8 -Dpackaging=jar -DgeneratePom=false -Dfile=/tmp/jmemcached-core-0.8-sources.jar -Dclassifier=sources
