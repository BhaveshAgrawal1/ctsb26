import { Injectable } from "@angular/core";
import { User } from "../model/user";

@Injectable(
    { providedIn: "root" }
)
export class UserService{
    private u: User = {
        name: "mark", 
        age: 35,
        address: "pune, india"
    }; 

    public set name(name:string){
        this.u.name = name;
    }

    public get name(){
        return this.u.name;
    }

    public get user(){
        return {...this.u};
    }

}