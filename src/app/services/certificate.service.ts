import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Certificate {
  register_number: number;
  name: string;
  coursename: string;
  verificationid: string;
  issueDate: string;
  course_duration: string;
}

@Injectable({
  providedIn: 'root'
})
export class CertificateService {
  private apiUrl = 'http://localhost:8080/certificate/certificateservice';

  constructor(private http: HttpClient) {}

  getCertificates(): Observable<Certificate[]> {
    return this.http.get<Certificate[]>(this.apiUrl);
  }

  getCertificateById(id: number): Observable<Certificate> {
    return this.http.get<Certificate>(`${this.apiUrl}/${id}`);
  }

  addCertificate(certificate: Certificate): Observable<void> {
    console.log("Sending POST request to backend", certificate);
    return this.http.post<void>(`${this.apiUrl}/post`, certificate, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }

  updateCertificate(id: number, certificate: Certificate): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, certificate, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }

  deleteCertificate(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
