package cz.jjaros.playing.lombok.pojo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"lastName", "age"})
@ToString
public class Person {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private int age;

}
