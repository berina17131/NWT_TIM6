import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {CommentService} from '../services/comment/comment.service';
import {Event} from '../services/event/Event';

@Component({
  selector: 'app-kultura-detalji',
  templateUrl: './kultura-detalji.component.html',
  styleUrls: ['./kultura-detalji.component.css']
})
export class KulturaDetaljiComponent implements OnInit {

  event: Event = {
    name: '',
    description: '',
    category: {
        id: null
    },
    place: {
        id: null
    }
  };
  comments: Array<any>;

  constructor(private eventService: EventService, private commentService: CommentService, private router: ActivatedRoute) {
  }


  ngOnInit() {
    const id = +this.router.snapshot.paramMap.get('id');
    this.getEvent();
    console.log(this.event.name);
   // this.getComments(id);
  }

  getEvent(){
    const id = +this.router.snapshot.paramMap.get('id');

    this.eventService.getEvent(id).subscribe(data => {
      this.event = data;
      console.log(event);
       });
   }

   getComments(id){

    this.commentService.getCommentsForEvent(id).subscribe(data => {
      this.comments = data;
       });
   }

}
