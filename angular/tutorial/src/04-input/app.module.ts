import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { ButtonComponent } from './button/button.component';
import { HeaderComponent } from './include/header/header.component';

@NgModule({
    declarations: [AppComponent, ButtonComponent, HeaderComponent], // @Pipe/@Directive/@Component
    imports: [BrowserModule],
    bootstrap: [AppComponent]
})
export class AppModule { }