import { Component, EventEmitter, Output } from '@angular/core';
import { FilterOptions } from '../interfaces/FilterOptions';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FilterbarValues } from './values/FilterbarValues';

@Component({
  selector: 'app-filter-bar',
  templateUrl: './filter-bar.component.html',
  styleUrls: ['./filter-bar.component.css']
})
export class FilterBarComponent {

  filterbar: FormGroup;
  FilterbarValues = new FilterbarValues();

  @Output() filterbardata = new EventEmitter<any>();
  @Output() IsValidInput = new EventEmitter<any>();

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.filterbar = this.formBuilder.group({
      hasFreeTrial: [null],
      budget: [null, Validators.required],
      emailsPerMonth: [null],
      contacts: [null],
      features: new FormArray([]),
      levelOfSupport: [null],
      dbQuality: [null],
      hasDragAndDrop: [null],
      implementationModel: [null],
      score: [null],
    })
  }


  // create a function that can read all the filters and send them to the parent component

  onCheckboxChange() {
    let filterOptions: FilterOptions = this.filterbar.value;

    if (filterOptions.levelOfSupport != null)
      this.splitLevelOfSupport();

    if (this.canEmittInputToParent(filterOptions)){
      this.IsValidInput.emit(true);
      this.filterbardata.emit(filterOptions);
    }
    else
      this.IsValidInput.emit(false);
  }

  // make sure to add formArray to the formBuilder 
  onMultiCheckChange(event, formBuilderFieldName: string) {
    const formArray: FormArray = this.filterbar.get(formBuilderFieldName) as FormArray

    /* Selected */
    if (event.target.checked) {
      // Add a new control in the arrayForm
      formArray.push(new FormControl(event.target.value));
    }
    /* unselected */
    else {
      // find the unselected element
      let i: number = 0;

      formArray.controls.forEach((ctrl: any) => {
        if (ctrl.value == event.target.value) {
          // Remove the unselected element from the arrayForm
          formArray.removeAt(i);
          return;
        }

        i++;
      });
    }

    this.onCheckboxChange()
  }


  splitLevelOfSupport() {
    this.filterbar.value.levelOfSupport =  this.filterbar.value.levelOfSupport.split(":")[0];
  }

  canEmittInputToParent(filterOptions: FilterOptions): Boolean {
    let numFieldsFilledIn = Object.values(this.filterbar.value).filter(val => val !== null).length - 1;
    const featIsFilled = filterOptions.features.length >= 1


    if (featIsFilled)
      numFieldsFilledIn += 1;

    if (numFieldsFilledIn >= 5 && this.filterbar.valid)
      return true;

    
    return false;
  }

  collapse1 = false;
  collapse2 = false;
  collapse3 = false;
  collapse4 = false;
  collapse5 = false;
  collapse6 = false;
  collapse7 = false;
  collapse8 = false;
  collapse9 = false;

}