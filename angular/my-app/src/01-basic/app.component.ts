import { Component } from "@angular/core";

@Component({
    selector: "app-root",
    // template: '<h2>This is working</h2>'
    templateUrl: `app.component.html`,
    styleUrls: [`app.component.scss`]
})
export class AppComponent {
    constructor() {
        console.log("this is app component constructor")
    }
}