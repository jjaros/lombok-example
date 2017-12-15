package cz.jjaros.playing.lombok.dto;

public class SmallCompany extends Company {

    public SmallCompany(String name, int employeesCount, boolean taxPayer) {
        super(name, employeesCount);
        setTaxPayer(taxPayer);
    }
}
