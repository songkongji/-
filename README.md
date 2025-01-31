# API 명세

|API기능|Method|URL|Request|Response|상태코드|
|------|---|---|---|---|---|
|일정 등록|POST|/schedules{id}|요청 body|등록 정보|200: 정상등록|
|일정 단건 조회|GET|/scedules/{id}|요청 param|단건 응답 정보|200: 정상조회 </br>400, 404: 조회불가|
|일정 목록 조회|GET|/scedules/|요청 param|목록 응답 정보|200: 정상조회</br>400, 404: 조회불가|
|일정 수정|PUT|/scedules{id}|요청 body|수정 정보|200: 정상수정</br>400, 404: 수정불가|
|일정 삭제|DELETE|/scedules{id}|요청 param|없음|200: 정상삭제</br>400, 404: 삭제불가|

</br></br>

# ERD

| schedule              |
|-----------------------|
| ID(PK) (BIGINT)       |
| NAME (VARCHAR)        |
| PASSWORD (VARCAHR)    |
| CONTENTS (VARCHAR)    |
| CREATEDATE (DATETIME) |
| UPDATEDATE (DATETIME) |
