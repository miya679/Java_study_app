# Java_study_app

## フォルダ構成

```text
src/
  main/
    java/
      app/
        component/
          ComponentFactory.java
        ui/
          MainFrame.java
        AppConfig.java
        ImageLoader.java
        Main.java
    resources/
      images/
        pota.jpg
```

## 実行方法

```powershell
javac --release 17 -d out src\main\java\app\*.java src\main\java\app\component\*.java src\main\java\app\ui\*.java
Copy-Item -Recurse -Force src\main\resources\* out\
java -cp out app.Main
```
