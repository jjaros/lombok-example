# lombok-example
All features are completly described at official project page: https://projectlombok.org/features/

## Introduction
Getting to know and playing with Lombok stable features.

In this example project are used only **stable features of Lombok 1.16.18** (expect [`@Value`](https://projectlombok.org/features/Value), [`@Synchronized`](https://projectlombok.org/features/Synchronized) and [`@Log`](https://projectlombok.org/features/log)). Some features are used in their multiple variants.

In this project you can find:
- [`val`](https://projectlombok.org/features/val)
- [`@NonNull`](https://projectlombok.org/features/NonNull)
- [`@Cleanup`](https://projectlombok.org/features/Cleanup)
- [`@Getter / @Setter`](https://projectlombok.org/features/GetterSetter)
- [`@ToString`](https://projectlombok.org/features/ToString)
- [`@EqualsAndHashCode`](https://projectlombok.org/features/EqualsAndHashCode)
- [`@NoArgsConstructor, @AllArgsConstructor, @RequiredArgsConstructor`](https://projectlombok.org/features/constructor)
- [`@Data`](https://projectlombok.org/features/Data)
- [`@Builder`](https://projectlombok.org/features/Builder)
- [`@SneakyThrows`](https://projectlombok.org/features/Builder)
- [`@Getter(lazy = true)`](https://projectlombok.org/features/GetterLazy)

## Project structure
```
src
   └── main
      └── java
         └── cz.jjaros.playing.lombok.pojo
            └── ...all Lombok POJOs...
   └── test
      └── java
         └── cz.jjaros.playing.lombok
            └── LombokTest.java - all features are tested in this test class
      └── resources
         └── test-file.txt
```

## Clone
```
git clone https://github.com/jjaros/lombok-example
```
For support of Lombok in your IDE you need install appropriate plugin. Lombok dependency is download to project via Maven.
