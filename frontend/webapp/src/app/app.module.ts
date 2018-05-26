import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { MuzikaComponent } from './muzika/muzika.component';
import {RouterModule, Routes } from '@angular/router';
import { KulturaComponent } from './kultura/kultura.component';
import { SportComponent } from './sport/sport.component';
import { ZabavaComponent } from './zabava/zabava.component';
import { NaukaComponent } from './nauka/nauka.component';
import { NaukaDetaljiComponent } from './nauka-detalji/nauka-detalji.component';
import { SportDetaljiComponent } from './sport-detalji/sport-detalji.component';
import { ZabavaDetaljiComponent } from './zabava-detalji/zabava-detalji.component';
import { KulturaDetaljiComponent } from './kultura-detalji/kultura-detalji.component';
import { MuzikaDetaljiComponent } from './muzika-detalji/muzika-detalji.component';
import { AdminLokacijaComponent } from './admin-lokacija/admin-lokacija.component';
import { PlaceService } from './services/place/place.service';
import { EventService } from './services/event/event.service';
import { AdminUseriComponent } from './admin-useri/admin-useri.component';
import { AdminEventsComponent } from './admin-events/admin-events.component';
import { UserDetaljiComponent } from './user-detalji/user-detalji.component';

const routes: Routes = [
  { path: 'muzika', component: MuzikaComponent },
  { path: 'kultura', component: KulturaComponent },
  { path: 'sport', component: SportComponent },
  { path: 'zabava', component: ZabavaComponent },
  { path: 'nauka', component: NaukaComponent },
  { path: 'kultura-detalji', component: KulturaDetaljiComponent },
  { path: 'nauka-detalji', component: NaukaDetaljiComponent },
  { path: 'zabava-detalji', component: ZabavaDetaljiComponent },
  { path: 'sport-detalji', component: SportDetaljiComponent },
  { path: 'muzika-detalji', component: MuzikaDetaljiComponent },
  { path: 'admin-lokacija', component: AdminLokacijaComponent },
  { path: 'admin-useri', component: AdminUseriComponent },
  { path: 'admin-events', component: AdminEventsComponent },
  { path: 'user-detalji/:idUser', component: UserDetaljiComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    MuzikaComponent,
    KulturaComponent,
    SportComponent,
    ZabavaComponent,
    NaukaComponent,
    NaukaDetaljiComponent,
    SportDetaljiComponent,
    ZabavaDetaljiComponent,
    KulturaDetaljiComponent,
    MuzikaDetaljiComponent,
    AdminLokacijaComponent,
    AdminUseriComponent,
    AdminEventsComponent,
    UserDetaljiComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    HttpModule,
    FormsModule
  ],
  providers: [PlaceService, EventService],
  bootstrap: [AppComponent]
})
export class AppModule { }
