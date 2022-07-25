import { Component } from "@angular/core";
import { NGXLogger } from "ngx-logger";

@Component({
    selector: "app-root",
    templateUrl: "app.component.html",
    styleUrls: ["app.component.css"]
})
export class AppComponent {
    constructor(private logger: NGXLogger) {

        this.logger.info("this is info message");
        this.logger.warn("this is warn message");
        this.logger.error("this is error message");
        this.logger.error({message: "huglu", buglu: "huglu", abcsdfsd: 75});
      }
}