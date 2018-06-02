import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {CommentService} from '../services/comment/comment.service';
import { GradeService } from '../services/grade/grade.service';
import {Comment} from '../services/comment/Comment';
import {Grade} from '../services/grade/Grade';

@Component({
  selector: 'app-nauka-detalji',
  templateUrl: './nauka-detalji.component.html',
  styleUrls: ['./nauka-detalji.component.css']
})
export class NaukaDetaljiComponent implements OnInit {

  event: any;
  comments: Array<any>;
  eventId: any;
  comment: any;

  averageGrade: any;

  newComment: Comment = { 
    comment: '',
    user: {
        id: null
    },
    event: {
        id: null
    }
};

newGrade: Grade = {
  grade: 1,
  user: {
    id: null
  },
  event: {
    id: null
  }
};

odabranaOcjena: any;
ocjene = [{id: 5, name: '5 - Najbolji provod'},{id: 4, name: '4 - Odličan provod'}, {id: 3, name: '3 - Neutralan sam'}, {id: 2, name: '2 - Nisam oduševljen'}, {id: 1, name: '1 - Loš događaj '}];



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
    this.eventId = id;

    this.eventService.getEvent(id).subscribe(data => {
      this.event = data;
       });
   }

   getComments(id){

    this.commentService.getCommentsForEvent(id).subscribe(data => {
      this.comments = data;
       });
   }

   createComment(){
    //id usera;
    this.newComment.event.id = this.eventId;
    this.newComment.comment = this.comment;

    this.commentService.createComment(this.newComment).subscribe(data => {
      console.log(data);
    });
  }
}
