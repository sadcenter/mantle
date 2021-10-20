# mantle
Optifine's cape system, which replaces s.optifine.net, mainly this project is for people who want to see how this works!

## Insert your cape!
 If you want to insert your cape you have to put the .png file in the same directory of built jar

## What I have to do on the client-side?
 Add a line to local system host's file: 
 ```text 
 (website server's ipv4) s.optifine net
 ```
 for example:
 ```text
 1.2.3.4 s.optifine.net
 ```
 Feel free to write your own application which will change the host's file

## Database
 I've used Mongo Database for this project, in the properties file (`application.properties`) you have to change host, port, login data etc.

 ```json
 {
  "name": "nickname",
  "cape": "fileName"  
}
```


## How can I enable it?
 Just upload the built jar file to your server then run it (Wow! It's so simple)

