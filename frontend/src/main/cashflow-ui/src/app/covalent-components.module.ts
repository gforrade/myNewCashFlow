import { NgModule } from '@angular/core';
import { CovalentLayoutModule } from '@covalent/core/layout';
import { CovalentStepsModule  } from '@covalent/core/steps';
import {
  CovalentCommonModule,
  CovalentDataTableModule, CovalentDialogsModule,
  CovalentLoadingModule,
  CovalentMediaModule, CovalentSearchModule, TdDialogService
} from '@covalent/core';
import {CommonModule} from '@angular/common';

@NgModule({
  exports: [
    CovalentLayoutModule,
    CovalentStepsModule,
    CovalentCommonModule,
    CovalentLayoutModule,
    CovalentMediaModule,
    CovalentLoadingModule,
    CovalentDataTableModule,
    CovalentSearchModule,
    CovalentDialogsModule
  ],
  declarations: []
})
export class CovalentComponentsModule { }
