# sprint_4

# Запуск в Chrome

```bash
mvn test
```

# Запуск с Firefox
```bash
mvn -Dbrowser=firefox test
```

Если mvn test падает с ошибкой 500 и не находит бинарник, то запускаем с параметром:
```bash
mvn -Dbrowser=firefox -Dwebdriver.firefox.bin=/usr/bin/firefox test
```



