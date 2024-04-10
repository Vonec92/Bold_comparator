import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpResponse, HttpClient} from '@angular/common/http';
import { Observable, tap } from 'rxjs';

const API_URL = 'http://localhost:8080';
const TOOLDATA_CACHE_KEY = 'tool_data_cache';
const HEADER_KEY = 'cached_ma_data';
const EXPIRATION_KEY = 'expiration_date_tool_data';


@Injectable()
export class HttpCacheInterceptor implements HttpInterceptor {

  constructor(private _http: HttpClient) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const cachedResponse = localStorage.getItem(TOOLDATA_CACHE_KEY);
    const expiryDate = localStorage.getItem(EXPIRATION_KEY);
    const now = new Date().getTime();

    // Check if the request is a POST request to "/calculateRecommendedTool"
    if (request.method === 'POST' && request.url.includes('/calculateRecommendedTool')) {

      // Check if the response is already cached
      if (cachedResponse && now <= parseInt(expiryDate)) {
        // Attach cached data to the request headers
        const headers = request.headers.set(HEADER_KEY, cachedResponse);
        // Clone the request with the updated headers
        const newRequest = request.clone({ headers });
        // Send the request to the server
        return next.handle(newRequest);
      }
      else{
          // Delete cache if it's expired
          localStorage.removeItem(TOOLDATA_CACHE_KEY);
          localStorage.removeItem(EXPIRATION_KEY);
      }
    }
    // Forward the request to the next handler
    return next.handle(request).pipe(
      tap((event) => {
        if (event instanceof HttpResponse && request.method === 'POST' && request.url.includes('/calculateRecommendedTool')) {

          const expiryDate = new Date();
          expiryDate.setDate(expiryDate.getDate() + 1);
          expiryDate.setHours(8, 0, 0, 0);
          localStorage.setItem(EXPIRATION_KEY, expiryDate.getTime().toString());

          // Cache the response
          this._http.get(`${API_URL}/GetAllMarketingTools`).subscribe((response) => {
            console.log(response);
            localStorage.setItem(TOOLDATA_CACHE_KEY, JSON.stringify(response));
          });
        }
      })
    );
  }
}
