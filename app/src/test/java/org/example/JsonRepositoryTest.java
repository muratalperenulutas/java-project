package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.data.JsonRepository;
import org.project.data.OsUtil;
import org.project.models.Product;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonRepositoryTest {

    private static JsonRepository<Product> productRepository;
    private static final String testFileName = "test-products.json";
    private static String testFilePath;


    @BeforeAll
    public static void setup() {
        testFilePath= OsUtil.getUserDataPath(testFileName);
        System.out.println(testFilePath);
    }


    @BeforeEach
    public void init() {
        OsUtil.createFileIfNotExists(testFilePath);
        productRepository = new JsonRepository<>(testFilePath, Product[].class);
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product(1, "Product 1", "Description 1", "Category 1", "uri",10.99);
        productRepository.save(product);

        List<Product> products = productRepository.findAll();
        assertEquals(1, products.size(), "Product should be saved correctly.");
        assertEquals(1, products.get(0).getId(), "Product ID should match.");
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product(1, "Product 1", "Description 1", "Category 1", "uri",10.99);
        productRepository.save(product);

        Product updatedProduct = new Product(1, "Updated Product 1", "Updated Description", "Updated Category", "url",12.99);
        productRepository.update(updatedProduct);

        List<Product> products = productRepository.findAll();
        assertEquals(1, products.size(), "Product should be updated.");
        assertEquals("Updated Product 1", products.get(0).getName(), "Product name should be updated.");
        assertEquals(12.99, products.get(0).getPrice(), "Product price should be updated.");
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product(1, "Product 1", "Description 1", "Category 1", "er",10.99);
        productRepository.save(product);

        productRepository.delete(1);

        List<Product> products = productRepository.findAll();
        assertTrue(products.isEmpty(), "Product should be deleted.");
    }

    @Test
    public void testFindAllProducts() {
        Product product1 = new Product(1, "Product 1", "Description 1", "Category 1", "k",10.99);
        Product product2 = new Product(2, "Product 2", "Description 2", "Category 2", "l",20.99);

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> products = productRepository.findAll();
        assertEquals(2, products.size(), "Should return all saved products.");
    }

    @Test
    public void testSaveDuplicateProduct() {
        Product product1 = new Product(1, "Product 1", "Description 1", "Category 1", "kş",10.99);
        Product product2 = new Product(1, "Product 1 Duplicate", "Description Duplicate", "Category Duplicate", "jjh",15.99);

        productRepository.save(product1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            productRepository.save(product2);
        });

        assertEquals("Duplicate item id: 1", exception.getMessage(), "Should throw exception for duplicate ID.");
    }

    @AfterEach
    public void cleanup() {
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
