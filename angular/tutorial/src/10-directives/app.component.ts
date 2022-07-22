import { Component } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: [`app.component.scss`]
})
export class AppComponent {

    books:any[] = [
        {title: "Superman", price: 26.7, author: "Tim"},
        {title: "Shaktiman", price: 16.9, author: "Mukesh"},
    ]

    flag:boolean = false;

    myClass:string = "error";

    myStyle = {
        color: "white",
        "background-color": "black",
        padding: "10px",
        "font-size": "1.5em"
    }

    toggle(){
        this.flag = !this.flag;

        if(this.flag){
            this.myClass = "success";

            this.myStyle.color= "black";
            this.myStyle["background-color"]= "white";

        } else {
            this.myClass = "error";

            this.myStyle.color= "white";
            this.myStyle["background-color"]= "black";
        }
    }
   

}