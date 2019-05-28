import { Component, OnInit } from '@angular/core';
import { Pcs } from 'src/app/shared/mock/pc-mock';

@Component({
  selector: 'app-pc-list',
  templateUrl: './pc-list.component.html',
  styleUrls: ['./pc-list.component.css']
})
export class PcListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  pcs = Pcs;
}




