

# DB 설계

#### Account

| column명     | type         | null | key  | default     | extra          |
| ------------ | ------------ | ---- | ---- | ----------- | -------------- |
| uid          | long         | no   | pri  | null        | auto_increment |
| userId       | varchar(10)  | no   |      | null        | unique         |
| userPassword | varchar(255) | no   |      | null        |                |
| userName     | varchar(25)  | no   |      | null        |                |
| userEmail    | varchar(255) | no   |      | null        | unique         |
| userImage    | varchar(255) | yes  |      | default.png |                |
| status       | boolean      | yes  |      | false       |                |

https://engkimbs.tistory.com/849 - sns 로그인



#### ClubDivision

| column명 | type         | null | key  | default | extra          |
| -------- | ------------ | ---- | ---- | ------- | -------------- |
| uid      | long         | no   | PK   | null    | auto_increment |
| dName    | varchar(255) | no   |      | null    | unique         |
| dImage   | varchar(255) | no   |      | null    |                |



#### Club

| column명    | type         | null | key  | default | extra          |
| ----------- | ------------ | ---- | ---- | ------- | -------------- |
| uid         | long         | no   | PK   | null    | auto_increment |
| division    | int          | no   | FK   | null    |                |
| clubName    | varchar(255) | no   |      | null    |                |
| isMid       | boolean      | no   |      | null    |                |
| description | varchar(255) | yes  |      | null    |                |



#### ClubMember (club_member)

| column명   | type         | null | key  | default | extra          |
| ---------- | ------------ | ---- | ---- | ------- | -------------- |
| uid        | long         | no   | PK   | null    | auto_increment |
| accountUid | long         | no   | FK   | null    |                |
| clubUid    | long         | no   | FK   | null    |                |
| role       | varchar(255) | yes  |      | user    |                |



#### RefRoom(ref_room)

| column명   | type         | null | key  | default           | extra          |
| ---------- | ------------ | ---- | ---- | ----------------- | -------------- |
| uid        | long         | no   | PK   | null              | auto_increment |
| accountUid | long         | no   | FK   | null              |                |
| title      | varchar(255) | no   |      | null              |                |
| content    | varchar(255) | yes  |      | null              |                |
| filename   | varchar(255) | yes  |      | null              |                |
| regtime    | date         | yes  |      | current_timestamp |                |



#### RefBigDivision

| column명 | type         | null | key  | default | extra          |
| -------- | ------------ | ---- | ---- | ------- | -------------- |
| uid      | long         | no   | PK   | null    | auto_increment |
| clubUid  | long         | no   | FK   | null    |                |
| dName    | varchar(255) | no   |      | null    |                |



#### RefSmallDivision

| column명  | type         | null | key  | default | extra          |
| --------- | ------------ | ---- | ---- | ------- | -------------- |
| uid       | long         | no   | PK   | null    | auto_increment |
| bigDivUid | long         | no   | FK   | null    |                |
| dName     | varchar(255) | no   |      | null    |                |

