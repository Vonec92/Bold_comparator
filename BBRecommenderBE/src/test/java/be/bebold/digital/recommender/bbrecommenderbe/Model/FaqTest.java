package be.bebold.digital.recommender.bbrecommenderbe.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaqTest {
    @Test
    void getAndSetQuestionString() {
        Faq faq = new Faq(1L, "Question 1");
        assertEquals("Question 1", faq.getQuestion());
    }

    @Test
    void setQuestionString() {
        Faq faq = new Faq();
        faq.setQuestion("Question 2");
        assertEquals("Question 2", faq.getQuestion());
    }

    @Test
    void getAndSetIdLong() {
        Faq faq = new Faq(1L, "Question 1");
        assertEquals(1L, faq.getId());
    }

    @Test
    void setIdLong() {
        Faq faq = new Faq();
        faq.setId(2L);
        assertEquals(2L, faq.getId());
    }

    @Test
    void testToString() {
        Faq faq = new Faq(1L, "Question 1");
        assertEquals("Faq(id=1, question=Question 1)", faq.toString());
    }

    @Test
    void testBothSettersForFaqWithValuesAndToString() {
        Faq faq = new Faq();
        faq.setId(1L);
        faq.setQuestion("Question 1");
        assertEquals(1L, faq.getId());
        assertEquals("Question 1", faq.getQuestion());
        assertEquals("Faq(id=1, question=Question 1)", faq.toString());
    }

    @Test
    void testAllArgsConstructor() {
        Faq faq = new Faq(1L, "Question 1");
        assertEquals(1L, faq.getId());
        assertEquals("Question 1", faq.getQuestion());
       
    }
    @Test
    void testNoArgsConstructor(){
        Faq faq = new Faq();
        assertEquals(0, faq.getId());
        assertNull(null, faq.getQuestion());
        
    }

}