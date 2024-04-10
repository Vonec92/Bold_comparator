package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;
import be.bebold.digital.recommender.bbrecommenderbe.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * The FileController class handles requests related to file operations.
 * This class is responsible for converting HTML to PDF using a provided filter
 * and returning the generated PDF as a byte array in the response.
 * @author Baeten Jens
 * @version 1.0
 */
@RestController
public class FileController {

  @Autowired
  private FileService fileService;

  /**
   * This method accepts a filter option and HTML data to convert into PDF.
   * The PDF is then returned as a byte array in the response.
   * 
   * @param inputFilteroptions the filter options to apply when converting HTML to
   *                           PDF
   * @param model              the model to add attributes to
   * @return a ResponseEntity containing the PDF byte array and headers
   * @see FileService#convertHtmlToPdf(FilterOptions)
   * @see ResponseEntity
   */
  @PostMapping("/inputToPDF")
  public ResponseEntity<byte[]> htmlToPdf(@RequestBody FilterOptions inputFilteroptions, Model model) {

    System.out.println(inputFilteroptions);
    try {
      // convert HTML to PDF
      byte[] pdfBytes = fileService.convertHtmlToPdf(inputFilteroptions);

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_PDF);
      headers.setContentDispositionFormData("attachment", "filteredData.pdf");

      System.out.println("PDF generated" + pdfBytes.length);
      return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

    } catch (Exception e) {
      // handle error
      System.out.println(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
