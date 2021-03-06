package cz.jjaros.funfromboredom.lombok.dto;

import lombok.ToString;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
@ToString(callSuper = true)
public class SmallCompany extends Company {

    public SmallCompany(String name, int employeesCount, boolean taxPayer) {
        super(name, employeesCount);
        setTaxPayer(taxPayer);
    }
}
