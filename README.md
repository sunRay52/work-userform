# Userform2.0.0
![scheme of work](src/main/resources/userform-work_scheme.png)
## Error

**When trying to delete a user by email (if the user's email is found):**
```java
Error creating bean with name 'addContact' defined in org.example.SpringConfig: Failed to instantiate [org.example.Wrapper]: Factory method 'wrapping' threw exception with message: null
```
**Console example:**
```console
> Task :AppBeans.main()
Привет, ты запустил контакты!
Введите значение / Пример: Андроников Дмитрий Дмитриевич; 899099999; email@gmail.com
Пользователь с email: someEmail@example.example добавлен!
Что вы хотите сделать ?
Добавить контакт - 1 / Удалить контакт - 2 / Закрыть приложение - любое другое значение
Введите значение / Пример: email@gmail.com
найден
удален
Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'addContact' defined in org.example.SpringConfig: Failed to instantiate [org.example.Wrapper]: Factory method 'wrapping' threw exception with message: null
```
