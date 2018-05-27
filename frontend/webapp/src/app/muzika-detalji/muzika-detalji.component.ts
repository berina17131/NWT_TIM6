import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {CommentService} from '../services/comment/comment.service';

@Component({
  selector: 'app-muzika-detalji',
  templateUrl: './muzika-detalji.component.html',
  styleUrls: ['./muzika-detalji.component.css']
})
export class MuzikaDetaljiComponent implements OnInit {

  event: any;
  comments: Array<any>;

  constructor(
    private eventService: EventService, 
    private router: ActivatedRoute, 
    private commentService: CommentService) {}


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
    this.commentService.getCommentsForEvent(id).subscribe(data =>{
      this.comments = data;
    })
  }

}
