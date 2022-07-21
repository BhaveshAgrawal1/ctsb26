import { platformBrowserDynamic } from "@angular/platform-browser-dynamic";
// import { AppModule } from "./01-basic/app.module";
// import { AppModule } from "./02-databinding/app.module";
// import { AppModule } from "./03-child-component/app.module";
// import { AppModule } from "./04-input/app.module";
// import { AppModule } from "./05-routing/app.module";
// import { AppModule } from "./06-lazy-load/app.module";
// import { AppModule } from "./07-routing-params/app.module";
import { AppModule } from "./8-service/app.module";


platformBrowserDynamic()
  .bootstrapModule(AppModule)