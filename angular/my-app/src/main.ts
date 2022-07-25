import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

// import { AppModule } from './app/app.module';
// import { AppModule } from "./01-basic/app.module";
// import { AppModule } from "./02-databinding/app.module";
// import { AppModule } from "./03-child-component/app.module";
// import { AppModule } from "./04-input/app.module";
// import { AppModule } from "./05-routing/app.module";
// import { AppModule } from "./06-lazy-load/app.module";
// import { AppModule } from "./07-routing-params/app.module";
// import { AppModule } from "./08-service/app.module";
// import { AppModule } from "./09-forms/app.module";
// import { AppModule } from "./10-directives/app.module";
// import { AppModule } from "./11-pipes/app.module";
// import { AppModule } from "./12-ajax/app.module";
// import { AppModule } from './14-forms-array/app.module';
// import { AppModule } from './15-ajax-with-springboot-doubt/app.module';
import { AppModule } from './16-logger/app.module';

import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
