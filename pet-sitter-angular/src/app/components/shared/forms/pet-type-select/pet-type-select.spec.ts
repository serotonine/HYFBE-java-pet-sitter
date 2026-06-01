import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetTypeSelect } from './pet-type-select';

describe('PetTypeSelect', () => {
  let component: PetTypeSelect;
  let fixture: ComponentFixture<PetTypeSelect>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PetTypeSelect]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PetTypeSelect);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
