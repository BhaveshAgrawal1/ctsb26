import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";

  
  @NgModule({
    declarations: [AppComponent], // comp, pipe, directive
    exports: [], // provide modules for others
    imports: [BrowserModule, ReactiveFormsModule], // consume modules from others
    providers: [], // utils, reusable code
    bootstrap: [AppComponent]
  })
export class AppModule{}