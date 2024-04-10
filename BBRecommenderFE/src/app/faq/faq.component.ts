import { Component } from '@angular/core';
import { FAQ } from '../interfaces/FAQ';
import { FaqService } from '../services/API/faq.service';
import { NotificationService } from '../services/Helper/notification.service';
import { NavStateService } from '../services/Helper/nav-state.service';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent {

  newFAQText: string = '';
  FAQtextCopy: string = '';

  FAQList: FAQ[];

  constructor(private faqService: FaqService, private notificationService: NotificationService, public navState: NavStateService) {
    this.faqService.GetAllFaqs().subscribe((faqs) => {
      console.log(faqs);
      this.FAQList = faqs;
    });
  }

  async addFAQ() {
    if (!this.checkIfInputIsEmpty(this.newFAQText)) {
      this.faqService.AddFaq({ "question": this.newFAQText }).subscribe((response) => {
        
        this.notificationService.showGreenSnackbar(response.message, "Close", 1000, 'bottom');

      });

      await setTimeout(function () {
        location.reload();
      }, 1001);

    }
    this.newFAQText = "";

  }

  async removeFAQ(id: number) {
    this.faqService.DeleteFaq(id).subscribe((response) => {
   
      // verticalPos: MatSnackBarVerticalPosition = 'top' || 'bottom' only two options
      this.notificationService.showRedSnackbar(response.message, "Close", 1000, 'bottom');
    });

    //reload page to update FAQ list
    await setTimeout(function () {
      location.reload();
    }, 1001);

  }

  saveFAQ(faq: FAQ) {
    console.log(faq);
    // if input is empty, cancel edit
    if (!this.checkIfInputIsEmpty(faq.question)) {
      this.faqService.UpdateFaq(faq).subscribe((response) => {
        this.notificationService.showGreenSnackbar(response.message, "Close", 1000, 'bottom');     
      });
      faq.editMode = false;
      
    } else{
      this.notificationService.showRedSnackbar("No valid input", "Close", 1000, 'bottom');
    }
  }

  cancelEdit(faq: FAQ) {
    faq.question = this.FAQtextCopy;
    faq.editMode = false;
    this.notificationService.showRedSnackbar("edit canceled", "Close", 1000, 'bottom');
  }

  editFAQ(faq: FAQ) {
    //save title
    this.FAQtextCopy = faq.question;
    faq.editMode = true;
  }

  checkIfInputIsEmpty(question: String) {
    if (question.trim() === "") {
      return true;
    }
    return false;
  }



}
