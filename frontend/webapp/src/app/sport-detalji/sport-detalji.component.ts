import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {CommentService} from '../services/comment/comment.service';
import { GradeService } from '../services/grade/grade.service';

@Component({
  selector: 'app-sport-detalji',
  templateUrl: './sport-detalji.component.html',
  styleUrls: ['./sport-detalji.component.css']
})
export class SportDetaljiComponent implements OnInit {

  event: any;
  comments: Array<any>;

  averageGrade: any;

  constructor(
    private eventService: EventService, 
    private commentService: CommentService, 
    private router: ActivatedRoute,
    private gradeService: GradeService) {
  }


  ngOnInit() {
    const id = +this.router.snapshot.paramMap.get('id');
    this.getEvent();
    this.getComments(id);

    this.gradeService.getAverageGrade(id).subscribe(data => {
      this.averageGrade = data;
       });

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
