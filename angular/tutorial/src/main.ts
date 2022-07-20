import { platformBrowserDynamic } from "@angular/platform-browser-dynamic";
import { AppModule } from "./02-databinding/app.module";

// import { AppModule } from "./01-basic/app.module";

platformBrowserDynamic()
  .bootstrapModule(AppModule)