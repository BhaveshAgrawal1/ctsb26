import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  host:string = "http://localhost:9009/admin";
  count:number = 34;

	constructor(private httpClient:HttpClient){}

	testDemo(){

		console.log("statement 1");
		this.count = 33;
		console.log("statement 2");

		let user = {
			name: "spiderman",
			address: "comic world"
		}

		let reqHeaders = new HttpHeaders({
			// 'Content-Type':'application/x-www-form-urlencoded',
			// 'Access-Control-Allow-Origin': '*'
		 });

		console.log("statement 3");


		return this.httpClient.get(this.host+"/demo", {headers: reqHeaders});
	}

}
