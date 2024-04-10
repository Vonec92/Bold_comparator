import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { FilterOptions } from 'src/app/interfaces/FilterOptions';
import { HttpResponse } from 'src/app/interfaces/HttpResponse';
import { RecommendedTool } from 'src/app/interfaces/RecommendedTool';
import { RecommendedToolNameResponse } from 'src/app/interfaces/RecommendedToolNameResponse';
import { environment } from 'src/environments/environment';

const BASE_API_URL = environment.BASE_API_URL;

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {

  constructor(private _http: HttpClient) { }

  SaveRecommendedTool(recommendationData: RecommendedTool): Observable<HttpResponse> {
    console.log(recommendationData);
    return this._http.post<HttpResponse>(`${BASE_API_URL}/recommendedtool`, recommendationData, { responseType: 'json' });
  }

  getRecommendedToolNameForUserInput(filterOptions: FilterOptions){
    return this._http.post<RecommendedToolNameResponse>(`${BASE_API_URL}/calculateRecommendedTool`, filterOptions);
  }

}
