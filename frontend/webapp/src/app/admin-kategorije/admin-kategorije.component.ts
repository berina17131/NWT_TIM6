import { Component, OnInit } from '@angular/core';
import {CategoryService} from '../services/category/category.service';

@Component({
  selector: 'app-admin-kategorije',
  templateUrl: './admin-kategorije.component.html',
  styleUrls: ['./admin-kategorije.component.css']
})
export class AdminKategorijeComponent implements OnInit {

  categories: any;

  constructor(private categoryService: CategoryService) { }

  ngOnInit() {
    this.getAllCategories();
  }

  getAllCategories() {
    this.categoryService.getAllCategory().subscribe(data => {this.categories = data});
  }

  prikaziDetalje(category)
  {
    console.log(category);
  }

  obrisiKategoriju(category) {
    console.log(category);
  }


}
