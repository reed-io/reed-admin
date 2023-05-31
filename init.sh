echo "start admin"
#JVM_OPTIONS="-server -Xms512m -Xmx2g"
#echo "JVM_OPTIONS : "
#echo "$JVM_OPTIONS"

java -jar -Xms1024m -Xmx2048m /home/jboss/reed-admin.jar
#tail -f /rflog/REED-ADMIN.log