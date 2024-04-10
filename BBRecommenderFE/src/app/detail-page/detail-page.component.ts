import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { RecommendedTool } from '../interfaces/RecommendedTool';
import { NavStateService } from '../services/Helper/nav-state.service';
import { DetailService } from '../services/API/detail.service';
import { FileService } from '../services/API/file.service';
import { CurrentDateService } from '../services/Helper/current-date.service';

@Component({
  selector: 'app-detail-page',
  templateUrl: './detail-page.component.html',
  styleUrls: ['./detail-page.component.css']
})
export class DetailPageComponent {

  id: number;
  recommendedTool: RecommendedTool;
  isProcessing = false;

  constructor(private route: ActivatedRoute,
    private detailService: DetailService,
    private sanitizer: DomSanitizer,
    private fileService: FileService,
    private currentDateService: CurrentDateService,
    public navState: NavStateService,

  ) { }

  async ngOnInit(): Promise<void> {

    //get url id
    this.route.params.subscribe(params => { this.id = params['id']; });

    await this.detailService.GetDetailByToolName(this.id).subscribe(recommendedTool => {
      this.recommendedTool = recommendedTool;
    })
  }

  downloadPdf() {

    let currentDate = this.currentDateService.getCurrentDate();

    setTimeout(() => {
      const fileName = `${this.recommendedTool.companyName}_${currentDate}`;

      this.fileService.downloadInputPDF(this.recommendedTool.filterOptions).subscribe(data => {
        const blob = new Blob([data], { type: 'application/pdf', });

        const url = window.URL.createObjectURL(blob);
        window.open(url, fileName);

        const link = document.createElement('a');
        link.href = url;
        link.download = fileName;
        link.click();
      });
    }, 1000);


    this.isProcessing = true;

    setTimeout(() => {
      this.isProcessing = false;
    }, 5000);
  }

  sanitizeUrl(videoUrl: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(videoUrl);
  }

}
