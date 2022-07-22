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
        this.loadUsers();
    }


    loadUsers(){
        this.userService.getAllUsers().subscribe({
            next: (res:any)=>{
                console.log(res);
                this.users = res;
            },
            error: (e)=>{
                console.log(e)
            }
        })
    }

    addUser(){
        let user = {name: "mark", email: "mark@gmail.com"};

        this.userService.createUser(user).subscribe({
            next: (res:any)=>{
                console.log(res);
                this.loadUsers();
            },
            error: (e)=>{
                console.log(e)
            }
        })
    }
   
    deleteUser(id:number){
        this.userService.deleteUser(id).subscribe({
            next: (res:any)=>{
                console.log(res);
                this.loadUsers();
            },
            error: (e)=>{
                console.log(e)
            }
        })
    }
}