import { Component, Input, ViewChild } from '@angular/core';
import { RecommendedTool } from '../interfaces/RecommendedTool';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { FormControl } from '@angular/forms';
import { ThemePalette } from '@angular/material/core';



@Component({
  selector: 'app-overview-table',
  templateUrl: './overview-table.component.html',
  styleUrls: ['./overview-table.component.css']
})

export class OverviewTableComponent {

  @Input() recommendationsList: RecommendedTool[];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  displayedColumns: string[] = ['Name', 'Date', 'Recommendation', 'Company name'];
  dataSource : MatTableDataSource<RecommendedTool>;

  constructor() {
    this.dataSource = new MatTableDataSource<RecommendedTool>(this.recommendationsList);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
   }

   ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }


  ngOnChanges(): void {
   
        this.dataSource = new MatTableDataSource<RecommendedTool>(this.recommendationsList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
