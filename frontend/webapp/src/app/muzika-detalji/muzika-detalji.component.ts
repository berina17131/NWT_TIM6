import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {CommentService} from '../services/comment/comment.service';
import { GradeService } from '../services/grade/grade.service';

@Component({
  selector: 'app-muzika-detalji',
  templateUrl: './muzika-detalji.component.html',
  styleUrls: ['./muzika-detalji.component.css']
})
export class MuzikaDetaljiComponent implements OnInit {

  event: any;
  comments: Array<any>;
  selectedComment: any;

  averageGrade: any;

  constructor(
    private eventService: EventService, 
    private router: ActivatedRoute, 
    private commentService: CommentService,
    private gradeService: GradeService) {}


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
    this.commentService.getCommentsForEvent(id).subscribe(data =>{
      console.log("aaaaaa");
      this.comments = data;
      console.log(this.comments.length);
    });   
  }

}
