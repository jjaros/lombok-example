package cz.jjaros.lombok;

import cz.jjaros.playing.lombok.dto.Corporate;
import cz.jjaros.playing.lombok.dto.PassengerCar;
import cz.jjaros.playing.lombok.dto.SmallCompany;
import cz.jjaros.playing.lombok.dto.VanCar;
import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LombokTest {

    private static int CORPORATE_EMPLOYEES_COUNT = 5000;
    private static int SMALL_COMPANY_EMPLOYEES_COUNT = 2;
    
    @Test
    public void testCorporate() {
        val corporate = new Corporate("Example corp.", CORPORATE_EMPLOYEES_COUNT);

        assertEquals("Example corp.", corporate.getName());
        assertEquals(CORPORATE_EMPLOYEES_COUNT, corporate.getEmployeesCount());
        assertTrue(corporate.isTaxPayer());

        // This line produce compilation error because 'corporate' is final.
//        corporate = new Corporate("Example corp.", CORPORATE_EMPLOYEES_COUNT);
    }

    @Test
    public void testCompanyCars() {
        val corporate = new Corporate("Example corp.", CORPORATE_EMPLOYEES_COUNT);

        val passengerCar = new PassengerCar("Mini");
        passengerCar.setModelName("Cooper");
        corporate.addCar(passengerCar);

        val vanCar = new VanCar("VW");
        vanCar.setModelName("Multivan");
        corporate.addCar(vanCar);

        assertNotNull(corporate.getCars());
        assertEquals(SMALL_COMPANY_EMPLOYEES_COUNT, corporate.getCars().size());
        assertEquals(passengerCar, corporate.getCars().get(0));
        assertEquals(vanCar, corporate.getCars().get(1));
    }

    @Test
    public void testSmallCompany() {
        val smallComp = new SmallCompany("Small company", SMALL_COMPANY_EMPLOYEES_COUNT, false);

        assertEquals("Small company", smallComp.getName());
        assertEquals(SMALL_COMPANY_EMPLOYEES_COUNT, smallComp.getEmployeesCount());
        assertFalse(smallComp.isTaxPayer());
        assertNotNull(smallComp.getCars());
        assertTrue(smallComp.getCars().isEmpty());
    }

    @Test
    public void testObjectsEquals() {
        val car1 = new PassengerCar("Mini");
        car1.setModelName("Cooper");
        val car2 = new PassengerCar("Mini");
        car2.setModelName("Cooper");

        val company1 = new SmallCompany("Small company", SMALL_COMPANY_EMPLOYEES_COUNT, false);
        val company2 = new SmallCompany("Small company", SMALL_COMPANY_EMPLOYEES_COUNT, false);

        assertEquals(car1, car2); // @Data provides Car#equals and Car#hashCode
        assertNotEquals(company1, company2); // compare reference only because Company#equals not exist
    }

    @Test(expected = NullPointerException.class)
    public void testCreateCorporate_nullName() {
        new Corporate(null, CORPORATE_EMPLOYEES_COUNT);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateSmallCompany_nullName() {
        new SmallCompany(null, SMALL_COMPANY_EMPLOYEES_COUNT, true);
    }
}
