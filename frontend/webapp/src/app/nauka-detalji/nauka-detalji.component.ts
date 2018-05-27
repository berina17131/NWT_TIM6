import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {CommentService} from '../services/comment/comment.service';

@Component({
  selector: 'app-nauka-detalji',
  templateUrl: './nauka-detalji.component.html',
  styleUrls: ['./nauka-detalji.component.css']
})
export class NaukaDetaljiComponent implements OnInit {

  event: any;
  comments: Array<any>;

  constructor(private eventService: EventService, private commentService: CommentService, private router: ActivatedRoute) {
  }


  ngOnInit() {
    const id = +this.router.snapshot.paramMap.get('id');
    this.getEvent();
    this.getComments(id);
  }

  getEvent(){
    const id = +this.router.snapshot.paramMap.get('id');

    this.eventService.getEvent(id).subscribe(data => {
      this.event = data;
       });
   }

   getComments(id){

    this.commentService.getCommentsForEvent(id).subscribe(data => {
      this.comments = data;
       });
   }
}
