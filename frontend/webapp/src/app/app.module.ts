import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MuzikaComponent } from './muzika/muzika.component';
import {RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'muzika', component: MuzikaComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    MuzikaComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
