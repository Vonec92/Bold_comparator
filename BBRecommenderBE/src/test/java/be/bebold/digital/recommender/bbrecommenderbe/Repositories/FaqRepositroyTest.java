package be.bebold.digital.recommender.bbrecommenderbe.Repositories;

import be.bebold.digital.recommender.bbrecommenderbe.Model.Faq;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FaqRepositroyTest {

    @Test
    void findAlFaqs() {
        List<Faq> faqs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            faqs.add(new Faq(i, "Question" + i ));
        }
        FaqRepositroy faqRepositroy = mock(FaqRepositroy.class);
        assertNotNull(when(faqRepositroy.findAll()).thenReturn(faqs));

    }
    @Test
    void findAlFaqsWhenEmpty() {
        List<Faq> faqs = new ArrayList<>();

        FaqRepositroy faqRepositroy = mock(FaqRepositroy.class);
        assertNotNull(when(faqRepositroy.findAll()).thenReturn(faqs));
    }

}