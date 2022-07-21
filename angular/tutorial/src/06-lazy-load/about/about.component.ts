import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  // @Autowired
  // private MovieService movieService;

  // @Autowired
  // private router:Router;

  constructor(private router:Router) { }

  ngOnInit() {
  }

  goto(path){
    this.router.navigate([path]);
  }

}
