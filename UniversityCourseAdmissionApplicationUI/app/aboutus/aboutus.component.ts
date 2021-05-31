import { Component, OnInit, VERSION } from '@angular/core';

@Component({
  selector: 'app-aboutus',
  templateUrl: './aboutus.component.html',
  styleUrls: ['./aboutus.component.css']
})
export class AboutusComponent implements OnInit {

  images = ['assets/bigstock-Multiethnic-Students-Taking-Gr-243636175.jpg', 'assets/librarystudent01_1920.jpg',
    'assets/c2.jpg'];

  constructor() {
  }
  ngOnInit(): void {
  }

}
