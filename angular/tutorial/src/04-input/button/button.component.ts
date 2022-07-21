import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.scss']
})
export class ButtonComponent implements OnInit {

  @Input()
  bgColor:string = "beige";
  myStyle:any = {}

  constructor() { }

  ngOnInit() {
    // this.myStyle.background-color
    this.myStyle["background-color"] = this.bgColor;
  }

}
