## Build

```shell script
./gradlew build
```

## Usage

```shell script
java -jar build/libs/ru.airux.operationgenerator-1.0-SNAPSHOT.jar \
  --project-dir ../project/dir \
  --source-dir src/ \
  --package-prefix Proj \
  --component-name User \
  --operation Create \
  --operation Update \
  --operation GetList \
  --operation Get \
  --operation Delete \
  --operation Restore
```

