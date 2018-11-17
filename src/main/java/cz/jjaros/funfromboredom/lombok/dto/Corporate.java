package cz.jjaros.funfromboredom.lombok.dto;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
public class Corporate extends Company {

    public Corporate(String name, int employeesCount) {
        super(name, employeesCount);
        setTaxPayer(true);
    }
}
