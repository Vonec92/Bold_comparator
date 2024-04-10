import { Component } from '@angular/core';
import { NavStateService } from '../services/Helper/nav-state.service';

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.css']
})
export class StartPageComponent {

  constructor(public navState: NavStateService) { }
}
