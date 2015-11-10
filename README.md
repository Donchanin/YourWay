# YourWay

10.11.2015 г.

Первая работающая часть проекта.

1. Описание компонентов проекта.

1.1. Определены сущности Person и PersonData (классы com.inetex.yourway.dao.Person.java  
и com.inetex.yourway.dao.PersonData.java) в соответствии с UML-диаграммой; 
установлено отношение между этими классами (OneToOne).

1.2.Класс com.inetex.yourway.controller.PersonTestAppl.java предоставляет метод fillPersonAndPersonData(), позволяющий 
получать случайные значения полей таблиц Person и PersonData базы данных для их последующего заполнения, 
а также clearTables(), готовящий объекты для последующего удаления данных из таблиц. 

1.3.Класс com.inetex.yourway.controller.OrmConsoleAppl.java представляет собой аппликацию, позволяющую
вводить простые и составные jpql-запросы с консоли. Реализует интерфейс  com.inetex.yourway.interfaces.OrmConsole.

1.4.Класс com.inetex.yourway.repository.PersonRepository.java реализует интерфейс com.inetex.yourway.interfaces.PersonCRUD,
предоставляющий метод createPerson(String email, String password, Date registrationDate, 
Date lastLogin, String firstName, Date birthDate, char gender), позволяющий заполнить таблицы Person 
и PersonData базы данных, а также clearPersonAndPersonDataTable(), удаляющий записи из таблиц.

1.5.Подключены пользовательские jar-библиотеки (фрэймворки) Spring и Hibernate, 
позволяющие решать задачи persistance и ORM.

1.6.Сформирован файл YourWay/src/META-INF/persistence.xml, описывающий параметры и свойства хранимых
сущностей и соединения java - классов с базой данных.

1.7.Сформирован файл beans.xml, определяющий связь консольной аппликации com.inetex.yourway.controller.OrmConsoleAppl
с базой данных.

1.8.Сформирован файл beansPerson.xml, определяющий связь com.inetex.yourway.repository.PersonRepository
с базой данных.

2. Результаты тестирования кода.

После заполнения таблиц значениями с помощью com.inetex.yourway.controller.PersonTestAppl.java 
тестирование выполнялось с помощью консольной аппликации com.inetex.yourway.controller.OrmConsoleAppl.java
путем ввода jpql-запросов с консоли:

Запрос № 1:
SELECT p FROM Person p

Результат запроса № 1:
Person [id=1, email=3054AUZJ@gmail.com, password=6314GZLL, registrationDate=2015-11-09, 
lastLogin=2015-11-24, personData=PersonData [id=1, identity=null, birthDate=1955-11-09, 
firstName=Sarah, lastName=null, gender=m, familyStatus=null, workPhone=null, mobilePhone=null, 
homePhone=null, occupation=null, education=null]]

Person [id=2, email=2332QGKC@gmail.com, password=5761NXTC, registrationDate=2015-11-09, 
lastLogin=2015-12-02, personData=PersonData [id=2, identity=null, birthDate=1967-11-09, 
firstName=David, lastName=null, gender=f, familyStatus=null, workPhone=null, mobilePhone=null, 
homePhone=null, occupation=null, education=null]]

Person [id=3, email=8280LNKZ@gmail.com, password=4031XYTJ, registrationDate=2015-11-09, 
lastLogin=2015-11-18, personData=PersonData [id=3, identity=null, birthDate=1964-11-09, 
firstName=Sarah, lastName=null, gender=m, familyStatus=null, workPhone=null, mobilePhone=null, 
homePhone=null, occupation=null, education=null]]

Запрос № 2:
SELECT p FROM PersonData p

Результат запроса № 2:
PersonData [id=1, identity=null, birthDate=1955-11-09, firstName=Sarah, lastName=null, gender=m, 
familyStatus=null, workPhone=null, mobilePhone=null, homePhone=null, occupation=null, education=null]

PersonData [id=2, identity=null, birthDate=1967-11-09, firstName=David, lastName=null, gender=f, 
familyStatus=null, workPhone=null, mobilePhone=null, homePhone=null, occupation=null, education=null]

PersonData [id=3, identity=null, birthDate=1964-11-09, firstName=Sarah, lastName=null, gender=m, 
familyStatus=null, workPhone=null, mobilePhone=null, homePhone=null, occupation=null, education=null]

Запрос № 3:
SELECT p FROM Person p JOIN p.personData pd WHERE pd.firstName='David'

Результат запроса № 3:
Person [id=2, email=2332QGKC@gmail.com, password=5761NXTC, registrationDate=2015-11-09, 
lastLogin=2015-12-02, personData=PersonData [id=2, identity=null, birthDate=1967-11-09, 
firstName=David, lastName=null, gender=f, familyStatus=null, workPhone=null, mobilePhone=null, 
homePhone=null, occupation=null, education=null]]

Запрос № 4:
SELECT p.password FROM Person p JOIN p.personData pd WHERE pd.firstName='David'

Результат запроса № 4:
5761NXTC

Запрос № 5:
SELECT p.email FROM Person p JOIN p.personData pd WHERE pd.gender='m'

Результат запроса № 5:
3054AUZJ@gmail.com
8280LNKZ@gmail.com

Запрос № 6:
SELECT p.registrationDate, p.email FROM Person p JOIN p.personData pd WHERE pd.gender='f'

Результат запроса № 6:
2015-11-09 2332QGKC@gmail.com







