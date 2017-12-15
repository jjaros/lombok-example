package cz.jjaros.playing.lombok.dto;

public class Corporate extends Company {

    public Corporate(String name, int employeesCount) {
        super(name, employeesCount);
        setTaxPayer(true);
    }
}
