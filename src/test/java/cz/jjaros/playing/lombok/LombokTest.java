package cz.jjaros.playing.lombok;

import cz.jjaros.playing.lombok.pojo.Book;
import cz.jjaros.playing.lombok.pojo.Computer;
import cz.jjaros.playing.lombok.pojo.Corporate;
import cz.jjaros.playing.lombok.pojo.DestroyableObject;
import cz.jjaros.playing.lombok.pojo.PassengerCar;
import cz.jjaros.playing.lombok.pojo.Person;
import cz.jjaros.playing.lombok.pojo.SmallCompany;
import cz.jjaros.playing.lombok.pojo.VanCar;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

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
    public void testCarsAndCompaniesEquals() {
        val car1 = new PassengerCar("Mini");
        car1.setModelName("Cooper");
        val car2 = new PassengerCar("Mini");
        car2.setModelName("Cooper");

        val company1 = new SmallCompany("Small company", SMALL_COMPANY_EMPLOYEES_COUNT, false);
        val company2 = new SmallCompany("Small company", SMALL_COMPANY_EMPLOYEES_COUNT, false);

        assertEquals(car1, car2); // @Data provides Car#equals and Car#hashCode
        assertNotEquals(company1, company2); // compare reference only because Company#equals not exist
    }

    @Test
    public void testPersonEquals() {
        assertEquals(new Person("John", "Doe", 22), new Person("John", "Smith"));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateCorporate_nullName() {
        new Corporate(null, CORPORATE_EMPLOYEES_COUNT);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateSmallCompany_nullName() {
        new SmallCompany(null, SMALL_COMPANY_EMPLOYEES_COUNT, true);
    }

    @Test(expected = IOException.class)
    @SneakyThrows // throws Throwable
    public void testCleanUp() {
        FileInputStream input = createFileInputStream();

        input.read(); // throws exception because 'input' is closed at the end of 'createFileInputStream'
    }

    @Test
    public void testCleanUpWithCustomMethod() {
        DestroyableObject destroyableObject = createDestroyableObject();

        assertTrue(destroyableObject.isDestroyed());
    }

    @SneakyThrows(IOException.class)
    private FileInputStream createFileInputStream() {
        @Cleanup FileInputStream input = new FileInputStream(new File("src/test/resources/test-file.txt"));
        input.read(); // it works here - 'input' is not close yet
        return input;
    }

    private DestroyableObject createDestroyableObject() {
        @Cleanup("destroy") DestroyableObject destroyableObject = DestroyableObject.create();
        assertFalse(destroyableObject.isDestroyed());
        return destroyableObject;
    }

    @Test
    public void testToString() {
        assertEquals("SmallCompany(super=Company(smallNameValue, 2, false))", new SmallCompany("smallNameValue", 2, false).toString());
        assertEquals("Company(corpNameValue, 555, true)", new Corporate("corpNameValue", 555).toString());
        assertEquals("Car(carBrand=Mini, modelName=null, type=PASSENGER)", new PassengerCar("Mini").toString());
    }

    @Test
    public void testLombokBuilder() {
        Book book = Book.lombokBuilder()
                .clearAuthors()
                .title("Lombok project examples")
                .subTitle("Playing with Lombok")
                .isbn("ISBNcode")
                .pageCount(200)
                .authors(Collections.singletonList(new Person("John", "Doe", 25)))
                .addAuthor(new Person("John", "Smith"))
                .buildBook();

        assertNotNull(book);
        assertEquals("Lombok project examples", book.getTitle());
        assertEquals("Playing with Lombok", book.getSubTitle());
        assertEquals("ISBNcode", book.getIsbn());
        assertEquals(200, book.getPageCount());
        assertNotNull(book.getAuthors());
        assertEquals(2, book.getAuthors().size());
    }

    @Test
    public void testLombokBuilder_emptyCollection() {
        Book book = Book.lombokBuilder()
                .clearAuthors()
                .title("Lombok project examples")
                .subTitle("Playing with Lombok")
                .isbn("ISBNcode")
                .pageCount(200)
                .buildBook();

        assertNotNull(book);
        assertEquals("Lombok project examples", book.getTitle());
        assertEquals("Playing with Lombok", book.getSubTitle());
        assertEquals("ISBNcode", book.getIsbn());
        assertEquals(200, book.getPageCount());
        assertNotNull(book.getAuthors());
        assertEquals(0, book.getAuthors().size());
    }

    @Test(expected = NullPointerException.class)
    public void testLombokBuilderWithnoutRequiredField() {
        // fields 'title' and 'isbn' are required
        Book.lombokBuilder()
                .clearAuthors()
                .subTitle("Playing with Lombok")
                .buildBook();
    }

    @Test
    public void testComputer() {
        Computer computer1 = Computer.create("1TB", "16GB");
        computer1.setOperatingSystem("Debian");
        computer1.setRamSize("32GB");

        Computer computer2 = Computer.create("512GB", "32GB");
        computer2.setOperatingSystem("Windows");
        computer2.setHddSize("1TB");

        assertNotNull(computer1);
        assertNotNull(computer2);
        assertNotEquals(computer1, computer2);
        assertEquals(computer1.getHddSize(), computer2.getHddSize());
        assertEquals(computer1.getRamSize(), computer2.getRamSize());
        assertNotEquals(computer1.getOperatingSystem(), computer2.getOperatingSystem());
    }
}
