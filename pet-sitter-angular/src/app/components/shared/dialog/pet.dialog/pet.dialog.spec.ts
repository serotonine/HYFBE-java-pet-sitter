import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetDialog } from './pet.dialog';

describe('PetDialog', () => {
  let component: PetDialog;
  let fixture: ComponentFixture<PetDialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PetDialog]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PetDialog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
