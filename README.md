# mantle
Mantle cape system, but worse lmao

## Insert your cape!
 If you want to insert your cape you must put .png file in same directory of builded jar

## Client
 Run notepad as admin and open "C:\Windows\System32\drivers\etc\hosts", add line with text: 
 (vps ipv4) s.optifine net
 for example:
 ```text
 127.0.0.1 s.optifine.net
 ```

## Database
 I use MongoDatabase for it, in "SpringWebApplication" you must provide host, port, login data etc
 Document template:
 ```json
 {
  "name": "nickname",
  "cape": "cape"  
}
```


## How it works?
 Just upload builded jar file to vps. etc run and you got your own mantle cape system
