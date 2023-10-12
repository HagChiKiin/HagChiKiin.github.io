import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart-header',
  templateUrl: './header.component.html',

})
export class HeaderComponent implements OnInit{
  title = 'Shopping Cart';

  numberItems = 4;

  constructor() {}

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
 
}
