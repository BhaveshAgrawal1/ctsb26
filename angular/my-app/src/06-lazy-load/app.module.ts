import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { HeaderComponent } from './include/header/header.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from "./modules/user/login/login.component";

const routes:Routes = [
    { path: "home", component: HomeComponent},
    { path: "about", component: AboutComponent},

    // lazy-load
    { path: "user", loadChildren: ()=>import("./modules/user/user.module").then(module=>module.UserModule) },
    // { path: "**", component: NotFoundComponent},
    { path: "**", redirectTo: "home" },
    
];

@NgModule({
    declarations: [
        AppComponent, 
        HeaderComponent, 
        HomeComponent, 
        AboutComponent
    ], // @Pipe/@Directive/@Component
    imports: [BrowserModule, RouterModule.forRoot(routes)],
    bootstrap: [AppComponent]
})
export class AppModule { }