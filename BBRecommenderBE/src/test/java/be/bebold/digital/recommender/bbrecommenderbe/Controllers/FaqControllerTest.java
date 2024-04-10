package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import be.bebold.digital.recommender.bbrecommenderbe.Model.Faq;
import be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses.ResponseMessage;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.FaqRepositroy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class FaqControllerTest {

    @Mock
    private FaqRepositroy faqRepository;

    @InjectMocks
    private FaqController faqController;

    @Test
    public void testGetAllFaqs() {
        // mock the findAll method to return a list of FAQs
        List<Faq> faqs = Arrays.asList(
                new Faq(1L, "Question 1"),
                new Faq(2L, "Question 2")
        );

        when(faqRepository.findAll()).thenReturn(faqs);

        // call the controller method and verify the result
        List<Faq> result = faqController.getAllFaqs();
        assertEquals(2, result.size());
        assertEquals("Question 1", result.get(0).getQuestion());
        assertEquals("Question 2", result.get(1).getQuestion());

        verify(faqRepository).findAll();
    }

    @Test
    public void testAddFaq() {
        // create a new FAQ to add
        Faq faq = new Faq(1L, "Question 1");

        // mock the save method to return the saved FAQ
        when(faqRepository.save(any())).thenReturn(faq);

        // call the controller method and verify the result
        ResponseEntity<?> response = faqController.addFaq(faq);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Faq saved successfully", ((ResponseMessage) response.getBody()).getMessage());

        verify(faqRepository).save(any());
    }
    @Test
    public void testAddFaqError() {
        // create an invalid FAQ to add
        Faq faq = new Faq(1L, null); // null question should cause an error

        // mock the save method to throw an exception
        when(faqRepository.save(any())).thenThrow(new RuntimeException("test error"));

        // call the controller method and verify the error response
        ResponseEntity<?> response = faqController.addFaq(faq);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("error saving saving faq", ((ResponseMessage) response.getBody()).getMessage());

        verify(faqRepository).save(any());
    }

    @Test
    public void testDeleteFaq() {
        // mock the findById method to return an optional containing a FAQ
        Faq faq = new Faq(1L, "Question 1");
        when(faqRepository.findById(1L)).thenReturn(Optional.of(faq));

        // call the controller method and verify the result
        ResponseEntity<?> response = faqController.deleteFaq(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Faq deleted successfully", ((ResponseMessage) response.getBody()).getMessage());

        // verify that the delete method was called with the correct argument
        verify(faqRepository).delete(faq);
    }
    @Test
    public void testDeleteFaqThrowException() {
        // create a new FAQ to delete
        Faq faq = new Faq(1L, "Question 1");

        // mock the delete method to throw an exception
        doThrow(new RuntimeException("Failed to delete FAQ")).when(faqRepository).delete(faq);

        // call the controller method and verify the result
        ResponseEntity<?> response = faqController.deleteFaq(faq.getId());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("error deleting faq", ((ResponseMessage) response.getBody()).getMessage());
    }


    @Test
    public void testUpdateFaq() {

        Long id =  1L;

        // mock the findById method to return an optional containing a FAQ
        Faq faq = new Faq(1L, "Question 1");
        when(faqRepository.findById(id)).thenReturn(Optional.of(faq));

        // create an updated FAQ with a new question
        Faq updatedFaq = new Faq(id, "Updated Question");

        // call the controller method and verify the result
        ResponseEntity<?> response = faqController.updateFaq(1L, updatedFaq);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Faq updated successfully", ((ResponseMessage) response.getBody()).getMessage());

        // verify that the save method was called with the updated FAQ
        verify(faqRepository).findById(id);
    }

    @Test
    public void testUpdateFaq_exception() {
        // create a new FAQ to update
        Faq faq = new Faq(1L, "Question 1");

        // mock the findById method to throw an exception
        when(faqRepository.findById(anyLong())).thenThrow(new RuntimeException());

        // call the controller method and verify the result
        ResponseEntity<?> response = faqController.updateFaq(1L, faq);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("error updating faq", ((ResponseMessage) response.getBody()).getMessage());
    }

}