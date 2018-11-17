package cz.jjaros.funfromboredom.lombok.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
@Getter
@Builder(builderClassName = "BookLombokBuilder", builderMethodName = "lombokBuilder", buildMethodName = "buildBook")
public class Book {

    @NonNull
    private String title;

    private String subTitle;

    @NonNull
    private String isbn;

    private int pageCount;

    @Singular("addAuthor") // provides method addAuthor(Person)
    private List<Person> authors;
}
