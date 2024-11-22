import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExecutiveListComponent } from './admin-executive-list.component';

describe('AdminExecutiveListComponent', () => {
  let component: AdminExecutiveListComponent;
  let fixture: ComponentFixture<AdminExecutiveListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminExecutiveListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminExecutiveListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
