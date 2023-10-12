import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list', // Tên của selector
  templateUrl: './product-list.component.html',
})
export class BodyComponent implements OnInit {
  products = [
    {
      name:'IPHONE 15pro max',
      description:'Đẹp xinh',
      thumbnail:'https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/news/di-dong/hinh-anh-ro-ri-ve-thiet-ke-cua-iphone-15-pro.jpg',
      price: 2000.59,
      quantity:2 
    },
    {
      name:'IPHONE PRO MAX 16',
      description:'KO ĐẸP LẮM',
      thumbnail:'https://media-cdn-v2.laodong.vn/storage/newsportal/2023/8/23/1232331/Anh-Man-Hinh-2023-08-01.jpg',
      price: 3000.99,
      quantity: 2 
    },
    {
      name:'IPHONE 15pro max',
      description:'Đẹp xinh',
      thumbnail:'https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/news/di-dong/hinh-anh-ro-ri-ve-thiet-ke-cua-iphone-15-pro.jpg',
      price: 2000.59,
      quantity:2 
    }
  ]

  constructor() {}

  ngOnInit(): void {}

}
