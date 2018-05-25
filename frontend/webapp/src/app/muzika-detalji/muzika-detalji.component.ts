import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';

@Component({
  selector: 'app-muzika-detalji',
  templateUrl: './muzika-detalji.component.html',
  styleUrls: ['./muzika-detalji.component.css']
})
export class MuzikaDetaljiComponent implements OnInit {

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
