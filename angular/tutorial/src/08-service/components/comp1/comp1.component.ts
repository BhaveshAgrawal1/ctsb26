import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/08-service/service/user.service';

@Component({
  selector: 'app-comp1',
  templateUrl: './comp1.component.html',
  styleUrls: ['./comp1.component.css']
})
export class Comp1Component implements OnInit {

  constructor(public userService:UserService) { }

  ngOnInit(): void {
  }

  changeName(name:string){
    this.userService.name = name;
    console.log(name);
    console.log(this.userService.name)
  }

}
