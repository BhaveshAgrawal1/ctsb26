import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { HeaderComponent } from './include/header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AboutComponent } from './about/about.component';
import { RouterModule, Routes } from "@angular/router";

const routes:Routes = [
    { path: "home", component: HomeComponent},
    { path: "about", component: AboutComponent},
    { path: "login", component: LoginComponent},
    { path: "welcome", component: WelcomeComponent},

    // { path: "**", component: NotFoundComponent},
    { path: "**", redirectTo: "home" },
    
];

@NgModule({
    declarations: [AppComponent, HeaderComponent, HomeComponent, LoginComponent, WelcomeComponent, AboutComponent], // @Pipe/@Directive/@Component
    imports: [BrowserModule, RouterModule.forRoot(routes)],
    bootstrap: [AppComponent]
})
export class AppModule { }