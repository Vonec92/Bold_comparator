import { Component, ElementRef, ViewChild } from '@angular/core';
import { Message } from '../classes/Message';
import { ChatService } from '../services/ChatBot/chat.service';

@Component({
  selector: 'app-bebot',
  templateUrl: './bebot.component.html',
  styleUrls: ['./bebot.component.css']
})
export class BebotComponent {

  messages: Message[] = [];
  value: string;
  isChatOpen = false;

  @ViewChild('messageWrapper') messageWrapper: ElementRef;
  @ViewChild('chatBody') chatBody: ElementRef;


  constructor(private chatService: ChatService) { }

  async ngOnInit(): Promise<void> {

    this.chatService.conversation.subscribe((val) => {
      this.messages = this.messages.concat(val);
      setTimeout(() => {
        this.messageWrapper.nativeElement.scrollTop = this.messageWrapper.nativeElement.scrollHeight;
      });
    });
  }

  openCloseChat() {
    this.isChatOpen = !this.isChatOpen;
  }

sendMessage() {
  this.chatService.getBotAnswer(this.value);
  this.value = '';
  setTimeout(() => {
    this.messageWrapper.nativeElement.scrollTop = this.messageWrapper.nativeElement.scrollHeight;
  });
}


}
