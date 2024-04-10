import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { messageMap } from 'src/app/classes/ChatMessages';
import { Message } from 'src/app/classes/Message';


@Injectable({
  providedIn: 'root'
})
export class ChatService {

  constructor() { }

  conversation = new Subject<Message[]>();
  
  getBotAnswer(msg: string) {
    msg = this.alterMessge(msg);
    const userMessage = new Message('You' , msg);  
    this.conversation.next([userMessage]);
    const botMessage = new Message('BeBot', this.getBotMessage(msg));
    
    setTimeout(()=>{
      this.conversation.next([botMessage]);
    }, 1500);
  }

  getBotMessage(question: string){
    let answer = messageMap[question];
    return answer || messageMap['default'];
  }

  alterMessge(message : string){

    // delete all punctuation in a string and replace them with ""
    const punctRegex = /[!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~]/g;
    message = message.replace(punctRegex, "").toLowerCase();

    return message;
  }

}
