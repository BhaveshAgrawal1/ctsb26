import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  host:string = "https://jsonplaceholder.typicode.com/users";

	constructor(private httpClient:HttpClient){}

	getAllUsers(){
		return this.httpClient.get(this.host);
	}

	createUser(user:any){
		return this.httpClient.post(this.host, user);
	}

	deleteUser(id:number){
		return this.httpClient.delete(this.host+"/"+id);
	}

}
