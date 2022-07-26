import { Component } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [NgbCarouselConfig]  // add NgbCarouselConfig to the component providers
})
export class AppComponent {
  title = 'ngbootstrapdemo';
  radio:any = {};


  images:string[] = [
    "https://i.picsum.photos/id/799/1200/700.jpg?hmac=6Dpp5qWo0XGfSVQ1CsFgq7A8kHW1mrOi9Bx_jYlo6eU",
    "https://i.picsum.photos/id/479/1200/700.jpg?hmac=KhWhgPxSkWXX12QahZa0iD0lR6lg_JcUD7nYG1Ghpmw",
    "https://i.picsum.photos/id/2/1200/700.jpg?hmac=gXcJPE8NlKw1ruVTtPI8JENdMkb7Ky1pAf906Iv_D2A",
    "https://i.picsum.photos/id/452/1200/700.jpg?hmac=eMQ46ut8Je-yLVKUaGWSzBvUANOrOEvcoNl__4T4Z8g"
  ]
  showNavigationArrows = false;
  showNavigationIndicators = false;
  constructor(config: NgbCarouselConfig) {
  //   // customize default values of carousels used by this component tree
    config.showNavigationArrows = true;
    config.showNavigationIndicators = true;
  }

}
