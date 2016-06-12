# spring-stateless-auth-play
Spring Boot Stateless Auth Play


Run:
```
cd <repo dir>
maven clean install
java -jar target/spring-stateless-auth-play-0.0.1-SNAPSHOT.jar
```

The TokenAuthenticationFilter determines whether the request is valid. 
It currently only looks for the request parameter: `allow=yes`. If this exists then the request is authenticated.
Otherwise a json response and 401 status will be generated: 
   
Then hit [http://localhost:8080?test/allow=yes](http://localhost:8080?test/allow=yes)

A full implementation would examine a signature in the `Authorization` header and compare it with the request to ensure it was signed correctly with a shared secret.
For example:

  * [Amazon](http://docs.aws.amazon.com/AmazonS3/latest/dev/RESTAuthentication.html)
  * [DuoAuth](https://duo.com/docs/authapi#authentication)
  
