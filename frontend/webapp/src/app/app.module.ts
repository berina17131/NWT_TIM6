import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MuzikaComponent } from './muzika/muzika.component';
import {RouterModule, Routes } from '@angular/router';
import { KulturaComponent } from './kultura/kultura.component';
import { SportComponent } from './sport/sport.component';
import { ZabavaComponent } from './zabava/zabava.component';
import { NaukaComponent } from './nauka/nauka.component';

const routes: Routes = [
  { path: 'muzika', component: MuzikaComponent },
  { path: 'kultura', component: KulturaComponent },
  { path: 'sport', component: SportComponent },
  { path: 'zabava', component: ZabavaComponent },
  { path: 'nauka', component: NaukaComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    MuzikaComponent,
    KulturaComponent,
    SportComponent,
    ZabavaComponent,
    NaukaComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
