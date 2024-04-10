package be.bebold.digital.recommender.bbrecommenderbe.Services;

import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(SpringExtension.class)
class FileServiceTest {

    @Test
    void testConvertHtmlToPdf() throws IOException {
        // Arrange
        String[] features = { "Email Marketing", "Marketing Automation" };
        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click", "in House");
        FileService fileService = new FileService();

        // Act
        byte[] pdfBytes = fileService.convertHtmlToPdf(filterOptions);

        // Assert
        assertNotNull(pdfBytes);
        assertTrue(pdfBytes.length > 0);
    }

    @Test
    void testConvertHtmlToPdfWhenFeaturesAndPropertiesAreNull() throws IOException {
        // Arrange
        FilterOptions filterOptions = new FilterOptions();
        filterOptions.setFeatures(new String[0]);
        FileService fileService = new FileService();

        // Act
        byte[] pdfBytes = fileService.convertHtmlToPdf(filterOptions);

        // Assert
        assertNotNull(pdfBytes);
        assertTrue(pdfBytes.length > 0);
    }
    @Test
    void testConvertHtmlToPdfWhenFeaturesAreEmpty() throws IOException {
        // Arrange
        String[] features = new String[5];
        FilterOptions filterOptions = new FilterOptions(1L,200,true,100,1000, features,"Low","High","Point & click","in House");
        FileService fileService = new FileService();

        // Act
        byte[] pdfBytes = fileService.convertHtmlToPdf(filterOptions);

        // Assert
        assertNotNull(pdfBytes);
        assertTrue(pdfBytes.length > 0);
    }


}