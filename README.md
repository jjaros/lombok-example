# lombok-example
All features are completly described at official project page: https://projectlombok.org/features/

## Introduction
Getting to know and playing with Lombok stable features.

In this example project are used only **stable features of Lombok 1.16.18** (expect `@Value`, `@Synchronized` and `@Log`). Some features are used in their multiple variants.

In this project you can find:
- `val`
- `@NonNull`
- `@Cleanup`
- `@Getter / @Setter`
- `@ToString`
- `@EqualsAndHashCode`
- `@NoArgsConstructor, @AllArgsConstructor, @RequiredArgsConstructor`
- `@Data`
- `@Builder`
- `@SneakyThrows`
- `@Getter(lazy = true)`

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
