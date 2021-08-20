# mantle
Mantle cape system, but worse lmao
(YES, OPTIFINE WORKS TOO)

## Insert your cape!
 If you want to insert your cape you have to put the .png file in the same directory of built jar

## Client
 Run notepad as an admin and open the "C:\Windows\System32\drivers\etc\hosts" file, then add line with text: 
 (vps ipv4) s.optifine net
 for example:
 ```text
 127.0.0.1 s.optifine.net
 ```
 You can write your own application that will change the host's file [LOOK THIS](https://github.com/sadcenter/Capes)

## Database
 I've used Mongo Database for this project, in the "SpringWebApplication" class you have to provide host, port, login data etc.
 Mongo document template:
 ```json
 {
  "name": "nickname",
  "cape": "cape"  
}
```


## How can I enable it?
 Just upload the built jar file to VPS. etc run and you've just got your own mantle cape system

