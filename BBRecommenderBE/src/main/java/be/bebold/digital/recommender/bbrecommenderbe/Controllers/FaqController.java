package be.bebold.digital.recommender.bbrecommenderbe.Controllers;

import be.bebold.digital.recommender.bbrecommenderbe.Model.Faq;
import be.bebold.digital.recommender.bbrecommenderbe.Payload.Responses.ResponseMessage;
import be.bebold.digital.recommender.bbrecommenderbe.Repositories.FaqRepositroy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling requests related to FAQs.
 * @author Baeten Jens
 * @version 1.0
 */
@RestController
public class FaqController {

    @Autowired
    private FaqRepositroy FaqRepositroy;

    /**
     * Retrieves all FAQs from the database.
     *
     * @return a list of all {@link Faq} objects
     * @see FaqRepositroy#findAll()
     */

    @GetMapping("/faqs")
    public List<Faq> getAllFaqs() {
        return FaqRepositroy.findAll();
    }

    /**
     * Adds a new FAQ to the database.
     *
     * @param faq the {@link Faq} object representing the FAQ to add
     * @return a {@link ResponseEntity} object with an appropriate HTTP status code
     *         and message
     */

    @PostMapping("/faq")
    public ResponseEntity<?> addFaq(@RequestBody Faq faq) {
        try {
            FaqRepositroy.save(faq);
            return ResponseEntity
                    .ok(new ResponseMessage("Faq saved successfully", HttpStatus.OK, HttpStatus.OK.value()));

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(new ResponseMessage("error saving saving faq",
                    HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));
        }
    }

    /**
     * Deletes an FAQ with the specified ID from the database.
     *
     * @param id the ID of the FAQ to delete
     * @return a {@link ResponseEntity} object with an appropriate HTTP status code
     *         and message
     */

    @DeleteMapping("/deleteFaq/{id}")
    public ResponseEntity<?> deleteFaq(@PathVariable("id") Long id) {
        try {
            FaqRepositroy.delete(FaqRepositroy.findById(id).get());
            return ResponseEntity
                    .ok(new ResponseMessage("Faq deleted successfully", HttpStatus.OK, HttpStatus.OK.value()));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new ResponseMessage("error deleting faq", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));
        }
    }

    /**
     * Updates an existing FAQ with the specified ID in the database.
     *
     * @param faqId       the ID of the FAQ to update
     * @param FaqToUpdate the {@link Faq} object representing the updated FAQ
     * @return a {@link ResponseEntity} object with an appropriate HTTP status code
     *         and message
     * @see FaqRepositroy#findById(Object)
     */

    @PutMapping("/updateFaq/{id}")
    public ResponseEntity<?> updateFaq(@PathVariable(value = "id") Long faqId,
            @RequestBody Faq FaqToUpdate) {

        try {

            Faq currentFaq = FaqRepositroy.findById(faqId).get();

            // update the current faq with the updated question
            currentFaq.setQuestion(FaqToUpdate.getQuestion());
            FaqRepositroy.save(currentFaq);

            return ResponseEntity
                    .ok(new ResponseMessage("Faq updated successfully", HttpStatus.OK, HttpStatus.OK.value()));

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(
                    new ResponseMessage("error updating faq", HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value()));
        }
    }

}
