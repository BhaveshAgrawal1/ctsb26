import { Component } from "@angular/core";
import { FormArray, FormControl, FormGroup, Validators } from "@angular/forms";

// https://www.tektutorialshub.com/angular/angular-formarray-example-in-reactive-forms/

@Component({
    selector: "app-root",
    templateUrl: "app.component.html",
    styleUrls: ["app.component.scss"]
  })
export class AppComponent{
  myForm:FormGroup; 
  
  constructor(){
    this.myForm = new FormGroup({
      subjects: new FormArray([
        new FormControl("Angular"),
        new FormControl("Springboot")
      ])
    });
  }

  get subjects() : FormArray {
    return this.myForm.get("subjects") as FormArray;
  }

  addSubject() {
    (<FormArray>this.myForm.controls['subjects']).push(new FormControl('abc', Validators.required));
  }
  removeSubject() {
    let subjectsArray = (<FormArray>this.myForm.controls['subjects']);
    if(subjectsArray.length > 1){
      subjectsArray.removeAt(subjectsArray.length-1);
    }
  }


  getLogin(){
    console.log(this.myForm)
    console.log(this.myForm.value)
  }
}