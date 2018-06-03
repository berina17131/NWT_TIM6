import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {CommentService} from '../services/comment/comment.service';
import { GradeService } from '../services/grade/grade.service';
import {Grade} from '../services/grade/Grade';
import {Comment} from '../services/comment/Comment';
import { TokenStorage } from '../core/token.storage';
import { User } from '../services/user/User';
import { UserService } from '../services/user/user.service';



@Component({
  selector: 'app-zabava-detalji',
  templateUrl: './zabava-detalji.component.html',
  styleUrls: ['./zabava-detalji.component.css']
})
export class ZabavaDetaljiComponent implements OnInit {

  event: any;
  comments: Array<any>;

  averageGrade: any;

  newGrade: Grade = {
    grade: 1,
    user: {
      id: null
    },
    event: {
      id: null
    }
  };

  newComment: Comment = { 
    comment: '',
    user: {
        id: null
    },
    event: {
        id: null
    }
};

eventId: any;
noviKomentar: any;
loggedUser: any;

user: User = {
  id: null,
  username: '',
  password: '',
  email: '',
  ime: '',
  prezime: '',
  role: {
      id: 2,
  }
};

  constructor(
    private eventService: EventService, 
    private commentService: CommentService, 
    private router: ActivatedRoute,
    private gradeService: GradeService,
    private userService: UserService) {
  }

  odabranaOcjena: any;
  ocjene = [{id: 5, name: '5 - Najbolji provod'},{id: 4, name: '4 - Odličan provod'}, {id: 3, name: '3 - Neutralan sam'}, {id: 2, name: '2 - Nisam oduševljen'}, {id: 1, name: '1 - Loš događaj '}];



  ngOnInit() {
    const id = +this.router.snapshot.paramMap.get('id');
    this.eventId = id;
    this.getEvent();
    this.getComments(id);

    this.gradeService.getAverageGrade(id).subscribe(data => {
      this.averageGrade = data;
       });

    this.getUserData();
  }

  getUserData(){

    this.loggedUser = TokenStorage.getCurrentUser();

    this.userService.getByUsername(this.loggedUser).subscribe(data => {
      this.user = data;
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

   createComment(){
    this.newComment.user.id = this.user.id;
    this.newComment.event.id = this.eventId;
    this.newComment.comment = this.noviKomentar;
    this.commentService.createComment(this.newComment).subscribe(data => {
      window.location.reload();
    });
    this.noviKomentar = '';
   }

}
