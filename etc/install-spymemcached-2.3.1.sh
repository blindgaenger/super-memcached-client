wget -o /tmp/memcached-2.3.1.jar http://spymemcached.googlecode.com/files/memcached-2.3.1.jar
wget -o /tmp/memcached-2.3.1-sources.jar http://spymemcached.googlecode.com/files/memcached-2.3.1-sources.zip
wget -o /tmp/memcached-2.3.1-javadoc.jar http://spymemcached.googlecode.com/files/memcached-2.3.1-javadoc.zip

mvn install:install-file -DgroupId=spy -DartifactId=memcached -Dversion=2.3.1 -Dpackaging=jar -DgeneratePom=true -Dfile=/tmp/memcached-2.3.1.jar
mvn install:install-file -DgroupId=spy -DartifactId=memcached -Dversion=2.3.1 -Dpackaging=jar -DgeneratePom=false -Dfile=/tmp/memcached-2.3.1-javadoc.zip -Dclassifier=javadoc
mvn install:install-file -DgroupId=spy -DartifactId=memcached -Dversion=2.3.1 -Dpackaging=jar -DgeneratePom=false -Dfile=/tmp/memcached-2.3.1-sources.jar -Dclassifier=sources
