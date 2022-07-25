import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { LoggerModule, NgxLoggerLevel } from "ngx-logger";
import { AppComponent } from "./app.component";

import { environment } from "./../environments/environment";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
    declarations: [AppComponent],// component, pipe, directive
    imports: [
        BrowserModule,
        HttpClientModule,
        LoggerModule.forRoot({
            level: environment.level,
            // level: NgxLoggerLevel.ERROR,
            serverLoggingUrl: '/errors',
            serverLogLevel: NgxLoggerLevel.ERROR
          })
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }