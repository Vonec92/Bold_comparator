package be.bebold.digital.recommender.bbrecommenderbe.Services;

import be.bebold.digital.recommender.bbrecommenderbe.Model.FilterOptions;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

/***
 * Service for the file conversion from html to pdf
 * @author [Baeten Jens]
 * @version 1.0
 */

@Service
public class FileService {

  /***
   * The base uri of the html file
   */
  public static String BASE_URI = "templates/";

  /***
   * Converts the html file to a pdf file
   * @param inputFilteroptions the filteroptions that are used to fill in the html file
   * @return byte[] pdfBytes the pdf file in bytes
   * @throws IOException when the html file is not found
   * @author [Baeten Jens]
   */
  public byte[] convertHtmlToPdf(FilterOptions inputFilteroptions)
      throws IOException {
    // convert HTML to PDF
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    HtmlConverter.convertToPdf(ProcessHtml(inputFilteroptions), outputStream);
    byte[] pdfBytes = outputStream.toByteArray();

    return pdfBytes;
  }

  /***
   * Process the html file with the inputFilteroptions to fill in with thymeleaf fill in the inputFilteroptions in the html file
   * returns a string in the form of an html file
   * @param inputFilteroptions the filteroptions that are used to fill in the html file
   * @return String the html file in string form
   * @throws IOException when the html file is not found
   */

  private String ProcessHtml(FilterOptions inputFilteroptions) throws IOException {

    ClassPathResource resource = new ClassPathResource(BASE_URI + "clientInput.html");

    InputStream inputStream = resource.getInputStream();
    String html = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setEnableSpringELCompiler(true);

    String features = convertFeaturesToString(inputFilteroptions.getFeatures());

    // set context to use in the HTML
    Context context = new Context();
    context.setVariable("filterOption", inputFilteroptions);
    context.setVariable("features", features);

    String processedHtml = templateEngine.process(html, context);
  
    return processedHtml;

  }

  /***
   * Convert the features string[] to a string to put in the pdf file
   * @param features the features that are selected in the frontend
   * @return String the features in string form with a comma between each feature
   */
  private String convertFeaturesToString(String[] features) {

    // featutes is [] when no features are selected in the frontend
    // it is never null but instead an empty array
    if (features.length == 0) {
      System.out.println("features is null");
      return "";
    } else {
      return listToString(features);
    }
  }


  /***
   * convert String[] to String with a comma between each element
   * @param list the list that needs to be converted to a string
   * @return String the list in string form with a comma between each element
   */
  private String listToString(String[] list) {
    StringBuilder string = new StringBuilder();
    for (String s : list) {
      string.append(s + ", ");
    }

    string.deleteCharAt(string.length() - 2);

    return string.toString();
  }
}
