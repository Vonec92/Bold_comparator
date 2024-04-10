import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { RecommendedTool } from 'src/app/interfaces/RecommendedTool';
import { environment } from 'src/environments/environment';

const BASE_API_URL = environment.BASE_API_URL;

@Injectable({
  providedIn: 'root'
})
export class DetailService {

  constructor(private _http: HttpClient) { }

  GetDetailByToolName(id: number): Observable<RecommendedTool> {
    return this._http.get<RecommendedTool>(`${BASE_API_URL}/detail/${id}`, { responseType: 'json' });
  }
}
