Niestety, nie uda�o mi sie doprowadzi� aplikacji do u�ytku. Postanowi�em spr�bowa�, �eby aplikacja odczytywa�a dane z bazy danych, ale mnie
to przeros�o i zabrak�o mi czasu.
Uda�o si� stworzy� paczk� zadanie.war. Projekt mo�na zdeployowa� do serwera Tomcat. U�y�em plugina tomcat7-maven-plugin, wi�c raczej trzeba
mie� pobran� w�a�nie wersj� Tomcat7. Nale�y skonfigurowa� Tomcata oraz Mavena tak jak pod tym adresem 
(http://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/), upewni� si�(np. przy instalacji), �e b�dzie s�ucha� portu 8080
i nast�pnie w lini polecen (cmd.exe) wykona� komend� (mvn tomcat7:deploy) bed�c w katalogu /zadanie. Mo�na te� wej�� pod adres managera 
Tomcata (localhost:8080/manager lub z strony g��wnej),i w sekcji "WAR file to deploy" wybra� paczk� zadanie.war. Je�li "uruchomimy" projekt
z lini polece� powinien by� pod adresem(http://localhost:8080/myWebapp), a w drugim wypadku (http://localhost:8080/zadanie). Je�li wpiszemy
adres np.(http://localhost:8080/myWebapp/books) powinien ukaza� si� b��d:
HTTP Status 500 - Request processing failed; nested exception is org.springframework.transaction.CannotCreateTransactionException: Could 
not open Hibernate Session for transaction; nested exception is org.hibernate.exception.GenericJDBCException: Could not open connection.
Najprawdopodobniej problem jest zwi�zany z baz� dancyh.