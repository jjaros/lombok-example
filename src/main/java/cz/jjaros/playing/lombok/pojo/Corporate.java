package cz.jjaros.playing.lombok.pojo;

public class Corporate extends Company {

    public Corporate(String name, int employeesCount) {
        super(name, employeesCount);
        setTaxPayer(true);
    }
}
