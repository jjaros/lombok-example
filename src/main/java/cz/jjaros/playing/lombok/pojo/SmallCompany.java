package cz.jjaros.playing.lombok.pojo;

import lombok.ToString;

@ToString(callSuper = true)
public class SmallCompany extends Company {

    public SmallCompany(String name, int employeesCount, boolean taxPayer) {
        super(name, employeesCount);
        setTaxPayer(taxPayer);
    }
}
