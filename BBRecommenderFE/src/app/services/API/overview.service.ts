import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RecommendedTool } from 'src/app/interfaces/RecommendedTool';
import { environment } from 'src/environments/environment';

const BASE_API_URL = environment.BASE_API_URL;


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: `Bearer ${localStorage.getItem('token')}`
  })
};

@Injectable({
  providedIn: 'root'
})

// beternaam voor een service ? 
export class OverviewService {

  constructor(private _http: HttpClient) { }

  getRecommendationsForCurrentUser(uid: string): Observable<RecommendedTool[]> {
    return this._http.get<RecommendedTool[]>(`${BASE_API_URL}/personal/${uid}`, { responseType: 'json' });
  }

  getAllRecommendations(): Observable<RecommendedTool[]> {
    return this._http.get<RecommendedTool[]>(`${BASE_API_URL}/all`, { responseType: 'json' });
  }

}
