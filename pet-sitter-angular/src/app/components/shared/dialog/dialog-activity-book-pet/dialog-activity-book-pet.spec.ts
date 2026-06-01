import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogActivityBookPet } from './dialog-activity-book-pet';

describe('DialogActivityBookPet', () => {
  let component: DialogActivityBookPet;
  let fixture: ComponentFixture<DialogActivityBookPet>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DialogActivityBookPet]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DialogActivityBookPet);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
