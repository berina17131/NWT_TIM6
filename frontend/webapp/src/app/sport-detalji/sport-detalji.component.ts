import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';

@Component({
  selector: 'app-sport-detalji',
  templateUrl: './sport-detalji.component.html',
  styleUrls: ['./sport-detalji.component.css']
})
export class SportDetaljiComponent implements OnInit {

  event: any;

  constructor(private eventService: EventService, private router: ActivatedRoute) {
  }


  ngOnInit() {
    const id = +this.router.snapshot.paramMap.get('id');
    this.getEvent();
    //this.getFeedbacks(id);
  }

  getEvent(){
    const id = +this.router.snapshot.paramMap.get('id');

    this.eventService.getEvent(id).subscribe(data => {
      this.event = data;
       });
   }
}
