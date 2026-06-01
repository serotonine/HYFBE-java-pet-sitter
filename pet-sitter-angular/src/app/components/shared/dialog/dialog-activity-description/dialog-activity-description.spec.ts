import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogActivityDescription } from './dialog-activity-description';

describe('DialogActivityDescription', () => {
  let component: DialogActivityDescription;
  let fixture: ComponentFixture<DialogActivityDescription>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DialogActivityDescription]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DialogActivityDescription);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
