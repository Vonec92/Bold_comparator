import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';

const pdfHeaders = new HttpHeaders({ 'Accept': 'application/pdf' })

const BASE_API_URL = environment.BASE_API_URL;


@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private _http: HttpClient) { }


  downloadInputPDF(filteroptions: any): Observable<any> {
    return this._http.post(BASE_API_URL + `/inputToPDF`, filteroptions, { headers: pdfHeaders, responseType: 'blob' });
  }


}
