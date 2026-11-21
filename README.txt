NameProtect (Fabric 1.21.11)

Збірка локально (Java 21 + Gradle 9.x):
    gradle wrapper
    ./gradlew build
Готовий jar: build/libs/nameprotect-1.0.0.jar  (НЕ -sources.jar)
Кидати в папку mods/ (потрібен Fabric Loader, Fabric API не потрібен).

Без установки: залий папку на GitHub -> вкладка Actions -> build -> Artifacts -> nameprotect-jar.
Якщо Gradle скаржиться на версії — візьми актуальні yarn/loader на https://fabricmc.net/develop
