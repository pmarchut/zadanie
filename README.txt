Niestety, nie uda³o mi sie doprowadziæ aplikacji do u¿ytku. Postanowi³em spróbowaæ, ¿eby aplikacja odczytywa³a dane z bazy danych, ale mnie
to przeros³o i zabrak³o mi czasu.
Uda³o siê stworzyæ paczkê zadanie.war. Projekt mo¿na zdeployowaæ do serwera Tomcat. U¿y³em plugina tomcat7-maven-plugin, wiêc raczej trzeba
mieæ pobran¹ w³aœnie wersjê Tomcat7. Nale¿y skonfigurowaæ Tomcata oraz Mavena tak jak pod tym adresem 
(http://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/), upewniæ siê(np. przy instalacji), ¿e bêdzie s³ucha³ portu 8080
i nastêpnie w lini polecen (cmd.exe) wykonaæ komendê (mvn tomcat7:deploy) bed¹c w katalogu /zadanie. Mo¿na te¿ wejœæ pod adres managera 
Tomcata (localhost:8080/manager lub z strony g³ównej),i w sekcji "WAR file to deploy" wybraæ paczkê zadanie.war. Jeœli "uruchomimy" projekt
z lini poleceñ powinien byæ pod adresem(http://localhost:8080/myWebapp), a w drugim wypadku (http://localhost:8080/zadanie). Jeœli wpiszemy
adres np.(http://localhost:8080/myWebapp/books) powinien ukazaæ siê b³¹d:
HTTP Status 500 - Request processing failed; nested exception is org.springframework.transaction.CannotCreateTransactionException: Could 
not open Hibernate Session for transaction; nested exception is org.hibernate.exception.GenericJDBCException: Could not open connection.
Najprawdopodobniej problem jest zwi¹zany z baz¹ dancyh.