import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FAQ } from 'src/app/interfaces/FAQ';
import { HttpResponse } from 'src/app/interfaces/HttpResponse';
import { environment } from 'src/environments/environment';

const BASE_API_URL = environment.BASE_API_URL;


@Injectable({
  providedIn: 'root'
})
export class FaqService {

  constructor(private _http : HttpClient) { }

  GetAllFaqs() : Observable<FAQ[]> {
    return this._http.get<FAQ[]>(`${BASE_API_URL}/faqs`, {responseType: 'json'});
  }

  AddFaq(faq : FAQ) : Observable<HttpResponse> {
    return this._http.post<HttpResponse>(`${BASE_API_URL}/faq`, faq, {responseType: 'json'});
  }

  DeleteFaq(faq : number) : Observable<HttpResponse> {
    return this._http.delete<HttpResponse>(`${BASE_API_URL}/deleteFaq/${faq}`, {responseType: 'json'});
  }

  UpdateFaq(faq : FAQ) : Observable<HttpResponse> {
    return this._http.put<HttpResponse>(`${BASE_API_URL}/updateFaq/${faq.id}`, faq, {responseType: 'json'});
  }




}
