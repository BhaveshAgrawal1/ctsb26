import { Component, OnInit } from "@angular/core";
import { UserService } from "./user.service";

@Component({
    selector: "app-root",
    templateUrl: `app.component.html`,
    styleUrls: [`app.component.scss`]
})
export class AppComponent implements OnInit {

    users:any[] = [];

    constructor(private userService:UserService){
        // load users from db
        // taking time - 5sec
    }

    ngOnInit(){
        this.test();
    }


    test(){
        this.userService.testDemo().subscribe({
            next: (res:any)=>{
                console.log(res)
            },
            error: (e)=>{
                console.log("Error occurred: ");
                console.log(e)
            }
        })
    }

   
}