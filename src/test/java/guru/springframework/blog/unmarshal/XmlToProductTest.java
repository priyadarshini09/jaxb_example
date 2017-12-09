package guru.springframework.blog.unmarshal;

import guru.springframework.blog.domain.Product;
import guru.springframework.blog.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class XmlToProductTest {
    private Product product;

    @Before
    public void setUp(){
        long l = 10;
        Long longId = new Long(l);
        User user = new User(longId,"John","john99@gmail.com");
        product = new Product("PO1", "Spring Guru Mug","https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", new BigDecimal(18.95),user);
    }

    @After
    public void tearDown(){
        product = null;
    }

    @Test
    public void testXmlToObject() throws JAXBException, FileNotFoundException {
        File file = new File("Simple.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Product product1 = (Product) unmarshaller.unmarshal(file);
        System.out.println(product1);
    }
}
