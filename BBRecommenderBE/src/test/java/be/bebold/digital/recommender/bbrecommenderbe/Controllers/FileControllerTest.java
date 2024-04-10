package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;
import be.bebold.digital.recommender.bbrecommenderbe.Services.FileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class FileControllerTest {

    @Mock
    private FileService fileService;

    @InjectMocks
    private FileController fileController;

    @Test
    void testHtmlToPdf() throws Exception {
        // Arrange
        byte[] pdfBytes = "test pdf".getBytes();
        when(fileService.convertHtmlToPdf(any(FilterOptions.class))).thenReturn(pdfBytes);

        FilterOptions filterOptions = new FilterOptions();
        Model model = new ExtendedModelMap();

        // Act
        ResponseEntity<byte[]> response = fileController.htmlToPdf(filterOptions, model);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_PDF, response.getHeaders().getContentType());
        assertEquals("form-data; name=\"attachment\"; filename=\"filteredData.pdf\"", response.getHeaders().getContentDisposition().toString());
        assertArrayEquals(pdfBytes, response.getBody());
    }

    @Test
    void testHtmlToPdfError() throws Exception {
        // Arrange
        doThrow(new RuntimeException("Failed to convert HTML to PDF")).when(fileService).convertHtmlToPdf(any(FilterOptions.class));
        FilterOptions filterOptions = new FilterOptions();
        Model model = new ExtendedModelMap();

        ResponseEntity<byte[]> response = fileController.htmlToPdf(filterOptions, model);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}