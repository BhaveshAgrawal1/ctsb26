import { Component, OnInit } from '@angular/core';
import { UserService } from './../../service/user.service';

@Component({
  selector: 'app-comp2',
  templateUrl: './comp2.component.html',
  styleUrls: ['./comp2.component.css']
})
export class Comp2Component implements OnInit {

  constructor(public userService:UserService) { }

  ngOnInit(): void {
  }

}
