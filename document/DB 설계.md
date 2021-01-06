# DB 설계

#### Account

uid : long, auto_increment, PK

userName : String, not null

userId : String, not null, unique

userPassword : String, not null

userEmail : String, not null, unique

https://engkimbs.tistory.com/849



#### Profile

uid : PK

userName : String, not null

profileImage : String, default image

userId : String, not null, unique

userPassword : String, not null

userEmail : String, not null, unique





#### Area

uid : int, auto_increment, PK

area_name : String, not null, unique



