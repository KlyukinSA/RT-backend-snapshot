# Приложение для Android - Профсоюзный навигатор.
Новости профсоюза, лайки коменты. Планируемые мероприятия, предложить. Подать заявку на вступление в профсоюз.

см тесты + API:

# регистрация и авторизация при входе

## регистрация

`POST /auth/register`

принимает объект с именем, фамилией,  почтой и паролем, регистрирует такого ползователя если его еще нет и возвращает объект с токеном

пример: `src/test/java/com/example/rt/RtApplicationTests::register`

## авторизация

`POST /auth/authenticate`

принимает объект с почтой и паролем, авторизирует такого ползователя (обновляет авторизацию) и возвращает объект с токеном

запускать не пробовал.

> все следующие запросы надо снабжать .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)

# планируемые мероприятия

пример: `src/test/java/com/example/rt/RtApplicationTests::testPlannedActivities`

## получить текущие планируемые мероприятия

`GET /planned-activities?pageSize={size}&pageNo={no}`

возвращает страницу мероприятий с нужным размером и номером в виде массива следующих объектов где state это либо IN_REVIEWING либо APPROVED

## предложить мероприятие

`POST /planned-activities`

принимает объект, создает по нему мероприятие с state: IN_REVIEWING и айди автора из jwt и возвращает объект этого мероприятия

## принять мероприятие

`PUT /planned-activities/{id}`

принимает мероприятие под номером {id}, ставит ему state: APPROVED и возвращает объект этого мероприятия 

# заявки на вступление в профсоюз

такая же хуйня

пример: `src/test/java/com/example/rt/RtApplicationTests::testMembership`

## получить текущие заявки

`GET /applications?pageSize={size}&pageNo={no}`

## подать заявку

`POST /applications`

## принять заявку

`PUT /applications/{id}`

# новости

пример: `src/test/java/com/example/rt/RtApplicationTests::testNews`

## получить текущие новости

`GET /news?pageSize={size}&pageNo={no}`

## создать новость

`POST /news`

# лайки

пример: `src/test/java/com/example/rt/RtApplicationTests::testLikes`

## поставить лайк

`POST /news/{id}/likes`

ставит лайк на новость номер {id} от имени из jwt

## получить все лайки к новости

`GET /news/{id}/likes`

# коменты

пример: `src/test/java/com/example/rt/RtApplicationTests::testComments`

## написать комент

`POST /news/{id}/comments`

пишет комент на новость номер {id} от имени из jwt с содержаемием из `CommentNewsRequest`

## получить коменты к новости

`GET /news/{id}/comments?pageSize={size}&pageNo={no}`
