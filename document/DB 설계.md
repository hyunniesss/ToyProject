# DB 설계

#### Account

| column명                   | type         | null | key  | default     | extra          |
| -------------------------- | ------------ | ---- | ---- | ----------- | -------------- |
| uid                        | long         | no   | pri  | null        | auto_increment |
| userId<br />학번           | varchar(10)  | no   |      | null        | unique         |
| userPassword<br />비밀번호 | varchar(255) | no   |      | null        |                |
| userName<br />이름         | varchar(25)  | no   |      | null        |                |
| userEmail<br />이메일      | varchar(255) | no   |      | null        | unique         |
| userImage<br />프로필 사진 | varchar(255) | yes  |      | default.png |                |
| status<br />로그인 상태    | boolean      | yes  |      | false       |                |

https://engkimbs.tistory.com/849 - sns 로그인



#### ClubDivision

| column명                         | type         | null | key  | default | extra          |
| -------------------------------- | ------------ | ---- | ---- | ------- | -------------- |
| uid                              | long         | no   | PK   | null    | auto_increment |
| dName<br />동아리 분류명         | varchar(255) | no   |      | null    | unique         |
| dImage<br />동아리 분류별 이미지 | varchar(255) | no   |      | null    |                |



#### Club

| column명                     | type         | null | key  | default | extra          |
| ---------------------------- | ------------ | ---- | ---- | ------- | -------------- |
| uid                          | long         | no   | PK   | null    | auto_increment |
| clubDivUid                   | long         | no   | FK   | null    | 분류명         |
| clubName<br />동아리명       | varchar(255) | no   |      | null    |                |
| isMid<br />중앙동아리인지    | boolean      | no   |      | null    |                |
| description<br />동아리 설명 | varchar(255) | yes  |      | null    |                |



#### ClubMember (club_member)

| column명                    | type         | null | key  | default | extra          |
| --------------------------- | ------------ | ---- | ---- | ------- | -------------- |
| uid                         | long         | no   | PK   | null    | auto_increment |
| accountUid                  | long         | no   | FK   | null    | 회원이름       |
| clubUid                     | long         | no   | FK   | null    | 동아리명       |
| role<br />동아리에서의 역할 | varchar(255) | yes  |      | user    |                |



#### ClubNotice

| column명                    | type         | null | key  | default           | extra          |
| --------------------------- | ------------ | ---- | ---- | ----------------- | -------------- |
| uid                         | long         | no   | PK   | null              | auto_increment |
| accountUid                  | long         | no   | FK   | null              | 작성자명       |
| clubUid                     | long         | no   | FK   | null              | 동아리명       |
| title<br />제목             | varchar(255) | no   |      | null              |                |
| content<br />내용           | varchar(255) | yes  |      | null              |                |
| filename<br />첨부파일 위치 | varchar(255) | yes  |      | null              |                |
| regtime<br />작성 시간      | date         | yes  |      | current_timestamp |                |
| isNotice<br />공지사항인지  | boolean      | no   |      | null              |                |



#### ClubCalendar

| column명                      | type     | null | key  | default | extra             |
| ----------------------------- | -------- | ---- | ---- | ------- | ----------------- |
| uid                           | long     | no   | PK   | null    | auto_increment    |
| clubNoticeUid                 | long     | no   | FK   | null    | notice의 모든 것~ |
| startDate<br />일정 시작 날짜 | datetime | no   |      | null    |                   |
| endDate<br />일정 끝 날짜     | datetime | no   |      | null    |                   |



#### RefRoom(ref_room)

| column명                    | type         | null | key  | default           | extra          |
| --------------------------- | ------------ | ---- | ---- | ----------------- | -------------- |
| uid                         | long         | no   | PK   | null              | auto_increment |
| accountUid                  | long         | no   | FK   | null              | 작성자명       |
| clubUid                     | long         | no   | FK   | null              | 동아리명       |
| bigDivUid                   | long         | no   | FK   | null              | 대분류명       |
| smallDivUid                 | long         | yes  | FK   | null              | 소분류명       |
| title<br />제목             | varchar(255) | no   |      | null              |                |
| content<br />내용           | varchar(255) | yes  |      | null              |                |
| filename<br />첨부파일 위치 | varchar(255) | yes  |      | null              |                |
| regtime<br />작성 시간      | date         | yes  |      | current_timestamp |                |



#### RefBigDivision

| column명            | type         | null | key  | default | extra          |
| ------------------- | ------------ | ---- | ---- | ------- | -------------- |
| uid                 | long         | no   | PK   | null    | auto_increment |
| clubUid             | long         | no   | FK   | null    | 동아리명       |
| dName<br />대분류명 | varchar(255) | no   |      | null    |                |



#### RefSmallDivision

| column명            | type         | null | key  | default | extra          |
| ------------------- | ------------ | ---- | ---- | ------- | -------------- |
| uid                 | long         | no   | PK   | null    | auto_increment |
| bigDivUid           | long         | no   | FK   | null    | 대분류명       |
| dName<br />소분류명 | varchar(255) | no   |      | null    |                |

